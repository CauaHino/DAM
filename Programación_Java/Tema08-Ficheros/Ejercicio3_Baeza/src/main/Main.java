package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader ficheroEntrada = null;
		String texto = "";
		String[] num = null;
		double suma = 0;

		try {
			FileReader fichero = new FileReader("NumerosReales.txt");
			ficheroEntrada = new BufferedReader(fichero);
			String linea = ficheroEntrada.readLine();

			while (linea != null) {
				texto += linea + "\n";
				linea = ficheroEntrada.readLine();
			}

			num = texto.split(" ");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ficheroEntrada != null) {
				try {
					ficheroEntrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				double precio = Double.valueOf(num[0]);
				double iva = Double.valueOf(num[1]);

				double precioIVA = precio * (1 + iva / 100);

				System.out.println("El precio es: " + precio);
				System.out.println("El IVA es: " + iva);
				System.out.println("El precio con IVA es: " + precioIVA);

			}
		}
	}
}
