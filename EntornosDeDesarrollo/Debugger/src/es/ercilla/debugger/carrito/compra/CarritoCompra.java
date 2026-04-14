package es.ercilla.debugger.carrito.compra;

import java.util.ArrayList;

public class CarritoCompra {

	private ArrayList<Double> precios;

	public CarritoCompra() {
		precios = null;
	}

	public void agregarProducto(double precio) {
		precios.add(precio);
	}

	public double calcularTotal() {
		double total = 0;

		for (Double p : precios) {
			total += p;
		}

		return total;
	}

	public void eliminarProducto(int indice) {
		precios.remove(indice);
	}

	public double calcularMedia() {
		return calcularTotal() / precios.size();
	}

	public static void main(String[] args) {
		CarritoCompra carrito = new CarritoCompra();

		carrito.agregarProducto(10.0);
		carrito.agregarProducto(20.0);
		carrito.agregarProducto(30.0);

		carrito.eliminarProducto(3);

		System.out.println("Total: " + carrito.calcularTotal());
		System.out.println("Media: " + carrito.calcularMedia());
	}
}