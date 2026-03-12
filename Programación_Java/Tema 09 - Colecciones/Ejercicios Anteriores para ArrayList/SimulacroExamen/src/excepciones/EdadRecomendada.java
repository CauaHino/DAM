package excepciones;

public class EdadRecomendada extends Exception{
	public int id;
	public String name;
	public int edad;
	
	public EdadRecomendada(int id, String name, int edad) {
		this.id = id;
		this.name = name;
		this.edad = edad;
	}
	
	public String toString() {
		return "El espectador con ID: " + this.id + " , nombre: " + this.name + " con "+ this.edad + " años, no tiene la edad mínima recomendada para ver la película.";
	}

}
