package apuesta;

import clientes.Cliente;
import excepciones.SaldoInsuficiente;

public class Apuesta {
	private boolean futbol; // "futbol" o "tenis"
	private Cliente cliente;
	private double cantidadApostada;
	private String pronostico;

	public Apuesta(boolean futbol, Cliente cliente, double cantidadApostada, String pronostico)
			throws SaldoInsuficiente {
		if (cantidadApostada > cliente.getDinero()) {
			throw new SaldoInsuficiente(cliente.getNombre());
		} else {
			this.futbol = futbol;
			this.cliente = cliente;
			this.cantidadApostada = cantidadApostada;
			this.pronostico = pronostico;
			cliente.restarDinero(cantidadApostada);
		}
	}

	

	public boolean isFutbol() {
		return futbol;
	}



	public void setFutbol(boolean futbol) {
		this.futbol = futbol;
	}



	public Cliente getCliente() {
		return cliente;
	}

	public double getCantidadApostada() {
		return cantidadApostada;
	}

	public String getPronostico() {
		return pronostico;
	}

	@Override
	public String toString() {
		return "APUESTA:" + "\n" + "\tDeporte: " + (this.futbol ? "Futbol" : "Tenis") + "\n" + "\tCliente: " + this.cliente.getNombre() + "\n"
				+ "\tCantidad: " + String.format("%.2f", cantidadApostada) + "€" + "\n" + "\tPronóstico: " + pronostico;
	}
}
