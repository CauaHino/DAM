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

public class Main {
	public static void main(String[] args) {
		ConexionBBDD conexionBBDD = new ConexionBBDD();
		Connection conexion = conexionBBDD.conectarPostgreSQL();
		ArrayList<Alumno> aula = new ArrayList<Alumno>();
		Scanner see = new Scanner(System.in);
		
		String[] curso = {"1ro", "2do"};
		
		boolean salir = false;
		String query;
		Statement sentencia = null;
		PreparedStatement sentenciaPreparada = null;
		ResultSet resulSet = null;
		int idAlumno;
		double notaMedia;
		int opcion;
		
		System.out.print("Cuantos alumnos desea crear: ");
		int cantidadAlumnos = see.nextInt();
		see.nextLine();
		
		try(BufferedReader ficheroEntrada = new BufferedReader(new FileReader("data/datosAlumnos.json"))){
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
			
			try {
				switch (opcion) {
				case 1:
					
					query = "create table if not exists aula ( "
							+ "idalumno int primary key,"
							+ "nombre varchar(20),"
							+ "fechanacimiento date,"
							+ "notamedia decimal(4,2),"
							+ "curso varchar(10)"
							+ ");";
					
					sentencia = conexion.createStatement();
					sentencia.executeUpdate(query);
					
					System.out.println();
					System.out.println("Se ha creado la tabla correctamente");
					System.out.println();
					break;
				case 2:
					ArrayList<Integer> idAlumnos = new ArrayList<Integer>();
					query = "select idAlumno from aula;";
					sentencia = conexion.createStatement();
					resulSet = sentencia.executeQuery(query);
					
					while(resulSet.next()) {
						idAlumnos.add(resulSet.getInt("idalumno"));
					}
					
					for(int i = 0; i < aula.size(); i++) {
						for(int j = 0; j < idAlumnos.size(); j++) {
							if(aula.size() < idAlumnos.size()) {
								aula.clear();
							}else if(aula.get(i).getIdAlumno() == idAlumnos.get(j)) {
								aula.remove(aula.get(i));
							}
						}
					}
					
					query = "insert into aula (idalumno, nombre, fechanacimiento, notamedia, curso) values (?,?,?,?,?);";
					
					System.out.println();
					for(Alumno alumno : aula) {
						sentenciaPreparada = conexion.prepareStatement(query);
						sentenciaPreparada.setInt(1, alumno.getIdAlumno());
						sentenciaPreparada.setString(2, alumno.getNombre());
						sentenciaPreparada.setDate(3, alumno.getFechaNacimiento());
						sentenciaPreparada.setDouble(4, alumno.getNotaMedia());
						sentenciaPreparada.setString(5, alumno.getCurso());
						sentenciaPreparada.executeUpdate();
						
						System.out.println("Alumno: " + alumno.getNombre() + ", ha sido agregado a la base de datos");
					}
					System.out.println();
					break;
				case 3:
					ArrayList<Alumno> aulaBBDD = new ArrayList<Alumno>();
					query = "select * from aula;";
					
					sentencia = conexion.createStatement();
					resulSet = sentencia.executeQuery(query);
					
					while(resulSet.next()) {
						aulaBBDD.add(new Alumno(resulSet.getInt("idalumno"),
												resulSet.getString("nombre"), 
												resulSet.getDate("fechanacimiento"),
												resulSet.getDouble("notamedia"),
												resulSet.getString("curso")));
					}
					
					for(Alumno alumno : aulaBBDD) {
						System.out.println(alumno);
					}
					break;
				case 4:
					query = "select * from aula where idalumno = ?;";
					
					System.out.println();
					System.out.print("Introduzca el id del alumno: ");
					idAlumno = see.nextInt();
					see.nextLine();
					
					sentenciaPreparada = conexion.prepareStatement(query);
					sentenciaPreparada.setInt(1, idAlumno);
					
					resulSet = sentenciaPreparada.executeQuery();
					
					if(resulSet.next()) {
						Alumno alumno = new Alumno(resulSet.getInt("idalumno"),
													resulSet.getString("nombre"), 
													resulSet.getDate("fechanacimiento"),
													resulSet.getDouble("notamedia"),
													resulSet.getString("curso"));
						System.out.println();
						System.out.println(alumno);
					}else {
						System.out.println();
						System.out.println("No existe un alumno con el id " + idAlumno);
						System.out.println();
					}				
					break;
				case 5:
					System.out.println();
					System.out.print("Introduzca el id del alumno para actualizar su nota media: ");
					idAlumno = see.nextInt();
					see.nextLine();
					
					query = "select * from aula where idalumno = ?;";
					
					sentenciaPreparada = conexion.prepareStatement(query);
					sentenciaPreparada.setInt(1, idAlumno);
					
					resulSet = sentenciaPreparada.executeQuery();
					
					if(resulSet.next()) {
						Alumno alumno = new Alumno(resulSet.getInt("idalumno"),
													resulSet.getString("nombre"), 
													resulSet.getDate("fechanacimiento"),
													resulSet.getDouble("notamedia"),
													resulSet.getString("curso"));
						System.out.println();
						System.out.println(alumno);
						
						System.out.print("Estas seguro que quieres cambiar la nota media de este alumno (S/N): ");
						String cambiar = see.nextLine();
						
						if(cambiar.equalsIgnoreCase("s")) {
							System.out.println();
							System.out.print("Indique la nota media nueva: ");
							notaMedia = see.nextDouble();
							see.nextLine();
							
							query = "update aula set notamedia = ? where idalumno = ?;";
							sentenciaPreparada = conexion.prepareStatement(query);
							sentenciaPreparada.setDouble(1, notaMedia);
							sentenciaPreparada.setInt(2, idAlumno);
							
							sentenciaPreparada.executeUpdate();
							System.out.println("Nota media cambiada!!!");
							System.out.println();
						}
					}else {
						System.out.println();
						System.out.println("No existe un alumno con el id " + idAlumno);
						System.out.println();
					}
					
					break;
				case 6:
					query = "delete from aula where idalumno = ?;";
					
					System.out.println();
					System.out.print("Introduzca el id del alumno para eliminarlo de la base de datos: ");
					idAlumno = see.nextInt();
					see.nextLine();
					
					sentenciaPreparada = conexion.prepareStatement(query);
					sentenciaPreparada.setInt(1, idAlumno);
					sentenciaPreparada.executeUpdate();
					System.out.println("Se ha eliminado el alumno con id: " + idAlumno);
					System.out.println();
					break;
				case 7:
					query = "delete from aula";
					sentencia = conexion.createStatement();
					sentencia.executeUpdate(query);
					System.out.println();
					System.out.println("Se han borrado todos los datos de la tabla aula");
					break;
				case 8:
					salir = true;
					break;
				default:
					System.out.println("Elija una opcion correcta");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		conexionBBDD.cerrarConexion();
		System.out.println("HASTA LUEGO");
	}
}
