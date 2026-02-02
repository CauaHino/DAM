import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] num = new int[5];
		int tamano = 0;

		do {
			System.out.println("Introduzca un número");
			int numInsertado = sc.nextInt();
			num[tamano] = numInsertado;
			tamano++;
		} while (tamano < num.length);

		System.out.println("Los números introducidos en la orden inversa son: ");

		for (int i = num.length - 1; i >= 0; i--)
			System.out.print(num[i] + " | ");

	}

}
