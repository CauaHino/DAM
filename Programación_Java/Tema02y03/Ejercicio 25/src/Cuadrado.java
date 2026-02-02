import java.util.Scanner;

public class Cuadrado {

	public static void main(String[] args) {
		Scanner inputDate = new Scanner(System.in);

		int cuadrado;

		do {
			System.out.println("Introduce la dimensión del cuadrado");
			cuadrado = inputDate.nextInt();

			if (cuadrado <= 0) {
				System.out.println("El número " + cuadrado + " no es válido, introduzca un número positivo");
			} else {
				System.out.println("La dimensión es: " + cuadrado);
			}
		} while (cuadrado <= 0);

		for (int i = 1; i <= cuadrado; i++) {

			for (int j = 1; j <= cuadrado; j++) {
				System.out.print("* ");
			}

			System.out.println();
		}
	}
}