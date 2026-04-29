package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBBDD.ConexionBBDD;
import cuentas.CuentaBancaria;
import cuentas.CuentaCorrientePersonal;
import personas.Persona;

public class CuentaCorrientePersonalDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet rs;

	// En el constructor creamos la conexión que se mantendra abierta todo el tiempo
	// que usemos el CuentaBancariaDAO
	public CuentaCorrientePersonalDAO() {
		//connection = conexion.conectarMySQL();
		connection = conexion.conectarPostgreSQL();
	}
	
	public void createTable() {
		String queryCreate = "create table cuentacorrientepersonal "
				+ "(idCuenta int PRIMARY KEY, "
				+ "comisionmantenimiento DECIMAL(5,2),"
				+ "constraint fk_idCuenta foreign key (idCuenta) "
				+ "references cuentacorriente (idCuenta)"
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
			String queryInsert = "INSERT INTO cuentacorrientepersonal (idCuenta, comisionmantenimiento) "
					+ "values (?,?)";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryInsert);
				sentenciaParametrizada.setInt(1, cuenta.getIdCuenta());
				sentenciaParametrizada.setDouble(2, ((CuentaCorrientePersonal)cuenta).getComisionMantenimiento());
				sentenciaParametrizada.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<CuentaBancaria> read() {
		ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
		Persona titular = null;
		String querySelect = "SELECT cb.idCuenta, cb.iban, cb.saldo, cc.listaentidades, ccp.comisionmantenimiento, per.* "
							+ "FROM CuentaBancaria as cb "
							+ "INNER JOIN CuentaCorriente as cc "
							+ "ON cb.idCuenta = cc.idCuenta "
							+ "INNER JOIN CuentaCorrientePersonal as ccp "
							+ "ON cc.idCuenta = ccp.idCuenta "
							+ "INNER JOIN Personas as per "
							+ "ON cb.idPersona = per.idPersona "
							+ "ORDER BY cb.idCuenta;";
		try {
			sentencia = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = sentencia.executeQuery(querySelect);
			while (rs.next()) {
				titular = new Persona(rs.getInt("idPersona"), rs.getString("nombre"), rs.getString("apellidos"), 
						rs.getString("dni"), rs.getInt("edad"));
				cuentas.add(new CuentaCorrientePersonal(rs.getInt("idCuenta"),rs.getDouble("saldo"), rs.getString("IBAN"),
						titular,rs.getString("listaEntidades"), rs.getDouble("comisionMantenimiento")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cuentas;
	}
	
	public CuentaBancaria readIBAN(String IBAN) {
		CuentaBancaria cuenta = null;
		Persona titular = null;
		String querySelect = "SELECT cb.idCuenta, cb.iban, cb.saldo, cc.listaentidades, ccp.comisionmantenimiento, per.* "
							+ "FROM CuentaBancaria as cb "
							+ "INNER JOIN CuentaCorriente as cc "
							+ "ON cb.idCuenta = cc.idCuenta "
							+ "INNER JOIN CuentaCorrientePersonal as ccp "
							+ "ON cc.idCuenta = ccp.idCuenta "
							+ "INNER JOIN Personas as per "
							+ "ON cb.idPersona = per.idPersona "
							+ "WHERE cb.IBAN = ? "
							+ "ORDER BY cb.idCuenta;";
		try {
			sentenciaParametrizada = connection.prepareStatement(querySelect, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sentenciaParametrizada.setString(1, IBAN);
			rs = sentenciaParametrizada.executeQuery();
			while (rs.next()) {
				titular = new Persona(rs.getInt("idPersona"), rs.getString("nombre"), rs.getString("apellidos"), 
						rs.getString("dni"), rs.getInt("edad"));
				cuenta = new CuentaCorrientePersonal(rs.getInt("idCuenta"),rs.getDouble("saldo"), rs.getString("IBAN"),
						titular,rs.getString("listaEntidades"), rs.getDouble("comisionMantenimiento"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cuenta;
	}

	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

}
