package Libros;

public class Libros {
	private String titulo;
	private String isbn;
	private String editorial;
	private int numPag;
	private static int contador;
	private int id;
	
	public Libros (String t, String isbn, String e, int num) {
		this.titulo = t;
		this.isbn = isbn;
		this.editorial = e;
		this.numPag = num;
		contador++;
		this.id = contador;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "LIBRO:" + "\n" + "\tTitulo: " + this.titulo +
				"\n" + "\tISBN: " + this.isbn +
				"\n" + "\tEditorial: " + this.editorial +
				"\n" + "\tNúmero de Páginas: " + this.numPag +
				"\n" + "\tID: " + this.id;
	}

}
