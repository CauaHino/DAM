package empleadoa;

public class Empleado {
	private String dni;
	private String nombre;
	private int edad;
	private boolean teletrabajo;
	private static final double SALARIOBASE = 1000;
	private double salarioTotal;
	private static int contador;
	private int idEmpleado;
	
	public Empleado (String dni, String nombre, int edad, boolean teletrabajo) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.teletrabajo = teletrabajo;
		this.salarioTotal = SALARIOBASE;
		contador++;
		this.idEmpleado = contador;
	}
	public String dameDni () {
		return this.dni;
	}
	public String dameNombre() {
		return this.nombre;
	}
	public int dameEdad() {
		return this.edad;
	}
	public boolean dameTeletrabajo() {
		return this.teletrabajo;
	}
	public void calcularSueldo() {
		if (this.edad > 30) {
			this.salarioTotal += 200;
		} if (this.teletrabajo == true) {
			this.salarioTotal += 30;
		}
	}
		public String mostrarInfo() {
			return "EMPLEADO:"+ "\n" + "\tDNI: "+ this.dni + "\n"+ "\tNombre: "+ this.nombre+
					"\n" + "\tEdad: "+ this.edad + "\n" + "\t¿Teletrabajo?: " + (this.teletrabajo ? "Si" : "No")  + "\n"+
					"\tSalario Total: " + this.salarioTotal + "\n" + "\tID: " + this.idEmpleado;
	}

}
