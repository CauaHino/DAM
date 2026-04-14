package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bbdd.conexion.ConexionBBDD;
import excepciones.MenorDeEdad;
import personas.Persona;
import personas.Profesor;

public class ProfesorDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection conn;
	
	public ProfesorDAO() {
		this.conn = this.conexion.conectar();
	}
	
	public boolean createTable() {
		String query = "create table if not exists Profesor("
				+ "idProfesor int primary key, "
				+ "departamento varchar(100), "
				+ "foreign key (idProfesor) references persona(idPersona)"
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
	
	public boolean insert(Profesor p) {
		String query = "insert into profesor values (?, ?)";
		
		try(PreparedStatement sentencia = conn.prepareStatement(query)){
			sentencia.setInt(1, p.getIdPersona());
			sentencia.setString(2, p.getDepartamento());
			sentencia.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public ArrayList<Profesor> read() {
		ArrayList<Profesor> profesores = new ArrayList<Profesor>();
		String query = "select pr.*, p.* "
				+ "from persona p "
				+ "join profesor pr on p.idPersona = pr.idProfesor;";
		try(Statement sentencia = conn.createStatement()){
			ResultSet rs = sentencia.executeQuery(query);
			while(rs.next()) {
				Profesor p = new Profesor(rs.getInt("idProfesor"), rs.getString("nombre"), rs.getString("apellidos"), 
						rs.getInt("edad"), rs.getString("curso"), rs.getString("departamento"));
				profesores.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MenorDeEdad e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profesores;
	}

}
