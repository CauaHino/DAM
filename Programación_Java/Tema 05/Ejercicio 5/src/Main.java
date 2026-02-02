import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] valores = new int[5];
		int tamano = 0;
		int contadorCeros = 0;
		int contadorPositivo = 0;
		int contadorNegativo = 0;
		int positivos = 0, negativos = 0;
		double mediaPositivos = 0;
		double mediaNegativos = 0;
		
		do {
			System.out.println("Introduzca los valores");
			int numInsertado = sc.nextInt();
			valores[tamano] = numInsertado;
			tamano++;
			if (numInsertado > 0) {
				contadorPositivo++;
				positivos += numInsertado;
			} else if (numInsertado == 0) {
				contadorCeros++;
			} else {
				contadorNegativo++;
				negativos += numInsertado;
			}
		} while (tamano < valores.length);
		
		
		if (contadorPositivo > 0) {
			mediaPositivos = (double) positivos/contadorPositivo;
		}
		if (contadorNegativo > 0) {
			mediaNegativos = (double) negativos/contadorNegativo;
		}
		
		
		System.out.println("La media de los valores positivos es: "+ mediaPositivos);
		System.out.println("La media de los valores negativo es: "+ mediaNegativos);
		System.out.println("El 0 fue puesto: "+ contadorCeros+ " veces");

	}

}
