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
			br = new BufferedReader(new FileReader("prueba.txt"));
			String linea = leerFichero(br);
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

	public static String leerFichero(BufferedReader br) throws Exception {
		int letra;
		char caracter;
		String texto = "";
		letra = br.read();
		
		while(letra != -1) {
			
			if(letra != 32) {
				caracter = (char)letra;
				texto += (char)letra;
				System.out.print(caracter);
			}
			letra = br.read();
		}
		return texto;
	}

}
