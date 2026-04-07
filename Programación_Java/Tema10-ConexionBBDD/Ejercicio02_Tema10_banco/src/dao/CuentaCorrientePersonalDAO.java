package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bbdd.conexion.ConexionBBDD;
import cuentas.CuentaBancaria;
import cuentas.CuentaCorrientePersonal;

public class CuentaCorrientePersonalDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet rs;
	
	public CuentaCorrientePersonalDAO() {
		this.connection = this.conexion.conectar();
	}
	
	public boolean createTable() {
		String query = "create table if not exists CuentaCorrientePersonal("
				+ "idCuenta int, "
				+ "comisionMante decimal(10,2), "
				+ "foreign key (idCuenta) references CuentaCorriente(idCuenta)"
				+ ");";
		
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.err.println("ERROR AL CREAR LA TABLA CUENTA CORRIENTE PERSONAL");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean insertCuentaCorrientePersonal(CuentaCorrientePersonal c) {
		String query = "insert into cuentaBancaria values (?,?);";
		
		try {
			sentenciaParametrizada = connection.prepareStatement(query);
			sentenciaParametrizada.setInt(1, c.getIdCuenta());
			sentenciaParametrizada.setDouble(2, c.getComisionMantenimiento());
			sentenciaParametrizada.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("ERROR AL INSERTAR CUENTA DE AHORRO");
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
}
