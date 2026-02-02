import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int numero1;
		int numero2;
		int numero3;
		
		System.out.println("Introduzca el primer número");
		numero1= scanner.nextInt();
		System.out.println("El primer número es "+ numero1);
		
		System.out.println("Introduzca el segundo número");
		numero2= scanner.nextInt();
		System.out.println("El segundo número es "+ numero2);
		
		System.out.println("Introduzca el tercer número");
		numero3= scanner.nextInt();
		System.out.println("El tercer número es "+ numero3);
		
		if (numero1 > numero2 && numero1 > numero3 && numero2>numero3) {
		System.out.println("La orden de MAYOR número es "+ numero1+ " , " +numero2+ " , " + numero3);
		}
		else if (numero2> numero1 && numero2 > numero3 && numero3 < numero1) {
			System.out.println("La orden de MAYOR número es "+ numero2+ " , "+ numero1+ " , " + numero3);
			
		}
		else if (numero3> numero2 && numero3>numero1 && numero2>numero3) {
			System.out.println("La orden de MAYOR número es "+ numero3+ " , "+ numero2+ " , " + numero1);
		}
		
		else if (numero2>numero1 && numero3>numero1) {
			System.out.println("La orden de MAYOR número es "+ numero2+ " , "+ numero3+ " , "+ numero1);
		}
		
		else if(numero3 > numero2 && numero1 > numero2) {
			System.out.println("La orden de MAYOR número es "+ numero3+ " , " + numero1+ " , "+ numero2);		
			}
		
		else {
			System.out.println("Los números son IGUALES");
		}

	}

}
