package asignaturas;

import java.util.ArrayList;

import personas.Alumno;
import personas.Profesor;

public class Asignatura {
	private int idAsignatura;
	private static int contador = 0;
	private String nombre;
	private String curso;
	private Profesor profesor;
	private int calificacion;
	private String departamento;
	
	public Asignatura(String nombre, String curso, Profesor profesor, String departamento) {
		contador++;
		this.idAsignatura = contador;
		this.nombre = nombre;
		this.curso = curso;		
		this.profesor = profesor;
		this.departamento = departamento;
		this.calificacion = 0;
	}
	
	public Asignatura(int idAsignatura, String nombre, String curso, Profesor profesor, String departamento) {
		this.idAsignatura = idAsignatura;
		this.nombre = nombre;
		this.curso = curso;		
		this.profesor = profesor;
		this.departamento = departamento;
	}
	
	public Asignatura(int idAsignatura, String nombre, String curso, String departamento, int calificacion) {
		this.idAsignatura = idAsignatura;
		this.nombre = nombre;
		this.curso = curso;		
		this.departamento = departamento;
		this.calificacion = calificacion;
	}
		
	public String toString() {
		return "ASIGNATURA: \n"+
				"\tID: "+this.idAsignatura+"\n"+
				"\tNombre"+this.nombre+"\n"+
				"\tCurso: "+this.curso+"\n"+
				"\tDepartamento: "+this.departamento+"\n"+
				"\tProfesor que la imparte: \n"+this.profesor+"\n"+
				"\tCalificación: "+this.calificacion+"\n";
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

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

}
