package viviendas;

public class Chalet extends Unifamiliar{
	private double metrosJardin;

	public Chalet() {
		super();
	}
	
	public Chalet(double p, double m2, double mJardin) {
		super(p,m2);
		this.metrosJardin = mJardin;
	}
	
	public String toString() {
		return "CHALET:" + "\n" + "\tPrecio Total: " + (this.precio + impuesto()) + "\n"
										+ "\tM2: " + this.m2 + "\n"
										+ "\tMetros del Jardin: " + this.metrosJardin + "\n"
										+ "\tPrecio de Adquisición: " + this.precio + "\n"
										+ "\tImpuesto: " + impuesto() + "\n";
		
	}

	public double getMetrosJardin() {
		return metrosJardin;
	}

	public void setMetrosJardin(double metrosJardin) {
		this.metrosJardin = metrosJardin;
	}
	

}
