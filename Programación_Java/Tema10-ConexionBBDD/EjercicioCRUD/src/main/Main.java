package main;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import alumno.Alumno;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import conexion.ConexionBBDD;

public class Main {

	public static void main(String[] args) {
		ConexionBBDD bbdd = new ConexionBBDD();
		Connection conn = null;
		Statement setencia = null;
		ArrayList<Alumno> alumnos = new ArrayList<>();	
		boolean salir = false;
		int opcion;
		Scanner input = new Scanner(System.in);
		
		alumnos.add(new Alumno("Pepe", Date.valueOf("2000-01-15"), 5.5, "1A"));
		alumnos.add(new Alumno("Ana", Date.valueOf("2001-11-17"), 8.5, "1B"));
		alumnos.add(new Alumno("Juan", Date.valueOf("2002-04-25"), 9.5, "1A"));
		
		while(!salir) {
			System.out.println("1. Crear tabla alumno.");
			System.out.println("2. Insertar alumnos.");
			System.out.println("3. Consultar alumnos.");
			System.out.println("4. Consultar alumno en concreto.");
			System.out.println("5. Actualizar nota media.");
			System.out.println("6. Borrar un alumno en concreto.");
			System.out.println("7. Borrar alumnos.");
			System.out.println("8. Salir de la aplicación");
			System.out.println();
			System.out.print("Introduzca la opción: ");
			opcion = input.nextInt();
			
			conn = bbdd.conectarPostgreSQL();
						
			switch(opcion) {
			case 1:
				String createTable = "create table if not exists Alumno( " +
						"id int PRIMARY KEY, " +
						"nombre varchar(30), " +
						"fechaNacimiento date," +
						 "notaMedia decima(6,2), " +
						"curso char(2));";

				try {
					setencia = conn.createStatement();
					setencia.executeUpdate(createTable);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 2:
				String insertAlumnos = "insert into alumno(?, ?, ?, ?)";
				
			}
			
		}

	}

}
