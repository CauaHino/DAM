package vagones;

import interfaces.CaractComunes;

abstract public class Vagones implements CaractComunes {
	protected static int contador;
	protected int id;
	protected String marca;
	protected String modelo;

	public Vagones(String marca, String modelo) {
		contador++;
		this.id = contador;
		this.marca = marca;
		this.modelo = modelo;
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

	public int getId() {
		return id;
	}

}
