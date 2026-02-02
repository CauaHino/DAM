package otrosOrdenadores;

import ordenadores.OrdenadorIncompleto;

public class OrdenadorPortatil extends OrdenadorIncompleto {
	private double peso;
	
	public OrdenadorPortatil(String m, String c, double precio, int frecuencia, int tamDisco, int memoria, double peso) {
		super(m, c, precio, frecuencia, tamDisco, memoria);
		this.peso = peso;
	}

	public int getTamañoDisco() {
		return this.tamDisco;
	}

	public int getMemoria() {
		return this.memoria;
	}


	public void mostrarCaracteristicas(int numCaract) {
		switch(numCaract) {
		case 1: 
			System.out.println(this.marca);
			break;
			
		case 2:
			System.out.println(this.codigo);
			break;
			
		case 3:
			System.out.println(this.precio);
			break;
			
		case 4:
			System.out.println(this.frecuencia);
			break;
			
		case 5:
			System.out.println(this.tamDisco);
			break;
			
		case 6:
			System.out.println(this.memoria);
			break;
			
		case 7:
			System.out.println(this.peso);
			break;
		}
		
		
	}

}
