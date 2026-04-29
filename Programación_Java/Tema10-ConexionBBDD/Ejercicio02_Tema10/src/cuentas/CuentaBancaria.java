package cuentas;

import excepciones.TitularMenorDeEdad;
import interfaces.Imprimible;
import personas.Persona;

public abstract class CuentaBancaria implements Imprimible{
	protected static int contador = 0;
	protected int idCuenta;
	protected Persona titular;
	protected double saldo;
	protected String IBAN;
	protected int idBanco;
	
	public CuentaBancaria() {
		
	}
	
	public CuentaBancaria(Persona titular, double saldo, String IBAN) throws TitularMenorDeEdad {
		if(titular.getEdad() < 18)
			throw new TitularMenorDeEdad(titular.getIdPersona(), titular.getNombre());
		contador++;
		this.idCuenta = contador;
		this.titular = titular;
		this.saldo = saldo;
		this.IBAN = IBAN;
	}
	
	public Persona getTitular() {
		return titular;
	}

	public void setTitular(Persona titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	
	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public abstract String devolverInfoString();

}
