package pasajeros;

public class Pasajero {
	private int idPasajero;
	private static int contador = 0;
	private String nombre;
	private String infoBillete;
	private boolean subidoEnVagon;
	private int idVagon;
	
	public Pasajero(String nombre, String infoBillete) {
		this.nombre = nombre;
		this.infoBillete = infoBillete;
		this.subidoEnVagon = false;
		contador++;
		this.idPasajero = contador;
	}
	
	public Pasajero(int idPasajero, String nombre, String infoBillete, boolean subidoEnVagon,
			int idVagon) {
		this.idPasajero = idPasajero;
		this.nombre = nombre;
		this.infoBillete = infoBillete;
		this.subidoEnVagon = subidoEnVagon;
		this.idVagon = idVagon;
	}


	public String toString() {
		return "PASAJERO:\n"+ 
				"\tNombre: "+this.nombre + 
				"\tBillete "+ this.infoBillete + 
				"\t¿Está montado en algún vagón? "+(this.subidoEnVagon ? "SI" : "NO")+
				"\tIDVagon: "+this.idVagon;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getInfoBillete() {
		return infoBillete;
	}

	public void setInfoBillete(String infoBillete) {
		this.infoBillete = infoBillete;
	}

	public boolean isSubidoEnVagon() {
		return subidoEnVagon;
	}

	public void setSubidoEnVagon(boolean subidoEnVagon) {
		this.subidoEnVagon = subidoEnVagon;
	}

	public int getIdPasajero() {
		return idPasajero;
	}

	public void setIdPasajero(int idPasajero) {
		this.idPasajero = idPasajero;
	}

	public int getIdVagon() {
		return idVagon;
	}

	public void setIdVagon(int idVagon) {
		this.idVagon = idVagon;
	}
	

}
