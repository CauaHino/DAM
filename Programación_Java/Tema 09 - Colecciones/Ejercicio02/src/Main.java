import java.util.*;

public class Main {

	public static void main(String[] args) {
		Collection<Integer> lista = new ArrayList<>();
		for(int i = 0; i < 20; i++) {
			lista.add((int)(Math.random() * 10) + 1);
		}
		System.out.println(lista);
		
		boolean eliminado = lista.remove(5);
		while(eliminado) {
			eliminado = lista.remove(5);
		}
		
		System.out.println(lista);
	}

}
