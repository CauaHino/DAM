package Persona;

public class Persona {
	private String nombre;
	private String dni;
	private int edad;
	private int identificador;
	private static int contador = 0;
	
	public Persona (String nombre, String dni, int edad) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		contador++;
		this.identificador = contador;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getIdentificador() {
		return identificador;
	}
	
	public String toString() {
		return "PERSONA:" + "\n" + "\tNombre: " + this.nombre +
				"\n" + "\tDNI: " + this.dni +
				"\n" + "\tEdad: " + this.edad + 
				"\n" + "\tIdentificador: " + this.identificador;
	}
	
	

}
