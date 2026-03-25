package vagones;

import java.util.ArrayList;

import excepciones.NumAsientosNegativo;
import pasajeros.Pasajero;

public class VagonPasajeros extends Vagon{
	private int numAsientos;
	private int numPasajeros;
	private ArrayList<Pasajero> pasajeros = new ArrayList<>();
	
	public VagonPasajeros(String marca, String modelo, int numAsientos) throws NumAsientosNegativo {
		super(marca, modelo);
		if(numAsientos < 0) {
			throw new NumAsientosNegativo(marca, modelo);
		}
		else {
			this.numAsientos = numAsientos;
			this.numPasajeros = 0;
		}
	}
	
	public VagonPasajeros(int idVagon, String marca, String modelo, int numAsientos,
			int numPasajeros) {
		this.identificador = idVagon;
		this.marca = marca;
		this.modelo = modelo;
		this.numAsientos = numAsientos;
		this.numPasajeros = numPasajeros;
	}
	
	public String mostrarInfoPasajeros() {
		String acumPasajeros="";
		for(Pasajero p : this.pasajeros) {
			if(p != null) {
				acumPasajeros += "\t"+ p.toString() + "\n";
			}
		}
		return acumPasajeros;
	}
	
	@Override
	public String toString() {
		return "VAGÓN DE PASAJEROS: \n"+
				"\tID "+ identificador+ ", " + marca + ", "+ modelo + " con "+numAsientos+" asientos disponibles y con pasajeros: \n"+mostrarInfoPasajeros() ;
	}
	
	public void agregarPasajeros(Pasajero pasajero) {
		if(this.numAsientos > 0 && !pasajero.isSubidoEnVagon()) {
			this.pasajeros.add(pasajero);
			pasajero.setSubidoEnVagon(true);
			this.numAsientos--;
			this.numPasajeros++;
			pasajero.setIdVagon(this.identificador);
		}
		else if(this.numAsientos <= 0)
			System.out.println("No hay asientos disponibles en vagón "+this.marca+" "+this.modelo);
		else
			System.out.println("El pasajero "+pasajero.getNombre()+" con billete "+pasajero.getInfoBillete()+" ya ha subido a un vagón");
	}

	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
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
	
}
