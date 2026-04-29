package modelo;

import java.util.ArrayList;

public class Carrito {
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	
	public void agregar(Producto producto) {
		boolean encontrado = false;
		if(!listaProductos.isEmpty()) {
			for(Producto p : this.listaProductos) {
				if(p.getIdProducto() == producto.getIdProducto()) {
					p.setCantidad(p.getCantidad() + 1);
					encontrado = true;
					break;
				}
			}
		}
		if(!encontrado) {
			this.listaProductos.add(producto);
		}
		
	}
	
	public void eliminar(int idProducto) {
		for(int i = 0; i < this.listaProductos.size(); i++) {
			if(this.listaProductos.get(i).getIdProducto() == idProducto) {
				this.listaProductos.remove(i);
				i--;
			}
		}
	}
	
	public void vaciar() {
		this.listaProductos.clear();
	}
	
	public double precioTotal(){
		double total = 0;
		for(Producto p : this.listaProductos) {
			total += p.getPrecio() * p.getCantidad();
		}
		return total;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

}
