package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBBDD.ConexionBBDD;
import trenes.Tren;
import vagones.Vagon;
import vagones.VagonMercancias;
import vagones.VagonPasajeros;

public class VagonDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet resultSet;

	// En el constructor establecemos la conexión a BBDD que quedará
	// abierta mientras usemos la clase LocomotoraDAO
	public VagonDAO() {
		this.connection = conexion.conectar();
	}

	public boolean createTable() {
		String queryCreate = "CREATE TABLE vagon(" + "idVagon int PRIMARY KEY," + "marca VARCHAR(20),"
				+ "modelo VARCHAR(20)" + ");";
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(queryCreate);
			return true;
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla vagon");
			e.printStackTrace();
			return false;
		}
	}

	// Método que inserta el pasajero pasado por parámetro en la tabla pasajeros
	public boolean create(Vagon vagon) {
		if (vagon != null) {
			String queryInsert = "INSERT INTO vagon " + "(idVagon, marca, modelo)" + " values (?,?,?);";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryInsert);
				sentenciaParametrizada.setInt(1, vagon.getIdentificador());
				sentenciaParametrizada.setString(2, vagon.getMarca());
				sentenciaParametrizada.setString(3, vagon.getModelo());

				sentenciaParametrizada.executeUpdate();
				return true;
			} catch (SQLException e) {
				System.out.println("Error al insertar en tabla vagon");
				e.printStackTrace();
			}
		}
		return false;
	}

	public ArrayList<Integer> readAll() {
		ArrayList<Integer> vagonesBBDD = new ArrayList<Integer>();
		String querySelect = "SELECT idVagon FROM vagon;";
		try {
			sentencia = connection.createStatement();
			resultSet = sentencia.executeQuery(querySelect);
			while (resultSet.next()) {
				vagonesBBDD.add(resultSet.getInt("idVagon"));
			}
		} catch (SQLException e) {
			System.out.println("Error al seleccionar en tabla vagon");
			e.printStackTrace();
		}
		return vagonesBBDD;
	}

	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

	public ArrayList<Vagon> readVagonesPasajeros(int idTren) {
		ArrayList<Vagon> vagonesPasajeros = new ArrayList<Vagon>();
		String query = "select v.*, vp.numAsientos, vp.numPasajeros " + "from Tren t " + "join trenlocomotoravagon tlv "
				+ "on t.idTren = tlv.idTren " + "join vagon v " + "on tlv.idVagon = v.idVagon "
				+ "join VagonPasajeros vp " + "on v.idVagon = vp.idVagon " + "where t.idTren = ?";

		try {
			sentenciaParametrizada = connection.prepareStatement(query);
			sentenciaParametrizada.setInt(1, idTren);
			resultSet = sentenciaParametrizada.executeQuery();
			while (resultSet.next()) {
				vagonesPasajeros.add(new VagonPasajeros(resultSet.getInt("idVagon"), resultSet.getString("marca"),
						resultSet.getString("modelo"), resultSet.getInt("numAsientos"),
						resultSet.getInt("numPasajeros")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vagonesPasajeros;
	}

	public ArrayList<Vagon> readVagonesMercancia(int idTren) {
		ArrayList<Vagon> vagonesMercancia = new ArrayList<Vagon>();
		String query = "select v.*, vm.capacidad " + "from Tren t " + "join trenlocomotoravagon tlv "
				+ "on t.idTren = tlv.idTren " + "join vagon v " + "on tlv.idVagon = v.idVagon "
				+ "join VagonMercancias vm " + "on v.idVagon = vm.idVagon " + "where t.idTren = ?";

		try {
			sentenciaParametrizada = connection.prepareStatement(query);
			sentenciaParametrizada.setInt(1, idTren);
			resultSet = sentenciaParametrizada.executeQuery();
			while (resultSet.next()) {
				vagonesMercancia.add(new VagonMercancias(resultSet.getInt("idVagon"), resultSet.getString("marca"),
						resultSet.getString("modelo"), resultSet.getDouble("capacidad")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vagonesMercancia;
	}

	public ArrayList<Vagon> readVagonesMixtos(int idTren) {
		ArrayList<Vagon> vagonesMixtos = new ArrayList<Vagon>();
		ArrayList<Vagon> vagonesMercancia = this.readVagonesMercancia(idTren);
		ArrayList<Vagon> vagonesPasajeros = this.readVagonesPasajeros(idTren);
		
		vagonesMixtos.addAll(vagonesMercancia);
		vagonesMixtos.addAll(vagonesPasajeros);
		
		return vagonesMixtos;
	}

}
