import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double cantidad = 0;
		Cuenta cuenta = new Cuenta("Caua", 1000);
		
		try {
			System.out.println("Cuanto desea ingresar en la cuenta?");
			cantidad = input.nextDouble();
			cuenta.ingresar(cantidad);
		} catch(CantidadNegativa e) {
			System.err.println(e);
		}
		
		try {
			System.out.println("Cuanto desea retirar de la cuenta?");
			cantidad = input.nextDouble();
			cuenta.retirar(cantidad);
		} catch(CantidadNoDisponible e) {
			System.err.println(e);
		}
	}

}
