package clientes;

public class ClientePresencial extends Cliente{
	
	public ClientePresencial(String nombre, int edad, double dinero) {
		super(nombre, edad, dinero);
		this.presencial = true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CLIENTE PRESENCIAL: \n"+
				"\tNombre: "+this.nombre+"\n"+
				"\tEdad: "+this.edad+" años\n"+
				"\tDinero: "+this.dinero+" €\n";
	}
	
}
