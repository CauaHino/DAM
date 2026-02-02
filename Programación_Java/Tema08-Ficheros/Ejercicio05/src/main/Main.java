package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		BufferedWriter out = null;
		BufferedReader entrada = null;

		try {
			FileReader leer = new FileReader("alumno.txt");
			entrada = new BufferedReader(leer);
			out = new BufferedWriter(new FileWriter("alumno2txt"));
			String linea1 = entrada.readLine();
			out.write(linea1);
			out.newLine();
			String cadena = "y estoy escribiendo en un fichero de salida";
			for (int i = 0; i < cadena.length(); i++) {
				out.write(cadena.charAt(i));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
