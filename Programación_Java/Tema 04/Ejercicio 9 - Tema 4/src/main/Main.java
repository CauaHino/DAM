package main;

import coche.Coche;

public class Main {

	public static void main(String[] args) {
		
		Coche coche1 = new Coche ();
		System.out.println(coche1);
		
		Coche coche2= new Coche("Audi", "Rojo", 140, 4, 2021, "Eléctrico");
        System.out.println(coche2);
        
        Coche coche3 = new Coche ("Mercedes", "Gris", 120, 3, 2015, "Gasolina");
        System.out.println(coche3);
        
        Coche coche4 = new Coche ("Peugeot", "Azul Marino", 115, 5, 2018,"Gasolina");
        System.out.println(coche4);
        

	}

}

