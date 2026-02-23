package mian;

import java.io.*;

import com.google.gson.*;

import clientes.Cliente;
import vehiculos.*;

public class Main {

	public static void main(String[] args) {
		Cliente[] clientes = new Cliente[5];
		Vehiculo[] vehiculos = new Vehiculo[6];

		Gson gson = new Gson();

		try (BufferedReader br = new BufferedReader(new FileReader("datosVehiculos.json"))) {

			String matricula = "", tipo = "";
			String marca = "";
			double km = 0;
			int numPlazas = 0;
			boolean grua = false;

			JsonArray jsonArray = JsonParser.parseReader(br).getAsJsonArray();
			for (int i = 0; i < vehiculos.length || i < jsonArray.size(); i++) {

				JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

				tipo = jsonObject.get("tipo").getAsString();
				matricula = jsonObject.get("matricula").getAsString();
				marca = jsonObject.get("marca").getAsString();
				km = jsonObject.get("kmActuales").getAsDouble();

				if (tipo.equalsIgnoreCase("Turismo")) {
					vehiculos[i] = new Turismo(matricula, marca, km);
				} else if (tipo.equalsIgnoreCase("Furgoneta")) {
					numPlazas = jsonObject.get("numPlazas").getAsInt();
					vehiculos[i] = new Furgonetas(matricula, marca, km, numPlazas);
				} else if (tipo.equalsIgnoreCase("Camion")) {
					grua = jsonObject.get("tieneGrua").getAsBoolean();
					vehiculos[i] = new Camion(matricula, marca, km, grua);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader("datosClientes.Json"))) {
			String nombre = "", dni = "";
			boolean carnetTurismo = false, carnetFurgoneta = false, carnetCamion = false;

			JsonArray jsonArray = JsonParser.parseReader(br).getAsJsonArray();

			for (int i = 0; i < clientes.length || i < jsonArray.size(); i++) {

				JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
				
				nombre = jsonObject.get("nombre").getAsString();
				dni = jsonObject.get("dni").getAsString();
				carnetTurismo = jsonObject.get("carnetTurismo").getAsBoolean();
				carnetFurgoneta = jsonObject.get("carnetFurgoneta").getAsBoolean();
				carnetCamion = jsonObject.get("carnetCamion").getAsBoolean();
				
				clientes[i] = new Cliente(nombre, dni, carnetTurismo, carnetFurgoneta, carnetCamion);

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
		
		for(int i = 0; i < clientes.length && i < vehiculos.length; i++) {
			vehiculos[i].alquilar(clientes[i]);
		}
		
		for(Cliente c : clientes) {
			System.out.println(c);
		}
	}

}
