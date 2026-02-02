package main;

import Banco.Banco;
import Cuenta_bancaria.Cuenta_bancaria;
import Persona.Persona;

public class Main {

	public static void main(String[] args) {

		Persona p1 = new Persona("Ana López", "111A", 18);
		Persona p2 = new Persona("Benito Ruiz", "222B", 20);
		Persona p3 = new Persona("Carla Sanz", "333C", 19);
		Persona p4 = new Persona("David Mas", "444D", 30);
		Persona p5 = new Persona("Eva Costa", "555E", 29);

		Cuenta_bancaria c1 = new Cuenta_bancaria(p1, 2500, "ES01");
		Cuenta_bancaria c2 = new Cuenta_bancaria(p2, 2500, "ES02");
		Cuenta_bancaria c3 = new Cuenta_bancaria(p3, 6000, "ES03");
		Cuenta_bancaria c4 = new Cuenta_bancaria(p4, 8400, "ES04");
		Cuenta_bancaria c5 = new Cuenta_bancaria(p5, 1600, "ES05");

		Cuenta_bancaria[] cuentas = {c1, c2, c3, c4, c5};

		Banco miBanco = new Banco(4);
		System.out.println("Banco creado.");

		for (int i = 0; i < cuentas.length; i++) {
			boolean cuentaAbierta = miBanco.abrirCuenta(cuentas[i]);
			System.out.println("¿Se ha podido abrir la cuenta? " + (cuentaAbierta ? "Si" : "No"));
		}
		for (int i = 0; i < miBanco.getNumCuentas(); i++) {
			Cuenta_bancaria c[] = miBanco.getCuentaBancaria();
			System.out.println("Saldo de " + c[i].getTitular().getNombre() + " : " +miBanco.obtenerSaldo(c[i].getIban()));
		}

		for (int i = 0; i < miBanco.getNumCuentas(); i++) {
			Cuenta_bancaria c[] = miBanco.getCuentaBancaria();
			if (i % 2 == 0) {
				miBanco.ingresoCuenta(c[i].getIban(), 1500);
			}
		}
		for (int i = 0; i < miBanco.getNumCuentas(); i++) {
			Cuenta_bancaria c[] = miBanco.getCuentaBancaria();
			if (i == 0 || i == miBanco.getNumCuentas() - 1) {
				miBanco.retiradaCuenta(c[i].getIban(), 1500);
			}
		}
		for (int i = 0; i < miBanco.getNumCuentas(); i++) {
			System.out.println(miBanco.listarCuentas()[i].toString());

		}

	}

}
