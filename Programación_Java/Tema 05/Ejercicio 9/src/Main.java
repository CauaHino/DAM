import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int [] array = new int[10];
		int contadorPares = 0;
		int contadorImpar = 0;
		
		
		for (int i = 0; i < array.length; i++) {
			System.out.print("Introduzca un número:");
			 array[i] = input.nextInt();	
			if (array[i] % 2 == 0) {
				contadorPares++; 
				} else {
					contadorImpar++;
				} 
		}
			int [] arrayPares = new int[contadorPares];
			int [] arrayImpar = new int[contadorImpar];
			
			int pares = 0;
			int impares = 0;
			
			for (int j = 0; j < array.length; j++) {
				if (array[j] % 2 == 0) {
					arrayPares [pares] = array [j];
					pares++;
				} else {
					arrayImpar[impares] = array [j];
					impares++;
				}
				
			}
			System.out.println(Arrays.toString(array));
			System.out.println(Arrays.toString(arrayPares));
			System.out.println(Arrays.toString(arrayImpar));
		}
		

	}


