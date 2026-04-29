package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import conexionBBDD.ConexionBBDD;
import recursos.VideoJuego;

public class VideoJuegoDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection conn;
	
	public VideoJuegoDAO() {
		this.conn = conexion.conectarPostgreSQL();
	}
	
	public boolean createTable() {
		String query = "create table if not exists VideoJuego("
				+ "idRecurso int, "
				+ "categoria varchar(20), "
				+ "digital boolean, "
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
	
	public boolean create(VideoJuego vj) {
		if(vj != null) {
			String query = "insert into videojuego values (?, ?, ?);";
			try(PreparedStatement sentenciaParametrizada = conn.prepareStatement(query)){
				sentenciaParametrizada.setInt(1, vj.getIdRecurso());
				sentenciaParametrizada.setString(2, vj.getCategoria());
				sentenciaParametrizada.setBoolean(3, vj.isDigital());
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
