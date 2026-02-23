package apuestas;

import clientes.Cliente;
import excepciones.SaldoInsuficiente;

public class Apuesta {
	private Cliente cliente;
	private double cantidad;
	private String pronostico;
	private boolean futbol;

	public Apuesta(boolean futbol, Cliente cliente, double cantidad, 
			String pronostico) throws SaldoInsuficiente{
		if(cliente.getDinero() < cantidad) {
			throw new SaldoInsuficiente(cliente.getNombre());
		}
		else {
			this.futbol = futbol;
			this.cliente = cliente;
			this.cantidad = cantidad;
			cliente.setDinero(cliente.getDinero() - cantidad);
			this.pronostico = pronostico;
		}
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getPronostico() {
		return pronostico;
	}

	public void setPronostico(String pronostico) {
		this.pronostico = pronostico;
	}

	public boolean isFutbol() {
		return futbol;
	}

	public void setFutbol(boolean futbol) {
		this.futbol = futbol;
	}
	public String toString() {
		return "INFORMACIÓN APUESTA: \n"+
				"\tApuesta al evento: "+(this.futbol ? "FÚTBOL" : "TENIS")+"\n"+
				"\tCliente: "+this.cliente+"\n"+
				"\tCantidad apostada: "+this.cantidad+" €\n"+
				"\tPronóstico: "+this.pronostico+"\n";
	}

}
