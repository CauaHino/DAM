package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bbdd.conexion.ConexionBBDD;
import cuentas.CuentaBancaria;
import cuentas.CuentaCorrienteEmpresa;
import cuentas.CuentaCorrientePersonal;
import personas.Persona;

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
		String query = "insert into cuentaCorrientePersonal values (?,?);";
		
		try {
			sentenciaParametrizada = connection.prepareStatement(query);
			sentenciaParametrizada.setInt(1, c.getIdCuenta());
			sentenciaParametrizada.setDouble(2, c.getComisionMantenimiento());
			sentenciaParametrizada.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println("ERROR AL INSERTAR CUENTA DE CORRIENTE PERSONAL");
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<CuentaBancaria> read() {
		ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
		Persona titular = null;
		String querySelect = "SELECT cb.idCuenta, cb.iban, cb.saldo, cc.listaentidades, ccp.comisionmante, per.* "
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
						titular,rs.getString("listaEntidades"), rs.getDouble("comisionMante")));
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
