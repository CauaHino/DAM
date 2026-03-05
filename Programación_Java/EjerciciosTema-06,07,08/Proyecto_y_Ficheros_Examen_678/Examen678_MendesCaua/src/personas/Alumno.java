package personas;

import asignaturas.Asignatura;
import excepciones.MenorDeEdad;

public class Alumno extends Persona{
	private static int contador;
	private int idAlumno;
	private Asignatura[] asignaturas;
	private int numAsig;
	
	public Alumno(String nombre, String apellidos, int edad, String curso, int cantidadAsig) throws MenorDeEdad {
		super(nombre, apellidos, edad, curso);
		contador++;
		this.idAlumno = contador;
		this.asignaturas = new Asignatura[cantidadAsig];
		numAsig = 0;
	}
	
	public String infoAsignaturas() {
		String info = "";
		for(Asignatura a : this.asignaturas) {
			if(a != null) {
				info +=  "\n" +a.toString() + "\t";
			}
		}
		return info;
	}


	@Override
	public String toString() {
		return "ALUMNO: \n"+
				"\tID: " + this.idAlumno + " \n" + 
				"\tCurso: "+this.curso +" \n"+
				"\tNombre: "+this.nombre+"\n"+
				"\tApellidos: "+this.apellidos+" \n"+
				"\tEdad: "+this.edad+" años\n"+
				"\tMatriculado en: \n"+(this.infoAsignaturas().equals("1º") ? "" : this.infoAsignaturas());
	}

	public Asignatura[] getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Asignatura asignaturas) {
			this.asignaturas[numAsig] = new Asignatura(asignaturas.getNombre(), asignaturas.getCurso(), asignaturas.getProfesor() );
			numAsig++;
		}

	public int getIdAlumno() {
		return idAlumno;
	}
	
	
	

}
