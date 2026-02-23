package eventos;

public abstract class Evento {
	protected int idEvento;
	protected static int contador = 0;
	protected double dineroRecaudado;
	protected double dineroEntregado;
	
	public Evento() {
		contador++;
		this.idEvento = contador;
		this.dineroRecaudado = 0;
		this.dineroEntregado = 0;
	}

	public double getDineroRecaudado() {
		return dineroRecaudado;
	}

	public void setDineroRecaudado(double dineroRecaudado) {
		this.dineroRecaudado = dineroRecaudado;
	}

	public double getDineroEntregado() {
		return dineroEntregado;
	}

	public void setDineroEntregado(double dineroEntregado) {
		this.dineroEntregado = dineroEntregado;
	}
	
	public int getIdEvento() {
		return idEvento;
	}

	public abstract String toString();
}
