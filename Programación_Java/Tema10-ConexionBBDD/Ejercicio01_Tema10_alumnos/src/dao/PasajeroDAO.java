package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBBDD.ConexionBBDD;
import pasajeros.Pasajero;
import vagones.VagonPasajeros;

public class PasajeroDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet resultSet;

	// En el constructor establecemos la conexión a BBDD que quedará
	// abierta mientras usemos la clase PasajeroDAO
	public PasajeroDAO() {
		this.connection = conexion.conectar();
	}

	public boolean createTable() {
		String queryCreate = "CREATE TABLE pasajeros(" 
						+ "idPasajero int PRIMARY KEY," 
						+ "nombre VARCHAR(30),"
						+ "infoBillete VARCHAR(5)," 
						+ "subidoEnVagon BOOLEAN,"
						+ "idVagon int,"
						+ "foreign key (idVagon) references vagonPasajeros (idVagon)" 
						+ ");";
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(queryCreate);
			return true;
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla pasajeros");
			e.printStackTrace();
			return false;
		}
	}

	// Método que inserta el pasajero pasado por parámetro en la tabla pasajeros
	public boolean create(Pasajero pasajero) {
		if (pasajero != null) {
			String queryInsert = "INSERT INTO pasajeros " 
							+ "(idPasajero, nombre, infoBillete, subidoEnVagon, idVagon)"
							+ " values (?,?,?,?,?);";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryInsert);
				sentenciaParametrizada.setInt(1, pasajero.getIdPasajero());
				sentenciaParametrizada.setString(2, pasajero.getNombre());
				sentenciaParametrizada.setString(3, pasajero.getInfoBillete());
				sentenciaParametrizada.setBoolean(4, pasajero.isSubidoEnVagon());
				sentenciaParametrizada.setInt(5, pasajero.getIdVagon());

				sentenciaParametrizada.executeUpdate();
				return true;
			} catch (SQLException e) {
				System.out.println("Error al insertar en tabla pasajeros");
				e.printStackTrace();
			}
		}
		return false;
	}
	// Método que extrae todos los registros de la tabla pasajeros y los añade
	// a un ArrayList<Pasajero>
	public ArrayList<Pasajero> readAll(){
		ArrayList<Pasajero> pasajerosBBDD = new ArrayList<Pasajero>();
		String querySelect = "SELECT * FROM pasajeros;";
		try {
			sentencia = connection.createStatement();
			resultSet = sentencia.executeQuery(querySelect);
			while(resultSet.next()) {
				pasajerosBBDD.add(new Pasajero(resultSet.getInt("idPasajero"), 
						resultSet.getString("nombre"), 
						resultSet.getString("infoBillete"), 
						resultSet.getBoolean("subidoEnVagon"),
						resultSet.getInt("idVagon")));
			}
		} catch (SQLException e) {
			System.out.println("Error al seleccionar en tabla pasajeros");
			e.printStackTrace();
		}
		return pasajerosBBDD;
	}


	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Pasajero> readPasajeros(int id) {
		ArrayList<Pasajero> pasajerosBBDD = new ArrayList<Pasajero>();
		String query = "select p.* "
					+ "from pasajeros p "
					+ "join vagonPasajeros vp "
					+ "on p.idVagon = vp.idVagon "
					+ "where vp.idVagon = ?";
		
		try {
			sentenciaParametrizada = connection.prepareStatement(query);
			sentenciaParametrizada.setInt(1, id);
			resultSet = sentenciaParametrizada.executeQuery();
			while(resultSet.next()) {
				pasajerosBBDD.add(new Pasajero(resultSet.getInt("idPasajero"),
												resultSet.getString("nombre"),
												resultSet.getString("infoBillete"),
												resultSet.getBoolean("subidoEnVagon"),
												resultSet.getInt("idVagon")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pasajerosBBDD;
	}

}
