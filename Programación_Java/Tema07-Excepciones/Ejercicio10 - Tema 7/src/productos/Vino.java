package productos;

import java.time.LocalDate;

import interfaces.ConDescuento;
import interfaces.EsAlimento;
import interfaces.EsLiquido;

public class Vino extends Producto implements EsAlimento, ConDescuento, EsLiquido {
	
	private String tipoVino;
	private double gradosAlcohol;
	private double volumen;
	private String tipoEnvase;
	private double descuento;
	private LocalDate fechaCaducidad;
	
	public Vino(String marca, double precio) {
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
	public void setCaducidad(LocalDate fc) {
		this.fechaCaducidad = fc;

	}

	@Override
	public LocalDate getCaducidad() {
		return this.fechaCaducidad;
	}

	@Override
	public int getCalorias() {
		return (int) (10 * this.gradosAlcohol);
	}

	public String getTipoVino() {
		return tipoVino;
	}

	public void setTipoVino(String tipoVino) {
		this.tipoVino = tipoVino;
	}

	public double getGradosAlcohol() {
		return gradosAlcohol;
	}

	public void setGradosAlcohol(double gradosAlcohol) {
		this.gradosAlcohol = gradosAlcohol;
	}

	@Override
	public String toString() {
		return "Vino: \n" +
				"\tMarca: " + this.marca + "\n" +
				"\tPrecio: " + this.precio + "\n" +
				"\tTipo de Vino: " + this.tipoVino + "\n" +
				"\tGrados de Alcohol: " + this.gradosAlcohol + "\n" +
				"\tTipo de Envase: " + this.tipoEnvase + "\n" +
				"\tVolumen: " + this.volumen + "\n" +
				"\tDescuento: " + this.descuento + "\n" +
				"\tPrecio con Descuento: " + this.getPrecioDescuento() + "\n";
	}

}
