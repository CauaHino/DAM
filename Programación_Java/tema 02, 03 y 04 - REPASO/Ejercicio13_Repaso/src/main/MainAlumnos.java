package main;

import java.time.LocalDate;
import java.util.Scanner;

import propietario.Propietario;
import vehiculo.Vehiculo;

public class MainAlumnos {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		boolean salir = false;
		int opcion;
		Vehiculo v = null;

		String marca, matricula, color, nombreProp, apellidosProp, DNIProp;
		int km, dia, mes, anio;
		double precio;
		LocalDate fechaMatriculacion;
		Propietario propietario = null;
		Vehiculo [] flota = new Vehiculo [5];
		int numVehiculos = 0;
		

		while (!salir) {

			System.out.println("1. Nuevo Vehiculo.");
			System.out.println("2. Ver Matrícula.");
			System.out.println("3. Ver Número de Kilómetros.");
			System.out.println("4. Actualizar Kilómetros.");
			System.out.println("5. Ver años de antigüedad.");
			System.out.println("6. Mostrar propietario.");
			System.out.println("7. Mostrar color.");
			System.out.println("8. Mostrar precio.");
			System.out.println("9. Mostrar información completa del vehículo.");
			System.out.println("10. Salir.");
			System.out.println("Elige una opcion");
			opcion = entrada.nextInt();
			entrada.nextLine();

			switch (opcion) {
			case 1:

				System.out.println("Introduce la marca");
				marca = entrada.nextLine();

				System.out.println("Introduce la matricula");
				matricula = entrada.nextLine();

				System.out.println("Introduce el numero de km");
				km = entrada.nextInt();
				entrada.nextLine();
				
				System.out.println("Introduce el dia de la fecha de matriculacion");
				dia = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Introduce el mes de la fecha de matriculacion");
				mes = entrada.nextInt();
				entrada.nextLine();
				System.out.println("Introduce el año de la fecha de matriculacion");
				anio = entrada.nextInt();
				entrada.nextLine();
				fechaMatriculacion = LocalDate.of(anio, mes, dia);

				System.out.println("Introduce el color");
				color = entrada.nextLine();
				
				System.out.println("Introduce el precio");
				precio = entrada.nextDouble();
				entrada.nextLine();

				System.out.println("Introduce el nombre del propietario");
				nombreProp = entrada.nextLine();
				
				System.out.println("Introduce los apellidos del propietario");
				apellidosProp = entrada.nextLine();

				System.out.println("Introduce el dni del propietario");
				DNIProp = entrada.nextLine();

				propietario = new Propietario(nombreProp, apellidosProp, DNIProp);
				
				

				v = new Vehiculo(marca, matricula, km, fechaMatriculacion, color, precio, propietario);
				System.out.println("Vehiculo creado");

				break;

			case 2:
				if (v != null) {
					System.out.println("Matricula: " + v.dameMatricula());
				} else {
					System.out.println("Debes crear un vehiculo");
				}
				break;

			case 3:

				if (v != null) {
					System.out.println("KM: " + v.dameNumKM());
				} else {
					System.out.println("Debes crear un vehiculo");
				}
				break;

			case 4:

				if (v != null) {

					System.out.println("Introduce el numero de km");
					km = entrada.nextInt();

					v.modificaNumKM(km);
					System.out.println("KM actualizados");

				} else {
					System.out.println("Debes crear un vehiculo");
				}

				break;

			case 5:

				if (v != null) {
					System.out.println("Antiguedad: " + v.dameAnios() + " años");
				} else {
					System.out.println("Debes crear un vehiculo");
				}

				break;

			case 6:

				if (v != null) {
					System.out.println(v.damePropietario() );
				} else {
					System.out.println("Debes crear un vehiculo");
				}
				break;

			case 7:

				if (v != null) {
					System.out.println("Descripcion: " + v.dameColor());
					System.out.println("Matricula: " + v.dameMatricula());
					System.out.println("KM: " + v.dameNumKM());
				} else {
					System.out.println("Debes crear un vehiculo");
				}

				break;

			case 8:

				if (v != null) {
					System.out.println("Precio: " + v.damePrecio());
				} else {
					System.out.println("Debes crear un vehiculo");
				}
				break;

			case 9:
				if (v != null) {
					v.mostrarInfo();
					;
				} else {
					System.out.println("Debes crear un vehiculo");
				}
				break;
			case 10:
				salir = true;
				break;
			default:
				System.out.println("Elige una opcion entre 1 y 10");
			}

		}

	}

}
