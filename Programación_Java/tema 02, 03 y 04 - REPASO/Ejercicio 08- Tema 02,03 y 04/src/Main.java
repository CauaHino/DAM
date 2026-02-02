import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double num;
		double contador = 0;
		double suma = 0;
		double numPositivos = 0;
		
		do {
			System.out.println("Introduzca un número");
			num = sc.nextDouble();
			 if (num>0) {
				 suma += num;
				 numPositivos ++;
				 contador++;
			 }
			
		} while (num > 0) ;
		System.out.println("La media de los números son: "+ (suma/numPositivos));
		

	}

}
