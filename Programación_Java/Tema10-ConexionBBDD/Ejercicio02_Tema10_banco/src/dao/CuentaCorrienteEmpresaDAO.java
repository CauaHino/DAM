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
import personas.Persona;

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

	public ArrayList<CuentaBancaria> read() {
		ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
		Persona titular = null;
		String querySelect = "SELECT cb.idCuenta, cb.iban, cb.saldo, cc.listaentidades, cce.maximoDescubierto, cce.interesDescubierto, "
							+ "cce.comisionDescubierto, per.* "
							+ "FROM CuentaBancaria as cb "
							+ "INNER JOIN CuentaCorriente as cc "
							+ "ON cb.idCuenta = cc.idCuenta "
							+ "INNER JOIN CuentaCorrienteEmpresa as cce "
							+ "ON cc.idCuenta = cce.idCuenta "
							+ "INNER JOIN Personas as per "
							+ "ON cb.idPersona = per.idPersona "
							+ "ORDER BY cb.idCuenta;";
		try {
			sentencia = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = sentencia.executeQuery(querySelect);
			while (rs.next()) {
				titular = new Persona(rs.getInt("idPersona"), rs.getString("nombre"), rs.getString("apellidos"), 
						rs.getString("dni"), rs.getInt("edad"));
				cuentas.add(new CuentaCorrienteEmpresa(rs.getInt("idCuenta"),rs.getDouble("saldo"), rs.getString("IBAN"),
						titular,rs.getString("listaEntidades"), rs.getDouble("maximoDescubierto"), rs.getDouble("interesDescubierto"),
						rs.getDouble("comisionDescubierto")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cuentas;
	}
}
