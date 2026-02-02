package mazo;

import excepciones.CartaNoExiste;
import excepciones.CartaNoValida;
import lecturas.Lectura;

public class Mazo {
	private int carta;
	private int[] baraja = new int[40];
	private int sumaTotal;
	
	public Mazo() {
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= 4; j++) {
				int pos;
				do {
					pos = (int) (Math.random() * 40);
				}while(this.baraja[pos] != 0);
				this.baraja[pos] = i;
			}
		}
	}
	
	public boolean jugar() throws CartaNoExiste, CartaNoValida{
		int suma = 0;
		int pos;
		
		try {
			for(int i = 1; i <= 5; i++) {
				System.out.print("Ingresa un valor: ");
				pos = Lectura.etInt();
				if(pos < 0 || pos > 39) {
					throw new CartaNoValida();
				}
				suma += this.baraja[pos];
			}
		}catch (NumberFormatException e) {
			throw new CartaNoExiste();
		}
		this.sumaTotal = suma;
		return suma > 21;
	}
	
	public void mostrarCarta() {
		int aux = 0;
		for(int carta : this.baraja) {
			System.out.print("|" + carta + "|");
			aux++;
			if(aux > 4) {
				System.out.println();
				aux = 0;
			}
		}
			
		
	}
	
	public int[] baraja() {
		return this.baraja;
	}
	
	public int sumaTotal() {
		return this.sumaTotal;
	}
}
