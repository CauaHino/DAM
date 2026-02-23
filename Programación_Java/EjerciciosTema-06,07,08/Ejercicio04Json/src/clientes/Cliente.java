package clientes;

import vehiculos.Vehiculo;

public class Cliente {
	private String nombre;
	private String dni;
	private Vehiculo vehiculoAlquilado;
	private boolean carnetTurismo;
	private boolean carnetFurgoneta;
	private boolean carnetCamion;
	public Cliente(String nombre, String dni, boolean carnetTurismo, boolean carnetFurgoneta, boolean carnetCamion) {
		this.nombre = nombre;
		this.dni = dni;
		this.carnetTurismo = carnetTurismo;
		this.carnetFurgoneta = carnetFurgoneta;
		this.carnetCamion = carnetCamion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Vehiculo getVehiculoAlquilado() {
		return vehiculoAlquilado;
	}
	public void setVehiculoAlquilado(Vehiculo vehiculoAlquilado) {
		this.vehiculoAlquilado = vehiculoAlquilado;
	}
	public boolean isCarnetTurismo() {
		return carnetTurismo;
	}
	public void setCarnetTurismo(boolean carnetTurismo) {
		this.carnetTurismo = carnetTurismo;
	}
	public boolean isCarnetFurgoneta() {
		return carnetFurgoneta;
	}
	public void setCarnetFurgoneta(boolean carnetFurgoneta) {
		this.carnetFurgoneta = carnetFurgoneta;
	}
	public boolean isCarnetCamion() {
		return carnetCamion;
	}
	public void setCarnetCamion(boolean carnetCamion) {
		this.carnetCamion = carnetCamion;
	}
	
	@Override
	public String toString() {
	    return "CLIENTE: \n" +
	            "\tNombre: " + nombre + "\n" +
	            "\tDNI: " + dni + "\n" +
	            "\tCarnet Turismo: " + (carnetTurismo ? "Sí" : "No") + "\n" +
	            "\tCarnet Furgoneta: " + (carnetFurgoneta ? "Sí" : "No") + "\n" +
	            "\tCarnet Camion: " + (carnetCamion ? "Sí" : "No") + "\n" +
	            "\tVehiculo Alquilado: " + (vehiculoAlquilado != null ? vehiculoAlquilado.getMatricula() : "Ninguno");
	}

}
