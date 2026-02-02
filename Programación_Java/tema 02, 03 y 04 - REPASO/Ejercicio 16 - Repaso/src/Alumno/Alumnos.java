package Alumno;

import java.time.LocalDate;

import Curso.Curso;

public class Alumnos {
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String dni;
	private Curso nombreCurso;

	public Alumnos(String n, String a, LocalDate fecha, String dni, Curso nC) {
		this.nombre = n;
		this.apellidos = a;
		this.fechaNacimiento = fecha;
		this.dni = dni;
		this.nombreCurso = nC;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Curso getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(Curso nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public void mostrarInfo() {
		System.out.println("--- Información del Alumno ---");
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Apellidos: " + this.apellidos);
		System.out.println("Fecha de Nacimiento: " + this.fechaNacimiento);
		System.out.println("DNI: " + this.dni);
		System.out.println("Curso: " + this.nombreCurso);
		System.out.println("------------------------------");
	}
}
