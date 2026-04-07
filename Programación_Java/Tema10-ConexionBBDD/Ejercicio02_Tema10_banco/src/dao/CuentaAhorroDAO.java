package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bbdd.conexion.ConexionBBDD;
import cuentas.CuentaAhorro;
import cuentas.CuentaBancaria;

public class CuentaAhorroDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	// private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet rs;
	
	public CuentaAhorroDAO() {
		this.connection = this.conexion.conectar();
	}
	
	public boolean createTable() {
		String query = "create table if not exists CuentaAhorro("
				+ "idCuenta int, "
				+ "tipoInteres decimal(6,2), "
				+ "foreign key (idCuenta) references CuentaBancaria(idCuenta)"
				+ ");";
		
		try(Statement sentencia = connection.createStatement()){
			
			sentencia.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.err.println("ERROR AL CREAR LA TABLA CUENTA AHORRO");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean insertCuentaAhorro(CuentaAhorro c) {
		String query = "insert into cuentaAhorro (idCuenta, tipoInteres) values (?,?);";
		
		try {
			sentenciaParametrizada = connection.prepareStatement(query);
			sentenciaParametrizada.setInt(1, c.getIdCuenta());
			sentenciaParametrizada.setDouble(2, c.getTipoInteresAnual());
			sentenciaParametrizada.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("ERROR AL INSERTAR CUENTA DE AHORRO");
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<CuentaAhorro> listarCuentaAhorro() {
		ArrayList<CuentaAhorro> cuentasAhorros = new ArrayList<CuentaAhorro>();
		PersonasDAO personas = new PersonasDAO();
		String query = "select cb.*, ca.tipointeres "
				+ "from CuentaAhorro ca "
				+ "join CuentaBancaria cb on cb.idCuenta = ca.idCuenta; ";
		try(Statement sentencia = connection.createStatement()) {
			;
			rs = sentencia.executeQuery(query);
			while(rs.next()) {
				CuentaAhorro c = new CuentaAhorro(rs.getInt("idCuenta"), rs.getDouble("Saldo"), rs.getString("iban"), personas.read(rs.getInt("idPersona")), rs.getDouble("tipoInteres"));
				cuentasAhorros.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cuentasAhorros;
	}
	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}
}
