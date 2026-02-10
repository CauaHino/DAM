package imobiliaria;

import viviendas.*;

public class Imobiliaria {

	private Vivienda[] viviendas;

	public Imobiliaria(int n) {
		viviendas = new Vivienda[n];

		int x;

		for (int i = 0; i < n; i++) {
			x = (int) (Math.random() * 5) + 1;
			switch (x) {
			case 1:
				viviendas[i] = new Unifamiliar();
				break;
			case 2:
				viviendas[i] = new Chalet();
				break;
			case 3:
				viviendas[i] = new Pisos();
				break;
			case 4:
				viviendas[i] = new CasaDeCampo();
				break;
			case 5:
				viviendas[i] = new LocalComercial();
				break;
			}
		}
	}

	public Vivienda[] getViviendas() {
		return viviendas;
	}

	public void setViviendas(Vivienda[] viviendas) {
		this.viviendas = viviendas;
	}
	public static void compararImpuesto(Vivienda[] v) {
		double impuesto = 0;
		int aux = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].impuesto() > impuesto) {
				impuesto = v[i].impuesto();
				aux = i;
			}
		}
		System.out.println("La vivenda con el impuesto más grande es " + v[aux].toString());

	}
}
