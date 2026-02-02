package productos;

import java.time.LocalDate;

import interfaces.EsAlimento;

public class Cereales extends Producto implements EsAlimento {
	
	private String tipoCereal;
	private LocalDate fechaCaducidad;
	
	
	public Cereales(String marca, double precio, String tc) {
		super(marca, precio);
		this.tipoCereal = tc;
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
		switch (this.tipoCereal) {
			case "espelta":
				return 5;
			case "maiz":
				return 8;
			case "trigo":
				return 12;
			default:
				return 15;
		}

	}

	public String getTipoCereal() {
		return tipoCereal;
	}

	public void setTipoCereal(String tipoCereal) {
		this.tipoCereal = tipoCereal;
	}

	@Override
	public String toString() {
		return "Cereales: \n" +
				"\tMarca: " + this.marca + "\n" +
				"\tPrecio: " + this.precio + "\n" +
				"\tTipo de Cereales: " + this.tipoCereal + "\n" +
				"\tFecha de Caducidad: " + this.fechaCaducidad + "\n" +
				"\tCalorias: " + this.getCalorias() + "\n";
	}

}
