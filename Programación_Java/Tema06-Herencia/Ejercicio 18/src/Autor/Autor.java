package Autor;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import Libros.Libros;

public class Autor {
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String dni;
	private Libros [] libros;
	private int numLibros;
	private static int contador;
	private int idLibro;
	
	public Autor (String n, String a, LocalDate fN, String dni, Libros [] libros) {
		this.nombre = n;
		this.apellidos = a;
		this.fechaNacimiento = fN;
		this.libros = libros;
		this.dni = dni;
		contador++;
		this.idLibro= contador;
		numLibros = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Libros[] getNumLibros() {
		return libros;
	}
	public int getNumeroLibros() {
		return numLibros;
	}

	public void setNumLibros(Libros[] numLibros) {
		this.libros = libros;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int dameAnios() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, fechaActual);
		return periodo.getYears();
	}

	@Override
	public String toString() {
		String info = "Autor:"
				+ "\tNombre=" + nombre + "\n"+"\tapellidos=" + apellidos + "\n" +
				"\tFecha de Nacimiento=" + fechaNacimiento  + "\n"
				+ "\tDNI=" + dni + "\n"+ "\tidLibro=" + idLibro + "\n";
		for (int i=0; i < this.libros.length && libros[i] != null; i++) {
			info += this.libros[i].toString();
		}
		return info;
	}
	public void insertarLibro(Libros libro) {
		if (this.numLibros < this.libros.length) {
			libros[this.numLibros] = libro;
			numLibros++;
		}
	}
	public void eliminarLibro(String titulo) {
		for(int i = 0; i < this.libros.length && libros[i] != null; i++) {
			if(libros[i].getTitulo().equalsIgnoreCase(titulo)) {
				libros[i] = null;
				this.numLibros--;
				break;
			}
		}
		for(int i = 0; i < numLibros; i++) {
			if(libros[i] == null) {
				libros[i] = libros [i+1];
				libros[i+1] = null;
			}
		}
	}
	
	public void ordenarLibros() {
		for(int i = this.numLibros - 2; i >= 0; i--) {
			for (int j=0; j <= i; j++) {
				if(this.libros[i] != null) {
					if(this.libros[j].getTitulo().compareToIgnoreCase(this.libros[j+1].getTitulo()) > 0) {
						Libros auxiliar = libros[j];
						libros[j] = libros [j+1];
						libros [j+1] = auxiliar;
					}
				}
			}
		}
	}
	

}
