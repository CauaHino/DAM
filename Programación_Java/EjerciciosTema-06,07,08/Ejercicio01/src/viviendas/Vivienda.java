package viviendas;

public abstract class Vivienda {
	protected double precio;
	protected double m2;
	protected double impuesto;

	public Vivienda() {

	}

	public Vivienda(double p, double m2, double imp) {
		this.precio = p;
		this.m2 = m2;
		this.impuesto = imp;
	}

	abstract public String toString();

	public double compararImpuesto(Vivienda[] v) {
		double impuesto = 0;
		int aux = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].getImpuesto() > impuesto) {
				impuesto = v[i].getImpuesto();
				aux++;
			}
		}
		System.out.println("La vivenda con el impuesto más grande es " + v[aux].toString());
		return impuesto;

	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getM2() {
		return m2;
	}

	public void setM2(double m2) {
		this.m2 = m2;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

}
