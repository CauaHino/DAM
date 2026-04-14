package personas;

import java.util.ArrayList;

import asignaturas.Asignatura;
import excepciones.MenorDeEdad;

public class Alumno extends Persona{
	private String especialidad;
	private ArrayList<Asignatura> asignaturas;
	
	public Alumno(String nombre, String apellidos, int edad, String curso, String especialidad) throws MenorDeEdad {
		super(nombre, apellidos, edad, curso);
		this.especialidad = especialidad;
		this.asignaturas = new ArrayList<>();
	}
	
	public Alumno(int idAlumno, String nombre, String apellidos, int edad, String curso, String especialidad) {
		this.idPersona = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.curso = curso;
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "ALUMNO con ID: "+this.idPersona+"\n"+
				"\tNombre: "+this.nombre+"\n"+
				"\tApellidos: "+this.apellidos+"\n"+
				"\tEdad: "+this.edad +" años\n"+
				"\tCurso: "+this.curso+"\n"+
				"\tEspecialidad: "+this.especialidad+"\n"+
				"\tAsignaturas: \n"+mostrarInfoAsignaturas()+"\n";
	}
		
	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public String mostrarInfoAsignaturas() {
		String acumuladorAsig="";
		for(Asignatura a : this.asignaturas) {
			if(a != null) {
				acumuladorAsig += "\tID: " + a.getIdAsignatura() + "\n"+ 
						"\tNombre: " + a.getNombre() + "\n"+
						"\tCurso: " + a.getCurso() + "\n"+
						"\tCalificación: "+a.getCalificacion()+"\n";
			}
		}
		return acumuladorAsig;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
}
