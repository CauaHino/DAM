package clientes;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import excepciones.SinSuscripcion;
import prestamo.Prestamo;
import recursos.Libro;
import recursos.Pelicula;
import recursos.Recurso;
import recursos.VideoJuego;

public class Cliente implements Prestamo {
	private static int contador = 0;
	private int idCliente;
	private String nombre;
	private String dni;
	private boolean basic = false;
	private boolean estandar = false;
	private boolean premium = false;
	private int numRecursos;
	private final int MAX_RECURSOS = 2;
	private ArrayList<Recurso> recursos = new ArrayList<Recurso>();

	/**
	 * Constructor sin parámetros
	 */
	public Cliente() {
	}

	public Cliente(int idCliente, String nombre, String dni, boolean basic, boolean estandar, boolean premium,
			int numRecursos) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.dni = dni;
		this.basic = basic;
		this.estandar = estandar;
		this.premium = premium;
		this.numRecursos = numRecursos;
	}



	public Cliente(String nombre, String dni) {
		contador++;
		this.idCliente = contador;
		this.nombre = nombre;
		this.dni = dni;
		this.basic = false;
		this.estandar = false;
		this.premium = false;
		this.numRecursos = 0;	
	}
	
	public String toString() {
		return "CLIENTE con ID: " + this.idCliente + "\n" 
				+ "\tNombre: " + this.nombre + "\n" 
				+ "\tDNI: " + this.dni + "\n"
				+ "\tSuscripción BASIC: " + (this.basic ? "SI" : "NO") + "\n" 
				+ "\tSuscripción ESTÁNDAR: "	+ (this.estandar ? "SI" : "NO") + "\n" 
				+ "\tSuscripción PREMIUM: " + (this.premium ? "SI" : "NO")	+ "\n" 
				+ "\tNº Recursos alquilados: " + this.numRecursos + "\n" 
				+ "\tRECURSOS:\n " + mostrarInfoRecursos() + "\n";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public boolean isBasic() {
		return basic;
	}

	public void setBasic(boolean basic) {
		this.basic = basic;
	}

	public boolean isEstandar() {
		return estandar;
	}

	public void setEstandar(boolean estandar) {
		this.estandar = estandar;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public int getNumRecursos() {
		return numRecursos;
	}

	public void setNumRecursos(int numRecursos) {
		this.numRecursos = numRecursos;
	}
	
	public ArrayList<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(ArrayList<Recurso> recursos) {
		this.recursos = recursos;
	}

	public String mostrarInfoRecursos() {
		String acumuladorRecursos="";
		for(Recurso v : this.recursos) {
			if(v != null) {
				acumuladorRecursos += v +"\n";
			}
		}
		return acumuladorRecursos;
	}

	@Override
	public boolean prestar(Recurso recurso, int numDias) throws SinSuscripcion {
		if(this.basic || this.estandar || this.premium) {
			if(this.numRecursos < 2) {
				if(!recurso.isPrestado()) {
					if(recurso instanceof Libro && this.basic) {
						this.numRecursos++;
						this.recursos.add(recurso);
						recurso.setPrestado(true);
						return true;
					} else if(recurso instanceof Pelicula && estandar) {
						this.numRecursos++;
						this.recursos.add(recurso);
						recurso.setPrestado(true);
						return true;
					} else if(recurso instanceof VideoJuego && premium) {
						this.numRecursos++;
						this.recursos.add(recurso);
						recurso.setPrestado(true);
						return true;
					}
				}
			} else {
				System.out.println("No fue posible prestar el recurso " + recurso.getTitulo() + " porque el Cliente tiene más de dos recursos alquilados");
				return false;
			}
		} else {
			throw new SinSuscripcion(nombre, dni);
		}
		return false;
	}

}
