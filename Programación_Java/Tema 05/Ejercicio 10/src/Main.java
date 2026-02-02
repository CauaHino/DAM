import java.util.Scanner;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		String [] student = new String [10];
		int [] grade = new int[10];
		int studentcount = 1;
		
		for (int i = 0; i < student.length; i++) {
			System.out.println("Insert the name of the Student " + studentcount);
			student [i] = input.nextLine();
			studentcount++;
		}
		for (int j = 0; j < grade.length; j++) {
			System.out.print("Insert the grade of " + student[j].toUpperCase());
			grade [j] = input.nextInt();
		}
		for (int k = 0; k < student.length; k++) {
		switch (grade[k]) {
		case 0,1,2,3,4:
			System.out.println("The student "+ student[k].toUpperCase() + " got a " + grade[k] + " resulting FAILURE");
		break;
		case 5,6: // Grades 5, 6
			System.out.println("The student "+ student[k].toUpperCase() + " got a " + grade[k] + " resulting PASS");
			break;
		case 7,8: // Grades 7, 8
			System.out.println("The student "+ student[k].toUpperCase() + " got a " + grade[k] + " resulting GOOD");
			break;
		case 9,10: // Grades 9, 10
			System.out.println("The student "+ student[k].toUpperCase() + " got a " + grade[k] + " resulting EXCELLENT");
			break;
		default:
			System.out.println("ERROR");
		}
		}
	

}
	}
