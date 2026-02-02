import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [] num = new int[10];
		
		
		for (int i= 0; i < num.length; i++) {
			System.out.println("Introduzca los valores:");	
			num[i] =  sc.nextInt();
		}
		for (int j= 0; j <= num.length/2; j++) {
			System.out.print(num[j]+ " | ");
			System.out.print(num [(num.length-1) - j] + " | ");
		}
	}

}
