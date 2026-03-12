package electrodomestico;

public class Television extends Electrodomestico {
	private int pulgadas;
	private final static int PULGADASDEFECTO = 20;
	private boolean smartTv;
	private static final boolean SMARTTVDEFECTO = false;


	public Television(double peso, double precio, char consumo, String color, int pulgadas, boolean smarttv) {
		super(peso, precio, consumo, color);
		this.pulgadas = pulgadas;
		this.smartTv = smarttv;
	}
	
	public Television() {
		this.precio = PRECIODEFECTO;
		this.peso = PESODEFECTO;
		this.color = COLORDEFECTO;
		this.consumo = CONSUMODEFECTO;
		this.pulgadas = PULGADASDEFECTO;
		this.smartTv = SMARTTVDEFECTO;
	}

	public Television(double peso, double precio) {
		this(peso, precio, CONSUMODEFECTO, COLORDEFECTO, PULGADASDEFECTO, SMARTTVDEFECTO);
	}

	public Television(double precio, double peso, String color, char consumo, int pulgadas, boolean smartTv) {
		this.precio = precio;
		this.peso = peso;
		this.pulgadas = pulgadas;
		this.smartTv = smartTv;
	}
	
	public double precioFinal() {
		double precio = super.precioFinal();
		
		if(this.pulgadas > 40) {
			precio += (precio * 0.30); 
		}
		if(this.smartTv) {
			precio += 50;
		}
		return precio;
	}

	public int getPulgadas() {
		return this.pulgadas;
	}

	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}

	public boolean isSmartTv() {
		return this.smartTv;
	}

	public void setSmartTv(boolean smartTv) {
		this.smartTv = smartTv;
	}

	@Override
	public String toString() {
	    return "TELEVISIÓN:" + "\n" +
	           "\tPrecio Total: " + precioFinal() + " €" + "\n" +
	           "\tPulgadas: " + this.pulgadas + "\"" + "\n" +
	           "\tSmart TV: " + (this.smartTv ? "Sí" : "No") + "\n" +
	           "\tColor: " + this.color + "\n" +
	           "\tConsumo: " + this.consumo + "\n" +
	           "\tPrecio de Adquisición: " + this.precio + " €" + "\n";
	}

}
