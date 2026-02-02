import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Write a setence");
		String text = input.nextLine();
		
		int size = text.length();
		char [] array = new char[size];
		
		for (int i = 0; i < size; i++) {
			array[i] = text.charAt(i);
		}
		System.out.println("The characters saved at the array are: " + Arrays.toString(array));

	}

}
