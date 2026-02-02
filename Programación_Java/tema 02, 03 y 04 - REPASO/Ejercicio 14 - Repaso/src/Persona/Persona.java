package Persona;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String dni;
	private static int CONTADOR;
	private int id;
	
	public Persona (String n, String a, LocalDate f, String dni) {
		this.nombre = n;
		this.apellidos = a;
		this.fechaNacimiento = f;
		this.dni = dni;
		CONTADOR++;
		this.id = CONTADOR;
	}
		
		public String getName() {
			return this.nombre;
		}
		public void setName(String nombre) {
			this.nombre = nombre;
		}
		
		public String getApellidos () {
			return this.apellidos;
		}
		public void setApellidos (String apellidos) {
			this.apellidos = apellidos;
		}
		public LocalDate getFecha () {
			return this.fechaNacimiento;
		}
		public void setFecha (LocalDate fecha) {
			this.fechaNacimiento= fecha;
		}
		public String getdni() {
			return this.dni;
		}
		public void setDni (String dni) {
			this.dni = dni;
		}
		public int getId() {
			return this.id;
		}
		public int getAnos() {
			LocalDate f1 = this.fechaNacimiento;
			LocalDate f2 = LocalDate.now();
			
			Period p = Period.between(f1, f2);
			
			return p.getYears();
			
		}
		public String toString () {
			return "---------- Informaciones Personales ---------------" + "\n" +
					"\tNombre:" + this.nombre+  "\n" +
					"\tApellidos:" + this.apellidos +"\n" +
					"\tDNI:" + this.dni + "\n" +
					"\tID:" + this.id +"\n";
		}
		
	
	
	
	

}
