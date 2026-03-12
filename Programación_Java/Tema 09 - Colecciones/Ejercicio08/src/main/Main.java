package main;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> listaDias = new ArrayList<>();
		listaDias.add("Lunes");
		listaDias.add("Martes");
		listaDias.add("Miercoles");
		listaDias.add("Jueves");
		listaDias.add("Viernes");
		listaDias.add("Sabado");
		listaDias.add("Domingo");
		
		System.out.println(listaDias);
		
		listaDias.add(4, "Juernes");
		
		System.out.println(listaDias);
		
		ArrayList<String> listaDos = new ArrayList<>(listaDias);
		System.out.println(listaDos);
		ArrayList<String> listaTres = new ArrayList<>();
		listaTres.addAll(listaDos);
		System.out.println("Los elementos 3 y 4 son: ");
		System.out.println("[" + listaDias.get(3) + ", " + listaDias.get(4) + "]");
		System.out.println("Los elementos primero y último son: ");
		System.out.println("[" + listaDias.getFirst() + ", " + listaDias.getLast() + "]");
		
		if(listaDias.remove("Juernes")) {
			System.out.println("Juernes BORRADO");
		} else {
			System.out.println("No existe Juernes");
		}
		
		Iterator<String> iterator = listaDias.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		if(listaDias.contains("Lunes")) {
			System.out.println("Existe un elemento LUNES");
		}
		iterator = listaDias.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equalsIgnoreCase("lunes")) {
				System.out.println("Existe un elemento LUNES ya sea en mayúscula o minuscula");
			}
		}
		listaDias.clear();
	}
}
