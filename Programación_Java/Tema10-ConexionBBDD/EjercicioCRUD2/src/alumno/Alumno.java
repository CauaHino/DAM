package alumno;

import java.sql.Date;

public class Alumno {
	private int idAlumno;
	private static int contador;
	private String nombre;
	private Date fechaNacimiento;
	private double notaMedia;
	private String curso;
	
	
	public Alumno(String nombre, Date fechaNacimiento, double notaMedia, String curso) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.notaMedia = notaMedia;
		this.curso = curso;
		this.idAlumno = ++contador;
	}
	
	public Alumno(int idAlumno, String nombre, Date fechaNacimiento, double notaMedia, String curso) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.notaMedia = notaMedia;
		this.curso = curso;
		this.idAlumno = idAlumno;
	}

	public String toString() {
		return "Alumno " + this.idAlumno + "\n" +
				"\tNombre: " + this.nombre + "\n" +
				"\tFecha de Nacimiento: " + this.fechaNacimiento + "\n" +
				"\tNota Media: " + this.notaMedia + "\n" +
				"\tCurso: " + this.curso + "\n";
	}


	public int getIdAlumno() {
		return idAlumno;
	}


	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public double getNotaMedia() {
		return notaMedia;
	}


	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}
	
}
