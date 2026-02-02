package mesa;

public class Mesa {

	private double alto;
	private double ancho;
	private double largo;
	private String color;
	private String material;

	public Mesa() {
		this.alto = 80;
		this.ancho = 120;
		this.largo = 60;
		this.color = "Negra";
		this.material = "Madera";
	}

	public Mesa(double alto, double ancho, double largo, String color, String material) {
		this.alto = alto;
		this.ancho = ancho;
		this.largo = largo;
		this.color = color;
		this.material = material;
	}

	public Mesa(double alto, double ancho, double largo) {
		this.alto = alto;
		this.ancho = ancho;
		this.largo = largo;
		this.color = "Negra";
		this.material = "Hierro";
	}

	public String dameColor() {
		return this.color;
	}

	public void modificarColor(String color) {
		this.color = color;
	}

	public String dameMaterial() {
		return this.material;
	}

	public void modificaMaterial(String material) {
		this.material = material;
	}

	public double dameAlto() {
		return this.alto;
	}

	public void modificaAlto(double alto) {
		this.alto = alto;
	}

	public double dameAncho() {
		return this.ancho;
	}

	public void modificaAncho(double ancho) {
		this.ancho = ancho;
	}

	public double dameLargo() {
		return this.largo;
	}

	public void modificaLargo(double largo) {
		this.largo = largo;
	}

	public void mostrarColor() {
		System.out.println("EL color de la mesa es: " + this.color);
	}

	public String toString() {
		return "MESA: " + "\n" + "\tCOLOR: " + this.color + "\n" + "\tMATERIAL: " + this.material + "\n" + "\tALTURA: "
				+ this.alto + "\n" + "\tANCHO: " + this.ancho + "\n" + "\tLARGURA: " + this.largo;
	}
}
