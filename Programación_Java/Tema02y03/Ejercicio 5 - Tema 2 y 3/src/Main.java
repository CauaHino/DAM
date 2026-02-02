import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numero1;
		int numero2;
		
		System.out.println("Introduzca el primer número");
		numero1= scanner.nextInt();
		System.out.println("El primer número es " +numero1);
		
		System.out.println("Introduzca el segundo número");
		numero2= scanner.nextInt();
		System.out.println("El segundo número es " +numero2);
		
		if (numero1 > numero2) {
			System.out.println("El orden de numero mayor es " +numero1+" y " +numero2);
		}
		
		else {
			System.out.println("El orden de número mayor es "+ numero2+ " y " +numero1);
		}

	}

}
