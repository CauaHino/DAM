package clientes;

public class ClienteOnline extends Cliente{

	public ClienteOnline(String n, int edad, double d) {
		super(n, edad, d);
	}

	@Override
	public String toString() {
		return "CLIENTE ONLINE: " + "\n" + "\tNombre: " + this.nombre + "\n"
											+ "\tEdad: " + this.edad + "\n"
											+ "\tDinero: " + this.dinero + "\n";
	}

}
