package vehiculos;

import java.util.Scanner;

import clientes.Cliente;

public class Turismo extends Vehiculo{
	Scanner teclado = new Scanner(System.in);

	public Turismo(String matricula, String marca, double km) {
		super(matricula, marca, km, 20,0.20);
	}

	@Override
	public String toString() {
	    return "TURISMO: \n" +
	    		"\tMatrícula: " + this.matricula + "\n" +
	           "\tMarca: " + this.marca + "\n" +
	           "\tDías: " + this.diasAlquiler + "\n" +
	           "\tKM: " + this.km + "\n" +
	           "\tEstado: " + (this.alquilado ? "Alquilado" : "Disponible");
	}

	@Override
	public boolean alquilar(Cliente cliente) {
		boolean alquilar = false;

		if (cliente.isCarnetTurismo() && cliente.getVehiculoAlquilado() == null && !this.alquilado) {
			String opcion = "";
			System.out.println("Para cuantos dias se alquila el vehiculo?");
			this.diasAlquiler = teclado.nextInt();
			teclado.nextLine();
			System.out.println("El coste del alquiler es de: " + this.diasAlquiler * this.precioDia + ", "
					+ this.precioKm + " por km recorrido");

			do {
				System.out.println("Desea alquilar el turismo: Si(s) / No(n)");
				opcion = teclado.nextLine();
			} while (!cliente.comprobarOpcion(opcion));

			if ("s".equalsIgnoreCase(opcion)) {
				cliente.setVehiculoAlquilado(this);
				this.alquilado = true;
				alquilar = true;
				System.out.println("Turismo alquilado");
			} else {
				System.out.println("Se ha cancelado el alquiler del Turismo");
			}
		} else {
			System.out.println("No se ha podido alquilar el turismo porque...");
			if (!cliente.isCarnetTurismo()) {
				System.out.println("El cliente " + cliente.getNombre() + " con ID " + cliente.getId()
						+ " no tiene el carnet para alquilar turismo \n");
			} else if (cliente.getVehiculoAlquilado() != null) {
				System.out.println("El cliente " + cliente.getNombre() + " con ID " + cliente.getId()
						+ " ya tiene un vehiculo alquilado \n");
			} else {
				System.out
						.println("El turismo " + this.marca + " con matricula " + this.matricula + "YA esta alquilado");
			}
		}

		return alquilar;
	}


	@Override
	public void devolver(Cliente cliente) {
		if(this.alquilado == true && cliente.getVehiculoAlquilado() != null) {
			this.setAlquilado(false);
			System.out.println("El Vehiculo fue devuelto con éxito");
			cliente.setVehiculoAlquilado(null);
		} else {
			System.out.println("No fue posible devolver el Vehiculo");
		}
		
	}

}
