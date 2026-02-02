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
			bw = new BufferedWriter(new FileWriter("mayusculas.txt"));
			
			String lineaAEscribir = "";
			String lineaLeida = "";
			
			lineaLeida = br.readLine();

			while (lineaLeida != null) {
				lineaAEscribir = lineaLeida.toUpperCase();
				bw.write(lineaAEscribir);
				
				lineaLeida = br.readLine();
				lineaAEscribir = lineaLeida.toLowerCase();
				bw.newLine();
				bw.write(lineaAEscribir);
				lineaLeida = br.readLine();
			}
			
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

}
