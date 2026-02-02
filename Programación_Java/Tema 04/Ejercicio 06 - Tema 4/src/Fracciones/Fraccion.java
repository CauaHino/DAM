package Fracciones;

public class Fraccion {
	private double numerador;
	private double denominador;

	public Fraccion() {
		this.numerador = 0;
		this.denominador = 0;
	}

	public void asignarDatos(double nuevoDenominador, double nuevoNumerador) {
		this.numerador = nuevoNumerador;
		this.denominador = nuevoDenominador;
		}

	public void mostrarFraccion() {
		System.out.println(this.denominador + "/" + this.numerador);
	}

	public double solucionReal() {
		return (double) this.denominador / this.numerador;
	}

}
