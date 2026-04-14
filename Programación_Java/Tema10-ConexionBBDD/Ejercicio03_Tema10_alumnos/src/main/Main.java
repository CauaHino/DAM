package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import asignaturas.Asignatura;
import dao.*;
import excepciones.MenorDeEdad;
import personas.Alumno;
import personas.Profesor;

public class Main {

	public static void main(String[] args) {
		BufferedReader infoPersonas = null;
		BufferedReader infoAsignaturas = null;
		ArrayList<Alumno> alumnos = new ArrayList<>();
		ArrayList<Profesor> profesores = new ArrayList<>();
		ArrayList<Asignatura> asignaturas = new ArrayList<>();
		try {
			infoPersonas = new BufferedReader(new FileReader("datosPersonas.txt"));
			String nombre = "";
			String apellidos = "";
			String edad = "";
			String curso = "", especialidad ="", departamento = "";
			String linea = infoPersonas.readLine();
			while (linea != null) {
				if ("Alumno".equals(linea)) {
					nombre = infoPersonas.readLine();
					apellidos = infoPersonas.readLine();
					edad = infoPersonas.readLine();
					int edadInt = Integer.valueOf(edad);
					curso = infoPersonas.readLine();
					especialidad = infoPersonas.readLine();
					alumnos.add(new Alumno(nombre, apellidos, edadInt, curso, especialidad));
				} else if ("Profesor".equals(linea)) {
					nombre = infoPersonas.readLine();
					apellidos = infoPersonas.readLine();
					edad = infoPersonas.readLine();
					int edadInt = Integer.valueOf(edad);
					curso = infoPersonas.readLine();
					departamento = infoPersonas.readLine();
					profesores.add(new Profesor(nombre, apellidos, edadInt, curso, departamento));
				}
				linea = infoPersonas.readLine();
			}
			System.out.println("INFORMACIÓN DE LOS PROFESORES:");
			for (Profesor p : profesores) {
				System.out.println(p);
			}
			System.out.println("-------------------------------------------------------------------------------");

			System.out.println("INFORMACIÓN DE LOS ALUMNOS:");
			for (Alumno a : alumnos) {
				System.out.println(a);
			}
			System.out.println("-------------------------------------------------------------------------------");

			infoAsignaturas = new BufferedReader(new FileReader("datosAsignaturas.txt"));
			linea = infoAsignaturas.readLine();
			while (linea != null) {
				if ("Asignatura".equals(linea)) {
					nombre = infoAsignaturas.readLine();
					curso = infoAsignaturas.readLine();
					departamento = infoAsignaturas.readLine();
					for (Profesor pr : profesores) {
						if (curso.equals(pr.getCurso()) && departamento.equalsIgnoreCase(pr.getDepartamento()))
							asignaturas.add(new Asignatura(nombre, curso, pr, departamento));
					}
				}
				linea = infoAsignaturas.readLine();
			}

			System.out.println("INFORMACIÓN DE LAS ASIGNATURAS ANTES DE CALIFICAR:");
			for (Asignatura a : asignaturas) {
				System.out.println(a);
			}
			System.out.println("-------------------------------------------------------------------------------");

			// Asignamos las asignaturas a los alumnos		
			for (Alumno a : alumnos) {
				for (Asignatura asig : asignaturas) {
					if (a.getCurso().equals(asig.getCurso()) && a.getEspecialidad().equalsIgnoreCase(asig.getDepartamento())) {
						a.getAsignaturas().add(new Asignatura(asig.getNombre(), asig.getCurso(), asig.getProfesor(), asig.getDepartamento()));
					}
				}
			}

			System.out.println("-------------------------------------------------------------------------------");

			for (Profesor p : profesores) {
				for (Alumno a : alumnos) {
					p.calificar(a);
				}
			}

			System.out.println("INFORMACIÓN DE LOS ALUMNOS DESPUÉS DE CALIFICAR:");
			int aprobadosJava = 0;
			int suspensosJava = 0;
			int aprobadosLLMM = 0;
			int suspensosLLMM = 0;
			int aprobadosMultimedia = 0;
			int suspensosMultimedia = 0;
			int aprobadosServicios = 0;
			int suspensosServicios = 0;
			int alumnosPrimero = 0;
			int alumnosSegundo = 0;
			for (Alumno a : alumnos) {
				System.out.println(a);
				if ("1º".equals(a.getCurso())) {
					alumnosPrimero++;
					for (Asignatura asig : a.getAsignaturas()) {
						if ("Programación Java".equals(asig.getNombre())) {
							if (asig.getCalificacion() >= 5) {
								aprobadosJava++;
							}
							else {
								suspensosJava++;
							}
						} else if ("Lenguajes de Marcas".equals(asig.getNombre())) {
							if (asig.getCalificacion() >= 5)
								aprobadosLLMM++;
							else
								suspensosLLMM++;
						}
					}
				}
				else {
					alumnosSegundo++;
					for (Asignatura asig : a.getAsignaturas()) {
						if("Programación Multimedia".equals(asig.getNombre())) {
							if (asig.getCalificacion() >= 5)
								aprobadosMultimedia++;
							else
								suspensosMultimedia++;
						} else if("Programación de Servicios".equals(asig.getNombre())) {
							if (asig.getCalificacion() >= 5)
								aprobadosServicios++;
							else
								suspensosServicios++;
						}
							
					}
					
					
				}
				
			}
			
					
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("PORCENTAJES DE APROBADOS/SUSPENSOS POR ASIGNATURA");
			System.out.println("Aprobados Java: "+aprobadosJava*100/alumnosPrimero+"%");
			System.out.println("Suspensos Java: "+suspensosJava*100/alumnosPrimero+"%");
			System.out.println("Aprobados LLMM: "+aprobadosLLMM*100/alumnosPrimero+"%");
			System.out.println("Suspensos LLMM: "+suspensosLLMM*100/alumnosPrimero+"%");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("Aprobados Programación Multimedia: "+aprobadosMultimedia*100/alumnosSegundo+"%");
			System.out.println("Suspensos Programación Multimedia: "+suspensosMultimedia*100/alumnosSegundo+"%");
			System.out.println("Aprobados Programación de Servicios: "+aprobadosServicios*100/alumnosSegundo+"%");
			System.out.println("Suspensos Programación de Servicios: "+suspensosServicios*100/alumnosSegundo+"%");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MenorDeEdad e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		}finally {
			if(infoPersonas!= null && infoAsignaturas!=null) {	
				try {
					infoPersonas.close();
					infoAsignaturas.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// INTERACCIÓN CON BASE DE DATOS "INSTITUTO"
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("INTERACCIÓN CON BASE DE DATOS \"INSTITUTO\"");
		Scanner entrada = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		AlumnoAsignaturaDAO alumnoAsignatura = null;
		AlumnoDAO alumnoDAO = null;
		AsignaturaDAO asigDAO = null;
		PersonaDAO personaDAO = null;
		ProfesorDAO profesorDAO = null;
		

		while(!salir) {
			System.out.println("0. Crear tablas en base de datos");
			System.out.println("1. Guardar información de los profesores");
			System.out.println("2. Guardar información de los alumnos");
			System.out.println("3. Guardar información de las asignaturas");
			System.out.println("4. Consultar información de las profesores");
			System.out.println("5. Consultar información de las asignaturas");
			System.out.println("6. Consultar información de los alumnos");
			System.out.println("7. Insertar un nuevo alumno");
			System.out.println("8. Salir de la aplicación");
			opcion = entrada.nextInt();
			entrada.nextLine();
			switch(opcion) {
			case 0:
				// Crear tablas en base de datos
				personaDAO = new PersonaDAO();
				personaDAO.createTable();
				personaDAO.getConexion().cerrarConexion();
				
				alumnoDAO = new AlumnoDAO();
				alumnoDAO.createTable();
				alumnoDAO.getConexion().cerrarConexion();
				
				profesorDAO = new ProfesorDAO();
				profesorDAO.createTable();
				profesorDAO.getConexion().cerrarConexion();
				
				asigDAO = new AsignaturaDAO();
				asigDAO.createTable();
				asigDAO.getConexion().cerrarConexion();
				
				alumnoAsignatura = new AlumnoAsignaturaDAO();
				alumnoAsignatura.createTable();
				alumnoAsignatura.getConexion().cerrarConexion();
				break;
			case 1:
				// Guardar información de los profesores
				profesorDAO = new ProfesorDAO();
				personaDAO = new PersonaDAO();
				for(Profesor p : profesores) {
					int lastId = personaDAO.lastId();
					if(p.getIdPersona() != 0) {
						p.setIdPersona(lastId + 1);
					}
					personaDAO.insert(p);
					profesorDAO.insert(p);
				}
				personaDAO.getConexion().cerrarConexion();
				profesorDAO.getConexion().cerrarConexion();
				break;
			case 2:
				// Guardar información de los alumnos
				alumnoDAO = new AlumnoDAO();
				personaDAO = new PersonaDAO();
				alumnoAsignatura = new AlumnoAsignaturaDAO();
				
				for(Alumno a : alumnos) {
					for(int i = 0; i < a.getAsignaturas().size(); i++) {
						int idAsignatura = alumnoAsignatura.getIdAsignatura(a.getAsignaturas().get(i).getNombre());
						if(a.getAsignaturas().get(i).getIdAsignatura() != idAsignatura) {
							a.getAsignaturas().get(i).setIdAsignatura(idAsignatura);
						}
					}
					
				}
				
				
				for(Alumno a : alumnos) {
					int lastId = personaDAO.lastId();
					if(lastId != 0) {
						a.setIdPersona(lastId + 1);
					}
					personaDAO.insert(a);
					alumnoDAO.insert(a);
					alumnoAsignatura.insert(a);
				}
				personaDAO.getConexion().cerrarConexion();
				alumnoDAO.getConexion().cerrarConexion();
				alumnoAsignatura.getConexion().cerrarConexion();
				break;
			case 3:
				// Guardar información de las asignaturas
				asigDAO = new AsignaturaDAO();
				for(Asignatura asig : asignaturas) {
					asigDAO.insert(asig);
				}
				asigDAO.getConexion().cerrarConexion();
				break;
			case 4:
				// Consultar información de los profesores
				profesorDAO = new ProfesorDAO();
				ArrayList<Profesor> profesoresBBDD = profesorDAO.read();
				profesorDAO.getConexion().cerrarConexion();
				for(Profesor p : profesoresBBDD) {
					System.out.println(p);
				}
				
				break;
			case 5:
				// Consultar información de las asignaturas
				asigDAO = new AsignaturaDAO();
				ArrayList<Asignatura> asignaturasBBDD = asigDAO.read();
				asigDAO.getConexion().cerrarConexion();
				for(Asignatura asig : asignaturasBBDD) {
					System.out.println(asig);
				}
				
				break;
			case 6:
				// Consultar información de los alumnos
				alumnoDAO = new AlumnoDAO();
				ArrayList<Alumno> alumnosBBDD = alumnoDAO.read();
				alumnoDAO.getConexion().cerrarConexion();
				for(Alumno a : alumnosBBDD) {
					System.out.println(a);
				}

				break;
			case 7:
				// Insertar un nuevo alumno
				System.out.println("Introduce el nombre del alumno");
				String nombre = entrada.nextLine();
				System.out.println("Introduce los apellidos del alumno");
				String apellidos = entrada.nextLine();
				System.out.println("Introduce la edad del alumno");
				int edad = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Introduce el curso del alumno");
				String curso = entrada.nextLine();
				System.out.println("Introduce la especialidad del alumno");
				String especialidad = entrada.nextLine();
				
				
				break;
			case 8:
				salir = true;
				break;
			}
		}

	}

}
