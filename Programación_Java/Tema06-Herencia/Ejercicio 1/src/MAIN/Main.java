package MAIN;

import java.time.LocalDate;

import bicicleta.Bicicleta;
import camión.Camion;
import coche.Coche;
import moto.Moto;

public class Main {

	public static void main(String[] args) {
		Coche c = new Coche("Rojo",1500.5,"1234-XYZ",2000.0, 150, "Ford", "Focus", 22000.00);
        Moto m = new Moto( "Verde", 180.5, "5678-DEF", 600.0, 74,"Kawasaki", "Ninja 650", LocalDate.of(2023, 3, 15));
        Camion camion = new Camion("Blanco",8500.5,"9012-LMN", 12800.0,480,24000);
        Bicicleta b = new Bicicleta("Negro Mate",12.5,2,"Orbea", "Alma H30", "Montaña");
        
       System.out.println(c);
       System.out.println("-----------------------------------------------------------");
       System.out.println(m);
       System.out.println("-----------------------------------------------------------");
       System.out.println(camion);
       System.out.println("-----------------------------------------------------------");
       System.out.println(b);

	}

}
