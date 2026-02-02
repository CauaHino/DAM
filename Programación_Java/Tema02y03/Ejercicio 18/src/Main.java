import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

			int suma=0;
			
		for(int i=0; i<15; i++) {
			System.out.println("Dame un número");
		suma += scan.nextInt();
		}
		System.out.println("La suma es: "+ suma);
	}

}
