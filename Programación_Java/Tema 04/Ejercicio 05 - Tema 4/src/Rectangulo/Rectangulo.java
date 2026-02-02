package Rectangulo;

import punto.Punto;

public class Rectangulo {
	private Punto esquina1;
	private Punto esquina2;
	private Punto esquina3;
	private Punto esquina4;

	public Rectangulo(Punto e1, Punto e2, Punto e3, Punto e4) {
		this.esquina1 = e1;
		this.esquina2 = e2;
		this.esquina3 = e3;
		this.esquina4 = e4;
	}
	public Rectangulo(double base, double altura) {
		this.esquina1 = new Punto (0,0);
		this.esquina2 = new Punto (base, 0);
		this.esquina3 = new Punto (base, altura);
		this.esquina4 = new Punto (0, altura);
	}

	public void desplazar(double x, double y) {
		this.esquina1.desplazar(x, y);
        this.esquina2.desplazar(x, y);
        this.esquina3.desplazar(x, y);
        this.esquina4.desplazar(x, y);
		
	}

	public void mostrarCoordenadas () {
		System.out.println("Esquina 1: "+ this.esquina1);
		System.out.println("Esquina 2: "+ this.esquina2);
		System.out.println("Esquina 3: "+ this.esquina3);
		System.out.println("Esquina 4: "+ this.esquina4 + "\n");
	}
}
