import java.util.Scanner;

public class Escalera {

	public static void main(String[] args) {
		Scanner inputDate = new Scanner(System.in);

		int height;

		System.out.println("Introduzca la altura de la escalera");
		height = inputDate.nextInt();

		for (int i = height; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}

}
