package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		BufferedReader in = null;
		if(args == null) {
			System.out.println("Faltan argumentos en main...");
		}else {		
		try {
			File ficheroEntrada = new File(args[0]);
			if(ficheroEntrada.exists()) {
				in = new BufferedReader(new FileReader(ficheroEntrada));
				
				System.out.println("El fichero existe.");
				System.out.println("EL fichero tiene: " + contar(in) + " caracteres");
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

	private static int contar(BufferedReader buferFichero) throws IOException {
		int contador = 0;
		while(buferFichero.read() != -1){
			contador++;
		}
		return contador;
		
	}
}
