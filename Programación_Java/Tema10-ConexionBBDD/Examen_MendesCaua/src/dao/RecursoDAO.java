package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clientes.Cliente;
import conexionBBDD.ConexionBBDD;
import recursos.*;

public class RecursoDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection conn;
	
	public RecursoDAO() {
		this.conn = this.conexion.conectarPostgreSQL();
	}
	
	public boolean createTable() {
		String query = "create table if not exists Recurso("
				+ "idRecurso int primary key, "
				+ "titulo varchar(30), "
				+ "numDias int, "
				+ "prestado boolean, "
				+ "idCliente int, "
				+ "foreign key (idCliente) references cliente(idCliente)"
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
	
	public boolean create(Recurso r) {
		if(r != null) {
			String query = "insert into recurso (idRecurso, titulo, numDias, prestado) "
					+ "values (?, ?, ?, ?);";
			try(PreparedStatement sentenciaParametrizada = conn.prepareStatement(query)){
				sentenciaParametrizada.setInt(1, r.getIdRecurso());
				sentenciaParametrizada.setString(2, r.getTitulo());
				sentenciaParametrizada.setInt(3, r.getNumDias());
				sentenciaParametrizada.setBoolean(4, r.isPrestado());
				sentenciaParametrizada.executeUpdate();
				if(r.isPrestado()) {
					String update = "update recurso "
							+ "set idCliente = ? "
							+ "where idRecurso = ?;";
					try(PreparedStatement sentencia = conn.prepareStatement(update)){
						sentencia.setInt(1, r.getIdCliente());
						sentencia.setInt(2, r.getIdRecurso());
						sentencia.executeUpdate();
					}
				}
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public int readId() {
		int id = 0;
		String query = "select idRecurso "
				+ "from Recurso "
				+ "order by idRecurso desc "
				+ "limit 1;";
		
		try(Statement sentencia = conn.createStatement()){
			ResultSet rs = sentencia.executeQuery(query);
			if(rs.next()) {
				id = rs.getInt("idRecurso");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public ArrayList<Recurso> readAll(Cliente c){
		ArrayList<Recurso> recursos = new ArrayList<Recurso>();
		String query = "select r.* "
				+ "from recurso r "
				+ "where r.idCliente = ?;";
		
		try(PreparedStatement sentencia = conn.prepareStatement(query)){
			sentencia.setInt(1, c.getIdCliente());
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				for(int i = 0; i < c.getRecursos().size(); i++) {
					if(c.getRecursos().get(i) instanceof Libro) {
						Recurso r = new Libro();
						r.setIdRecurso(rs.getInt("idRecurso"));
						r.setTitulo(rs.getString("titulo"));
						r.setNumDias(rs.getInt("numDias"));
						r.setPrestado(rs.getBoolean("prestado"));
						r.setIdCliente(rs.getInt("idCliente"));
						recursos.add(r);
					}else if(c.getRecursos().get(i) instanceof Pelicula) {
						Recurso r = new Pelicula();
						r = new Pelicula();
						((Pelicula)r).setDirector(rs.getString("director"));
						((Pelicula)r).setFechaEstreno(rs.getDate("fechaEstreno"));
						recursos.add(r);
					} else if(c.getRecursos().get(i) instanceof VideoJuego) {
						Recurso r = new VideoJuego();
						r = new VideoJuego();
						((VideoJuego)r).setCategoria(rs.getString("categoria"));
						((VideoJuego)r).setDigital(rs.getBoolean("digital"));
						recursos.add(r);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recursos;
	}
	
	
	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

}
