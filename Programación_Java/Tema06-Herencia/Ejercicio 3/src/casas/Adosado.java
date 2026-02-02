package casas;

import Piscinas.Piscina;

public class Adosado {
	private Chalet chalets[];
	private Piscina piscina;
	
	public Adosado(double m2Casa, int numH, double metroJ, int metroP, int profundidad) {
		chalets = new Chalet[2];
		for(int i = 0; i < chalets.length; i++) {
			chalets[i] = new Chalet(m2Casa, numH, metroJ);
			piscina = new Piscina(metroP, profundidad);
		}
	}

	public String toString() {
		String chalets="";
		for(int i = 0; i < this.chalets.length; i++) {
			chalets += this.chalets[i];
		}
		return "Adosado: " + chalets + piscina;
	}
}
