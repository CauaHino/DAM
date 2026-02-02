import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numero;
		int numero2;
		
		System.out.println("Introduzca el primer número");
		numero= scanner.nextInt();
		
		System.out.println("Introduzca el segundo número");
		numero2= scanner.nextInt();
		
		System.out.println("Los números pares entre "+ numero+ " y "+ numero2+ " son: ");
		
		int menor=0; int mayor=0;
		
		if(numero2>numero) {
			 mayor= numero2;
			 menor= numero;
		}
			else if (numero>numero2) {
				 mayor= numero;
				 menor= numero2;
			}
			else {
				System.out.println("Son iguales");
			}
			for(int i=menor; i<mayor; i++) {
				if (i%2 == 0) {
					System.out.println(i);
				}
				}
				
            }
           
            	
            }
        
			
				
				
			
		




