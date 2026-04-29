package recursos;

public class Libro extends Recurso {
	private String autor;
	private String isbn;

	public Libro(String titulo, String autor, String isbn) {
		super(titulo);
		this.autor = autor; 
		this.isbn = isbn;
	}
	public Libro() {
		
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\tLIBRO con ID: "+this.idRecurso +"\n"  
				+ "\t\tTítulo: " + this.titulo + "\n"
				+ "\t\tAutor: " + this.autor + "\n"
				+ "\t\tISBN: " + this.isbn + "\n"
				+ "\t\t¿Ubicado en estantería? " + (this.ubicado ? "SI" : "NO")+ "\n"
				+ "\t\tNº días prestado: " + this.numDias + "\n" 
				+ "\t\t¿Está prestado? " + (this.prestado ? "SI" : "NO" + "\n");
	}


	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
