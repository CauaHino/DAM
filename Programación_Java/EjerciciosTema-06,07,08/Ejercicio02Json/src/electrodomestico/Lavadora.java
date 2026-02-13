package electrodomestico;

public class Lavadora extends Electrodomestico {
	private double carga;
	private final static double CARGADEFECTO = 5;

	

	public Lavadora() {
		this.precio = PRECIODEFECTO;
		this.peso = PESODEFECTO;
		this.color = COLORDEFECTO;
		this.consumo = CONSUMODEFECTO;
		this.carga = CARGADEFECTO;
	}

	public Lavadora(double peso, double precio, char consumo, String color, double carga) {
		super(peso, precio, consumo, color);
		this.carga = carga;
	}

	public Lavadora(double peso, double precio) {
		this(peso, precio, CONSUMODEFECTO, COLORDEFECTO, CARGADEFECTO);
	}

	public Lavadora(double precio, double peso, double carga) {
		this.precio = precio;
		this.peso = peso;
		this.carga = carga;
	}

	public double precioFinal() {
		double precio = super.precioFinal();

		if (this.carga > 30) {
			precio += 50;
		}
		return precio;
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}

	public static double getCargadefecto() {
		return CARGADEFECTO;
	}
	public String toString() {
	    return "LAVADORA:" + "\n" +
	           "\tPrecio Final: " + precioFinal() + " €" + "\n" +
	           "\tCarga: " + this.carga + " kg" + "\n" +
	           "\tColor: " + this.color + "\n" +
	           "\tConsumo energético: " + this.consumo + "\n" +
	           "\tPeso: " + this.peso + " kg" + "\n" +
	           "\tPrecio Base: " + this.precio + " €" + "\n";
	}

}
