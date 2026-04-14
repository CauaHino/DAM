package personas;

import accionesProfesor.AccionesProfesor;
import asignaturas.Asignatura;
import excepciones.MenorDeEdad;

public class Profesor extends Persona implements AccionesProfesor{
	private String departamento;
	
	public Profesor(String nombre, String apellidos, int edad, String curso, String departamento) throws MenorDeEdad {
		super(nombre, apellidos, edad, curso);
		this.departamento = departamento;
	}
	
	
	public Profesor(int idProfesor, String nombre, String apellidos, int edad, String curso, String departamento) throws MenorDeEdad {
		this.idPersona = idProfesor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.curso = curso;
		this.departamento = departamento;
	}


	@Override
	public void calificar(Alumno a) {
		for(Asignatura asig : a.getAsignaturas()) {
			if(this.nombre.equals(asig.getProfesor().getNombre())) {
				asig.setCalificacion((int)(Math.random()*10)+1);
			}
		}
	}

	@Override
	public String toString() {
		return "PROFESOR con ID: "+this.idPersona+"\n"+
				"\tNombre: "+this.nombre+"\n"+
				"\tApellidos: "+this.apellidos+"\n"+
				"\tEdad: "+this.edad +" años\n"+
				"\tCurso: "+this.curso+"\n"+
				"\tDepartamento: "+this.departamento+"\n";
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
