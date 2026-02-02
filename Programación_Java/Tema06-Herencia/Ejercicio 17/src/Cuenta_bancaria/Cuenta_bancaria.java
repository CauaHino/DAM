package Cuenta_bancaria;

import Persona.Persona;

public class Cuenta_bancaria {
	private Persona titular;
	private double saldo;
	private String iban;
	
	public Cuenta_bancaria (Persona titular, double saldo, String iban) {
		this.titular = titular;
		this.saldo = saldo;
		this.iban = iban;
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

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String toString () {
		return "Cuenta Bancaria:" + "\n" + "\tTitular: \n"+this.titular +
				"\n" + "\tSaldo: " + this.saldo + " €" +
				"\n" + "\tIBAN: " + this.iban;
				
	}
	

}
