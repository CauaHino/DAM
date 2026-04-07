package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import banco.Banco;
import bbdd.conexion.ConexionBBDD;
import cuentas.CuentaAhorro;
import cuentas.CuentaBancaria;

public class CuentaBancariaDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet rs;
	
	public CuentaBancariaDAO() {
		this.connection = this.conexion.conectar();
	}
	
	public boolean createTable() {
		String query = "create table if not exists CuentaBancaria("
				+ "idCuenta int primary key, "
				+ "iban varchar(22), "
				+ "saldo decimal(10,2), "
				+ "idPersona int, "
				+ "idBanco int, "
				+ "foreign key (idPersona) references Personas(idPersona), "
				+ "foreign key (idBanco) references Banco(idBanco)"
				+ ");";
		
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.err.println("ERROR AL CREAR LA TABLA CUENTA BANCARIA");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean insertCuentaBancaria(CuentaBancaria c) {
		String query = "insert into cuentaBancaria (idCuenta, iban, saldo, idPersona, idBanco) values (?,?,?,?,?);";
		
		try {
			sentenciaParametrizada = connection.prepareStatement(query);
			sentenciaParametrizada.setInt(1, c.getIdCuenta());
			sentenciaParametrizada.setString(2, c.getIBAN());
			sentenciaParametrizada.setDouble(3, c.getSaldo());
			sentenciaParametrizada.setInt(4,c.getTitular().getIdPersona());
			sentenciaParametrizada.setInt(5, c.getIdBanco());
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
