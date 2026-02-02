package EquiposOcio;

import ElementosElectricos.Electrodomestico;

public class Televisor extends Electrodomestico implements EuroConector {

	protected int numeroDeCanales;
	protected boolean conectado;

 public void conexionDeDatos() { 
	  this.conectado = true; 
	 }
	public boolean garantia() {
		if (antigüedad < 400)
			return true;
		return false;
	}
	public void conexionAlimentacion() {
		conexionElectrica = true;		
	}
}
