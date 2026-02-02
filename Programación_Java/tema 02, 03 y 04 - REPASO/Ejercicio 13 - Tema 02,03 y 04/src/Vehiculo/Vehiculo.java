package Vehiculo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import Proprietario.Proprietario;

public class Vehiculo {

	private String marca;
	private String matricula;
	private int numKilometros;
	private LocalDate fechaMatriculacion;
	private double precio;
	private String color;
	private Proprietario propietario;

	public Vehiculo() {
		this.marca = "Peugeot";
		this.matricula = "7894MKJ";
		this.numKilometros = 14500;
		this.fechaMatriculacion = LocalDate.of(2019, 11, 15);
		this.precio = 21500.0;
		this.color = "Negro";

	}

	public Vehiculo(String marca, String matricula, int numKilometros, LocalDate fechaMatriculacion, double precio,
			String color, Proprietario propietario) {
		this.marca = marca;
		this.matricula = matricula;
		this.numKilometros = numKilometros;
		this.fechaMatriculacion = fechaMatriculacion;
		this.precio = precio;
		this.color = color;
		this.propietario = propietario;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getNumKilometros() {
		return numKilometros;
	}

	public void setNumKilometros(int numKilometros) {
		this.numKilometros = numKilometros;
	}

	public LocalDate getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Proprietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Proprietario propietario) {
		this.propietario = propietario;
	}

	public int dameAnos() {

		LocalDate f1 = this.fechaMatriculacion;
		LocalDate f2 = LocalDate.now();

		Period p = Period.between(f1, f2);

		return p.getYears();
	}
		public String toString() {
			return "\n===== Ficha del Vehículo =====" + "\n"+
			"\tMatrícula: " + this.matricula+ "\n"+
			"\tMarca: " + this.marca+ "\n" +
			"\tColor: " + this.color+ "\n"+
			"\tKilómetros: " + this.numKilometros + " km"+ "\n" +
			"\tPrecio: " + this.precio + " €";
		}

	}

