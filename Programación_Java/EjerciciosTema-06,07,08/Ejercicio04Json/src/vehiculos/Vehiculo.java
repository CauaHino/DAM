package vehiculos;

import Interfaces.Alquiler;

public abstract class Vehiculo implements Alquiler {
	protected String matricula;
	protected String marca;
	protected int diasAlquiler;
	protected double km;
	protected double precioDia;
	protected double precioKm;
	protected boolean alquilado;
	
	public Vehiculo(String matricula, String marca, int dias, double km, double precioDia, double precioKm) {
		this.matricula = matricula;
		this.marca = marca;
		this.diasAlquiler = dias;
		this.km = km;
		this.precioDia = precioDia;
		this.precioKm = precioKm;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getDiasAlquiler() {
		return diasAlquiler;
	}

	public void setDiasAlquiler(int diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public double getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}

	public double getPrecioKm() {
		return precioKm;
	}

	public void setPrecioKm(double precioKm) {
		this.precioKm = precioKm;
	}

	public boolean isAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
	
	public abstract String toString();

}
