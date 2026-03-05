package personas;

import accionesProfesor.AccionesProfesor;
import asignaturas.Asignatura;
import excepciones.MenorDeEdad;

public class Profesor extends Persona implements AccionesProfesor {
	private static int contador;
	private int idProfesor;

	public Profesor(String nombre, String apellidos, int edad, String curso) throws MenorDeEdad {
		super(nombre, apellidos, edad, curso);
		contador++;
		this.idProfesor = contador;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\t\tPROFESOR: \n" + "\t\t\tID: " + this.idProfesor + "\n" + "\t\t\tCurso: " + this.curso + "\n"
				+ "\t\t\tNombre: " + this.nombre + "\n" + "\t\t\tApellidos: " + this.apellidos + "\n" + "\t\t\tEdad: "
				+ this.edad + " años\n";
	}

	@Override
	public void calificar(Alumno a) {
		for (Asignatura asig : a.getAsignaturas()) {
			if (asig != null) {
				asig.setCalificacion((int) (Math.random() * 10) + 1);
			}
		}
	}

	public int getIdProfesor() {
		return idProfesor;
	}

}
