package Lampara;

public class Lampara {
	private static boolean Bombilla;
	private String tipo;
	
	public Lampara (String tipo) {
		this.tipo = tipo;
		Bombilla = false;
	}
	public static void encender() {
		Bombilla = true;
		System.out.println("La Lampara fue encendida");
	}
	public static void apagar() {
		Bombilla = false;
		System.out.println("La Lampara fue apagada");
	}
	public void modificaTipo(String tipo) {
		this.tipo = tipo;
	}
	public String toString () {
		return "La Lampara es de tipo: " + this.tipo + "\n" + "La Lampara está: "+ Bombilla + "\n"; 
	}

}
