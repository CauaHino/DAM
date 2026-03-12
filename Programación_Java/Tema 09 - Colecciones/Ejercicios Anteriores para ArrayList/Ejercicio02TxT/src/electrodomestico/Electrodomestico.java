package electrodomestico;

import InfoElectrodomestico.InfoElectrodomestico;

abstract public class Electrodomestico implements InfoElectrodomestico {
	protected final static double PRECIODEFECTO = 100;
	protected final static double PESODEFECTO = 5;
	protected final static String COLORDEFECTO = "blanco";
	protected final static char CONSUMODEFECTO = 'F';

	protected double precio;
	protected double peso;
	protected String color;
	protected char consumo;

	public Electrodomestico() {
		this.precio = PRECIODEFECTO;
		this.peso = PESODEFECTO;
		this.color = COLORDEFECTO;
		this.consumo = CONSUMODEFECTO;
	}

	public Electrodomestico(double peso, double precio) {
		this.precio = precio;
		this.peso = peso;
		this.color = COLORDEFECTO;
		this.consumo = CONSUMODEFECTO;
	}
	public Electrodomestico(double peso, double precio, char consumo, String color) {
		this.precio = precio;
		this.peso = peso;
		comprobarColor(color);
		comprobrarConsumoEnergetico(consumo);
	}

	private void comprobarColor(String color) {
		String[] colores = { "blanco", "negro", "rojo", "azul", "gris" };
		boolean aux = false;

		for (int i = 0; i < colores.length; i++) {
			if (colores[i].equalsIgnoreCase(color) && !aux) {
				aux = true;
			}
		}
		if (aux) {
			this.color = color.toLowerCase();
		} else {
			this.color = COLORDEFECTO;
		}
	}

	private void comprobrarConsumoEnergetico(char letra) {
		char letraUpper = Character.toUpperCase(letra);

		if (letraUpper >= 'A' && letraUpper <= 'F') {
			this.consumo = letraUpper;
		} else {
			this.consumo = CONSUMODEFECTO;
		}
	}

	public double precioFinal() {
		double aux = 0;

		switch (this.consumo) {
		case 'A':
			aux += 100;
			break;
		case 'B':
			aux += 80;
			break;
		case 'C':
			aux += 60;
			break;
		case 'D':
			aux += 50;
			break;
		case 'E':
			aux += 30;
			break;
		case 'F':
			aux += 10;
			break;

		}

		if (this.peso >= 0 && this.peso <= 19) {
			aux += 10;
		} else if (this.peso >= 20 && this.peso <= 49) {
			aux += 50;
		} else if (this.peso >= 50 && this.peso <= 79) {
			aux += 80;
		} else if (this.peso >= 80) {
			aux += 100;
		}
		return this.precio + aux;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPeso() {
		return this.peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getConsumo() {
		return this.consumo;
	}

	public void setConsumo(char consumo) {
		this.consumo = consumo;
	}

}
