package alumno;

import java.sql.Date;
import java.time.LocalDate;

public class Alumno {
	private static int contador;
	private int id;
	private String nombre;
	private Date fechaNacimiento;
	private double notaMedia;
	private String curso;
	
	public Alumno(String nombre, Date fechaNacimiento, double notaMedia, String curso) {
		contador++;
		this.id = contador;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.notaMedia = notaMedia;
		this.curso = curso;
	}
	
	public String toString() {
		return "ALUMNO:" + "\n" + "\tID: " + this.id +
							"\n" + "\tNombre: " + this.nombre +
							"\n" + "\tFecha de Nacimiento: " + this.fechaNacimiento +
							"\n" + "\tNota Media: " + this.notaMedia +
							"\n" + "\tCurso: " + this.curso;
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

	public double getNotaMedia() {
		return notaMedia;
	}

	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getId() {
		return id;
	}
	
	

}
