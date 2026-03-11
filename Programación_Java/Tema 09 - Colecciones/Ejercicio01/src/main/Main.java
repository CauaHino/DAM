package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<>();
		List<Integer> lista2 = new ArrayList<>();
		
		for(int i = 0; i < 20; i++) {
			lista.add(((int)(Math.random() * 10) + 1));
		}
		System.out.println(lista);
		
		for(Integer e : lista) {
			if(!lista2.contains(e)) {
				lista2.add(e);
			}
		}
		System.out.println(lista2);
		

	}

}
