package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		BufferedWriter out = null;
		double suma = 0;
		int contador = 0;
		
		try {
			out = new BufferedWriter(new FileWriter("ficheroSalida.txt"));			
			for(int i = 0; i < args.length; i++) {
				suma += Integer.parseInt(args[i]);
				contador++;
			}		
			double media = suma/contador;
			System.out.println("La suma es: " + suma);
			System.out.println("La media es: " + media);
			String cadenaSuma = String.valueOf(suma);
			out.write("El valor de la suma es " + cadenaSuma);
			out.newLine();
			String sMedia = String.valueOf(media);
			out.write("El valor de la media es " + sMedia);
			
		} catch (IOException e) {
			e.printStackTrace();
		}	finally {
			if(out != null) {
				try{
					out.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			
			
			
	}

	}
	}
