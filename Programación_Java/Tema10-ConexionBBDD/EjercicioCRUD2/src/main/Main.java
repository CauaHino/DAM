package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import alumno.Alumno;
import conexion.ConexionBBDD;
import opciones.Opciones;

public class Main {
	public static void main(String[] args) {
		ConexionBBDD conexionBBDD = new ConexionBBDD();
		Connection conexion = conexionBBDD.conectarPostgreSQL();
		Opciones opciones = new Opciones(conexion);
		ArrayList<Alumno> aula = new ArrayList<Alumno>();
		Scanner see = new Scanner(System.in);
		
		String[] curso = {"1ro", "2do"};
		
		boolean salir = false;
		int opcion;
		
		System.out.print("Cuantos alumnos desea crear: ");
		int cantidadAlumnos = see.nextInt();
		see.nextLine();
		
	try(BufferedReader ficheroEntrada = new BufferedReader(new FileReader("Java/DAM/Tema 10/EjercicioCRUD2/data/datosAlumnos.json"))){
			JsonArray jsonArray = JsonParser.parseReader(ficheroEntrada).getAsJsonArray();

			for(int i = 0; i < cantidadAlumnos; i++) {
				int random = (int) (Math.random() * jsonArray.size());
				
				aula.add(new Alumno(jsonArray.get(random).getAsJsonObject().get("nombre").getAsString(), 
									Date.valueOf(jsonArray.get(random).getAsJsonObject().get("fecha_nacimiento").getAsString()), 
									Math.round((Math.random() * 10) * 100.0) / 100.0, 
									curso[(int) (Math.random() * curso.length)]));
			}
			

		} catch(FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero");
			e.printStackTrace();
		} catch(IOException e) {
			System.err.println("Error al leer el fichero");
			e.printStackTrace();
		}
		
		while(!salir) {
			System.out.println("1. Crear tabla alumnos.");
			System.out.println("2. Insertar informacion de alumnos.");
			System.out.println("3. Consultar aula.");
			System.out.println("4. Consultar un alumno en concreto.");
			System.out.println("5. Actualizar nota media.");
			System.out.println("6. Borrar un alumno en concreto.");
			System.out.println("7. Borrar aula.");
			System.out.println("8. Salir de la aplicacion.");
			
			System.out.println();
			System.out.print("Elije una opcion: ");
			opcion = see.nextInt();
			see.nextLine();
			
			switch (opcion) {
			case 1:
				opciones.crearTabla();
				break;
			case 2:
				opciones.sincronizarAlumnos(aula);

				for(Alumno alumno : aula) {
					opciones.insertarAlumnos(alumno);
				}
				System.out.println();
				break;
			case 3:
				System.out.println();
				opciones.mostrarAlumnos();
				System.out.println();
				break;
			case 4:
				System.out.println();
				System.out.print("Indique el id del alumno: ");
				int idAlumno = see.nextInt();
				see.nextLine();
				opciones.mostrarAlumno(idAlumno);
				System.out.println();
				break;
			case 5:
				System.out.println();
				System.out.print("Indique el id del alumno: ");
				int idAlumno2 = see.nextInt();
				see.nextLine();
				double notaMedia = 0;
				opciones.actualizarNotaMedia(idAlumno2, notaMedia, see);
				break;
			case 6:
				System.out.println();
				System.out.print("Indique el id del alumno a eliminar: ");
				int idAlumno3 = see.nextInt();
				see.nextLine();
				opciones.eliminarAlumno(idAlumno3);
				System.out.println();
				break;
			case 7:
				System.out.println();
				opciones.eliminarDatos();
				break;
			case 8:
				salir = true;
				break;
			default:
				System.out.println("Elija una opcion correcta");
			}

		}
		
		conexionBBDD.cerrarConexion();
		System.out.println("HASTA LUEGO");
	}
}
