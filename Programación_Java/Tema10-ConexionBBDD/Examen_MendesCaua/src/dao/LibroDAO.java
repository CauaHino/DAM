package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import conexionBBDD.ConexionBBDD;
import recursos.Libro;

public class LibroDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection conn;
	
	public LibroDAO() {
		this.conn = this.conexion.conectarPostgreSQL();
	}
	
	public boolean createTable() {
		String query = "create table if not exists Libro("
				+ "idRecurso int, "
				+ "autor varchar(25), "
				+ "isbn varchar(20), "
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
	
	public boolean create(Libro l) {
		if(l != null) {
			String query = "insert into libro values (?, ?, ?);";
			try(PreparedStatement sentenciaParametrizada = conn.prepareStatement(query)){
				sentenciaParametrizada.setInt(1, l.getIdRecurso());
				sentenciaParametrizada.setString(2, l.getAutor());
				sentenciaParametrizada.setString(3, l.getIsbn());
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
