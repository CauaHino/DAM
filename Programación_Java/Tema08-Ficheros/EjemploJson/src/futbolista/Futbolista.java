package futbolista;

import com.google.gson.JsonArray;

public class Futbolista {
	private int dorsal;
	private String nombre;
	private String[] demarcaciones;
	private String equipo;

	public Futbolista(int dorsal, String nombre, String[] demarcaciones, String equipo) {
		this.dorsal = dorsal;
		this.nombre = nombre;
		this.demarcaciones = demarcaciones;
		this.equipo = equipo;
	}
	

	@Override
	public String toString() {
		String demarcaciones = "";
		for(String d : this.demarcaciones) {
			demarcaciones += d + " | ";
		}
		return "FUTBOLISTA: \n" + 
	"Nombre: " + this.nombre + 
	"\n" + "Dorsal: " + this.dorsal + 
	"\n" + "Demarcación: " + demarcaciones +
	"\n" + "Equipo: " + this.equipo + "\n";
	}
	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String[] getDemarcacion() {
		return demarcaciones;
	}

	public void setDemarcacion(String[] demarcacion) {
		this.demarcaciones = demarcacion;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
}