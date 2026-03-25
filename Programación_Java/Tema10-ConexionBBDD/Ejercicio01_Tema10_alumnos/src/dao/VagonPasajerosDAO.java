package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexionBBDD.ConexionBBDD;
import vagones.VagonPasajeros;

public class VagonPasajerosDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet resultSet;

	// En el constructor establecemos la conexión a BBDD que quedará
	// abierta mientras usemos la clase VagonMercanciasDAO
	public VagonPasajerosDAO() {
		this.connection = conexion.conectar();
	}
	
	public boolean createTable() {
		String queryCreate = "CREATE TABLE vagonPasajeros(" 
						+ "idVagon int PRIMARY KEY," 
						+ "numAsientos int,"
						+ "numPasajeros int,"
						+ "foreign key (idVagon) references vagon(idVagon)" 
						+ ");";
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(queryCreate);
			return true;
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla vagonPasajeros");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean create(VagonPasajeros vagonPasajeros) {
		if (vagonPasajeros != null) {
			String queryInsert = "INSERT INTO vagonpasajeros " 
							+ "(idVagon, numAsientos, numPasajeros)"
							+ " values (?,?,?);";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryInsert);
				sentenciaParametrizada.setInt(1, vagonPasajeros.getIdentificador());
				sentenciaParametrizada.setInt(2, vagonPasajeros.getNumAsientos());
				sentenciaParametrizada.setInt(3, vagonPasajeros.getNumPasajeros());
				sentenciaParametrizada.executeUpdate();
				return true;
			} catch (SQLException e) {
				System.out.println("Error al insertar en tabla vagonpasajeros");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

}
