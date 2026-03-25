package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBBDD.ConexionBBDD;
import locomotoras.Locomotora;

public class LocomotoraDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet resultSet;

	// En el constructor establecemos la conexión a BBDD que quedará
	// abierta mientras usemos la clase LocomotoraDAO
	public LocomotoraDAO() {
		this.connection = this.conexion.conectar();
	}
	
	public boolean createTable() {
		String queryCreate = "CREATE TABLE locomotora(" 
						+ "idLocomotora int PRIMARY KEY," 
						+ "marca VARCHAR(20),"
						+ "modelo VARCHAR(20)," 
						+ "tipo VARCHAR(20),"
						+ "potencia DECIMAL(10,2)" 
						+ ");";
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(queryCreate);
			return true;
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla locomotora");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean create(Locomotora locomotora) {
		if (locomotora != null) {
			String queryInsert = "INSERT INTO locomotora " 
							+ "(idLocomotora, marca, modelo, tipo, potencia)"
							+ " values (?,?,?,?,?);";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryInsert);
				sentenciaParametrizada.setInt(1, locomotora.getIdLocomotora());
				sentenciaParametrizada.setString(2, locomotora.getMarca());
				sentenciaParametrizada.setString(3, locomotora.getModelo());
				sentenciaParametrizada.setString(4, locomotora.getTipo());
				sentenciaParametrizada.setDouble(5, locomotora.getPotencia());

				sentenciaParametrizada.executeUpdate();
				return true;
			} catch (SQLException e) {
				System.out.println("Error al insertar en tabla locomotora");
				e.printStackTrace();
			}
		}
		return false;
	}

	public ArrayList<Integer> readAll(){
		ArrayList<Integer> idsLocomotoras = new ArrayList<Integer>();
		String querySelect = "SELECT idLocomotora FROM locomotora;";
		try {
			sentencia = connection.createStatement();
			resultSet = sentencia.executeQuery(querySelect);
			while(resultSet.next()) {
				idsLocomotoras.add(resultSet.getInt("idLocomotora"));
			}
		} catch (SQLException e) {
			System.out.println("Error al seleccionar en tabla locomotora");
			e.printStackTrace();
		}
		return idsLocomotoras;
	}
	
		
	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

	public Locomotora readLocomotora(int idTren) {
		Locomotora l = null;
		String query = "Select l.* "
						+ "from Tren as t "
						+ "join trenlocomotoravagon as tlv "
						+ "on t.idTren = tlv.idTren "
						+ "join locomotora as l "
						+ "on tlv.idLocomotora = l.idLocomotora "
						+  "where t.idTren = ?";
		
		try {
			sentenciaParametrizada = connection.prepareStatement(query);
			sentenciaParametrizada.setInt(1, idTren);
			resultSet = sentenciaParametrizada.executeQuery();
			if(resultSet.next()) {
				l = new Locomotora(resultSet.getInt("idLocomotora"),
									resultSet.getString("marca"),
									resultSet.getString("modelo"),
									resultSet.getString("tipo"),
									resultSet.getDouble("potencia"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

}
