package viviendas;

public class CasaDeCampo extends Vivienda {
	private Chalet chalet;
	private double metrosParcela;
	
	

	public CasaDeCampo() {
		super();
	}

	public CasaDeCampo(double p, double m2, double parcela) {
		super(p, m2);
		this.chalet = new Chalet();
		this.metrosParcela = parcela;
	}

	@Override
	public String toString() {
		return "CASA DE CAMPO:" + "\n" + "\tPrecio Total: " + (this.precio + impuesto()) + "\n"
										+ "\tM2: " + this.m2 + "\n"
										+ "\tMetros Parcela: " + this.m2 + "\n"
										+ "\tPrecio de Adquisición: " + this.precio + "\n"
										+ "\tImpuesto: " + impuesto() + "\n";
	}

	@Override
	public double impuesto() {
		double aux = this.metrosParcela * 0.01;
		double impuesto = this.precio * (aux/100);
		
		return impuesto;
	}

	public Chalet getChalet() {
		return chalet;
	}

	public void setChalet(Chalet chalet) {
		this.chalet = chalet;
	}

	public double getMetrosParcela() {
		return metrosParcela;
	}

	public void setMetrosParcela(double metrosParcela) {
		this.metrosParcela = metrosParcela;
	}

}
