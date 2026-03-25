package vagones;

public class VagonMercancias extends Vagon{
	private double capacidad;

	public VagonMercancias(String marca, String modelo, double capacidad) {
		super(marca, modelo);
		this.capacidad = capacidad;
	}
	

	public VagonMercancias(int idVagon, String marca, String modelo, double capacidad) {
		this.identificador = idVagon;
		this.marca = marca;
		this.modelo = modelo;
		this.capacidad = capacidad;
	}


	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "VAGÓN DE MERCANCÍAS: \n"+"\tID "+ identificador+ ", " + marca + ", "+ modelo + " y de capacidad "+capacidad+"\n";
	}
	
	

}
