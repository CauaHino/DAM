package trenes;

import java.util.ArrayList;

import locomotoras.Locomotora;
import vagones.Vagon;

public class Tren {
	private static int contador = 0;
	private int identificador;
	private Locomotora locomotora;
	private ArrayList<Vagon> vagones;
	private String tipo;
	
	public Tren(Locomotora lc, ArrayList<Vagon> vagones) {
		this.locomotora = lc;
		this.vagones = vagones;
		contador++;
		this.identificador = contador;
	}
	
	public Tren(int identificador, Locomotora locomotora, ArrayList<Vagon> vagones, String tipo) {
		this.identificador = identificador;
		this.locomotora = locomotora;
		this.vagones = vagones;
		this.tipo = tipo;
	}



	public String mostrarInfoVagones() {
		String acumVagones="";
		for(Vagon v : this.vagones) {
			if(v != null) {
				acumVagones += "\t"+v.toString() + "\n";
			}
		}
		return acumVagones;
	}
	
	public String toString() {
		return "TREN\n"+ 
				"\tID: "+this.identificador+" con "+this.locomotora+" y vagones: \n"+mostrarInfoVagones();
	}

	public Locomotora getLocomotora() {
		return locomotora;
	}

	public void setLocomotora(Locomotora locomotora) {
		this.locomotora = locomotora;
	}

	public ArrayList<Vagon> getVagones() {
		return vagones;
	}

	public void setVagones(ArrayList<Vagon> vagones) {
		this.vagones = vagones;
	}

	public int getIdentificador() {
		return identificador;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
