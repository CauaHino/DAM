package Persona;

public class Persona {
	protected String nombre;
	protected String apellidos;
	protected int edad;
	protected int numId;
	public static int contador = 0;
	
	public Persona() {
		this.nombre = "sin_nombre" ;
		this.apellidos = "sin_apellidos";
		this.edad = 18;
		contador++;
		this.contador = 0;
	}
	
	public Persona(String n, String a, int edad) {
		this.nombre = n;
		this.apellidos = a;
		this.edad = edad;
		contador++;
		this.contador = 0;
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
	
	public String toString() {
		return "PERSONA:" + "\n" + "\tID: " + this.numId + "\n" +
									"\tNombre: " + this.nombre + "\n" +
									"\tApellidos: " + this.apellidos + "\n" +
									"\tEdad: " + this.edad + "\n";
	}
	
}
