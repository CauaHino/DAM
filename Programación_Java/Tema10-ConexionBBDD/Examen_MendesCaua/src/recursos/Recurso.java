package recursos;

public abstract class Recurso {
	protected static int contador = 0;
	protected int idRecurso;
	protected String titulo;
	protected int numDias;			//días para los que se presta
	protected boolean prestado;
	protected boolean ubicado;
	protected int idCliente;
	
	protected Recurso() {
		
	}

	public Recurso(int idRecurso, String titulo, int numDias, boolean prestado, int idCliente) {
		super();
		this.idRecurso = idRecurso;
		this.titulo = titulo;
		this.numDias = numDias;
		this.prestado = prestado;
		this.idCliente = idCliente;
	}



	protected Recurso(String titulo)
	{
		contador++;
		this.idRecurso = contador;
		this.titulo = titulo;	
		this.prestado = false;
	}
	
	public abstract String toString();

	public int getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(int idRecurso) {
		this.idRecurso = idRecurso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumDias() {
		return numDias;
	}

	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public boolean isUbicado() {
		return ubicado;
	}

	public void setUbicado(boolean ubicado) {
		this.ubicado = ubicado;
	}
}
