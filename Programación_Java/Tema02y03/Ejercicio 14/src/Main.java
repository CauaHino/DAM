import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numero;
		
		do {
		System.out.println("Introduzca un número");
		numero = scanner.nextInt();
		System.out.println("El número es: "+ numero);
		
		if (numero >= 0) {
			System.out.println("El cuadrado del número es: "+ (numero*numero));
		}
		}
		while(numero >= 0); 
	System.out.println("Ha introducido un número negativo");
	
}
	}
	

