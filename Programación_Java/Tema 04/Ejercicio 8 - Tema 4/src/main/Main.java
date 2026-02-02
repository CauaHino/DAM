package main;

import Lampara.Lampara;

public class Main {

	public static void main(String[] args) {
		Lampara l1 = new Lampara("Techo");

		Lampara.encender();

		System.out.println(l1);
		
		l1.modificaTipo("de Pie");
		Lampara.apagar();
		System.out.println(l1);
		

	}

}
