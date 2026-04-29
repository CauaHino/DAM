package cuentas;

import excepciones.TitularMenorDeEdad;
import personas.Persona;

public abstract class CuentaCorriente extends CuentaBancaria{
	protected String listaEntidades;
	
	public CuentaCorriente() {
		
	}
	
	public CuentaCorriente(String listaEntidades, Persona titular, double saldo, String IBAN) throws TitularMenorDeEdad {
		super(titular, saldo, IBAN);
		this.listaEntidades = listaEntidades;
	}
	
	public String getListaEntidades() {
		return listaEntidades;
	}

	public void setListaEntidades(String listaEntidades) {
		this.listaEntidades = listaEntidades;
	}

	public abstract String devolverInfoString();

}
