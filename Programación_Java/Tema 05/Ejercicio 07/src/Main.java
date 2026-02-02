import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[] num1 = new int[5];
		int[] num2 = new int[5];
		int[] saveNum = new int[10];

		System.out.println("Introduzca 5 números");

		for (int i = 0; i < num1.length; i++) {
			num1[i] = input.nextInt();
		}
		System.out.println("Introduzca otros 5 números");
		for (int j = 0; j < num2.length; j++) {
			num2[j] = input.nextInt();
		}
		int p= 0;
		
		for (int k = 0; k < num1.length; k++) {
			saveNum[p] = num1[k];
			p++;
			saveNum[p] = num2[k];
			p++;
		}
		System.out.println("Los números salvos son: ");
		for (int c = 0; c < saveNum.length; c++) {
			System.out.println(saveNum[c]+ " ");
		}

	}

}
