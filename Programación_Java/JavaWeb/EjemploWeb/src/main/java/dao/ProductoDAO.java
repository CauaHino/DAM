package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBBDD.ConexionBBDD;
import modelo.Producto;

public class ProductoDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection conn;

	public ProductoDAO() {
		this.conn = this.conexion.conectarDotenv();
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
	
	public ArrayList<Producto> consultarProducto(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		String query = "select * "
				+ "from productos "
				+ "order by idProducto;";
		
		try(Statement sentencia = conn.createStatement()){
			ResultSet rs = sentencia.executeQuery(query);
			while(rs.next()) {
				productos.add(new Producto(rs.getInt("idProducto"), rs.getString("nombre"), rs.getInt("cantidad"),
											rs.getDouble("precio"), rs.getDate("fechaCreacion"), rs.getDate("fechaActualizacion")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productos;
	}

	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

	public Producto consultarProducto(int idProducto) {
		Producto p = null;		
		String query = "select * from productos where idProducto = ?";
		
		try(PreparedStatement sentencia = conn.prepareStatement(query)){
			sentencia.setInt(1, idProducto);
			ResultSet rs = sentencia.executeQuery();
			if(rs.next()) {
				p = new Producto(rs.getInt("idProducto"), rs.getString("nombre"), rs.getInt("cantidad"),
						rs.getDouble("precio"), rs.getDate("fechaCreacion"), rs.getDate("fechaActualizacion"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
	
	public boolean editarProducto(Producto p) {
		String query = "update productos "
				+ "set nombre = ?, "
				+ "cantidad = ?, "
				+ "precio = ?, "
				+ "fechaActualizacion = ? "
				+ "where idProducto = ?";
		
		if(p != null) {
			try(PreparedStatement sentencia = conn.prepareStatement(query)){
				sentencia.setString(1, p.getNombre());
				sentencia.setInt(2, p.getCantidad());
				sentencia.setDouble(3, p.getPrecio());
				sentencia.setDate(4, p.getFechaActualizacion());
				sentencia.setInt(5, p.getIdProducto());
				
				sentencia.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean eliminarProducto(int idProducto) {
		String query = "delete from productos "
				+ "where idProducto = ?";
		
		try(PreparedStatement sentencia = conn.prepareStatement(query)){
			sentencia.setInt(1, idProducto);
			sentencia.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
