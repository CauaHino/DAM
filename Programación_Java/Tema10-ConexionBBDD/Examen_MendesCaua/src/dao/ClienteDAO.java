package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clientes.Cliente;
import conexionBBDD.ConexionBBDD;
import recursos.Recurso;

public class ClienteDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection conn;
	
	public ClienteDAO() {
		this.conn = this.conexion.conectarPostgreSQL();
	}
	
	public boolean createTable() {
		String query = "create table if not exists Cliente("
				+ "idCliente int primary key, "
				+ "nombre varchar(20), "
				+ "dni varchar(9), "
				+ "basic boolean, "
				+ "estandar boolean, "
				+ "premium boolean, "
				+ "numRecursos int"
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
	
	public boolean create(Cliente c) {
		if(c != null) {
			String query = "insert into cliente values (?, ?, ?, ?, ?, ?, ?);";
			try(PreparedStatement sentenciaParametrizada = conn.prepareStatement(query)){
				sentenciaParametrizada.setInt(1, c.getIdCliente());
				sentenciaParametrizada.setString(2, c.getNombre());
				sentenciaParametrizada.setString(3, c.getDni());
				sentenciaParametrizada.setBoolean(4, c.isBasic());
				sentenciaParametrizada.setBoolean(5, c.isEstandar());
				sentenciaParametrizada.setBoolean(6, c.isPremium());
				sentenciaParametrizada.setInt(7, c.getNumRecursos());
				sentenciaParametrizada.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public int readID() {
		int id = 0;
		String query = "select idCliente "
				+ "from cliente "
				+ "order by idCliente desc "
				+ "limit 1;";
		
		try(Statement sentencia = conn.createStatement()){
			ResultSet rs = sentencia.executeQuery(query);
			if(rs.next()) {
				id = rs.getInt("idCliente");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public ArrayList<Cliente> readAll(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		String query = "select c.* "
				+ "from cliente c; ";
		
		try(Statement sentencia = conn.createStatement()){
			ResultSet rs = sentencia.executeQuery(query);
			while(rs.next()) {
				clientes.add(new Cliente(rs.getInt("idCliente"), rs.getString("nombre"), rs.getString("dni"), 
						rs.getBoolean("basic"),rs.getBoolean("estandar"),rs.getBoolean("premium"), rs.getInt("numRecursos")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}
	
	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

}
