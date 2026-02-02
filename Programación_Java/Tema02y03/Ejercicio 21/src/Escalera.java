import java.util.Scanner;

public class Escalera {

	public static void main(String[] args) {
		Scanner datosEntradas = new Scanner(System.in);

		int altura;
		do {
			System.out.println("Introduzca la altura de la escalera");
			altura = datosEntradas.nextInt();
			if (altura <= 0) {
				System.out.println("El número intrtoducido debe ser positivo");
			}
		} while (altura <= 0);
		for (int i = 1; i <= altura; i++) {
			
			for (int j = 0; j < i; j++) {
			System.out.print("*");
			}
			
			System.out.println("");
		}
		
		
	}

}
