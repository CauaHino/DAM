package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBBDD.ConexionBBDD;
import personas.Persona;

public class PersonaDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet rs;

	// En el constructor creamos la conexión que se mantendra abierta todo el tiempo
	// que usemos el PasajeroDAO
	public PersonaDAO() {
		//connection = conexion.conectarMySQL();
		connection = conexion.conectarPostgreSQL();
	}
	
	public void createTable() {
		String queryCreate = "create table personas "
						+ "(idPersona int PRIMARY KEY UNIQUE, "
						+ "nombre VARCHAR(20), "
						+ "apellidos VARCHAR(30), "
						+ "dni VARCHAR(9), edad int);";
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(queryCreate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método que inserta al Pasajero pasado como parámetro como un registro de la
	// tabla Pasajeros.
	public void create(Persona persona) {
		if (persona != null) {
			String queryInsert = "INSERT INTO personas (idPersona, nombre, apellidos, dni, edad) "
					+ "values (?,?,?,?,?)";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryInsert);
				sentenciaParametrizada.setInt(1, persona.getIdPersona());
				sentenciaParametrizada.setString(2, persona.getNombre());
				sentenciaParametrizada.setString(3, persona.getApellidos());
				sentenciaParametrizada.setString(4, persona.getDni());
				sentenciaParametrizada.setInt(5, persona.getEdad());
				sentenciaParametrizada.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Método que lee los datos del pasajero con clave infoBillete, construye un
	// objeto Pasajero con sus
	// datos y lo devuelve
	public Persona read(int idPersona) {
		Persona persona = null;
		try {
			String querySelect = "SELECT * FROM personas WHERE idPersona = ?";
			sentenciaParametrizada = connection.prepareStatement(querySelect, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			sentenciaParametrizada.setInt(1, idPersona);
			rs = sentenciaParametrizada.executeQuery();
			// Al buscar por la clave, solo existen dos alternativas:
			// 1) La encuentra: el ResultSet tendrá un ÚNICO registro
			// 2) No la encuentra: el ResultSet estará vacío
			if (rs.next()) {
				persona = new Persona(rs.getString("nombre"), rs.getString("apellidos"), 
						rs.getString("dni"), rs.getInt("edad"));
				// pasajero = new Pasajero(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return persona;
	}

	// Método que actualiza los valores del objeto pasajero pasado como parámetro en
	// la bbdd
	public void update(Persona persona) {
		if (persona != null) {
			String queryUpdate = "UPDATE personas SET nombre = ?, apellidos = ?, dni = ?, "
					+ "edad = ? WHERE idPersona = ?";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryUpdate);
				sentenciaParametrizada.setString(1, persona.getNombre());
				sentenciaParametrizada.setString(2, persona.getApellidos());
				sentenciaParametrizada.setString(3, persona.getDni());
				sentenciaParametrizada.setInt(4, persona.getEdad());
				sentenciaParametrizada.setInt(5, persona.getIdPersona());
				sentenciaParametrizada.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	// Método que elimina el registro correspondiente al registro con clave
	// infoBillete
	public void delete(int idPersona) {
		String queryDelete = "DELETE FROM personas WHERE idPersona = ?";
		try {
			sentenciaParametrizada = connection.prepareStatement(queryDelete);
			sentenciaParametrizada.setInt(1, idPersona);
			sentenciaParametrizada.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método que elimina el registro correspondiente al registro con clave
	// infoBillete
	public void deleteAll() {
		String queryDelete = "DELETE FROM personas";
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(queryDelete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Persona> read() {
		ArrayList<Persona> personas = new ArrayList<>();
		String querySelect = "SELECT * FROM personas";
		try {
			sentencia = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = sentencia.executeQuery(querySelect);
			while (rs.next()) {
				personas.add(new Persona(rs.getInt("idPersona"),rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("dni"), rs.getInt("edad")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personas;
	}

	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

}
