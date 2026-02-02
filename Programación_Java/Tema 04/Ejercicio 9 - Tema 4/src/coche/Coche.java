package coche;

import java.time.LocalDate;

public class Coche {

	private String marca;
	private String color;
	private int cv;
	private int puertas;
	private int ano;
	private String motor;
	private static final int GARANTIA = 5;
	private int idCoche;
	private static int contador;

	public Coche(String marca, String color, int cv, int p, int ano, String motor) {
		this.marca = marca;
		this.color = color;
		this.cv = cv;
		this.puertas = p;
		this.ano = ano;
		this.motor = motor;
		contador++;
		this.idCoche = contador;
	}

	public Coche() {
		this.marca = "FORD";
		this.color = "BLANCO";
		this.cv = 150;
		this.puertas = 5;
		this.ano = 2019;
		this.motor = "Gasoil";
		contador++;
		this.idCoche = contador;
	}
	
	public String getMarca () {
		return this.marca;
	}
	public String getColor () {
		return this.color;
	}
	public int getCV () {
		return this.cv;
	}
	public int getDoor () {
		return this.puertas;
	}
	public int getYear () {
		return this.ano;
	}
	public String getMotor() {
		return this.motor;
	}
	public void setMarca (String marca) {
		this.marca = marca;
	}
	public void setColor (String color) {
		this.color = color;
	}
	public void setCV (int cv) {
		this.cv = cv;
	}
	public void setDoor (int door) {
		this.puertas = door;
	}
	public void setYear (int ano) {
		 this.ano = ano;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	
	public boolean garantia () {
		int actualYear = 2025;
		if (actualYear - this.ano <= GARANTIA) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString () {
		return "COCHE: " +"\n" + "\tMARCA: " +this.marca + "\n "+ "\tCOLOR: " + this.color + "\n" +"\tCV: " + this.cv + "cv "
                + "\n" + "\tNúmero de Puertas: "+ this.puertas + "\n" +"\tAÑO: "+ this.ano
                + "\n"+ "\tTipo de Motor: " + this.motor + "\n"+ "\t¿Garantia?: "+ (this.garantia() ? "Si" : "No") + "\n" + "\tID: " + this.idCoche;
	}

}
