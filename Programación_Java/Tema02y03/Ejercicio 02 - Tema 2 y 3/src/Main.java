import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numero;
		System.out.println("Introduzca el número");
		numero = scanner.nextInt();
		
		if (numero > 0) {
			System.out.println("El numero" +numero +  "es POSITIVO");
			}
		else {
			System.out.println("El número " +numero + " es NEGATIVO");
		}
	}
	
		

}
