package cuentas;

import excepciones.TitularMenorDeEdad;
import personas.Persona;

public class CuentaCorrientePersonal extends CuentaCorriente{
	private double comisionMantenimiento;
	
	public CuentaCorrientePersonal(double comisionMantenimiento, String listaEntidades,
			Persona titular, double saldo, String IBAN) throws TitularMenorDeEdad {
		super(listaEntidades, titular, saldo, IBAN);
		this.comisionMantenimiento = comisionMantenimiento;
	}
	
	public CuentaCorrientePersonal(int idCuenta, double saldo, String IBAN, Persona titular, String listaEntidades, double comisionMantenimiento){
		this.idCuenta = idCuenta;
		this.saldo = saldo;
		this.IBAN = IBAN;
		this.titular = titular;
		this.listaEntidades = listaEntidades;
		this.comisionMantenimiento = comisionMantenimiento;
	}
	
	public double getComisionMantenimiento() {
		return comisionMantenimiento;
	}

	public void setComisionMantenimiento(double comisionMantenimiento) {
		this.comisionMantenimiento = comisionMantenimiento;
	}

	@Override
	public String devolverInfoString() {
		return "CuentaCorrientePersonal: \n"
				+"Titular: "+this.titular.devolverInfoString()+"\n"
				+"Saldo: "+this.saldo+"\n"
				+"IBAN: "+this.IBAN+"\n"
				+"Lista de entidades: "+this.listaEntidades+"\n"
				+"Comisión de mantenimiento: "+this.comisionMantenimiento+"\n";
	}

}
