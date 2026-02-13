package main;

import java.io.*;

import electrodomestico.*;

public class Main {

	public static void main(String[] args) {
		Electrodomestico[] electrodomesticos = new Electrodomestico[10];

		String precioTv = "", pesoTv = "", carga = "", precioLa = "", pesoLa = "";
		String smartTv = "";
		String pulgadas = "";
		String color = "";
		String consumo = "";
		
		int aux = 0;
		int aux2 = 5;

		for (int i = 0; i < electrodomesticos.length; i++) {
			if (i < 5) {
				electrodomesticos[i] = new Lavadora();
			} else {
				electrodomesticos[i] = new Television();
			}
		}

		try (BufferedReader br = new BufferedReader(new FileReader("electrodomesticos.txt"))) {
			String linea = "";
			linea = br.readLine();

			while (linea != null) {
					if (aux < 5) {
						if ("lavadora".equalsIgnoreCase(linea)) {
							precioLa = br.readLine();
							pesoLa = br.readLine();
							consumo = br.readLine();
							color = br.readLine();
							carga = br.readLine();

							double precioLavadora = Double.parseDouble(precioLa);
							double pesoLavadora = Double.parseDouble(pesoLa);
							char consumoLavadora = consumo.charAt(0);
							double cargaLavadora = Double.parseDouble(carga);

							electrodomesticos[aux].setPrecio(precioLavadora);
							electrodomesticos[aux].setConsumo(consumoLavadora);
							electrodomesticos[aux].setColor(color);
							electrodomesticos[aux].setPeso(pesoLavadora);
							((Lavadora) electrodomesticos[aux]).setCarga(cargaLavadora);
							aux++;
						} else if ("lavadora2".equalsIgnoreCase(linea)) {
							precioLa = br.readLine();
							pesoLa = br.readLine();

							double precioLavadora = Double.parseDouble(precioLa);
							double pesoLavadora = Double.parseDouble(pesoLa);

							electrodomesticos[aux].setPrecio(precioLavadora);
							electrodomesticos[aux].setPeso(pesoLavadora);;
							aux++;
						} else {
							if ("television".equalsIgnoreCase(linea)) {
								precioTv = br.readLine();
								pesoTv = br.readLine();
								consumo = br.readLine();
								color = br.readLine();
								pulgadas = br.readLine();
								smartTv = br.readLine();

								double precioTelevision = Double.parseDouble(precioTv);
								double pesoTelevision = Double.parseDouble(pesoTv);
								char consumoTelevision = consumo.charAt(0);
								int pulgadasTv = Integer.parseInt(pulgadas);
								boolean smartTvTele = Boolean.parseBoolean(smartTv);

								electrodomesticos[aux2].setPrecio(precioTelevision);
								electrodomesticos[aux2].setConsumo(consumoTelevision);
								electrodomesticos[aux2].setColor(color);
								electrodomesticos[aux2].setPeso(pesoTelevision);
								((Television) electrodomesticos[aux2]).setPulgadas(pulgadasTv);
								((Television) electrodomesticos[aux2]).setSmartTv(smartTvTele);
								aux2++;
								
							} else if ("television2".equalsIgnoreCase(linea)) {
								precioTv = br.readLine();
								pesoTv = br.readLine();

								double precioTelevision = Double.parseDouble(precioTv);
								double pesoTelevision = Double.parseDouble(pesoTv);

								electrodomesticos[aux2].setPrecio(precioTelevision);
								electrodomesticos[aux2].setPeso(pesoTelevision);
								aux2++;
							}

						}
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
		for (Electrodomestico e : electrodomesticos) {
			System.out.println(e.toString());
		}

	}

}