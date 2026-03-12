package clientes;

public class ClientePresencial extends Cliente {

	public ClientePresencial(String n, int edad, double d) {
		super(n, edad, d);
	}
	
	@Override
	public String toString() {
		return "CLIENTE PRESENCIAL: " + "\n" + "\tNombre: " + this.nombre + "\n"
											+ "\tEdad: " + this.edad + "\n"
											+ "\tDinero: " + this.dinero + "\n";
	}

}
