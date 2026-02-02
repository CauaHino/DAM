package Persona;

import Perro.Perro;

public class Persona {

	private String nombre;
	private String dni;
	private int edad;
	private Perro mascota;

	public Persona(String nombre, String dni, int edad, Perro mascota) {

		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.mascota = mascota;
	}

	public Persona() {
		this.nombre = "Pepe";
		this.dni = "1234567A";
		this.edad = 20;
	}

	public String dameNombre() {
		return this.nombre;
	}

	public void modificaNombre(String nombre) {
		this.nombre = nombre;
	}

	public String dameDNI() {
		return this.dni;
	}

	public void modificaDNI(String dni) {
		this.dni = dni;
	}

	public int dameEdad() {
		return this.edad;
	}

	public void modificaEdad(int edad) {
		this.edad = edad;
	}

	public Perro dameMascota() {
		return this.mascota;
	}

	public void modificaMascota(Perro mascota) {
		this.mascota = mascota;
	}

	public String toString() {
		return ("PERSONA: \n" + "\tNombre: " + this.nombre + "\n" + "\tDNI: " + this.dni + "\n" + "\tEdad :" + this.edad
				+ " años\n" + "\tMascota: " + this.mascota + "\n");
	}
}
