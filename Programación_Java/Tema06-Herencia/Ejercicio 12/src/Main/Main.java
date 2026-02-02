package Main;

import java.util.Scanner;

import Matriz.Matriz;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Matriz matriz1 = new Matriz(3);
		for (int i = 0; i < matriz1.getTabla().length; i++) {
			for (int j = 0; j < matriz1.getTabla()[0].length; j++) {
				System.out.print(
						"Escriba el valor que quieres introducir para la fila " + i + " y la columna " + j + " : ");
				double num = input.nextDouble();
				matriz1.getTabla()[i][j] = num;
			}
		}
		System.out.println("Matriz 1: ");
		matriz1.mostrarMatriz();
		System.out.println("\n");

		Matriz matriz2 = new Matriz(3, 2.0);
		System.out.println("Matriz 2: ");
		matriz2.mostrarMatriz();
		System.out.println("\n");

		Matriz matriz3 = new Matriz(3, 4);
		System.out.println("Matriz 3: ");
		matriz3.mostrarMatriz();
		System.out.println("\n");

		Matriz matriz4 = new Matriz(3, 4, 3.0);
		System.out.println("Matriz 4: ");
		matriz4.mostrarMatriz();
		System.out.println("\n");

		Matriz matriz5 = new Matriz(matriz2.getTabla());
		System.out.println("Matriz 5: ");
		matriz5.mostrarMatriz();
		System.out.println("\n");

		Matriz matriz6 = new Matriz(matriz1);
		System.out.println("Matriz 6: ");
		matriz6.mostrarMatriz();
		System.out.println("\n");
		
		System.out.println("Suma matrices 1 y 6: ");
		Matriz suma = matriz1.suma(matriz6);
		suma.mostrarMatriz();
		System.out.println("\n");
		
		System.out.println("Matriz 1 transpuesta: ");
		Matriz transpuesta = matriz1.traspuesta();
		transpuesta.mostrarMatriz();
		System.out.println("\n");
		
		System.out.println("Traza Matriz 1: ");
		double trazam1 = matriz1.traza();
		System.out.println(trazam1);
		System.out.println("\n");
		
		System.out.println("Introduce la fila que desea: ");
		int fila = input.nextInt();
		System.out.println("Suma fila " + fila + " Matriz 1: ");
		double sumaFila = matriz1.sumaFila(fila);
		System.out.println(sumaFila);
		System.out.println("\n");
		
		System.out.println("Introduce la fila que desea: ");
		int columna = input.nextInt();
		System.out.println("Suma Columna " + columna +" Matriz 1: ");
		double sumaColumna = matriz1.sumaColumna(columna);
		System.out.println(sumaColumna);
		System.out.println("\n");
		
		System.out.println("Suma diagonal Matriz 1: ");
		double sumaDiagonal = matriz1.sumaDiagonal();
		System.out.println(sumaDiagonal);
		System.out.println("\n");
		
		System.out.println("Suma diagonal inversa Matriz 1: ");
		double sumaDiagonalInv = matriz1.sumaDiagonalInversa();
		System.out.println(sumaDiagonalInv);
		System.out.println("\n");
		
	}

}
