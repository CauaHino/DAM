package excepciones;

public class SinSuscripcion extends Exception{
	
	private String nombre;
	private String dni;
	
	public SinSuscripcion(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public String toString() {
		return "El cliente "+this.nombre+" con DNI: "+this.dni+" no tiene ninguna suscripción de la biblioteca";
	}

}
