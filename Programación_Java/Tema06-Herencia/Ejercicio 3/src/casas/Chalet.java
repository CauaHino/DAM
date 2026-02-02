package casas;

public class Chalet extends Casa{
	protected double metrosJardin;

	public Chalet(double m2, int hab, double j) {
		super(m2, hab);
		this.metrosJardin = j;
	}

	public double getMetrosJardin() {
		return metrosJardin;
	}

	public void setMetrosJardin(double metrosJardin) {
		this.metrosJardin = metrosJardin;
	}

	public String toString() {
		return super.toString() + "\n\tMetros del Jardin: " + this.metrosJardin;
	}
}
