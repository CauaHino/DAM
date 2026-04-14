package excepciones;

public class MenorDeEdad extends Exception{
	
	private String nombre;
	private String apellidos;
	
	public MenorDeEdad(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public String toString() {
		return "La persona " + this.nombre +", "+this.apellidos+" no puede cursar o dar clase en el CFGS DAM";
	}

}
