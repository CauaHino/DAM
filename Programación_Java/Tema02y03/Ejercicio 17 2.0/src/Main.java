import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int maximo = 10;
		int minimo = 0;

		int N = (int) (Math.random() * ((maximo - minimo + 1) + minimo));
		System.out.println(N);

		boolean acierto = true;

		System.out.println("ADIVINA el número");

		while (acierto) {
			int guess;
			guess = scanner.nextInt();

			if (guess == N) {
				System.out.println("¡ENHORABUENA! el números es: " + N);
				break;
			} else if (guess > N) {
				System.out.println("El número buscado es MENOR que el puesto");
			} else {
				System.out.print("El número buscado es MAYOR que el puesto");
			}
		}
	}

}
