package persona;

public class Persona {
	private String nombre;
	private String apellidos;
	private int edad;
	
	public Persona(String n, String a, int edad) {
		this.nombre = n;
		this.apellidos = a;
		this.edad = edad;
	}
	public String toString() {
		return "PERSONA: \n" + "\tNombre: " + this.nombre + "\n" + 
								"\tApellidos: " + this.apellidos + "\n" + 
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	

}
