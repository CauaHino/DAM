package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import asignaturas.Asignatura;
import bbdd.conexion.ConexionBBDD;
import excepciones.MenorDeEdad;
import personas.Profesor;

public class AsignaturaDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection conn;
	
	public AsignaturaDAO() {
		this.conn = this.conexion.conectar();
	}
	
	public boolean createTable() {
		String query = "create table if not exists Asignatura("
				+ "idAsignatura int primary key, "
				+ "nombre varchar(100), "
				+ "curso varchar(100), "
				+ "departamento varchar(100), "
				+ "idProfesor int, "
				+ "foreign key (idProfesor) references profesor(idProfesor)"
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
	
	public boolean insert(Asignatura a) {
		String query = "insert into asignatura values (?, ?, ?,?, ?)";
		
		try(PreparedStatement sentencia = conn.prepareStatement(query)){
			sentencia.setInt(1, a.getIdAsignatura());
			sentencia.setString(2, a.getNombre());
			sentencia.setString(3, a.getCurso());
			sentencia.setString(4, a.getDepartamento());
			sentencia.setInt(5, a.getProfesor().getIdPersona());
			sentencia.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Asignatura> read(){
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		String query = "select a.*, pr.*, p.*, p.nombre as nombreProfesor "
				+ "from asignatura a "
				+ "join profesor pr on a.idProfesor = pr.idProfesor "
				+ "join persona p on pr.idProfesor = p.idPersona;";
		
		try(Statement sentencia = conn.createStatement()){
			ResultSet rs = sentencia.executeQuery(query);
			while(rs.next()) {
				Profesor p = new Profesor(rs.getInt("idProfesor"), rs.getString("nombreProfesor"), rs.getString("apellidos"), 
						rs.getInt("edad"), rs.getString("curso"), rs.getString("departamento"));
				Asignatura asig = new  Asignatura(rs.getInt("idAsignatura"), rs.getString("nombre") ,rs.getString("curso"),p , rs.getString("departamento"));
				asignaturas.add(asig);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MenorDeEdad e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asignaturas;
	}
	
	public ArrayList<Asignatura> readId(int id){
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		String query = "select a.*, pr.*, p.*, p.nombre as nombreProfesor, asig.calificacion "
				+ "from asignatura a "
				+ "join alumnoAsignatura asig on a.idAsignatura = asig.idAsignatura "
				+ "join Alumno al on asig.idAlumno = al.idAlumno "
				+ "join profesor pr on a.idProfesor = pr.idProfesor "
				+ "join persona p on pr.idProfesor = p.idPersona "
				+ "where al.idAlumno = ?;";
		
		try(PreparedStatement sentencia = conn.prepareStatement(query)){
			sentencia.setInt(1, id);
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				Profesor p = new Profesor(rs.getInt("idProfesor"), rs.getString("nombreProfesor"), rs.getString("apellidos"), 
						rs.getInt("edad"), rs.getString("curso"), rs.getString("departamento"));
				Asignatura asig = new  Asignatura(rs.getInt("idAsignatura"), rs.getString("nombre") ,rs.getString("curso"),p , rs.getString("departamento"));
				asig.setCalificacion(rs.getInt("calificacion"));
				asignaturas.add(asig);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MenorDeEdad e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asignaturas;
	}
	
	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

	public int idProfesor(Asignatura a) {
		int lastId = 0;
		String query = "select p.idProfesor "
				+ "from profesor p "
				+ "join asignatura asig on p.idProfesor = asig.idProfesor "
				+ "where asig.idAsignatura = ?;";
		
		try(PreparedStatement sentencia = conn.prepareStatement(query)){
			sentencia.setInt(1, a.getIdAsignatura());
			ResultSet rs = sentencia.executeQuery();
			if(rs.next()) {
				lastId = rs.getInt("idProfesor");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastId;
	}

}
