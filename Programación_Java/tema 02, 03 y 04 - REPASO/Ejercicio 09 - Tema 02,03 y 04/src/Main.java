import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double  sueldo;
		int numSueldos;
		int contador = 0;
		double sueldoMax = 0.0;
		
		System.out.println("Introduzca el número de sueldos");
		numSueldos = sc.nextInt();
		System.out.println("Número de sueldos: "+ numSueldos);
		
		do {
			System.out.println("Introduzca un sueldo "+ (sueldo= sc.nextDouble()));
			contador++;
			if (sueldo > sueldoMax) {
				sueldoMax = sueldo;
			}
			} while (contador < numSueldos);
		System.out.println("El sueldo máximo es: "+ sueldoMax);
		
		

	}

}
