package Personas;

abstract public class Personas {
	protected int id;
	protected static int contador;
	protected String nombre;
	protected int edad;
	
	public Personas(String n, int e) {
		contador++;
		this.id = contador;
		this.nombre = n;
		this.edad = e;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getId() {
		return id;
	}
	
	abstract public String toString();

}
