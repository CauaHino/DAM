import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] array = new int[4];
		boolean error = true;
			
		do {
			error = false;
		try {
			
			for(int i = 0; i < array.length; i++) {
				System.out.print("Introduzca el número enteros " + (i + 1) + ": ");
				int num = input.nextInt();
				array[i] = num;
			}
		}catch (InputMismatchException e) {
			System.err.println("Has introducido un dato erroneo");
			input.nextLine();
			error = true;
		} catch(Exception e) {
			System.err.println("Se ha produzido un error durante el programa");
		}
		
	} while(error);
		System.out.println("Los números introducidos fueron: " + array[0] + " + " + array[1] + " + " + array[2] + " + " + array[3]);
	}
}
