package Piscinas;

public class Piscina {
	protected int m2Piscina;
	protected int profundidad;
	
	public Piscina(int m2, int profundidad) {
		this.m2Piscina = m2;
		this.profundidad = profundidad;
	}

	public int getM2Piscina() {
		return m2Piscina;
	}

	public void setM2Piscina(int m2Piscina) {
		this.m2Piscina = m2Piscina;
	}

	public int getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}
	
	public String toString() {
		return "\nPISCINA: " + "\n" + "\tMetros: " + this.m2Piscina + "\n" + 
									"\tProfundidad: " + this.profundidad + "\n";
	}
	

}
