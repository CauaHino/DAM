package operario;

import Empleado.Empleado;

public class Operario extends Empleado{
	protected int antiguedad;
	protected boolean esOficial;

	
	public Operario(String n, String a, int edad, String nE, double salario, int ant) {
		super(n, a, edad, nE, salario);
		this.antiguedad = ant;
		if(ant > 10) {
			esOficial = true;
		} else {
			esOficial = false;
		}
	}


	public int getAntiguedad() {
		return antiguedad;
	}


	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	public String toString() {
		return super.toString() + "\n" + "OPERARIO:" + "\n" + "\tAntiguedad: " + this.antiguedad + "\n"+ 
																"\tFunción: " + (this.esOficial ? "Oficial" :  "Tecnico");
	}
	

}
