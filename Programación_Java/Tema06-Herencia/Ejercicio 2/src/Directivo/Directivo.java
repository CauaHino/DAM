package Directivo;

import Empleado.Empleado;

public class Directivo extends Empleado{
	private boolean socio;
		
	public Directivo(String n, String a, int edad, String nE, double salario, boolean socio) {
		super(n, a, edad, nE, salario);
		this.socio = socio;
	}

	public boolean isSocio() {
		return socio;
	}

	public void setSocio(boolean socio) {
		this.socio = socio;
	}
	public String toString() {
		return super.toString() + "\n\tSocio: " + (this.socio ? "Si" : "No");
	}
}
