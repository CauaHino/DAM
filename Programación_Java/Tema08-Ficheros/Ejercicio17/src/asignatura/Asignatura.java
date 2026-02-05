package asignatura;

public class Asignatura {
	private int idAsignatura;
	private String nombre;
	private static int contador = 0;
	
	public Asignatura(int id, String nombre) {
		this.nombre = nombre;
		contador++;
		this.idAsignatura = contador;
	}
	public String toString() {
		return "\t\tAsignatura: "+"\n"+"\t\t\tID: " + this.idAsignatura + "\n" +
									"\t\t\tNOMBRE: " + this.nombre + "\n";
	}
	public int getId() {
		return idAsignatura;
	}
	public void setId(int id) {
		this.idAsignatura = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
