package vehiculos;

import clientes.Cliente;

public class Furgonetas extends Vehiculo {
	private int numPlazas;

	public Furgonetas(String matricula, String marca, int dias, double km, boolean alquilado, int numPlazas) {
		super(matricula, marca, dias, km, 30, 0.30, alquilado);
		this.numPlazas = numPlazas;
		if (numPlazas > 7) {
			this.precioDia += 40;
		}
	}

	@Override
	public String toString() {
		return "\tMatrícula: " + this.matricula + "\n" + "\tMarca: " + this.marca + "\n" + "\tDías: "
				+ this.diasAlquiler + "\n" + "\tKM: " + this.km + "\n" + "\tNumero de Plazas: " + this.numPlazas + "\n"
				+ "\tEstado: " + (this.alquilado ? "Alquilado" : "Disponible");
	}

	public int getNumPlazas() {
		return this.numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	@Override
	public boolean alquilar(Cliente cliente) {
		if (!this.alquilado && cliente.isCarnetFurgoneta() == true) {
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
