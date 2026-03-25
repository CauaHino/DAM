package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBBDD.ConexionBBDD;
import locomotoras.Locomotora;
import trenes.Tren;
import vagones.Vagon;

public class TrenDAO {
	private ConexionBBDD conexion = new ConexionBBDD();
	private Connection connection;
	private Statement sentencia;
	private PreparedStatement sentenciaParametrizada;
	private ResultSet resultSet;

	// En el constructor establecemos la conexión a BBDD que quedará
	// abierta mientras usemos la clase LocomotoraDAO
	public TrenDAO() {
		this.connection = conexion.conectar();
	}
	
	public boolean createTable() {
		String queryCreate = "CREATE TABLE tren(" 
						+ "idTren int PRIMARY KEY," 
						+ "tipo VARCHAR(15)"
						+ ");";
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(queryCreate);
			return true;
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla tren");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean createTableTrenLocVagon() {
		String queryCreate = "CREATE TABLE trenlocomotoravagon(" 
						+ "idTren int,"
						+ "idLocomotora int,"
						+ "idVagon int,"
						+ "foreign key (idTren) references tren (idTren),"
						+ "foreign key (idLocomotora) references locomotora (idLocomotora),"
						+ "foreign key (idVagon) references vagon (idVagon),"
						+ "PRIMARY KEY (idTren, idLocomotora, idVagon)"
						+ ");";
		try {
			sentencia = connection.createStatement();
			sentencia.executeUpdate(queryCreate);
			return true;
		} catch (SQLException e) {
			System.out.println("Error al crear la tabla trenlocomotoravagon");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean create(Tren tren) {
		if (tren != null) {
			String queryInsert = "INSERT INTO tren " 
							+ "(idTren, tipo)"
							+ " values (?,?);";
			try {
				sentenciaParametrizada = connection.prepareStatement(queryInsert);
				sentenciaParametrizada.setInt(1, tren.getIdentificador());
				sentenciaParametrizada.setString(2, tren.getTipo());

				sentenciaParametrizada.executeUpdate();
				return true;
			} catch (SQLException e) {
				System.out.println("Error al insertar en tabla tren");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean insertTernaria(Tren tren){
        if(tren != null){

           String query = "insert into trenlocomotoravagon (idTren, idLocomotora, idVagon) " +
                                            "values (?, ?, ?);";

            try(PreparedStatement sentenciaPreparada = connection.prepareStatement(query)){
            	for(int i = 0; i < tren.getVagones().size(); i++) {
            		sentenciaPreparada.setInt(1, tren.getIdentificador());
                    sentenciaPreparada.setInt(2, tren.getLocomotora().getIdLocomotora());
                    sentenciaPreparada.setInt(3, tren.getVagones().get(i).getIdentificador());

                    sentenciaPreparada.executeUpdate();   
            	}
            	return true;
                
            }catch(SQLException e){
                System.err.println("Error al insertar en la tabla trenlocomotoravagon");
                e.printStackTrace();
            }
        }
        return false;
    }

	
	public ArrayList<Integer> readAll(){
		ArrayList<Integer> trenesBBDD = new ArrayList<Integer>();
		String querySelect = "SELECT idTren FROM tren;";
		try {
			sentencia = connection.createStatement();
			resultSet = sentencia.executeQuery(querySelect);
			while(resultSet.next()) {
				trenesBBDD.add(resultSet.getInt("idTren"));
			}
		} catch (SQLException e) {
			System.out.println("Error al seleccionar en tabla tren");
			e.printStackTrace();
		}
		return trenesBBDD;
	}
	
	public ArrayList<Tren> readTrenes(){
		ArrayList<Tren> trenesBBDD = new ArrayList<Tren>();
		String query = "select * from tren;";
		
		try {
			sentencia = connection.createStatement();
			resultSet = sentencia.executeQuery(query);
			while(resultSet.next()) {
				trenesBBDD.add(new Tren(resultSet.getInt("idTren"), null, null, resultSet.getString("tipo")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trenesBBDD;
	}

	
	public ConexionBBDD getConexion() {
		return conexion;
	}

	public void setConexion(ConexionBBDD conexion) {
		this.conexion = conexion;
	}

}
