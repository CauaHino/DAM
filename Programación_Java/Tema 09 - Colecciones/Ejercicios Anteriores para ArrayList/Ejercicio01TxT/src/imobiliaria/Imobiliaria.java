package imobiliaria;

import java.util.*;

import viviendas.*;

public class Imobiliaria {

	private ArrayList<Vivienda> viviendas = new ArrayList<>();

	public Imobiliaria(int n) {
		int x;

		for (int i = 0; i < n; i++) {
			x = (int) (Math.random() * 5) + 1;
			switch (x) {
			case 1:
				viviendas.add(new Unifamiliar());
				break;
			case 2:
				viviendas.add(new Chalet());
				break;
			case 3:
				viviendas.add(new Pisos());
				break;
			case 4:
				viviendas.add(new CasaDeCampo());
				break;
			case 5:
				viviendas.add(new LocalComercial());
				break;
			}
		}
	}
	public static void compararImpuesto(ArrayList) {
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
