package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bbdd.conexion.ConexionBBDD;
import cuentas.CuentaBancaria;
import cuentas.CuentaCorriente;

public class CuentaCorrienteDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet rs;

	public CuentaCorrienteDAO() {
		this.connection = this.conexion.conectar();
	}

	public boolean createTable() {
		String query = "create table if not exists CuentaCorriente(" + "idCuenta int primary key, "
				+ "listaEntidades varchar(100), " + "foreign key (idCuenta) references CuentaBancaria(idCuenta)" + ");";

		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			System.err.println("ERROR AL CREAR LA TABLA CUENTA CORRIENTE");
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

	public boolean insertCuentaCorriente(CuentaCorriente c) {
		String query = "insert into CuentaCorriente values (?,?);";

		try {
			sentenciaParametrizada = connection.prepareStatement(query);
			sentenciaParametrizada.setInt(1, c.getIdCuenta());
			sentenciaParametrizada.setString(2, c.getListaEntidades());
			sentenciaParametrizada.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("ERROR AL INSERTAR CUENTA DE CORRIENTE");
			e.printStackTrace();
			return false;
		}
	}

}
