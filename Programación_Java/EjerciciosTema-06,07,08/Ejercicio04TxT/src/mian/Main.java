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
			
			while(linea != null) {
				if("Turismo".equalsIgnoreCase(linea)) {
					marca = br.readLine();
					matricula = br.readLine();
					km = br.readLine();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
