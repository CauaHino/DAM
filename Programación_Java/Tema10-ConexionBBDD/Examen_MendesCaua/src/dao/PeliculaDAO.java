package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import conexionBBDD.ConexionBBDD;
import recursos.Pelicula;

public class PeliculaDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection conn;
	
	public PeliculaDAO() {
		this.conn = conexion.conectarPostgreSQL();
	}
	
	public boolean createTable() {
		String query = "create table if not exists Pelicula("
				+ "idRecurso int, "
				+ "director varchar(20), "
				+ "fechaEstreno date, "
				+ "foreign key (idRecurso) references Recurso(idRecurso)"
				+ ");";
		
		try(Statement sentencia = conn.createStatement()){
			sentencia.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean create(Pelicula p) {
		if(p != null) {
			String query = "insert into Pelicula values (?, ?, ?);";
			try(PreparedStatement sentenciaParametrizada = conn.prepareStatement(query)){
				sentenciaParametrizada.setInt(1, p.getIdRecurso());
				sentenciaParametrizada.setString(2, p.getDirector());
				sentenciaParametrizada.setDate(3, p.getFechaEstreno());
				sentenciaParametrizada.executeUpdate();
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
