package Empleado;

import Persona.Persona;

public class Empleado extends Persona{
	protected String nombreEmpresa;
	protected double salario;

	
	
	
	public Empleado(String n, String a, int edad, String nE, double salario) {
		super(n, a, edad);
		this.nombreEmpresa = nE;
		this.salario = salario;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String toString() {
		return super.toString() + "\nEMPLEADO:" + "\n" + "\tNombre de la Empresa: " + this.nombreEmpresa + "\n" +
										"\tSalario: " + this.salario + "\n";
	}
										
	

}
