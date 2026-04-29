package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import banco.Banco;
import conexionBBDD.ConexionBBDD;
import cuentas.CuentaAhorro;
import cuentas.CuentaBancaria;
import personas.Persona;

public class BancoDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet rs;

	// En el constructor creamos la conexión que se mantendra abierta todo el tiempo
	// que usemos el CuentaBancariaDAO
	public BancoDAO() {
		// connection = conexion.conectarMySQL();
		connection = conexion.conectarPostgreSQL();
	}

	public void createTable() {
		String queryCreate = "create table banco " + "(idBanco int PRIMARY KEY UNIQUE, numCuentas int);";
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(queryCreate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Método que inserta al CuentaBancaria pasado como parámetro como un registro
	// de la
	// tabla CuentaBancaria.
	public void create(Banco banco) {
		if (banco != null) {
			String queryInsert = "INSERT INTO banco (idBanco, numCuentas) " 
								+ "values (?,?)";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryInsert);
				sentenciaParametrizada.setInt(1, banco.getIdBanco());
				sentenciaParametrizada.setInt(2, banco.getNumeroCuentas());
				sentenciaParametrizada.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Banco readBanco() {
		Banco banco = null;
		String querySelect = "SELECT * FROM Banco ORDER BY idBanco DESC;";
		try {
			sentencia = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = sentencia.executeQuery(querySelect);
			if (rs.next()) {
				banco = new Banco(rs.getInt("idBanco"), rs.getInt("numCuentas"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return banco;
	}

	public void updateNumCuentas(Banco banco) {
		if (banco != null) {
			String queryUpdate = "UPDATE banco SET numCuentas = ? WHERE idBanco = ?;";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryUpdate);
				sentenciaParametrizada.setInt(1, banco.getNumeroCuentas());
				sentenciaParametrizada.setInt(2, banco.getIdBanco());
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
		String querySelect = "SELECT cb.idCuenta, cb.iban, cb.saldo, ca.tipoInteres, cc.listaEntidades, ccp.comisionMantenimiento,"
				+ "cce.maximoDescubierto, cce.interesDescubierto, cce.comisionDescubierto, per.*"
				+ "FROM CuentaBancaria as cb" + "INNER JOIN CuentaAhorro as ca" + "ON cb.idCuenta = ca.idCuenta"
				+ "INNER JOIN CuentaCorriente as cc" + "ON cb.idCuenta = cc.idCuenta"
				+ "INNER JOIN CuentaCorrientePersonal as ccp" + "ON cc.idCuenta = ccp.idCuenta"
				+ "INNER JOIN CuentaCorrienteEmpresa as cce" + "ON cc.idCuenta = cce.idCuenta"
				+ "INNER JOIN Personas as per" + "ON cb.idPersona = per.idPersona" + "ORDER BY cb.idCuenta;";
		try {
			sentencia = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = sentencia.executeQuery(querySelect);
			while (rs.next()) {
				titular = new Persona(rs.getInt("idPersona"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("dni"), rs.getInt("edad"));
				if (rs.getDouble("tipoInteres") != 0) {
					cuentas.add(new CuentaAhorro(rs.getInt("idCuenta"), rs.getDouble("saldo"), rs.getString("IBAN"),
							titular, rs.getDouble("tipoInteres")));
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cuentas;
	}

	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

}
