package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Introduzca una cadena de texto");
		String cadena = sc.nextLine();
		
		int contadorVocales = 0;
		
		for (int i=0; i < cadena.length();i++ ) {
			char c = Character.toLowerCase(cadena.charAt(i));
			if (c == 'a'|| c == 'e' ||c == 'i' ||c == 'o' || c == 'u') {
				contadorVocales++;
			}
			
		}
		System.out.println("La cadena de texto introducida tiene: "+ contadorVocales + " vocales");

	}

}