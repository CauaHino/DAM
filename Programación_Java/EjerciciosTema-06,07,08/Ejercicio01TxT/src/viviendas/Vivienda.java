package viviendas;

public abstract class Vivienda {
	protected double precio;
	protected double m2;

	public Vivienda() {

	}

	public Vivienda(double p, double m2) {
		this.precio = p;
		this.m2 = m2;
	}

	abstract public String toString();

	public static void compararImpuesto(Vivienda[] v) {
		double impuesto = 0;
		int aux = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].impuesto() > impuesto) {
				impuesto = v[i].impuesto();
				aux = i;
			}
		}
		System.out.println("La vivenda con el impuesto más grande es " + v[aux].toString());

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

	abstract public double impuesto();

}
