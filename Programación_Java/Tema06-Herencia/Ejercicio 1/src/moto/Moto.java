package moto;

import java.time.LocalDate;

import Vehiculo.Vehiculo;
import VehiculoConMotor.VehiculoConMotor;

public class Moto extends VehiculoConMotor {
	private String marca;
	private String modelo;
	private LocalDate fechaM;
	
	public Moto(String c, double p, String m, double cc, int cv, String marca, String modelo,LocalDate fechaM ) {
		super(c,p,m,cc,cv);
		this.marca = marca;
		this.modelo = modelo;
		this.fechaM = fechaM;
		
		
		}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getFechaM() {
		return fechaM;
	}

	public void setFechaM(LocalDate fechaM) {
		this.fechaM = fechaM;
	}

	public String toString() {
		return super.toString() + "MOTO: " +"\n" + "\tMarca: " + this.marca + "\n" + 
									"\tModelo: " + this.modelo + "\n" + 
									"\tFecha de Matricula: " + this.fechaM + "\n";
		
	}

}
