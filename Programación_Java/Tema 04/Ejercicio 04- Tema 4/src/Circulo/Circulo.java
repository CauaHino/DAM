package Circulo;

public class Circulo {
	
	private double radio;
	
	public Circulo (double radio) {
		this.radio = radio;
	}
	
	public double dameRadio () {
		return this.radio;
	}
	
	public void modificarRadio(double nuevoRadio) {
		this.radio = nuevoRadio;
	}
	public double area() {
		return Math.PI * Math.pow(radio, 2);
	}
	public void mostrarInfo() {
	        System.out.println("Radio: " + dameRadio()); 
	        System.out.println("Área: " + String.format("%.2f", area()));
	}

}
