package asientos;

import Personas.Espectadores;

public class Asientos {
	private int fila;
	private int columna;
	private Espectadores espectador;
	
	public Asientos(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
		this.espectador = null;
	}
	
	public String toString() {
		return "ASIENTO:" + "\n\tUbicacion: " + this.fila + this.columna +
				"\n\t" + (this.ocupado() ? this.espectador : "\tAsiento Vacio") + "\n";
	}
	
	public boolean ocupado() {
		return this.espectador != null;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public Espectadores getEspectador() {
		return espectador;
	}

	public void setEspectador(Espectadores espectador) {
		this.espectador = espectador;
	}
	
	

}
