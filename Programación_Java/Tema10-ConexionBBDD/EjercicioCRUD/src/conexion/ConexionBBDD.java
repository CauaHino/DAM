package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/Instituto";
	private static final String USER = "postgres";
	private static final String PASSWORD = "1234";
	private Connection conexion = null;
	
	public Connection conectarPostgreSQL() {
		try {
			Class.forName(DRIVER);
			this.conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexión a BBDD PostgreSQL OK");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("ERROR: Conexión a BBDD PostgreSQL no fue hecha");
			e.printStackTrace();
		}
		return conexion;
	}
	
	public void cerrarConexion() {
		try {
			this.conexion.close();
			System.out.println("Conexion con la BBDD cerrada");
		} catch (SQLException e) {
			System.err.println("ERROR: No fue posible cerrar la BBDD");
			e.printStackTrace();
		}
	}

}
