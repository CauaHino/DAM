package locomotoras;

import excepciones.PotenciaNegativa;

public class Locomotora {
	private String marca;
	private String modelo;
	private String tipo;
	private double potencia;
	
	public Locomotora(String marca, String modelo, String tipo, double potencia) throws PotenciaNegativa {
		if(potencia < 0) {
			throw new PotenciaNegativa(marca, modelo);
		} else {
			this.marca = marca;
			this.modelo = modelo;
			this.tipo = tipo;
			this.potencia = potencia;
		}
	}
	
	public String toString() {
		return "LOCOMOTORA: " + "\n" + "\tMarca: " + this.marca
								+ "\n" + "\tModelo: " + this.modelo
								+ "\n" + "\tTipo: " + this.tipo
								+ "\n" + "\tPotencia: " + this.potencia + "kW";
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	
	
	
	

}
