import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int cantidad;
		
		do {
			System.out.println("Introduce la cantidad de números");
			cantidad = scanner.nextInt();
		}while (cantidad <= 0);
		
		int numero;
		int iguales = 0;
		int mayor = 0;
		int menor = 0;
		
		for(int i=0; i < cantidad; i++) {
			System.out.println("Introduzca un número");
			numero = scanner.nextInt();
			
			if(numero > 0) {
				mayor++;
			}
			else if (numero < 0) {
				menor++;
			}
				else {
				iguales++;
			}
		}
			System.out.println("Has introducido "+ mayor+ " MAYORES que 0");
			System.out.println("Has introducido "+ menor+ " MENORES que 0");
			System.out.println("Has introducido "+ iguales+ " IGUAL que 0");
		}
		
}
 