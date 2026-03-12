import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Persona> listaPersonas = new ArrayList<>();
		double precioTotal = 0;
		
		for(int i = 0; i < generarCola(); i++) {
			Persona p = new Persona(0);
			listaPersonas.add(p);
		}
		generarEdad(listaPersonas);
		 System.out.println(listaPersonas);
		 
		 Iterator<Persona> it = listaPersonas.iterator();
		 while(it.hasNext()) {
			 Persona p = it.next();
				if(p.getEdad() >= 5 && p.getEdad() <= 10) {
					precioTotal += 1;
				} else if(p.getEdad() >= 11 && p.getEdad() <= 17) {
					precioTotal += 2.5;
				} else if(p.getEdad() >= 18) {
					precioTotal += 3.5;
				}
			}
		 System.out.println("El precio recaudado fue " + precioTotal + "€");
	}
	public static void generarEdad(ArrayList <Persona> p) {
		Iterator<Persona> it = p.iterator();
		while(it.hasNext()) {
			it.next().setEdad((int) (Math.random() * (60-5+1)) + 5);
		}
	}
	
	public static int generarCola() {
		int cola = (int) (Math.random() * 50) + 1;
		
		return cola;
	}
}
