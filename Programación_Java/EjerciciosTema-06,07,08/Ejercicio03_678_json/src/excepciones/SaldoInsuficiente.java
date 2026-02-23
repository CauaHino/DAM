package excepciones;

public class SaldoInsuficiente extends Exception{
	private String nombreCliente;
	
	public SaldoInsuficiente(String nombre) {
		this.nombreCliente = nombre;
	}
	
	public String toString() {
		return "El cliente "+this.nombreCliente+" no dispone de"
				+ "dinero suficiente";
	}

}
