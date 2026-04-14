package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bbdd.conexion.ConexionBBDD;
import personas.Persona;

public class PersonaDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection conn;
	
	public PersonaDAO() {
		this.conn = this.conexion.conectar();
	}
	
	public boolean createTable() {
		String query = "create table if not exists Persona("
				+ "idPersona int primary key, "
				+ "nombre varchar(50), "
				+ "apellidos varchar (50), "
				+ "edad int, "
				+ "curso varchar(100)"
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
	
	public boolean insert(Persona p) {
		String query ="insert into Persona values (?, ?, ?, ?, ?)";
		
		try(PreparedStatement sentencia = conn.prepareStatement(query)){
			sentencia.setInt(1, p.getIdPersona());
			sentencia.setString(2, p.getNombre());
			sentencia.setString(3, p.getApellidos());
			sentencia.setInt(4, p.getEdad());
			sentencia.setString(5, p.getCurso());
			sentencia.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public int lastId() {
		int id = 0;
		String query = "select idPersona "
				+ "from Persona "
				+ "order by idPersona desc;";
		
		try(Statement sentencia = conn.createStatement()){
			ResultSet rs = sentencia.executeQuery(query);
			if(rs.next()) {
				id = rs.getInt("idPersona");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

}
