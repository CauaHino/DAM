package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import conexion.bbdd.ConexionBBDD;

public class Main {

	public static void main(String[] args) {
		ConexionBBDD bbdd = new ConexionBBDD();
		Connection connection = null;
		Statement setencia = null;
		
		connection = bbdd.conectarPostgreSQL();
		
		String queryCreateTable = "create table if not exists productos( " + "idProducto int PRIMARY KEY," + "nombreProducto varchar(30));";

		try {
			setencia = connection.createStatement();
			setencia.executeUpdate(queryCreateTable);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String queryInsertTable = "insert into productos(idProducto, nombreProducto) values " +
									"(2,'Vino');";
		
		try {
			setencia = connection.createStatement();
			setencia.executeUpdate(queryInsertTable);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
