package productos;

import interfaces.ConDescuento;
import interfaces.EsLiquido;

public class Detergente extends Producto implements ConDescuento, EsLiquido {
	
	private double volumen;
	private String tipoEnvase;
	private double descuento;
	
	public Detergente(String marca, double precio) {
		super(marca, precio);
	}

	@Override
	public void setVolumen(double v) {
		this.volumen = v;

	}

	@Override
	public double getVolumen() {
		return this.volumen;
	}

	@Override
	public void setTipoEnvase(String env) {
		this.tipoEnvase = env;

	}

	@Override
	public String getTipoEnvase() {
		return this.tipoEnvase;
	}

	@Override
	public void setDescuento(double des) {
		this.descuento = des;

	}

	@Override
	public double getDescuento() {
		return this.descuento;
	}

	@Override
	public double getPrecioDescuento() {
		return this.precio - (this.precio * this.descuento/100);
	}

	@Override
	public String toString() {
		return "Detergente: \n" +
					"\tMarca: " + this.marca + "\n" +
					"\tPrecio: " + this.precio + "\n" +
					"\tTipo de Envase: " + this.tipoEnvase + "\n" +
					"\tVolumen: " + this.volumen + "\n" +
					"\tDescuento: " + this.descuento + "\n" +
					"\tPrecio con Descuento: " + this.getPrecioDescuento() + "\n";
	}

}
