package Interfaces;

import clientes.Cliente;

public interface Alquiler {
	
	public boolean alquilar(Cliente cliente);
	public void devolver(Cliente cliente);

}
