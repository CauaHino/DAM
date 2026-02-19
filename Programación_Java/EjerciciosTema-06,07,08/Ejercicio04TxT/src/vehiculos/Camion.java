package vehiculos;

import clientes.Cliente;

public class Camion extends Vehiculo{
	private boolean grua;
	
	public Camion(String matricula, String marca, int dias, double km, boolean alquilado, boolean grua) {
		super(matricula, marca, dias, km, 90, 0.50, alquilado);
		this.grua = grua;
		if(this.grua) {
			this.precioDia += 50;
		}
	}
	
	@Override
	public String toString() {
	    return "\tMatrícula: " + this.matricula + "\n" +
	           "\tMarca: " + this.marca + "\n" +
	           "\tDías: " + this.diasAlquiler + "\n" +
	           "\tKM: " + this.km + "\n" +
	           "\tGrua: " + (this.grua ? "Si" : "No") + "\n" +
	           "\tEstado: " + (this.alquilado ? "Alquilado" : "Disponible");
	}

	public boolean isGrua() {
		return grua;
	}

	public void setGrua(boolean grua) {
		this.grua = grua;
	}
	
	@Override
	public boolean alquilar(Cliente cliente) {
		if (!this.alquilado && cliente.isCarnetCamion() == true) {
			this.setAlquilado(true);
			System.out.println("El Vehiculo fue Alquilado con éxito");
			cliente.setVehiculoAlquilado(this);
			return true;
		}
		System.out.println("No fue posible alquilar el coche");
		return false;
	}

	@Override
	public void devolver(Cliente cliente) {
		if (this.alquilado == true && cliente.getVehiculoAlquilado() != null) {
			this.setAlquilado(false);
			System.out.println("El Vehiculo fue devuelto con éxito");
			cliente.setVehiculoAlquilado(null);
		} else {
			System.out.println("No fue posible devolver el Vehiculo");
		}
	}

}
