package mian;

import java.io.*;

import clientes.Cliente;
import vehiculos.*;

public class Main {

	public static void main(String[] args) {
		Cliente[] clientes = new Cliente[5];
		Vehiculo[] vehiculos = new Vehiculo[6];
		
		String matricula    = "";
		String marca        = "";
		String diasAlquiler = "";
		String km           = "";
		String precioDia    = "";
		String precioKm     = "";
		String alquilado    = "", numPlazas = "", grua = "";
		
		try(BufferedReader br =  new BufferedReader(new FileReader("datosVehiculos.txt"))){
			String linea = "";
			linea = br.readLine();
			
			for(int i = 0; i < vehiculos.length && linea != null; i++) {
				if("Turismo".equalsIgnoreCase(linea)) {
					marca = br.readLine();
					matricula = br.readLine();
					km = br.readLine();					
					
					vehiculos[i] = new Turismo (matricula, marca, Double.parseDouble(km));	
					
				} else if("Camion".equalsIgnoreCase(linea)) {
					marca = br.readLine();
					matricula = br.readLine();
					km = br.readLine();
					grua = br.readLine();
					
					vehiculos[i] = new Camion(matricula, marca, Double.parseDouble(km), Boolean.parseBoolean(grua));					
				
				} else if("Furgoneta".equalsIgnoreCase(linea)) {
					marca = br.readLine();
					matricula = br.readLine();
					km = br.readLine();
					numPlazas = br.readLine();
					
					vehiculos[i] = new Furgonetas(matricula, marca, Double.parseDouble(km), Integer.parseInt(numPlazas));					
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
		
		try(BufferedReader br = new BufferedReader(new FileReader("datosClientes.txt"))) {
			String nombre = "",dni = "" ,carnetTurismo = "",carnetFurgoneta = "", carnetCamion = "";
			
			String linea = "";
			linea = br.readLine();
			
			for(int i = 0; i < clientes.length && linea != null; i++) {
				nombre = br.readLine();
				dni = br.readLine();
				carnetTurismo = br.readLine();
				carnetFurgoneta = br.readLine();
				carnetCamion = br.readLine();
				
				clientes[i] = new Cliente(nombre, dni, Boolean.parseBoolean(carnetTurismo), Boolean.parseBoolean(carnetFurgoneta),Boolean.parseBoolean(carnetCamion));
				
				linea = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Cliente c : clientes) {
			System.out.println(c);
		}
		
		for(Vehiculo v : vehiculos) {
			System.out.println(v);
		}
		}
		
		
	}

