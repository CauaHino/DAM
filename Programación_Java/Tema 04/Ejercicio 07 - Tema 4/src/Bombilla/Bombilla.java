package Bombilla;

public class Bombilla {
	private static boolean interruptorLuz;
	private boolean interruptorBombilla;
	
	public Bombilla() {
		interruptorLuz = false;
		this.interruptorBombilla = false;
	}
	
	public static void activaGeneral () {
		interruptorLuz = true;
		System.out.println("El GENERAL fue activado");
	}
	public static void desactivaGeneral () {
		interruptorLuz = false;
		System.out.println("El GENERAL fue apagado");
	}
	public void enciende() {
		this.interruptorBombilla = true;
	}
	public void apaga() {
		this.interruptorBombilla = false;
	}
	public boolean encendida () {
		return interruptorLuz && interruptorBombilla;
	
	}

}
