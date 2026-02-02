import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introduzca el Día");
		int dia;
		dia = scanner.nextInt();
		
		System.out.println("Introduzca el Mes");
		int mes;
		mes = scanner.nextInt();
		
		System.out.println("Introduzca el Año");
		int ano;
		ano = scanner.nextInt();
		
		boolean esValida = (mes >= 1 && mes <= 12) &&
				(dia >= 1 && mes <= 30) &&
				(ano > 0);
			
		if(esValida) {
			System.out.println("La fecha: "+ dia+ "/"+mes+"/"+ano+" es correcta");
		}
		else { 
			System.out.println("La fecha"+dia+"/"+mes+"/"+ano+" es incorrecta");
		}
	}
	

}
