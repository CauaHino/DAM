package Personas;

public class Director extends Personas {
	private int numPeliculas;

	public Director(String n, int e, int nP) {
		super(n, e);
		this.numPeliculas = nP;
	}

	@Override
	public String toString() {
		return "DIRECTOR:" + "\n" + "\tID: " + this.id +
				"\n" + "\tNombre: " + this.nombre +
				"\n" + "\tEdad: " + this.edad +
				"\n" + "\tNº Películas: " + this.numPeliculas;
	}

	public int getNumPeliculas() {
		return numPeliculas;
	}

	public void setNumPeliculas(int numPeliculas) {
		this.numPeliculas = numPeliculas;
	}
	
	
	
	
	
	
	
}
