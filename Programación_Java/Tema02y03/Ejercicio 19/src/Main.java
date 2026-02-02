import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numero, factorial = 1;
		System.out.println("Introduzca un número");
		numero = scan.nextInt();
		
		for (int i = 1; i <= numero; i++) {
			factorial = factorial * i;
		}
		System.out.println("El factorial de "+ numero+ " es "+ factorial);

	}

}
