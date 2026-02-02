package bicicleta;

import VehiculoSinMotor.VehiculoSinMotor;

public class Bicicleta extends VehiculoSinMotor {
	
	private String marca;
	private String modelo;
	private String tipo;
	
	public Bicicleta(String c, double p, int numRuedas, String marca, String modelo, String tipo) {
		super(c, p, numRuedas);
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		
		
		
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

	public String isTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return super.toString() + "BICICLETA: " +"\n" +"\tMarca: " + this.marca + "\n" + 
									"\tModelo: " + this.modelo + "\n" + 
									"\tTipo: " + this.tipo;
	}

}
