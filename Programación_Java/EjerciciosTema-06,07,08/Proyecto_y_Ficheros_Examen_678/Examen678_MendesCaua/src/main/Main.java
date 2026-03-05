package main;

import java.io.*;

import com.google.gson.*;

import asignaturas.Asignatura;
import excepciones.MenorDeEdad;
import personas.*;

public class Main {

	public static void main(String[] args) {
		Alumno[] alumnos = new Alumno[10];
		Profesor[] profesores = new Profesor[2];
		String tipo = "", nombre = "", apellidos = "", curso = "";
		int edad = 0;
		Asignatura[] asignaturas = null;
		int aux = 0;
		int iAlumno = 0, iProf = 0;
		while (aux < alumnos.length + 2) {
			try (BufferedReader br = new BufferedReader(new FileReader("datosPersonas.json"))) {
				JsonArray jsonArray = JsonParser.parseReader(br).getAsJsonArray();
				while (iAlumno < alumnos.length) {
					JsonObject jsonObject = jsonArray.get(aux).getAsJsonObject();

					tipo = jsonObject.get("tipo").getAsString();

					if (tipo.equalsIgnoreCase("Alumno")) {
						nombre = jsonObject.get("nombre").getAsString();
						apellidos = jsonObject.get("apellidos").getAsString();
						edad = jsonObject.get("edad").getAsInt();
						curso = jsonObject.get("curso").getAsString();

						alumnos[iAlumno] = new Alumno(nombre, apellidos, edad, curso, 4);
						aux++;
						iAlumno++;
					} else if (tipo.equalsIgnoreCase("profesor")) {
						nombre = jsonObject.get("nombre").getAsString();
						apellidos = jsonObject.get("apellidos").getAsString();
						edad = jsonObject.get("edad").getAsInt();
						curso = jsonObject.get("curso").getAsString();

						profesores[iProf] = new Profesor(nombre, apellidos, edad, curso);
						aux++;
						iProf++;
					}
					
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MenorDeEdad e) {
				// TODO Auto-generated catch block
				System.err.println(e.toString());
				iAlumno++;
				aux++;
			}
		}

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("INFORMACIÓN DE LOS PROFESORES:");
		System.out.println("-------------------------------------------------------------------------------");
		for (Profesor p : profesores) {
			if (p != null) {
				System.out.println(p.toString());
			}

		}
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("INFORMACIÓN DE LOS ALUMNOS:");
		System.out.println("-------------------------------------------------------------------------------");
		for (Alumno a : alumnos) {
			if (a != null)
				System.out.println(a.toString());
		}
		System.out.println();

		// 2) Leemos información de fichero de asignaturas y asociamos a sus respectivos
		// objetos para guardarlos en arrays
		// Además, asociamos los profesores a las asignaturas por curso
		try (BufferedReader br = new BufferedReader(new FileReader("datosAsignaturas.json"))) {
			JsonArray jsonArray = JsonParser.parseReader(br).getAsJsonArray();
			asignaturas = new Asignatura[jsonArray.size()];
			for (int i = 0; i < asignaturas.length; i++) {
				JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
				nombre = jsonObject.get("nombre").getAsString();
				curso = jsonObject.get("curso").getAsString();

				asignaturas[i] = new Asignatura(nombre, curso, null);
			}
			for (Asignatura a : asignaturas) {
				for (Profesor p : profesores) {
					if(a.getCurso().equals(p.getCurso())) {
					a.setProfesor(p);
					break;
				}
				}
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("INFORMACIÓN DE LAS ASIGNATURAS ANTES DE CALIFICAR:");
		System.out.println("-------------------------------------------------------------------------------");
		for (Asignatura a : asignaturas) {
			System.out.println(a);
		}
		System.out.println();

		// 3) Asignamos las asignaturas a los alumnos, pero a cada alumno sus propias
		// asignaturas
		
			
				for(int i = 0; i < alumnos.length; i++) {
					int aux2 = 0;
					for(int j = 0; j < asignaturas.length; j++) {
					if(alumnos[i] != null) {
						if(alumnos[i].getCurso().equals(asignaturas[j].getCurso())) {
							alumnos[i].setAsignaturas(asignaturas[j]);
							
					}	
				}					
			}	
		}

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("INFORMACIÓN DE LOS ALUMNOS CON ASIGNATURAS:");
		System.out.println("-------------------------------------------------------------------------------");
		for (Alumno a : alumnos) {
			System.out.println(a);
		}
		System.out.println("-------------------------------------------------------------------------------");

		// 4) Los profesores califican las asignaturas de los alumnos por curso
		for (Profesor p : profesores) {
			for (Alumno a : alumnos) {
				if(a != null) {
					if (p.getCurso().equals(a.getCurso())) {
					p.calificar(a);
				}
			}
			}
		}

		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("INFORMACIÓN DE LOS ALUMNOS DESPUÉS DE CALIFICAR:");
		System.out.println("-------------------------------------------------------------------------------");

		for(Alumno a : alumnos) {
			if(a!=null) {
				System.out.println(a);
			}

		}
		// Calculamos las estadísticas
		int aprobadosJava = 0;
		int suspensosJava = 0;
		int aprobadosBBDD = 0;
		int suspensosBBDD = 0;
		int aprobadosMultimedia = 0;
		int suspensosMultimedia = 0;
		int aprobadosServicios = 0;
		int suspensosServicios = 0;
		int alumnosPrimero = 0;
		int alumnosSegundo = 0;



	}

}
