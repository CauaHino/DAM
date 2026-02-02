import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numero;
		int contador = 0;

		do {
			System.out.println("Introduzca un número");
			numero = scanner.nextInt();
			System.out.print("El número introducido fue: " + numero + ", ");

			if (numero >= 0) {
				contador++;
			}
		} while (numero >= 0);
		System.out.println("se han introducido " + contador + " números.");
	}

}
