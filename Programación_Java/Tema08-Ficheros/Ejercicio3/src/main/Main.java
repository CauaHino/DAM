package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader ficheroEntrada = null;
		String texto = "";
		String [] num = null;
		double suma = 0;
		
		try {
			FileReader fichero = new FileReader("NumerosReales.txt");
			ficheroEntrada = new BufferedReader(fichero);
			String linea = ficheroEntrada.readLine();
			
			while(linea != null) {
				texto += linea + "\n";
				linea = ficheroEntrada.readLine();
			}
			
			num = texto.split(" ");
			
		} catch (IOException e) {
			e.printStackTrace();
		}	finally {
			if(ficheroEntrada != null) {
				try{
					ficheroEntrada.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			System.out.println(texto);
			int contador = 0;
			for(int i = 0; i < num.length; i++) {
				suma += Double.valueOf(num[i]);
				contador++;
			}
			
			double media = suma/contador;
			System.out.println("La suma es: " + suma);
			System.out.println("La media es: " + media);
	}

	}
	}
