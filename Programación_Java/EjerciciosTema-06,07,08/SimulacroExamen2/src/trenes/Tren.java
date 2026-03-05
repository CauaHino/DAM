package trenes;

import locomotoras.Locomotora;
import vagones.Vagones;

public class Tren {
	private static int contador;
	private int id;
	private Locomotora locomotora;
	private Vagones[] vagones;
	
	public Tren(Locomotora locomotora, Vagones[] vagones) {
		contador++;
		this.id = contador;
		this.locomotora = locomotora;
		this.vagones = vagones;
	}
	
	public String toString() {
		String vagonesInfo = "";
		for(Vagones v : vagones) {
			if(v != null)
			vagonesInfo += "\n"+ v.toString() + "\t";
		}
		return "TREN:" + "\n" + "\tID: " + this.id + "\n\t" + this.locomotora.toString() + "\n\t" + vagonesInfo ;
	}

	public Locomotora getLocomotora() {
		return locomotora;
	}

	public void setLocomotora(Locomotora locomotora) {
		this.locomotora = locomotora;
	}

	public Vagones[] getVagones() {
		return vagones;
	}

	public void setVagones(Vagones[] vagones) {
		this.vagones = vagones;
	}

	public int getId() {
		return id;
	}

	
}
