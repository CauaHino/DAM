
public class Contacto {
	private String nombre;
	private int tlf;

	public Contacto(String n, int tlf) {
		this.nombre = n;
		this.tlf = tlf;
	}
	public Contacto(String n) {
		this.nombre = n;
		this.tlf = 0;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	
	public boolean equals(Contacto c) {
		if(this.nombre.trim().equalsIgnoreCase(c.nombre.trim())) {
			return true;
		}
		return false;
	}
	public String toString() {
		return "NOMBRE: " + this.nombre + "\nTELEFONO: " + this.tlf;
	}
}
