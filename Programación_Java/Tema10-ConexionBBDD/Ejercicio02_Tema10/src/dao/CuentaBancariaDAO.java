package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBBDD.ConexionBBDD;
import cuentas.CuentaBancaria;
import personas.Persona;

public class CuentaBancariaDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet rs;

	// En el constructor creamos la conexión que se mantendra abierta todo el tiempo
	// que usemos el CuentaBancariaDAO
	public CuentaBancariaDAO() {
		//connection = conexion.conectarMySQL();
		connection = conexion.conectarPostgreSQL();
	}
	
	public void createTable() {
		String queryCreate = "create table cuentabancaria "
						+ "(idCuenta int PRIMARY KEY UNIQUE, IBAN VARCHAR(24), "
						+ "saldo DECIMAL(10,2), idPersona int, idBanco int,"
						+ "constraint fk_idPersona foreign key (idPersona) "
						+ "references personas (idPersona),"
						+ "constraint fk_idBanco foreign key (idBanco) "
						+ "references banco (idBanco)"
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
			String queryInsert = "INSERT INTO cuentabancaria "
					+ "(idCuenta, IBAN, saldo, idPersona, idBanco) "
					+ "values (?,?,?,?,?)";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryInsert);
				sentenciaParametrizada.setInt(1, cuenta.getIdCuenta());
				sentenciaParametrizada.setString(2, cuenta.getIBAN());
				sentenciaParametrizada.setDouble(3, cuenta.getSaldo());
				sentenciaParametrizada.setInt(4, cuenta.getTitular().getIdPersona());
				sentenciaParametrizada.setInt(5, cuenta.getIdBanco());
				sentenciaParametrizada.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int readLastIdCuenta() {
		int lastIdCuenta = 0;
		String querySelect = "SELECT idCuenta FROM CuentaBancaria "
							+ "ORDER BY idCuenta DESC;";
		try {
			sentencia = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
			rs = sentencia.executeQuery(querySelect);
			if (rs.next()) {
				lastIdCuenta = rs.getInt("idCuenta");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastIdCuenta;
	}
	
	public ArrayList<String> readAllIBAN(){
		ArrayList<String> listaIBAN = new ArrayList<String>();
		String querySelect = "SELECT iban FROM CuentaBancaria;";
		try {
			sentencia = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = sentencia.executeQuery(querySelect);
			while (rs.next()) {
				listaIBAN.add(rs.getString("iban"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaIBAN;
	}
	
	public boolean ingresarSaldo(String IBAN, double cantidad) {
		if (IBAN != null) {
			CuentaBancaria cuenta = null;
			Persona titular = null;
			String querySelect = "SELECT cb.saldo "
								+ "FROM CuentaBancaria as cb "
								+ "WHERE cb.IBAN = ? "
								+ "ORDER BY cb.idCuenta;";
			try {
				sentenciaParametrizada = connection.prepareStatement(querySelect, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				sentenciaParametrizada.setString(1, IBAN);
				rs = sentenciaParametrizada.executeQuery();
				if(rs.next()) {
					double saldo = rs.getDouble("saldo");
					saldo+=cantidad;
					String queryUpdate = "UPDATE CuentaBancaria SET saldo = ? WHERE IBAN = ?";
					sentenciaParametrizada = connection.prepareStatement(queryUpdate);
					sentenciaParametrizada.setDouble(1, saldo);
					sentenciaParametrizada.setString(2, IBAN);
					sentenciaParametrizada.executeUpdate();
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return false;
	}
	
	public boolean retirarSaldo(String IBAN, double cantidad) {
		if (IBAN != null) {
			CuentaBancaria cuenta = null;
			Persona titular = null;
			String querySelect = "SELECT cb.saldo "
								+ "FROM CuentaBancaria as cb "
								+ "WHERE cb.IBAN = ? "
								+ "ORDER BY cb.idCuenta;";
			try {
				sentenciaParametrizada = connection.prepareStatement(querySelect, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				sentenciaParametrizada.setString(1, IBAN);
				rs = sentenciaParametrizada.executeQuery();
				if(rs.next()) {
					double saldo = rs.getDouble("saldo");
					if(saldo - cantidad < 0) {
						System.out.println("No hay suficiente dinero en la cuenta");
						return false;
					}
					else {
						saldo-=cantidad;
						String queryUpdate = "UPDATE CuentaBancaria SET saldo = ? WHERE IBAN = ?";
						sentenciaParametrizada = connection.prepareStatement(queryUpdate);
						sentenciaParametrizada.setDouble(1, saldo);
						sentenciaParametrizada.setString(2, IBAN);
						sentenciaParametrizada.executeUpdate();
						return true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return false;
	}
	
	public double consultarSaldo(String IBAN) {
		if (IBAN != null) {
			String querySelect = "SELECT cb.saldo "
								+ "FROM CuentaBancaria as cb "
								+ "WHERE cb.IBAN = ? "
								+ "ORDER BY cb.idCuenta;";
			try {
				sentenciaParametrizada = connection.prepareStatement(querySelect, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				sentenciaParametrizada.setString(1, IBAN);
				rs = sentenciaParametrizada.executeQuery();
				if(rs.next()) {
					return rs.getDouble("saldo");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return -1;
	}

	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}
	
}
