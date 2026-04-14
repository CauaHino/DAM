package personas;

import excepciones.MenorDeEdad;

public abstract class Persona {
	protected String nombre;
	protected String apellidos;
	protected int edad;
	protected String curso;
	protected int idPersona;
	protected static int contador = 0;

	public Persona(String nombre, String apellidos, int edad, String curso) throws MenorDeEdad {
		if (edad < 18) {
			throw new MenorDeEdad(nombre, apellidos);
		} else {
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.edad = edad;
			this.curso = curso;
			contador++;
			this.idPersona = contador;
		}
	}
	
	public Persona() {
		
	}

	public abstract String toString();

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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	
}
