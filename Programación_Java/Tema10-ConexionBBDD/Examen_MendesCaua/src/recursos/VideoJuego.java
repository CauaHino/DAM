package recursos;

public class VideoJuego extends Recurso {
	
	private String categoria; //Deportes, fantasía, disparos...
	private boolean digital;
	
	public VideoJuego(String titulo, String categoria, boolean digital) {
		super(titulo);
		this.categoria = categoria;
		this.digital = digital;
	}

	public VideoJuego() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\tVIDEOJUEGO con ID: "+this.idRecurso +"\n" 
				+ "\t\tTítulo: " + this.titulo + "\n"
				+ "\t\tCategoría: " + this.categoria + "\n"
				+ "\t\tFormato: " + (this.digital ? "Digital" : "Físico") + "\n"
				+ "\t\t¿Ubicado en estantería? " + (this.ubicado ? "SI" : "NO")+ "\n"
				+ "\t\tNº días prestado: " + this.numDias + "\n" 
				+ "\t\t¿Está prestado? " + (this.prestado ? "SI" : "NO" + "\n");
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public boolean isDigital() {
		return digital;
	}

	public void setDigital(boolean digital) {
		this.digital = digital;
	}
}
