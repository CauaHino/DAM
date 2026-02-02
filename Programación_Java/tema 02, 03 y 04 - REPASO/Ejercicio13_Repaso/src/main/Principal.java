package main;

import java.time.LocalDate;

import propietario.Propietario;
import vehiculo.Vehiculo;

public class Principal {

	public static void main(String[] args) {
		Propietario propietarioV1 = new Propietario("Bea", "López", "47852965T");
		Vehiculo v1 = new Vehiculo();
		v1.modificaPropietario(propietarioV1);
		System.out.println("Información del primer vehículo:");
		v1.mostrarInfo();
		
		Propietario propietarioV2 = new Propietario("Pepe", "Martínez", "74852963P");
		Vehiculo v2 = new Vehiculo("Audi", "4596JKL", 35000, 
				LocalDate.of(2015,10,20), "blanco", 42500, propietarioV2);
		System.out.println("Información del segundo vehículo:");
		v2.mostrarInfo();
		
		System.out.println("La matricula del vehiculo por defecto es: "
							+v1.dameMatricula());
		v2.modificaNumKM(38500);
		int aniosAntiguedad = v2.dameAnios();
		System.out.println("El vehículo v2 tiene: "+aniosAntiguedad+" años.");
		System.out.println("El propietario del vehículo v1 es: ");
		v1.damePropietario().mostrarInfo();
		System.out.println("El color del vehículo v1 es: "+v1.dameColor());
		System.out.println("El precio del vehículo v1 es: "+v1.damePrecio()+" €");
		
		

	}

}
