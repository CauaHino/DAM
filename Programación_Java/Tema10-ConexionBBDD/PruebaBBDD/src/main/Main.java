package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import conexion.bbdd.ConexionBBDD;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
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
									"(1,'Agua')," +
									"(2,'Tostarica')," +
									"(3,'Vino')," +
									"(4,'Leche')," +
									"(5,'Tomate');";
		
		String getResult = "select * from productos;";
		ResultSet datosProducto = null;
		
		try {
			setencia = connection.createStatement();
			// setencia.executeUpdate(queryInsertTable);
			datosProducto = setencia.executeQuery(getResult);
			while(datosProducto.next()) {
				int idProducto = datosProducto.getInt("idProducto");
				String nombreProductoString = datosProducto.getString("nombreProducto");
				System.out.println("Producto: " + "\n"+"\tID:" +idProducto + "\n" + "\tNombre: " + nombreProductoString);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String pStatement = "select * from productos "+ 
								"where idProducto = ?;";
			PreparedStatement ps = connection.prepareStatement(pStatement);
			System.out.print("Introduzca el id del producto que desea buscar: ");
			int idProducto = input.nextInt();
			ps.setInt(1, idProducto);
			datosProducto = ps.executeQuery();
			if(datosProducto.next()) {
				int idProducto2 = datosProducto.getInt("idProducto");
				String nombreProductoString = datosProducto.getString("nombreProducto");
				System.out.println("Producto: " + "\n"+"\tID:" +idProducto2 + "\n" + "\tNombre: " + nombreProductoString);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
