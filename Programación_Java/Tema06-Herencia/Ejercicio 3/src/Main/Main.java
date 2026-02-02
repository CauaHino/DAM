package Main;

import casas.Adosado;

public class Main {

	public static void main(String[] args) {
		Adosado[] adosado = new Adosado[10];
		
		for(int i = 0; i < adosado.length; i++) {
			adosado[i] = new Adosado(180, 20,60,80, 50);
			System.out.println(adosado[i].toString());
		}


	}

}
