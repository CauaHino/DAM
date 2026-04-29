package conexionBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBBDD {
	private static final String DRIVER_POSTGRESQL = "org.postgresql.Driver";
	private static final String URL_POSTGRESQL_INICIAL = "jdbc:postgresql://localhost:5432/";
	private static final String URL_POSTGRESQL = "jdbc:postgresql://localhost:5432/banco";
	private static final String USUARIO_POSTGRESQL = "postgres";
	private static final String PASSWORD_POSTGRESQL = "1234";
	
	private static final String DRIVER_MYSQL = "com.mysql.cj.jdbc.Driver";
	private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/banco";
	private static final String USUARIO_MYSQL = "root";
	private static final String PASSWORD_MYSQL = "1234";
	
	private Connection conexion = null;
	
	public Connection conectarPostgreSQL() {
		try {
			Class.forName(DRIVER_POSTGRESQL);
			conexion = DriverManager.getConnection(URL_POSTGRESQL, USUARIO_POSTGRESQL, PASSWORD_POSTGRESQL);
			System.out.println("Conexión a BBDD postgreSQL OK");
		} catch (SQLException e) {
			System.out.println("Error en la conexión a BBDD postgreSQL");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	public Connection conectarMySQL() {
		try {
			Class.forName(DRIVER_MYSQL);
			conexion = DriverManager.getConnection(URL_MYSQL, USUARIO_MYSQL, PASSWORD_MYSQL);
			System.out.println("Conexión a BBDD mySQL OK");
		} catch (SQLException e) {
			System.out.println("Error en la conexión a BBDD mySQL");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	public void cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexión a BBDD");
			e.printStackTrace();
		}
	}

}
