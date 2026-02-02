package casas;

public class Casa {
	protected double m2Casa;
	protected int habitaciones;
	
	public Casa(double m2, int hab) {
		this.m2Casa = m2;
		this.habitaciones = hab;
	}

	public double getM2Casa() {
		return m2Casa;
	}

	public void setM2Casa(double m2Casa) {
		this.m2Casa = m2Casa;
	}

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	public String toString() {
		return "\nCASA: " + "\n" + "\tMetros:" + this.m2Casa + "\n" + 
									"\tHabitaciones:" + this.habitaciones; 
	}

}
