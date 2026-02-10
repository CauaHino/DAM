package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import imobiliaria.Imobiliaria;
import viviendas.*;

public class Principal {
	public static void main(String[] args) {
		Gson gson = new Gson();
		Imobiliaria inmobiliaria = new Imobiliaria(10);
		String tipoVivienda;

		double precioUF = 0, metrosCuadradosUF = 0, precioCH = 0, metrosCuadradosCH = 0, metrosJardinCH = 0,
				precioPiso = 0, metrosCuadradosPiso = 0, precioCDC = 0, metrosCuadradosCDC = 0, metrosParalelosCDC = 0,
				metrosJardin = 0, precioLC = 0, metrosCuadradosLC = 0;
		int numHabitacionesPiso = 0;

		try (BufferedReader br = new BufferedReader(new FileReader("datosViviendas.json"))) {
			JsonArray jsonArray = JsonParser.parseReader(br).getAsJsonArray();

			for (JsonElement jsonElement : jsonArray) {
				JsonObject jsonObject = jsonElement.getAsJsonObject();

				tipoVivienda = jsonObject.get("tipo").getAsString();

				if (tipoVivienda.equalsIgnoreCase("unifamiliar")) {
					precioUF = jsonObject.get("precio").getAsDouble();
					metrosCuadradosUF = jsonObject.get("superficie").getAsDouble();

				} else if (tipoVivienda.equalsIgnoreCase("chalet")) {
					precioCH = jsonObject.get("precio").getAsDouble();
					metrosCuadradosCH = jsonObject.get("superficie").getAsDouble();
					metrosJardinCH = jsonObject.get("metrosJardin").getAsDouble();
				} else if (tipoVivienda.equalsIgnoreCase("piso")) {
					precioPiso = jsonObject.get("precio").getAsDouble();
					metrosCuadradosPiso = jsonObject.get("superficie").getAsDouble();
					numHabitacionesPiso = jsonObject.get("numHabitaciones").getAsInt();
				} else if (tipoVivienda.equalsIgnoreCase("casadecampo")) {
					precioCDC = jsonObject.get("precio").getAsDouble();
					metrosCuadradosCDC = jsonObject.get("superficie").getAsDouble();
					metrosParalelosCDC = jsonObject.get("metrosParcela").getAsDouble();
				} else if (tipoVivienda.equalsIgnoreCase("localcomercial")) {
					precioLC = jsonObject.get("superficie").getAsDouble();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("------------------------------------");
		System.out.println("Vivienda de datos");
		System.out.println("------------------------------------");

		for (Vivienda v : inmobiliaria.getViviendas()) {
			if (v instanceof Chalet) {

				v.setPrecio(precioCH);
				v.setM2(metrosCuadradosCH);
				((Chalet) v).setMetrosJardin(metrosJardinCH);
			} else if (v instanceof Unifamiliar) {

				v.setPrecio(precioUF);
				v.setM2(metrosCuadradosUF);
			} else if (v instanceof Pisos) {

				v.setPrecio(precioPiso);
				v.setM2(metrosCuadradosPiso);
				((Pisos) v).setHabitaciones(numHabitacionesPiso);
			} else if (v instanceof CasaDeCampo) {

				v.setPrecio(precioCDC);
				v.setM2(metrosCuadradosCDC);
				((CasaDeCampo) v).setMetrosParcela(metrosParalelosCDC);
			} else if (v instanceof LocalComercial) {
				v.setM2(metrosCuadradosLC);
				v.setPrecio(metrosCuadradosLC * 3000);
			}
		}
		for(Vivienda v : inmobiliaria.getViviendas()) {
			System.out.println(v.toString());
		}
		Imobiliaria.compararImpuesto(inmobiliaria.getViviendas());

	}

}
