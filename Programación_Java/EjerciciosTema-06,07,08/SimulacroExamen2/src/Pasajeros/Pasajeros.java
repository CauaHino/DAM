package Pasajeros;

public class Pasajeros {
	private String nombre;
	private String billete;
	private boolean estaVagon;

	public Pasajeros(String nombre, String billete) {
		this.nombre = nombre;
		this.billete = billete;
	}
	
	public String toString() {
		return "PASAJERO: "
				+ "\n" + "\tNombre: " + this.nombre
				+ "\n" + "\tBillete: " + this.billete
				+ "\n" + "\t¿Está montado en algún vagón?: " + (this.estaVagon ? "SI" : "NO")
				+ "\n";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getBillete() {
		return billete;
	}

	public void setBillete(String billete) {
		this.billete = billete;
	}

	public boolean isEstaVagon() {
		return estaVagon;
	}

	public void setEstaVagon(boolean estaVagon) {
		this.estaVagon = estaVagon;
	}

}
