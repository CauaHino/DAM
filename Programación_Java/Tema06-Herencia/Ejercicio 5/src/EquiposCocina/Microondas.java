package EquiposCocina;

import ElementosElectricos.Electrodomestico;

public class Microondas extends Electrodomestico{
	protected int tipoDeSelectorDePotencia;
	
	public boolean garantia() {
		if(this.antigüedad < 365) {
			return true;
		} 
		return false;
	}
	public void conexionAlimentacion() {
		conexionElectrica = true;
		
	}

}
