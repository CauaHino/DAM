package excepciones;

public class MenorDeEdad extends Exception{
	private String nombre;
	private String apellido;
	
	public MenorDeEdad(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public String toString() {
		return "La persona " + this.nombre + " " + this.apellido + " no puede cursar o dar clase en el CFGS DAM";
	}

}
