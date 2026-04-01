package cuentas;

import excepciones.TitularMenorDeEdad;
import personas.Persona;

public class CuentaAhorro extends CuentaBancaria{
	private double tipoInteresAnual;
	
	public CuentaAhorro(double tipoInteresAnual, Persona titular, double saldo, String IBAN) throws TitularMenorDeEdad {
		super(titular, saldo, IBAN);
		this.tipoInteresAnual = tipoInteresAnual;
	}
	
	public CuentaAhorro(int idCuenta, double saldo, String IBAN, Persona titular, double tipoInteresAnual){
		this.idCuenta = idCuenta;
		this.saldo = saldo;
		this.IBAN = IBAN;
		this.titular = titular;
		this.tipoInteresAnual = tipoInteresAnual;
	}
	
	public double getTipoInteresAnual() {
		return tipoInteresAnual;
	}

	public void setTipoInteresAnual(double tipoInteresAnual) {
		this.tipoInteresAnual = tipoInteresAnual;
	}

	@Override
	public String devolverInfoString() {
		// TODO Auto-generated method stub
		return "CuentaAhorro: \n"
				+"Titular: "+this.titular.devolverInfoString()+"\n"
				+"Saldo: "+this.saldo+"\n"
				+"IBAN: "+this.IBAN+"\n"
				+"Tipo Interés Anual: "+this.tipoInteresAnual+"\n";
	}

}
