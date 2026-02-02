package punto;

public class Punto {
	private double x;
	private double y;

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void desplazar(double x, double y) {
		this.x += x;
		this.y += y;
	}

	public double dameX() {
		return this.x;
	}

	public double dameY() {
		return this.y;
	}

	public void modificaX(double x) {
		this.x = x;
	}

	public void modificaY(double y) {
		this.y = y;
	}
	public String toString () {
		return "(" + x +" , " + y + ")";
	}
	
}
