import Excepciones.AgendaLlena;

public class Agenda {
	private Contacto agenda[];
	private int numContactos;
	
	public Agenda(int tamAgenda) {
		this.agenda = new Contacto[tamAgenda];
		this.numContactos = 0;
	}
	public Agenda() {
		this.agenda = new Contacto[10];
		this.numContactos = 0;
	}
	
	public void anadirContacto(Contacto c) throws AgendaLlena {
		if(existeContacto(c)) {
			System.out.println("Ya existe el contacto con ese nombre");
		} else if(agendaLlena()) {
			throw new AgendaLlena();
		} else {
			boolean encontrado = false;
			for(int i = 0; i < agenda.length && !encontrado; i++) {
				if(agenda[i] == null) {
					agenda[i] = c;
					this.numContactos++;
					encontrado = true;
				}
			}
			if(encontrado) {
				System.out.println("Se ha añadido el contacto: " + c.getNombre());
			} else {
				System.out.println("No es ha podido añadir el contacto");
			}
		}
		
	}
	
	public boolean existeContacto(Contacto c) {
		for(int i = 0; i < this.numContactos; i++) {
			if(this.agenda[i].getNombre().equalsIgnoreCase(c.getNombre())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean agendaLlena() {
		if(this.numContactos == this.agenda.length) {
			return true;
		}
		return false;
	}
	
	public void listarContacto() {
		for(int i = 0; i < this.numContactos; i++) {
			System.out.println(this.agenda[i].toString());  
		}
	}
	
	public void buscarContacto(String nombre) {
		boolean encontrado = false;
		for(int i = 0; i < this.numContactos && !encontrado; i++) {
			if(this.agenda[i].getNombre().equalsIgnoreCase(nombre)) {
				System.out.println("El teléfono del contacto " + this.agenda[i].getNombre() + " es " + this.agenda[i].getTlf());
				encontrado = true;
			} 
			
		}
		if(!encontrado)
			System.out.println("No fue encontrado el contacto llamado " + nombre);
		}
		
	
	public void eliminarContacto(Contacto c) {
		for(int i = 0; i < this.numContactos; i++) {
			if(this.agenda[i].equals(c)) {
				this.agenda[i] = null;
				this.numContactos--;
				System.out.println("Se ha eliminado el contacto con el nombre " + c.getNombre());
			}
			System.out.println("No fue posible eliminar el contacto " + c.getNombre());
		}
	}
	public void huecosLibres() {
		System.out.println("Quedan " + (this.agenda.length - this.numContactos) + " Huecos");
	}
}
