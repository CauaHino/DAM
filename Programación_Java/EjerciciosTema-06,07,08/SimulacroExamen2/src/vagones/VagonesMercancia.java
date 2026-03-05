package vagones;

public class VagonesMercancia extends Vagones{
	private double capacidad;

	public VagonesMercancia(String marca, String modelo, double c) {
		super(marca, modelo);
		this.capacidad = c;
	}
	public String toString() {
		return "VAGÓN DE MERCANCIAS:"
					+ "\n" + "\tID: " +this.id
					+ "\n" + "\tMarca: " +this.marca
					+ "\n" + "\tModelo: " +this.modelo
					+ "\n" + "\tCapacidad: " + this.capacidad +"Kg";
	}
	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	
	

}
