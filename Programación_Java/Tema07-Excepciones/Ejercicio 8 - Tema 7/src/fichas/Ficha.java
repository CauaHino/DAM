package fichas;

import Excepciones.PosicionFueraDelTablero;

abstract public class Ficha {
	protected String color;
	protected int posicionX;
	protected int posicionY;
	
	public Ficha(String c, int posicionX,int posicionY) {
		this.color = c;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	
	abstract public boolean movimientoValido(int posX, int posY) throws PosicionFueraDelTablero;
	}


