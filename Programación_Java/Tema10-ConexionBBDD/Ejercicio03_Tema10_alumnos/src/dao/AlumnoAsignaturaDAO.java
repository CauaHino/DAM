package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bbdd.conexion.ConexionBBDD;
import personas.Alumno;

public class AlumnoAsignaturaDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection conn;
	
	public AlumnoAsignaturaDAO() {
		this.conn = this.conexion.conectar();
	}
	
	public boolean createTable() {
		String query = "create table if not exists AlumnoAsignatura("
				+ "idAlumno int, "
				+ "idAsignatura int, "
				+ "calificacion int, "
				+ "foreign key (idAlumno) references alumno(idAlumno), "
				+ "foreign key (idAsignatura) references asignatura(idAsignatura)"
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
		String query = "insert into AlumnoAsignatura values (?, ?, ?)";
		try(PreparedStatement sentencia = conn.prepareStatement(query)){
			sentencia.setInt(1, a.getIdPersona());
			for(int i = 0; i < a.getAsignaturas().size(); i++) {
				sentencia.setInt(2, a.getAsignaturas().get(i).getIdAsignatura());
				sentencia.setInt(3, a.getAsignaturas().get(i).getCalificacion());
				sentencia.executeUpdate();
			}
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public int getIdAsignatura(String nombre) {
		int idAsignatura = 0;
		String query = "select idAsignatura "
				+ "from asignatura "
				+ "where nombre = ?";
		try(PreparedStatement sentencia = conn.prepareStatement(query)){
			sentencia.setString(1, nombre);
			ResultSet rs = sentencia.executeQuery();
			if(rs.next()) {
				idAsignatura = rs.getInt("idAsignatura");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idAsignatura;
	}
	
	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

}
