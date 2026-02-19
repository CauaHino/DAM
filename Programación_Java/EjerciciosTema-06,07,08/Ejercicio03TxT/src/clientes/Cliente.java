package clientes;

abstract public class Cliente {
	protected String nombre;
	protected int edad;
	protected double dinero;
	
	public Cliente(String n, int edad, double d) {
		this.nombre = n;
		this.edad = edad;
		this.dinero = d;
	}
	
	abstract public String toString();
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	
	public double restarDinero(double cantidadApostada) {
		return this.dinero - cantidadApostada;
	}
	
	
}
