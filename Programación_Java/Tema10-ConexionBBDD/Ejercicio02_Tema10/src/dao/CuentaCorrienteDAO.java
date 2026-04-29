package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexionBBDD.ConexionBBDD;
import cuentas.CuentaBancaria;
import cuentas.CuentaCorriente;

public class CuentaCorrienteDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet rs;

	// En el constructor creamos la conexión que se mantendra abierta todo el tiempo
	// que usemos el CuentaBancariaDAO
	public CuentaCorrienteDAO() {
		//connection = conexion.conectarMySQL();
		connection = conexion.conectarPostgreSQL();
	}
	
	public void createTable() {
		String queryCreate = "create table cuentacorriente "
				+ "(idCuenta int PRIMARY KEY, listaEntidades VARCHAR(30), "
				+ "constraint fk_idCuenta foreign key (idCuenta) "
				+ "references CuentaBancaria (idCuenta)"
				+ ");";
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(queryCreate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método que inserta al CuentaBancaria pasado como parámetro como un registro de la
	// tabla CuentaBancaria.
	public void create(CuentaBancaria cuenta) {
		if (cuenta != null) {
			String queryInsert = "INSERT INTO cuentacorriente (idCuenta, listaEntidades) "
					+ "values (?,?)";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryInsert);
				sentenciaParametrizada.setInt(1, cuenta.getIdCuenta());
				sentenciaParametrizada.setString(2, ((CuentaCorriente)cuenta).getListaEntidades());
				sentenciaParametrizada.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

}
