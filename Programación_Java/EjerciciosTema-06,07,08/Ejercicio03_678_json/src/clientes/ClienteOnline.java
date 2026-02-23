package clientes;

public class ClienteOnline extends Cliente{
	public ClienteOnline(String nombre, int edad, double dinero) {
		super(nombre, edad, dinero);
		this.presencial = false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CLIENTE ONLINE: \n"+
				"\tNombre: "+this.nombre+"\n"+
				"\tEdad: "+this.edad+" años\n"+
				"\tDinero: "+this.dinero+" €\n";
	}
}
