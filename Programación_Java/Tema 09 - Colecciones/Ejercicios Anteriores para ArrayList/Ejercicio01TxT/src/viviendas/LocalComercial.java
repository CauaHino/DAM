package viviendas;

public class LocalComercial extends Vivienda{
	

	public LocalComercial() {
		super();
	}

	public LocalComercial(double m2) {
		super(m2 * 3000, m2);
	}

	@Override
	public String toString() {
		return "Local Comercial:" + "\n" + "\tPrecio Total: " + (this.precio + impuesto()) + "\n"
										+ "\tM2: " + this.m2 + "\n"
										+ "\tPrecio de Adquisición: " + this.precio + "\n"
										+ "\tImpuesto: " + impuesto() + "\n";
		
	}

	@Override
	public double impuesto() {
		double precioM2 = 0.02 * this.m2;
		double impuesto = (this.precio*0.05) + precioM2;
		
		return impuesto;
	}

}
