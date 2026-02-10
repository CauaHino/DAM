package viviendas;

public class Pisos extends Vivienda{
	private int habitaciones;
	
	

	public Pisos() {
		super();
	}

	public Pisos(double p, double m2, int hab) {
		super(p, m2);
		this.habitaciones = hab;
	}

	public String toString() {
		return "PISO:" + "\n" + "\tPrecio Total: " + (this.precio + impuesto()) + "\n"
										+ "\tHabitaciones: " + this.habitaciones + "\n"
										+ "\tM2: " + this.m2 + "\n"
										+ "\tPrecio de Adquisición: " + this.precio + "\n"
										+ "\tImpuesto: " + impuesto() + "\n";
		
	}

	@Override
	public double impuesto() {
		double impuesto = 0;
		impuesto = this.precio * 0.08;
		
		return impuesto;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}
	

}
