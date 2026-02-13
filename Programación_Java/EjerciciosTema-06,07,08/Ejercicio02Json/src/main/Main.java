package main;

import java.io.*;

import com.google.gson.*;

import electrodomestico.*;

public class Main {

	public static void main(String[] args) {
		Electrodomestico[] electrodomesticos = new Electrodomestico[10];

		Gson gson = new Gson();

		double precioTv = 0, pesoTv = 0, carga = 0, precioLa = 0, pesoLa = 0;
		boolean smartTv = false;
		int pulgadas = 0;
		String color = "", tipo = "";
		char consumo = 'F';

		int aux = 0;
		int aux2 = 5;

		for (int i = 0; i < electrodomesticos.length; i++) {
			if (i < 5) {
				electrodomesticos[i] = new Lavadora();
			} else {
				electrodomesticos[i] = new Television();
			}
		}

		try (BufferedReader br = new BufferedReader(new FileReader("electrodomesticos.json"))) {
			JsonArray jsonArray = JsonParser.parseReader(br).getAsJsonArray();

			for (JsonElement jsonElement : jsonArray) {
				JsonObject jsonObject = jsonElement.getAsJsonObject();

				tipo = jsonObject.get("tipo").getAsString();

				if (tipo.equalsIgnoreCase("LAVADORA")) {

					precioLa = jsonObject.get("precio").getAsDouble();
					consumo = jsonObject.get("consumo").getAsCharacter();
					color = jsonObject.get("color").getAsString();
					pesoLa = jsonObject.get("peso").getAsDouble();
					carga = jsonObject.get("carga").getAsDouble();

					electrodomesticos[aux].setPrecio(precioLa);
					electrodomesticos[aux].setConsumo(consumo);
					electrodomesticos[aux].setColor(color);
					electrodomesticos[aux].setPeso(pesoLa);
					((Lavadora) electrodomesticos[aux]).setCarga(carga);
					aux++;
				} else if (tipo.equalsIgnoreCase("LAVADORA2")) {
					precioLa = jsonObject.get("precio").getAsDouble();
					pesoLa = jsonObject.get("peso").getAsDouble();

					electrodomesticos[aux].setPrecio(precioLa);
					electrodomesticos[aux].setPeso(pesoLa);
					;
					aux++;
				} else {
					if (tipo.equalsIgnoreCase("television")) {
						precioTv = jsonObject.get("precio").getAsDouble();
						consumo = jsonObject.get("consumo").getAsCharacter();
						color = jsonObject.get("color").getAsString();
						pesoTv = jsonObject.get("peso").getAsDouble();
						pulgadas = jsonObject.get("pulgadas").getAsInt();
						smartTv = jsonObject.get("smartTV").getAsBoolean();

						electrodomesticos[aux2].setPrecio(precioTv);
						electrodomesticos[aux2].setConsumo(consumo);
						electrodomesticos[aux2].setColor(color);
						electrodomesticos[aux2].setPeso(pesoTv);
						((Television) electrodomesticos[aux2]).setPulgadas(pulgadas);
						((Television) electrodomesticos[aux2]).setSmartTv(smartTv);
						aux2++;

					} else if (tipo.equalsIgnoreCase("television2")) {
						precioTv = jsonObject.get("precio").getAsDouble();
						pesoTv = jsonObject.get("peso").getAsDouble();

						electrodomesticos[aux2].setPrecio(precioTv);
						electrodomesticos[aux2].setPeso(pesoTv);
						aux2++;
					}
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Electrodomestico e : electrodomesticos) {
			System.out.println(e.toString());
		}

	}

}