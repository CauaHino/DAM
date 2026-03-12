package vagones;

import Pasajeros.Pasajeros;
import excepciones.NumAsientosNegativo;

public class vagonPasajero extends Vagones {
	private int numAsientos;
	private Pasajeros[] pasajero;
	private int numPasajeros;
	
	public vagonPasajero(String marca, String modelo, int numAsientos) throws NumAsientosNegativo {
		super(marca, modelo);
		
		if(numAsientos < 0) {
			throw new NumAsientosNegativo(marca, modelo);
		} else {
			this.numAsientos = numAsientos;
			this.pasajero = new Pasajeros[numAsientos];
			this.numPasajeros = 0;
		}
	}

	public int getNumPasajeros() {
		return numPasajeros;
	}



	public void setNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
	}



	public int getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}

	public Pasajeros[] getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajeros[] pasajero) {
		this.pasajero = pasajero;
	}
	
	public void sentarPasajero(Pasajeros p) {
		if(numAsientos > 0 && p.isEstaVagon() == false) {
		numAsientos--;
		this.pasajero[numPasajeros] = p;
		p.setEstaVagon(true);
		numPasajeros++;
		} else if(numAsientos == 0) {
			System.out.println("El vagón está lleno");
		} else {
			System.out.println("El pasajero "+ p.getNombre() + " con billete: "+ p.getBillete() +" ya está en un vagón");
		}
	}
	
	public String Pasajero() {
	    String pasajero = "";
	    for (Pasajeros p : this.pasajero) {
	        if (p != null) {
	            pasajero += "\n" + p.toString() + "\t";
	        }
	    }
	    return pasajero;
	}
	
	public String toString() {
		return "VAGÓN DE PASAJEROS:"
					+ "\n" + "\tID: " +this.id
					+ "\n" + "\tMarca: " +this.marca
					+ "\n" + "\tModelo: " +this.modelo
					+ "\n" + "\tAsientos Disponibles: " + this.numAsientos
					+ "\n" + Pasajero();
	}

	

}
