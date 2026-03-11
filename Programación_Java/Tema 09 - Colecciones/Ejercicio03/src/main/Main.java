package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Collection<Integer> lista = new ArrayList<>();
		int num;
		
		do {
			System.out.print("Introduzca un número: ");
			num = input.nextInt();
			if(num >= 0)
				lista.add(num);
		} while (num >= 0);
		System.out.println("Los números insertados fueron:");
		System.out.println(lista);
		
		System.out.print("[");
		for(Integer e : lista) {
			if(e%2==0) {				
				System.out.print(e + " ");
			}
		}
		System.out.print("]");
		System.out.println();

		Iterator<Integer> iterator = lista.iterator();
		
			while(iterator.hasNext()) {
				int num2 = iterator.next();
				if(num2 % 3 == 0) {
					iterator.remove();
				}
			}
			System.out.println(lista);

	}
}
