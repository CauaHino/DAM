package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import imobiliaria.Imobiliaria;
import viviendas.*;

public class Principal {
	public static void main(String[] args) {
		BufferedReader datosEntrada = null;
		Imobiliaria inmobiliaria = new Imobiliaria(10);

		String precioUF = "", metrosCuadradosUF = "", precioCH = "", metrosCuadradosCH = "", metrosJardinCH = "",
				precioPiso = "", metrosCuadradosPiso = "", numHabitacionesPiso = "", precioCDC = "",
				metrosCuadradosCDC = "", metrosParalelosCDC = "", metrosJardin = "", precioLC = "",
				metrosCuadradosLC = "";

		double precio, metrosCuadrados;

		try (BufferedReader ficheroEntrada = new BufferedReader(new FileReader("datosViviendas.txt"))) {
			String lineaLeida = ficheroEntrada.readLine();
			while (lineaLeida != null) {
				if ("unifamiliar".equals(lineaLeida)) {
					precioUF = ficheroEntrada.readLine();
					metrosCuadradosUF = ficheroEntrada.readLine();
				} else if ("chalet".equals(lineaLeida)) {
					precioCH = ficheroEntrada.readLine();
					metrosCuadradosCH = ficheroEntrada.readLine();
					metrosJardinCH = ficheroEntrada.readLine();
				} else if ("piso".equals(lineaLeida)) {
					precioPiso = ficheroEntrada.readLine();
					metrosCuadradosPiso = ficheroEntrada.readLine();
					numHabitacionesPiso = ficheroEntrada.readLine();
				} else if ("casadecampo".equals(lineaLeida)) {
					precioCDC = ficheroEntrada.readLine();
					metrosCuadradosCDC = ficheroEntrada.readLine();
					metrosParalelosCDC = ficheroEntrada.readLine();
				} else if ("localcomercial".equals(lineaLeida)) {
					metrosCuadradosLC = ficheroEntrada.readLine();
				}

				lineaLeida = ficheroEntrada.readLine();
			}

			System.out.println("------------------------------------");
			System.out.println("Vivienda de datos");
			System.out.println("------------------------------------");

			for (Vivienda v : inmobiliaria.getViviendas()) {
				if (v instanceof Chalet) {
					precio = Double.parseDouble(precioCH);
					metrosCuadrados = Double.parseDouble(metrosCuadradosCH);
					double metrosJardin1 = Double.parseDouble(metrosJardinCH);

					v.setPrecio(precio);
					v.setM2(metrosCuadrados);
					((Chalet) v).setMetrosJardin(metrosJardin1);
				} else if (v instanceof Unifamiliar) {
					precio = Double.parseDouble(precioUF);
					metrosCuadrados = Double.parseDouble(metrosCuadradosUF);

					v.setPrecio(precio);
					v.setM2(metrosCuadrados);
				} else if (v instanceof Pisos) {
					precio = Double.parseDouble(precioPiso);
					metrosCuadrados = Double.parseDouble(metrosCuadradosPiso);
					int hab = Integer.parseInt(numHabitacionesPiso);

					v.setPrecio(precio);
					v.setM2(metrosCuadrados);
					((Pisos) v).setHabitaciones(hab);
				} else if (v instanceof CasaDeCampo) {
					precio = Double.parseDouble(precioCDC);
					metrosCuadrados = Double.parseDouble(metrosCuadradosCDC);
					double metrosParcela = Double.parseDouble(metrosParalelosCDC);

					v.setPrecio(precio);
					v.setM2(metrosCuadrados);
					((CasaDeCampo) v).setMetrosParcela(metrosParcela);
				}else if(v instanceof LocalComercial) {
	                metrosCuadrados = Double.parseDouble(metrosCuadradosLC);
	                v.setM2(metrosCuadrados);
	                v.setPrecio(metrosCuadrados*3000);
					}
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Vivienda v : inmobiliaria.getViviendas()) {
			System.out.println(v.toString());
		}
		Imobiliaria.compararImpuesto(inmobiliaria.getViviendas());

	}
}