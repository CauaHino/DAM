package Vehiculo;

public class Vehiculo {
	protected String color;
	protected double peso;

	public Vehiculo(String c, double p) {
		this.color = c;
		this.peso = p;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return "VEHICULO: " + "\n" +
				"\tColor: " + this.color + "\n" +
				"\tPeso: " + this.peso+ " kg" + "\n";
				
	}

}
