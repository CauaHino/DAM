package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bbdd.conexion.ConexionBBDD;
import personas.Persona;

public class PersonasDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet rs;
	
	public PersonasDAO() {
		this.connection = this.conexion.conectar();
	}
	
	public boolean createTable() {
		String query = "create table if not exists Personas("
				+ "idPersona int primary key, "
				+ "nombre varchar(30), "
				+ "apellidos varchar(50), "
				+ "dni char(9), "
				+ "edad int"
				+ ");";
		
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.err.println("ERROR AL CREAR LA TABLA PERSONAS");
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

	public ArrayList<Persona> read() {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		String query = "select * "
				+ "from personas;";
		
		try {
			sentencia = connection.createStatement();
			rs = sentencia.executeQuery(query);
			while(rs.next()) {
				Persona p = new Persona(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("dni"), rs.getInt("edad"));
				personas.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personas;
	}

	public boolean insert(Persona p) {
		String query = "insert into Personas (idPersona, nombre, apellidos, dni, edad) "
				+ "values (?, ?, ?, ?, ?)";
		
		try {
			sentenciaParametrizada = connection.prepareStatement(query);
			sentenciaParametrizada.setInt(1, p.getIdPersona());
			sentenciaParametrizada.setString(2, p.getNombre());
			sentenciaParametrizada.setString(3, p.getApellidos());
			sentenciaParametrizada.setString(4, p.getDni());
			sentenciaParametrizada.setInt(5, p.getEdad());
			sentenciaParametrizada.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Persona read(int idPersona) {
		Persona p = null;
		String query = "select * from personar where idPersona = ?;";
		
		try(PreparedStatement sentencia = connection.prepareStatement(query)){
			sentencia.setInt(1, idPersona);
			rs = sentencia.executeQuery(query);
			p = new Persona(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("dni"), rs.getInt("edad"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}
