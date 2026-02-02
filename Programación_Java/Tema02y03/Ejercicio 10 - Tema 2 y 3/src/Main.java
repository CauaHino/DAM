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
		
		if (ano==0) {
			System.out.println("Fecha incorrecta");
		}
		else if(mes == 2 && (dia>0 && dia <= 28)) {
			System.out.println(dia+"/"+mes+"/"+ano+ " es CORRECTA");
		}
		else if (mes == 4 ||mes == 6 ||mes == 9 || mes == 11 &&  (dia > 0 && dia <= 30)) {
			System.out.println(dia+"/"+mes+"/"+ano+" es CORRECTA");
		}
		else if (mes == 1 ||mes == 3 ||mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12 &&  (dia > 0 && dia <= 31)) {
			System.out.println(dia+"/"+mes+"/"+ano+" es CORRECTA");
		}
		else {
			System.out.println(dia+"/"+mes+"/"+ano+ " es INCORRECTA");
		}
	}
	
}
