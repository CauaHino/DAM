package excepciones;

public class SaldoInsuficiente extends Exception{
	private String nombre;
	
	public SaldoInsuficiente (String n){
		this.nombre = n;
	}
	
	public String toString() {
		return "El cliente " + this.nombre + " no dispone del dinero suficiente";
	}

}
