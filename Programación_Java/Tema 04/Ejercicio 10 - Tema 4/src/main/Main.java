package main;

import empleadoa.Empleado;
import empresa.Empresa;

public class Main {

	public static void main(String[] args) {
		Empleado empleado = new Empleado("74521874L", "Pepe López", 35, true);
		empleado.calcularSueldo();
		
		Empresa empresa = new Empresa ("B12548795", "InforOcaña SA", empleado);
		
		System.out.println(empresa);

	}

}
