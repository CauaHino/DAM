package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import asignaturas.Asignatura;
import bbdd.conexion.ConexionBBDD;
import personas.Alumno;

public class AlumnoDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection conn;
	
	public AlumnoDAO() {
		this.conn = this.conexion.conectar();
	}
	
	public boolean createTable() {
		String query = "create table if not exists Alumno("
				+ "idAlumno int primary key, "
				+ "especialidad varchar(100), "
				+ "foreign key (idAlumno) references persona(idPersona)"
				+ ");";
		
		try(Statement sentencia = conn.createStatement()){
			sentencia.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean insert(Alumno a) {
		String query="insert into alumno values (?, ?)";
		try(PreparedStatement sentencia = conn.prepareStatement(query)){
			sentencia.setInt(1, a.getIdPersona());
			sentencia.setString(2, a.getEspecialidad());
			sentencia.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Alumno> read() {
		AsignaturaDAO asig = new AsignaturaDAO();
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		String query = "select p.*, a.especialidad "
				+ "from persona p "
				+ "join alumno a on p.idPersona = a.idAlumno; ";
		try(Statement sentencia = conn.createStatement()){
			ResultSet rs = sentencia.executeQuery(query);
			while(rs.next()) {
				Alumno a = new Alumno(rs.getInt("idPersona"), rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("edad") ,rs.getString("curso"), rs.getString("especialidad"));
				ArrayList<Asignatura> asignaturas = asig.readId(a.getIdPersona());
				a.setAsignaturas(asignaturas);
				
				alumnos.add(a);
			}
			asig.getConexion().cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumnos;
	}

}
