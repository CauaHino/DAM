package Perro;

public class Perro {

	private String raza;
	private String nombre;
	private String color;
	private double edad;

	public Perro(String raza, String nombre, String color, double edad) {
		this.raza = raza;
		this.nombre = nombre;
		this.color = color;
		this.edad = edad;
	}

	public String dameRaza() {
		return this.raza;
	}

	public String dameNombre() {
		return this.nombre;
	}

	public String dameColor() {
		return this.color;
	}

	public double dameEdad() {
		return this.edad;
	}

	public void caminar() {
		System.out.println("El perro " + this.nombre + " está caminando...");
	}

	public void ladrar() {
		System.out.println("El perro " + this.nombre + " está ladrando...");
	}

	public void sleep() {
		System.out.println("El perro " + this.nombre + " está durmiendo...");
	}

	public String toString() {
		return ("PERRO: \n" + "\t\tNombre: " + this.nombre + "\n" + "\t\tRaza: " + this.raza + "\n" + "\t\tColor: "
				+ this.color + "\n" + "\t\tEdad :" + this.edad + "\n");
	}

	public void modificaRaza(String raza) {
		this.raza = raza;
	}

	public void modificaNombre(String nombre) {
		this.nombre = nombre;
	}

	public void modificaColor(String color) {
		this.color = color;
	}

	public void modificaEdad(double edad) {
		this.edad = edad;
	}
}
