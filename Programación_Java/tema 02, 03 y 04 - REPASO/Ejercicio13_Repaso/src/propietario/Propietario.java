package propietario;

public class Propietario {
	private String nombre;
	private String apellidos;
	private String dni;
	private int idPropietario;
	private static int contador = 0;
	
	public Propietario(String n, String a, String d) {
		this.nombre = n;
		this.apellidos = a;
		this.dni = d;
		contador++;
		this.idPropietario = contador;
	}
	
	public Propietario() {
		contador++;
		this.idPropietario = contador;
		this.nombre = "Pepe";
		this.apellidos = "López Sánchez";
		this.dni = "74125985L";
	}
	
	public String dameNombre() {
		return this.nombre;
	}
	
	public void modificaNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String dameApellidos() {
		return this.apellidos;
	}
	
	public void modificaApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String dameDNI() {
		return this.dni;
	}
	
	public void modificaDNI(String dni) {
		this.dni = dni;
	}
	
	public int dameIdPropietario() {
		return this.idPropietario;
	}
	
	public void mostrarInfo() {
		System.out.println("PROPIETARIO: \n"+
							"\tIdPropietario: "+this.idPropietario+"\n"+
							"\tNombre: "+this.nombre+"\n"+
							"\tApellidos: "+this.apellidos+"\n"+
							"\tDNI: "+this.dni+"\n"
							);
	}
	
	public String toString() {
		return "PROPIETARIO: \n"+
							"\tIdPropietario: "+this.idPropietario+"\n"+
							"\tNombre: "+this.nombre+"\n"+
							"\tApellidos: "+this.apellidos+"\n"+
							"\tDNI: "+this.dni+"\n";						
	}
	

}
