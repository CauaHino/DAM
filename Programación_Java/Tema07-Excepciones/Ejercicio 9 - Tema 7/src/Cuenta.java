
public class Cuenta {
	private String titular;
	private double cantidad;
	
	public Cuenta(String titular, double cantidad) {
		this.titular = titular;
		this.cantidad = cantidad;
	}
	public Cuenta(String titular) {
		this.titular = titular;
		this.cantidad = 0;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public boolean ingresar(double cantidad) throws CantidadNegativa {
		if(cantidad < 0) {
			throw new CantidadNegativa();
		}else {
			this.cantidad += cantidad;
			return true;
		}
	}
		public boolean retirar(double cantidad) throws CantidadNoDisponible {
			if(cantidad < 0 || this.cantidad - cantidad < 0) {
				throw new CantidadNoDisponible();
			}else {
				this.cantidad -= cantidad;
				return true;
			}
	}

}
