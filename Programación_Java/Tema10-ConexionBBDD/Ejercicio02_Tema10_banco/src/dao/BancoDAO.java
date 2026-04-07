package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import banco.Banco;
import bbdd.conexion.ConexionBBDD;

public class BancoDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private ResultSet rs;
	private Statement sentencia;
	private PreparedStatement sentenciaParamentrizada;
	
	public BancoDAO() {
		this.connection = this.conexion.conectar();
	}
	
	public boolean createTable() {
		String query = "create table if not exists banco("
				+ "idBanco int primary key, "
				+ "numCuentas int"
				+ ");";
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.err.println("Error al crear la tabla BANCO");
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

	public int ultimoID() {
		int idBanco = 0;
		String query = "select idBanco from banco "
				+ "order by idBanco desc "
				+ "limit 1;";
		
		try {
			sentencia = connection.createStatement();
			rs = sentencia.executeQuery(query);
			if(rs.next())
				idBanco = rs.getInt("idBanco");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idBanco;
	}
	
	public boolean create(Banco b) {
		String query = "insert into banco values (?, ?)";
		
		try {
			sentenciaParamentrizada = connection.prepareStatement(query);
			sentenciaParamentrizada.setInt(1, b.getIdBanco());
			sentenciaParamentrizada.setInt(2, b.getNumeroCuentas());
			sentenciaParamentrizada.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

}
