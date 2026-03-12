package evento;

import apuesta.Apuesta;

abstract public class Evento {
	protected static int contador = 0;
	protected int id;
	protected double dineroRecaudado;
	protected double dineroEntregado;
	
	public Evento() {
		contador++;
		this.id = contador;
		this.dineroRecaudado = 0;
		this.dineroEntregado = 0;
	}
	
	public int getId() {
        return this.id;
    }

    public double getDineroRecaudado() {
        return this.dineroRecaudado;
    }

    public double getDineroEntregado() {
        return this.dineroEntregado;
    }

    public void sumarDineroRecaudado(double cantidad) {
        this.dineroRecaudado += cantidad;
    }

    public void sumarDineroEntregado(double cantidad) {
        this.dineroEntregado += cantidad;
    }

    public abstract String generarResultado();
    
    public abstract void procesarApuesta(Apuesta apuesta);
}

