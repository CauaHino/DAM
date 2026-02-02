import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int notas;
		
		System.out.println("Introduzca la nota del Alumno:");
		notas = scanner.nextInt();
		
		switch (notas){
		case 1,2,3,4: 
			System.out.println("La nota del Alumno es: INSUFICIENTE");
		break;
		
		case 5,6:
			System.out.println("La nota del Alumno es: SUFICIENTE");
		break;
		
		case 7:
			System.out.println("La nota del Alumno es: BIEN");
			break;
			
		case 8:
			System.out.println("La nota del Alumno es: NOTABLE");
			break;
			
		case 9,10:
			System.out.println("La nota del alumno es: SOBRESALIENTE");
		break;
		}
	}
}