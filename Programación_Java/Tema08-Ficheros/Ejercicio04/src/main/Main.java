package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter("quijote.txt"));
			String cadena = "En un Lugar de la Mancha,";
			for (int i = 0; i < cadena.length(); i++) {
				out.write(cadena.charAt(i));
			}
			cadena = "de cuyo nombre no quiero acordarme";
			out.newLine();
			out.write(cadena);
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
