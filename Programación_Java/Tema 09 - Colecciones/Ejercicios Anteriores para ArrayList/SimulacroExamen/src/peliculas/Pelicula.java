package peliculas;

import Personas.Director;

public class Pelicula {
	private static int contador;
	private int id;
	private String titulo;
	private String genero;
	private Director director;
	private int edadMinima;
	
	public Pelicula(String titulo, String genero, Director director, int edadMinima) {
		contador++;
		this.id = contador;
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.edadMinima = edadMinima;
	}
	
	public String toString() {
		return "PELÍCULA:" + "\n" + "\tID: " + this.id +
				"\n" + "\tTitulo: " + this.titulo +
				"\n" + "\tGénero: " + this.genero +
				"\n" + "\tEdad Mínima: " + this.edadMinima
				+ "\n\t" + this.director.toString() + "\n";
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Pelicula.contador = contador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	
	
	
	
}
