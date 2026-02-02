package ElementosElectricos;

abstract public class Electrodomestico implements Enchufe {
	protected int potencia;
	protected int antigüedad;
	protected boolean conexionElectrica = false;

	public Electrodomestico() {
		potencia = 3;
	}

	public abstract boolean garantia();
}
