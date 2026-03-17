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

	public static void compararImpuesto(ArrayList<Vivienda> lista) {
		double impuestoMaximo = 0;
		int indiceMayor = 0;

		for (int i = 0; i < lista.size(); i++) {
			// Usamos .get(i) para acceder al objeto
			if (lista.get(i).impuesto() > impuestoMaximo) {
				impuestoMaximo = lista.get(i).impuesto();
				indiceMayor = i;
			}
		}

		System.out.println("La vivienda con el impuesto más grande es: " + lista.get(indiceMayor).toString());
	}

	public ArrayList<Vivienda> getViviendas() {
		return viviendas;
	}

	public void setViviendas(ArrayList<Vivienda> viviendas) {
		this.viviendas = viviendas;
	}
	
}
