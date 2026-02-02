import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num;
		
		try {
			System.out.println("Ingrese un numéro entero");
			num = input.nextInt();			
			System.out.println("El número introducido fue: " + num);
			} catch(InputMismatchException ae) {
				System.err.println("El número introducido debe ser entero!");
				System.err.println(ae.getMessage());
			} 

		}
	}


