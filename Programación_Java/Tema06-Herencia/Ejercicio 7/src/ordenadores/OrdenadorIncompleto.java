package ordenadores;

abstract public class OrdenadorIncompleto implements Ordenador {
	protected String marca, codigo;
	protected double precio;
	protected int frecuencia,tamDisco,memoria;
	
	protected OrdenadorIncompleto(String m, String c, double precio, int frecuencia, int tamDisco, int memoria) {
		this.marca = m;
		this.codigo = c;
		this.precio = precio;
		this.frecuencia = frecuencia;
		this.tamDisco = tamDisco;
		this.memoria = memoria;
	}

	public int getFrecuenciaMicro() {
		return this.frecuencia;
		
	}
	
	

}
