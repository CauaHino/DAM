package Instituto;

import Alumno.Alumnos;

public class Instituto {
	private String nombre, direccion, localidad;
	private Alumnos alumno;
	private static int CONTADOR = 0;
	private int id;
	
	public Instituto (String n, String d, String l, int id, Alumnos alumno) {
		this.nombre = n;
		this.direccion = d;
		this.localidad = l;
		this.id = CONTADOR++;
		this.alumno = alumno;
	}
	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getId() {
        return id;
    }
  
    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }
    public void mostrarInfo() {
        System.out.println("\n===== Información del Instituto =====");
        System.out.println("ID del Instituto: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Dirección: " + this.direccion);
        System.out.println("Localidad: " + this.localidad);
        
        System.out.println("\n--- Alumno Asociado ---");
    }
}
