package main;

import Circulo.Circulo;

public class Main {

	public static void main(String[] args) {
		Circulo circulo = new Circulo (5);
		
		System.out.println("Circulo Inicial: ");
		circulo.mostrarInfo();
		
		circulo.modificarRadio(10);
		System.out.println("Circulo Modificado: ");
		circulo.mostrarInfo();

	}

}
