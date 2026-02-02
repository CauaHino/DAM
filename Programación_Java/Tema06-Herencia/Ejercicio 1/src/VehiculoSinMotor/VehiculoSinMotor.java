package VehiculoSinMotor;

import Vehiculo.Vehiculo;

public class VehiculoSinMotor extends Vehiculo {
	protected int numRuedas;
	
	public VehiculoSinMotor(String c, double p,int numRuedas) {
		super(c,p);
		this.numRuedas = numRuedas;
	}
	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}
	
	public String toString() {
		return super.toString() + "\tNúmero de Ruedas: " + this.numRuedas + "\n";
	}
}
