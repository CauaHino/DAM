import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		leerEntero();
	}

	public static String leerEntero() {
		Scanner input = new Scanner(System.in);
		int[] array = new int[4];

		for (int i = 0; i < array.length; i++) {
			System.out.println("Introduzca el numero de la posición " + (i + 1) + " :");
			try {
				array[i] = input.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Has introducido un dato erroneo");
				input.nextLine();
				i--;
			}
		}
		System.out.println("Los números introducidos fueron: " + "[ "+array[0] + " , " + array[1] + " , " + array[2] + " , " + array[3] + " ]");
		System.out.println(Arrays.toString(array));
		
		return null;
		

	}
}
