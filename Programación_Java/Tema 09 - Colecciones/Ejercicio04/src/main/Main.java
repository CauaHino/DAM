package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Collection<Integer> lista = new ArrayList<>();
		Collection<Integer> lista2 = new ArrayList<>();
		for(int i = 0; i < 20; i++) {
			lista.add((int)(Math.random() * 10) + 1);
		}
		System.out.println(lista);
		
		lista2.add(5);
		
		lista.removeAll(lista2);
		
		
		System.out.println(lista);
	}

}
