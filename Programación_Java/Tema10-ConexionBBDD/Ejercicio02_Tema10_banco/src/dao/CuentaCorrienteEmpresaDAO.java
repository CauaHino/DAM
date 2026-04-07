package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bbdd.conexion.ConexionBBDD;
import cuentas.CuentaBancaria;
import cuentas.CuentaCorrienteEmpresa;

public class CuentaCorrienteEmpresaDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet rs;
	
	public CuentaCorrienteEmpresaDAO() {
		this.connection = this.conexion.conectar();
	}
	
	public boolean createTable() {
		String query = "create table if not exists CuentaCorrienteEmpresa("
				+ "idCuenta int, "
				+ "maximoDescubierto decimal(10,2), "
				+ "interesDescubierto decimal(10,2), "
				+ "comisionDescubierto decimal(10,2), "
				+ "foreign key (idCuenta) references CuentaCorriente(idCuenta)"
				+ ");";
		
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.err.println("ERROR AL CREAR LA TABLA CUENTA EMPRESA");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean insertCuentaCorrienteEmpresa(CuentaCorrienteEmpresa c) {
		String query = "insert into cuentaCorrienteEmpresa values (?,?,?,?);";
		
		try {
			sentenciaParametrizada = connection.prepareStatement(query);
			sentenciaParametrizada.setInt(1, c.getIdCuenta());
			sentenciaParametrizada.setDouble(2, c.getMaximoDescubierto());
			sentenciaParametrizada.setDouble(3, c.getTipoInteresDescubierto());
			sentenciaParametrizada.setDouble(4,c.getComisionFijaDescubierto());
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
