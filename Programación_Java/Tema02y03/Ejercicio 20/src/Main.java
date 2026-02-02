import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		

		int notas;
		int suspensos = 0;
		int suficientes = 0;
		int bien = 0;
		int notable = 0;
		int sobresaliente = 0;

		for (int i = 0; i < 6; i++) {
			int max = 10;
			int min = 0;
			notas = (int) (Math.random() * ((max - min + 1) + min));

			switch(notas) {
			case 0,1,2,3,4:
				suspensos++;
			break;
			case 5:
				suficientes++;
			break;
			case 6,7:
				bien++;
			break;
			case 8:
				notable++;
			break;
			case 9,10:
				sobresaliente++;
			break;
			}
		}
			System.out.println(suspensos + " Fueron SUSPENSOS");
			System.out.println(suficientes + " Fueron SUFICIENTES");
			System.out.println(bien + " Fueron BIENES");
			System.out.println(notable + " Fueron NOTABLES");
			System.out.println(sobresaliente + " Fueron SOBRESALIENTES");
		
	}
}
