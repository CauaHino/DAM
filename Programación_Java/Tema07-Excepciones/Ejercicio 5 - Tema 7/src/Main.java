import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		double n = 0;
		int posicion = 0;
		String cadena;
		double[] valores = { 9.9, 4.5, -3.3, 0.06, 2.22, -11.5, 7.60, 3.00, -10.8, 4.44 };
		boolean repetir = true;

		System.out.println("Contenido del array antes de modificar:");
		for (int i = 0; i < valores.length; i++) {
			System.out.print(valores[i] + ", ");
		}
		do {
			repetir = false;
		
		try {
		System.out.print("\n\nIntroduce la posición del array a modificar: ");
		cadena = sc.nextLine();
		posicion = Integer.parseInt(cadena);
		} catch(InputMismatchException e) {
			System.err.print("El valor introducido no es válido");
			sc.nextLine();
			repetir = true;
		} catch(Exception e) {
			System.err.print("Se ha produzido un error");
			sc.nextLine();
			repetir = true;
		}

		System.out.println("\nIntroduce el nuevo valor de la posición " + posicion + ": ");
		try {
		n = sc.nextDouble();
		valores[posicion] = n;
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.print("La posición que has puesto está fuera de los límites de la array!!");
			sc.nextLine();
			repetir = true;
		}catch(InputMismatchException e) {
			System.err.print("El valor introducido no es válido");
			sc.nextLine();
			repetir = true;
		} catch(Exception e) {
			System.err.print("Se ha produzido un error: " + e.toString());
			sc.nextLine();
			repetir = true;
		}

		} while(repetir);

		System.out.println("\nPosición a modificar " + posicion);
		System.out.println("Nuevo valor: " + n);
		System.out.println("Contenido del array modificado:");
		for (int i = 0; i < valores.length; i++) {
			System.out.print(valores[i] + ", ");
		}

	}
}