package vagones;

import comunes.CaractComunes;

public abstract class Vagon implements CaractComunes{
	protected static int contador = 0;
	protected int identificador;
	protected String marca;
	protected String modelo;
	
	public Vagon(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
		contador++;
		identificador = contador;
	}
	
	public Vagon() {
		
	}
	
	@Override
	public String getMarca() {
		// TODO Auto-generated method stub
		return this.marca;
	}

	@Override
	public String getModelo() {
		// TODO Auto-generated method stub
		return this.modelo;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public abstract String toString();

}
