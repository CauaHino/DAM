import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce el número para Adivinar");
		int N;
		N = scanner.nextInt();

		boolean acierto = true;

		while (acierto) {
			System.out.println("ADIVINA el número");
			int guess;
			guess = scanner.nextInt();

			if (guess < N) {
				System.out.print("El número buscado es MAYOR que el puesto");
			} else if (guess > N) {
				System.out.println("El número buscado es MENOR que el puesto");
			} else {
				System.out.println("¡ENHORABUENA! el números es: " + N);
				break;
			}
		}
	}

}
