package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class ConexionBBDD {
	private static final String DRIVER = "org.postgresql.Driver";

	private static final String URL = "jdbc:postgresql://localhost:5432/Instituto";
	private static final String USUARIO = "postgres";
	private static final String PASSWORD = "1234";
	private Connection conexion = null;
	
	public Connection conectarPostgreSQL() {
		try {
			Class.forName(DRIVER);
			this.conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			System.out.println("Conexion a BBDD PostgresSQL OK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLTimeoutException e) {
			System.err.println("ERROR ha pasado el tiempo de conexion");
			e.printStackTrace();
		} catch(SQLException e) {
			System.err.println("ERROR en la conexion a BBDD PostgresSQL");
			e.printStackTrace();
		}
		
		return conexion;
	}
	
	public void cerrarConexion() {
		try {
			this.conexion.close();
		} catch (SQLException e) {
			System.err.println("ERROR al cerrar la conexion a BBDD");
			e.printStackTrace();
		}
	}
}
