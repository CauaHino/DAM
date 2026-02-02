package Puntos;

public class Punto {
	private int x;
	private int y;

	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Punto() {
		this.x = 0;
		this.y = 0;
	}

	public void desplazar(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public void desplazar(int desplazamiento) {
		this.x += desplazamiento;
		this.y += desplazamiento;
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

	public String toString() {
		return "Las coordenadas de X vale: " + this.x + "\n" + "La coordenada de Y vale: " + this.y;
	}
}
