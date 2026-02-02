package Proprietario;

public class Proprietario {

	private String nombre;
	private String apellidos;
	private String dni;
	private static int CONTADOR = 0;
	private int idPropietario;

	public Proprietario(String n, String a, String dni) {
		this.nombre = n;
		this.apellidos = a;
		this.dni = dni;
		CONTADOR++;
		this.idPropietario = CONTADOR;

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

	public int getIdPropietario() {
		return idPropietario;
	}

	public void mostrarInfo() {
		System.out.println("--- Información del Propietario ---");
		System.out.println("ID: " + this.idPropietario);
		System.out.println("Nombre completo: " + this.nombre + " " + this.apellidos);
		System.out.println("DNI: " + this.dni);
		System.out.println("---------------------------------");
	}

	public String toString() {
		return "--- Información del Propietario ---\n" + "ID: " + this.idPropietario + "\n" + "Nombre completo: "
				+ this.nombre + " " + this.apellidos + "\n" + "DNI: " + this.dni + "\n"
				+ "---------------------------------";
	}
}
