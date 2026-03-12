package Personas;

public class Espectadores extends Personas {
	private double dinero;
	private boolean estaSentado;
	
	public Espectadores(String n, int e, double d) {
		super(n, e);
		this.dinero = d;
	}
	
	public boolean pagar (double precioEntrada) {
		double dineroEspectador = 0;
		if(this.tieneDinero(precioEntrada)) {
			System.out.println("La entrada fue pagada con éxito");
			dineroEspectador = this.dinero - precioEntrada;;
			this.setDinero(dineroEspectador); 
			return true;
		} else {
			System.out.println("Saldo Insuficiente");
			return false;
		}
	}
	
	private boolean tieneDinero(double precioEntrada) {
		if(this.dinero >= precioEntrada) {
			return true;
		} else {
			return false;
		}
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public boolean isEstaSentado() {
		return estaSentado;
	}

	public void setEstaSentado(boolean estaSentado) {
		this.estaSentado = estaSentado;
	}

	@Override
	public String toString() {
		return "ESPECTADOR:" + "\n" + "\tID: " + this.id +
								"\n" + "\tNombre: " + this.nombre +
								"\n" + "\tEdad: " + this.edad +
								"\n" + "\tDinero: " + this.dinero +
								"\n" + "\t¿Está sentado?: " + (this.estaSentado ? "SI" : "NO");
	}
	
	
	
	

}
