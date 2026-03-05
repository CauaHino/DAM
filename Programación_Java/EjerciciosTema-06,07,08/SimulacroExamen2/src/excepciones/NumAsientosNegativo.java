package excepciones;

public class NumAsientosNegativo extends Exception {
	private String marca;
	private String modelo;
	
	public NumAsientosNegativo(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String toString() {
		return "El número de asientos del vagón de pasajeros " + this.marca +
				this.modelo + " debe ser POSITIVO";
	}

}
