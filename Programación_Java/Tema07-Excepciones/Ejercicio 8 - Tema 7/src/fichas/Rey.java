package fichas;

import Excepciones.PosicionFueraDelTablero;

public class Rey extends Ficha{

	public Rey(String c, int posicionX, int posicionY) {
		super(c, posicionX, posicionY);
	}

	@Override
	public boolean movimientoValido(int posX, int posY) throws PosicionFueraDelTablero {
		if(posX < 0 || posX > 7 || posY < 0 || posY > 7) {
			throw new PosicionFueraDelTablero();
		} if(Math.abs(this.posicionX - posX) <= 1 && Math.abs(this.posicionY - posY) <= 1 
				&&(this.posicionX != posX || this.posicionY != posY)) {
			return true;
		}
		return false;
	}

}
