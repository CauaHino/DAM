package punto;

public class Punto {
	private int x;
	private int y;

	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void desplazar(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public int dameX() {
		return this.x;
	}

	public int dameY() {
		return this.y;
	}

	public void modificaX(int x) {
		this.x = x;
	}

	public void modificaY(int y) {
		this.y = y;
	}
}
