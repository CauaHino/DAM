package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import conexionBBDD.ConexionBBDD;
import modelo.Producto;

public class ProductoDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection conn;

	public ProductoDAO() {
		this.conn = this.conexion.conectar();
	}

	public boolean createTable() {
		String query = "create table if not exists productos(" + "idProducto serial primary key, "
				+ "nombre varchar(100), " + "cantidad int, " + "precio decimal(6,2), " + "fechaCreacion date, "
				+ "fechaActualizacion date" + ");";

		try (Statement sentencia = conn.createStatement()) {
			sentencia.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertProducto(Producto p) {
		String query = "insert into Productos (nombre, cantidad, precio, fechaCreacion) values (?,?,?,?)";
		if (p != null) {
			try (PreparedStatement sentencia = conn.prepareStatement(query)) {
				sentencia.setString(1, p.getNombre());
				sentencia.setInt(2, p.getCantidad());
				sentencia.setDouble(3, p.getPrecio());
				sentencia.setDate(4, p.getFechaCreacion());
				sentencia.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

}
