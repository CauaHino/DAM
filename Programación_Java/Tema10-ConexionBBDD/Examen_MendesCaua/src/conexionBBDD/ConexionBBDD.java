package conexionBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
	private static final String DRIVER_POSTGRESQL = "org.postgresql.Driver";
	private static final String URL_POSTGRESQL = "jdbc:postgresql://localhost:5432/biblioteca";
	private static final String USUARIO_POSTGRESQL = "postgres";
	private static final String PASSWORD_POSTGRESQL = "1234";
		
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
		
	public void cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexión a BBDD");
			e.printStackTrace();
		}
	}

}
