package Main;

import java.time.LocalDate;

import Proprietario.Proprietario;
import Vehiculo.Vehiculo;

public class Main {

	public static void main(String[] args) {
		Proprietario propietarioV1 = new Proprietario("Bea", "López", "47852965T");
		Vehiculo v1 = new Vehiculo();
		v1.setPropietario(propietarioV1);
		System.out.println("Informaación del primer vehiculo: " +"\n" + v1);
		
		
		Proprietario propietarioV2 = new Proprietario("Pepe", "Martinez", " 45123689J");
		Vehiculo v2 = new Vehiculo ("Audi", "4596JKL", 35000, LocalDate.of(2015, 10, 20), 42500, "Blanco", propietarioV2);
		System.out.println("Información del segundo vehiculo: "+ "\n" + v2);
		
		
		System.out.println("La matricula del vehiculo por defecto es: " + v1.getMatricula());
		
		v2.setNumKilometros(50350);
		int anosAntiguidad = v2.dameAnos();
		System.out.println("El vehiculo v2 tiene: "+ anosAntiguidad+ " años."+ "\n");
		
		System.out.println("El propietario del vehiculo v1 es: ");
		v1.getPropietario().mostrarInfo();
		System.out.println("El color del vehiculo v1 es: "+ v1.getColor());
		System.out.println("El precio del vehiculo v1 es: "+ v1.getPrecio());
		

	}

}
