package personas;

import interfaces.Imprimible;

public class Persona implements Imprimible{
	private static int contador = 0;
	private int idPersona;
	private String nombre;
	private String apellidos;
	private String dni;
	private int edad;
	
	public Persona(String nombre, String apellidos, String dni, int edad) {
		contador++;
		this.idPersona = contador;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
	}
	
	public Persona(int idPersona, String nombre, String apellidos, String dni, int edad) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String devolverInfoString() {
		// TODO Auto-generated method stub
		return "PERSONA: \n"
				+"\tID: "+this.idPersona+"\n"
				+"\tNombre: "+this.nombre+"\n"
				+"\tApellidos: "+this.apellidos+"\n"
				+"\tDNI: "+this.dni+"\n"
				+"\tEdad: "+this.edad+"\n";
	}

}
