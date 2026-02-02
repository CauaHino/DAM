
public class Cliente {
	private int numSocio;
	private static int contador;
	private String nombreSocio;
	private double saldo;

	public Cliente(String nombre, double saldoInicial) {
		this.nombreSocio = nombre;
		this.saldo = saldoInicial;
		contador++;
		this.numSocio = contador;
	}

	public String getNombre() {
		return nombreSocio;
	}

	public void cobrar(double cantidad) {
		this.saldo += cantidad;
	}

	public void pagar(double cantidad) {
		this.saldo -= cantidad;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void poneDinero(int dinero) {
		this.saldo += dinero;
	}
	
	public void cogeDinero(int dinero) {
		this.saldo -= dinero;
	}
}
