package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner see = new Scanner(System.in);
		List<Integer> numEnterosPositivos = new ArrayList<Integer>();
		int num = 0;
		
		do {
			System.out.print("Indique el numero:");
			num = see.nextInt();
			
			if(num >= 0) {
				numEnterosPositivos.add((Integer) num);
			}
		}while(num >= 0);
		
		Iterator<Integer> it = numEnterosPositivos.iterator();
		
		while(it.hasNext()) {
			num = it.next();
			
			if( num % 2 == 0) {
				System.out.println("El indice es: " + numEnterosPositivos.indexOf(num));
				
				numEnterosPositivos.set(numEnterosPositivos.indexOf(num), num*100);
			 }			
		}
		
		System.out.println(numEnterosPositivos);
	}

}
