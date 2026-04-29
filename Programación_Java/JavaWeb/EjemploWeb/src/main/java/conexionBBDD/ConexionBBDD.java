package conexionBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class ConexionBBDD {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/proyectoweb";
	private static final String USUARIO = "postgres";
	private static final String PASSWORD = "1234";
	private Connection conexion = null;
	
	private static final Dotenv DOTENV = Dotenv.configure().ignoreIfMissing().load();
	private static final String HOST = DOTENV.get("DB_HOST");
	private static final String PUERTO = DOTENV.get("DB_PORT");
	private static final String DB = DOTENV.get("DB_NAME");
	private static final String URL_DOTENV = "jdbc:postgresql://"+HOST+":"+PUERTO+"/"+DB;
	private static final String USER = DOTENV.get("DB_USER");
	private static final String PASS = DOTENV.get("DB_PASSWORD");
	
	public Connection conectar() {
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			System.out.println("Conexión a BDDD OK");
		} catch (SQLException e) {
			System.err.println("Error en la conexión a BBDD");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	public Connection conectarDotenv() {
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL_DOTENV, USER, PASS);
			System.out.println("Conexión a BDDD OK");
		} catch (SQLException e) {
			System.err.println("Error en la conexión a BBDD");
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
			System.out.println("¡¡Conexión con BBDD cerrada!!");
		} catch (SQLException e) {
			System.err.println("Error al cerrar la BBDD");
			e.printStackTrace();
		}
	}

}

