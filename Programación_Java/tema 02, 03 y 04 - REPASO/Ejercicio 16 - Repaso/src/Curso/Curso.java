package Curso;

public class Curso {
	private String nombre;
	private String asignatura;
	
	public Curso (String n, String a) {
		this.nombre = n;
		this.asignatura = a;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String asignatura) {
		this.nombre = asignatura;
	}
	public String getAsignatura() {
		return this.asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	public void mostrarInfo() {
		System.out.println("INFORMACIONES DEL CURSO"+ "\n" +
							"\tCurso: " + this.nombre + "\n"+
								"\tAsignatura: "+ this.asignatura);
	}

}
