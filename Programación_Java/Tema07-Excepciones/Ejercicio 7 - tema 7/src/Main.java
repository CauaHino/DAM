import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int edad;
		
		
		try {
			System.out.print("¿Cual es la edad del usuario? ");
			edad = scan.nextInt();
			if(edad < 0) {
				throw new ExcepcionEdadNegativa("La edad no puede ser negativa");
			} else {
				System.out.println("La edad es valida");
			}
		} catch(ExcepcionEdadNegativa e) {
			System.err.println(e.getMessage());
		} catch(InputMismatchException e) {
			 System.err.println("El dato introducido es erroneo");	
		} catch(Exception e) {
			System.err.println("Ocurrió un error durante la ejecución del programa");
		}

		
	}

}
