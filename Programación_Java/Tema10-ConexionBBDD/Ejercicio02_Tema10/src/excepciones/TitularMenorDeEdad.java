package excepciones;

public class TitularMenorDeEdad extends Exception{
	private int idPersona;
	private String nombre;
	
	public TitularMenorDeEdad(int idPersona, String nombre) {
		this.idPersona = idPersona;
		this.nombre = nombre;
	}
	
	public String toString() {
		return "La persona con ID "+this.idPersona+" y nombre "+this.nombre+" no tiene la edad suficiente para"
				+ "abrir una cuenta";
	}

}
