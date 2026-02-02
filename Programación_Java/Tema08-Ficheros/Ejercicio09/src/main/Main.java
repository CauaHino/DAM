package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader("numeros.txt"));
			bw = new BufferedWriter(new FileWriter("suma.txt", true));
			int suma = leerFichero(br);
			bw.write("La suma de los valores son: ");
			bw.write(String.valueOf(suma));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (bw != null && br != null) {
					bw.close();
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static int leerFichero(BufferedReader br) throws Exception {
		String linea;
		int suma = 0;
		int num;

		linea = br.readLine();

		while (linea != null) {
			num = Integer.parseInt(linea);
			suma = num + suma;
			linea = br.readLine();
		}
		System.out.println("La suma de los números son: " + suma);
		return suma;
	}

}
