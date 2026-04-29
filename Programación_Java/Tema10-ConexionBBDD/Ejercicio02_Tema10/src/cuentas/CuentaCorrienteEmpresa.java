package cuentas;

import excepciones.TitularMenorDeEdad;
import personas.Persona;

public class CuentaCorrienteEmpresa extends CuentaCorriente{
	private double maximoDescubierto;
	private double tipoInteresDescubierto;
	private double comisionFijaDescubierto;
	
	public CuentaCorrienteEmpresa(double maximoDescubierto, double tipoInteresDescubierto,
			double comisionFijaDescubierto, String listaEntidades,
			Persona titular, double saldo, String IBAN) throws TitularMenorDeEdad {
		super(listaEntidades, titular, saldo, IBAN);
		this.maximoDescubierto = maximoDescubierto;
		this.tipoInteresDescubierto = tipoInteresDescubierto;
		this.comisionFijaDescubierto = comisionFijaDescubierto;
	}
	
	public CuentaCorrienteEmpresa(int idCuenta, double saldo, String IBAN, Persona titular, String listaEntidades, double maximoDescubierto,
									double tipoInteresDescubierto, double comisionFijaDescubierto){
		this.idCuenta = idCuenta;
		this.saldo = saldo;
		this.IBAN = IBAN;
		this.titular = titular;
		this.listaEntidades = listaEntidades;
		this.maximoDescubierto = maximoDescubierto;
		this.tipoInteresDescubierto = tipoInteresDescubierto;
		this.comisionFijaDescubierto = comisionFijaDescubierto;
	}
	
	public double getMaximoDescubierto() {
		return maximoDescubierto;
	}

	public void setMaximoDescubierto(double maximoDescubierto) {
		this.maximoDescubierto = maximoDescubierto;
	}

	public double getTipoInteresDescubierto() {
		return tipoInteresDescubierto;
	}

	public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
		this.tipoInteresDescubierto = tipoInteresDescubierto;
	}

	public double getComisionFijaDescubierto() {
		return comisionFijaDescubierto;
	}

	public void setComisionFijaDescubierto(double comisionFijaDescubierto) {
		this.comisionFijaDescubierto = comisionFijaDescubierto;
	}

	@Override
	public String devolverInfoString() {
		return "CuentaCorrienteEmpresa: \n"
				+"Titular: "+this.titular.devolverInfoString()+"\n"
				+"Saldo: "+this.saldo+"\n"
				+"IBAN: "+this.IBAN+"\n"
				+"Lista de entidades: "+this.listaEntidades+"\n"
				+"Máximo descubierto: "+this.maximoDescubierto+"\n"
				+"Comisión descubierto: "+this.comisionFijaDescubierto+"\n"
				+"Tipo interés descubierto: "+this.tipoInteresDescubierto+"\n";
	}

}
