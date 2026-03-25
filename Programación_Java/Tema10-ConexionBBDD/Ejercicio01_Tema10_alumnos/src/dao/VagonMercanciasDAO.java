package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexionBBDD.ConexionBBDD;
import vagones.VagonMercancias;

public class VagonMercanciasDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet resultSet;

	// En el constructor establecemos la conexión a BBDD que quedará
	// abierta mientras usemos la clase VagonMercanciasDAO
	public VagonMercanciasDAO() {
		this.connection = conexion.conectar();
	}
	
	public boolean createTable() {
		String queryCreate = "CREATE TABLE vagonmercancias(" 
						+ "idVagon int PRIMARY KEY," 
						+ "capacidad DECIMAL(10,2),"
						+ "foreign key (idVagon) references vagon(idVagon)" 
						+ ");";
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(queryCreate);
			return true;
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla vagonMercancias");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean create(VagonMercancias vagonMercancias) {
		if (vagonMercancias != null) {
			String queryInsert = "INSERT INTO vagonmercancias " 
							+ "(idVagon, capacidad)"
							+ " values (?,?);";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryInsert);
				sentenciaParametrizada.setInt(1, vagonMercancias.getIdentificador());
				sentenciaParametrizada.setDouble(2, vagonMercancias.getCapacidad());

				sentenciaParametrizada.executeUpdate();
				return true;
			} catch (SQLException e) {
				System.out.println("Error al insertar en tabla vagonmercancias");
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
