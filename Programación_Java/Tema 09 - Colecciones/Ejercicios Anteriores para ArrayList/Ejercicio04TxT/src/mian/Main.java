package mian;

import java.io.*;
import java.util.ArrayList;

import clientes.Cliente;
import vehiculos.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<>();
		ArrayList<Vehiculo> vehiculos = new ArrayList<>();

		String matricula = "";
		String marca = "";
		String km = "";
		String numPlazas = "", grua = "";

		try (BufferedReader br = new BufferedReader(new FileReader("datosVehiculos.txt"))) {
			String linea = "";
			linea = br.readLine();

			while(linea != null) {
				if ("Turismo".equalsIgnoreCase(linea)) {
					marca = br.readLine();
					matricula = br.readLine();
					km = br.readLine();

					vehiculos.add(new Turismo(matricula, marca, Double.parseDouble(km)));

				} else if ("Camion".equalsIgnoreCase(linea)) {
					marca = br.readLine();
					matricula = br.readLine();
					km = br.readLine();
					grua = br.readLine();

					vehiculos.add(new Camion(matricula, marca, Double.parseDouble(km), Boolean.parseBoolean(grua)));

				} else if ("Furgoneta".equalsIgnoreCase(linea)) {
					marca = br.readLine();
					matricula = br.readLine();
					km = br.readLine();
					numPlazas = br.readLine();

					vehiculos.add(new Furgonetas(matricula, marca, Double.parseDouble(km),
							Integer.parseInt(numPlazas)));
				}
				linea = br.readLine();

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader("datosClientes.txt"))) {
			String nombre = "", dni = "", carnetTurismo = "", carnetFurgoneta = "", carnetCamion = "";

			String linea = "";
			linea = br.readLine();

			while(linea != null) {
				nombre = br.readLine();
				dni = br.readLine();
				carnetTurismo = br.readLine();
				carnetFurgoneta = br.readLine();
				carnetCamion = br.readLine();

				clientes.add(new Cliente(nombre, dni, Boolean.parseBoolean(carnetTurismo),
						Boolean.parseBoolean(carnetFurgoneta), Boolean.parseBoolean(carnetCamion)));

				linea = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Vehiculo v : vehiculos) {
			for(Cliente c : clientes)
			v.alquilar(c);
		}

		for (Cliente c : clientes) {
			if(c.getVehiculoAlquilado() != null) {
				System.out.println(c);
			}
		}

		for (Vehiculo v : vehiculos) {
			System.out.println(v);
		}

	}

}
