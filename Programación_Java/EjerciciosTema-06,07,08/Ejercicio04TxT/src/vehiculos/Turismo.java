package vehiculos;

import clientes.Cliente;

public class Turismo extends Vehiculo{

	public Turismo(String matricula, String marca, int dias, double km, boolean alquilado) {
		super(matricula, marca, dias, km, 20, 0.20, alquilado);
	}

	@Override
	public String toString() {
	    return "\tMatrícula: " + this.matricula + "\n" +
	           "\tMarca: " + this.marca + "\n" +
	           "\tDías: " + this.diasAlquiler + "\n" +
	           "\tKM: " + this.km + "\n" +
	           "\tEstado: " + (this.alquilado ? "Alquilado" : "Disponible");
	}

	@Override
	public boolean alquilar(Cliente cliente) {
		if(!this.alquilado && cliente.isCarnetTurismo() == true) {
			this.setAlquilado(true);
			System.out.println("El Vehiculo fue Alquilado con éxito");
			cliente.setVehiculoAlquilado(this);
			return true;
		}
		return false;
	}

	@Override
	public void devolver(Cliente cliente) {
		if(this.alquilado == true && cliente.getVehiculoAlquilado() != null) {
			this.setAlquilado(false);
			System.out.println("El Vehiculo fue devuelto con éxito");
			cliente.setVehiculoAlquilado(null);
		} else {
			System.out.println("No fue posible devolver el Vehiculo");
		}
		
	}

}
