package asignaturas;

import personas.Profesor;

public class Asignatura {
	private String nombre;
	private String curso;
	private int calificacion;
	private Profesor profesor;
	
	public Asignatura(String nombre, String curso, Profesor profesor) {
		this.nombre = nombre;
		this.curso = curso;
		this.profesor = profesor;
	}
	

		
	public String toString() {
		return "\tASIGNATURA: \n" + 
				"\t\tNombre: "+this.nombre + "\n" + 
				"\t\tCurso: "+this.curso + "\n"+
				"\t\tImpartida por: \n"+this.profesor+"\n"+
				"\t\tCalificación: "+this.calificacion+"\n";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}



	public Profesor getProfesor() {
		return profesor;
	}



	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
	
}
