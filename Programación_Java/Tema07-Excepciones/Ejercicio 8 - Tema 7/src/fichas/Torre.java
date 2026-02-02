package fichas;

import Excepciones.PosicionFueraDelTablero;

public class Torre extends Ficha{

	public Torre(String c, int posicionX, int posicionY) {
		super(c, posicionX, posicionY);
	}

	@Override
	public boolean movimientoValido(int posX, int posY) throws PosicionFueraDelTablero {
	if(posX < 0 || posX > 7 || posY < 0 || posY > 7) {
		throw new PosicionFueraDelTablero();
	}if((this.posicionX == posX || this.posicionY == posY) && (this.posicionX != posX || this.posicionY != posY)){
		return true;
	}
	return false;
}
	}
