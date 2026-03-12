package persona;

public class Persona {
	private String nombre;
	private String apellidos;
	private boolean genero;
	private int edad;
	
	public Persona(String nombre, String apellidos, boolean genero, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.edad = edad;
	}
	
	public String toString() {
		return "Persona\n" +
				"\tNombre: " + this.nombre + "\n" +
				"\tApellidos: " + this.apellidos + "\n" +
				"\tGenero: " + (this.genero ? "Masculino" : "Femenino") + "\n" +
				"\tEdad: " + this.edad + "\n";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public boolean isGenero() {
		return genero;
	}

	public void setGenero(boolean genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
