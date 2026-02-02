package coche;

import VehiculoConMotor.VehiculoConMotor;

public class Coche extends VehiculoConMotor{
	private String marca;
	private String modelo;
	private double precio;
	
	public Coche(String c, double p, String m, double cc, int cv, String marca, String modelo, double precio) {
		super(c,p,m,cc,cv);
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}
	
	
	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String toString() {
		return super.toString() + "COCHE: " +"\n" +"\tMarca: " + this.marca + "\n" + 
									"\tModelo: " + this.modelo + "\n" + 
									"\tPrecio: " + this.precio + "\n";
	}

}
