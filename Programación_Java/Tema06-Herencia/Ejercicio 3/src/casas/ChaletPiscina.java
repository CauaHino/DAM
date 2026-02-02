package casas;

import Piscinas.Piscina;

public class ChaletPiscina extends Chalet{
	private Piscina piscina;
	
	
	public ChaletPiscina(double m2, int hab, double j, int metroP, int profundidad) {
		super(m2, hab, j);
		Piscina piscina = new Piscina(metroP, profundidad);
	}
	
	public String toString() {
		return super.toString() + "\n\tPiscina: " + this.piscina;
}
	

}
