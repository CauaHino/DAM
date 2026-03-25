package excepciones;

public class PotenciaNegativa extends Exception{
	private String marca;
	private String modelo;
	
	public PotenciaNegativa(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String toString() {
		return "La potencia de la locomotora "+this.marca+" "+this.modelo+" debe ser POSITIVA";
	}

}
