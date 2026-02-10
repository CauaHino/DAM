package viviendas;

public class Unifamiliar extends Vivienda {
	

	public Unifamiliar() {
		super();
	}
	
	public Unifamiliar(double p, double m2) {
		super(p,m2);
	}

	@Override
	public String toString() {
		return "UNIFAMILIAR:" + "\n" + "\tPrecio Total: " + (this.precio + impuesto()) + "\n"
										+ "\tM2: " + this.m2 + "\n"
										+ "\tPrecio de Adquisición: " + this.precio + "\n"
										+ "\tImpuesto: " + impuesto() + "\n";
		
	}

	@Override
	public double impuesto() {
		double impuesto = 0;
		impuesto = this.precio * 0.10;
		
		return impuesto;
	}
		
}
