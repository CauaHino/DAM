
public class Persona {
	int edad;
	
	public Persona(int e) {
		this.edad = e;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	 public String toString() {
		 return "PERSONA tiene " + this.edad + " años" +"\n";
	 }

}
