package accionesProfesor;

import personas.Alumno;

public interface AccionesProfesor {
	/**
	 * Método que califica (pone una nota entre 0 y 10) de forma aleatoria en cada una de las asignaturas del alumno pasado por parámetro
	 * @param a --> Alumno cuyas asignaturas serán calificadas
	 */
	public void calificar(Alumno a);

}
