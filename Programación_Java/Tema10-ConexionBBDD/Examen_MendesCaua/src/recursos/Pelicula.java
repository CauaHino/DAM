package recursos;

import java.sql.Date;

public class Pelicula extends Recurso {

	private String director;
	private Date fechaEstreno;

	public Pelicula(String titulo, String director, Date fechaEstreno) {
		super(titulo);
		this.director = director; 
		this.fechaEstreno = fechaEstreno;
	}

	public Pelicula() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "\tPELÍCULA con ID: "+this.idRecurso +"\n" 
				+ "\t\tTítulo: " + this.titulo + "\n"
				+ "\t\tDirector: " + this.director + "\n"
				+ "\t\tFecha Estreno: " + this.fechaEstreno + "\n"
				+ "\t\t¿Ubicado en estantería? " + (this.ubicado ? "SI" : "NO")+ "\n"
				+ "\t\tNº días prestada: " + this.numDias + "\n" 
				+ "\t\t¿Está prestada? " + (this.prestado ? "SI" : "NO" + "\n");
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
}
