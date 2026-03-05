package personas;

import excepciones.MenorDeEdad;

abstract public class Persona {
	protected String nombre;
	protected String apellidos;
	protected int edad;
	protected String curso;

	public Persona(String nombre, String apellidos, int edad, String curso) throws MenorDeEdad {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.curso = curso;
		this.edad = edad;
		if (edad < 18) {
			throw new MenorDeEdad(nombre, apellidos);
		}
	}

	abstract public String toString();

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

}
