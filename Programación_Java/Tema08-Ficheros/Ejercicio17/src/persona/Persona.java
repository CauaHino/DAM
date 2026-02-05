package persona;

import asignatura.Asignatura;

public class Persona {
	private String nombre;
	private String apellidos;
	private int edad;
	private Asignatura[] asignaturas;
	
	public Persona(String n, String a, int edad, Asignatura[] as) {
		this.nombre = n;
		this.apellidos = a;
		this.edad = edad;
		this.asignaturas = as;
	}
	public String toString() {
		String asig = "";
		for(Asignatura a : this.asignaturas) {
			asig += a;
		}
		return "PERSONA: \n" + "\tNombre: " + this.nombre + "\n" + 
								"\tApellidos: " + this.apellidos + "\n" + 
								"\tEdad: " + this.edad + "\n" +
								"\tAsignaturas: \n" + asig;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	

}
