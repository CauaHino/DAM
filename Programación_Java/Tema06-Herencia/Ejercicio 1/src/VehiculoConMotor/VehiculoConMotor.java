package VehiculoConMotor;

import Vehiculo.Vehiculo;

public class VehiculoConMotor extends Vehiculo {
	protected String matricula;
	protected double cilindradas;
	protected int potencia;
	
	public VehiculoConMotor(String c, double p, String m, double cc, int cv) {
		super(c,p);
		this.matricula = m;
		this.cilindradas = cc;
		this.potencia = cv;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setCilindradas(double cilindradas) {
		this.cilindradas = cilindradas;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	public String toString() {
		return super.toString() + "\tMatricula: " + this.matricula + "\n" + 
									"\tCilindradas: " + this.cilindradas + "\n" + 
									"\tPotencia: " + this.potencia + " cv" +"\n";
	}
}
