package EquiposCocina;

public class HornoNormal extends Horno {
	public int tipoSelectorTemperatura;
	
	public boolean garantia() {
		if(this.antigüedad < 730) {
			return true;
		}
		return false;
	}
	public void conexionAlimentacion() {
		conexionElectrica = true;		
	}
	public String toString() {
		return (this.garantia() ? "SI" : "NO");
	}

}
