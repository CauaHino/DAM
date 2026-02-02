import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca el primer número");
		int num1 = sc.nextInt();
		
		System.out.println("Introduzca el segundo número");
		int num2 = sc.nextInt();
		
		if(num1 % num2 == 0) {
			System.out.println("El "+ num1+ " es múltiple del " + num2);
		} else if (num2 % num1 == 0) {
			System.out.println("El número "+ num2+ " es múltiple del número " + num1);
		} else {
			System.out.println("Los números introducidos no son múltiples");
		}

	}

}
