package Aula;

import java.util.Arrays;
import java.util.Comparator;

import Alumno.Alumno;

public class Aula {
    // Atributos
    private static int contadorId = 0;
    private final int identificador; 
    private Alumno[] alumnos;
    private int capacidadMaxima;
    private int numeroAlumnosActual = 0; 
    private Alumno[] [] alumnosMatriz;

    // Constructor
    public Aula(int capacidadMaxima) {
        this.identificador = ++contadorId;
        this.capacidadMaxima = capacidadMaxima;
        this.alumnos = new Alumno[capacidadMaxima];
    }
    public Aula(int maxFilas, int maxColumnas) {
	contadorId++;
	this.identificador = contadorId;
	alumnosMatriz = new Alumno [maxFilas] [maxColumnas];
	this.numeroAlumnosActual = 0;
}

    public Alumno[][] getAlumnosMatriz() {
		return alumnosMatriz;
	}
	public void setAlumnosMatriz(Alumno[][] alumnosMatriz) {
		this.alumnosMatriz = alumnosMatriz;
	}
	public int numeroAlumnos() {
        return this.numeroAlumnosActual;
    }

    public void entraAlumno(Alumno alumno) {
        if (numeroAlumnosActual < capacidadMaxima) {
            this.alumnos[numeroAlumnosActual] = alumno;
            this.numeroAlumnosActual++;
          
        } else {
            System.out.println("El Aula " + this.identificador + " está llena. No puede entrar " + alumno.dameNombre());
           
        }
    }

   
    public void saleAlumno(String nombre) {
        for (int i = 0; i < numeroAlumnosActual; i++) {
            if (this.alumnos[i] != null && this.alumnos[i].dameNombre().equals(nombre)) {
                System.out.println("Salió el alumno: " + this.alumnos[i].dameNombre() + " " + this.alumnos[i].dameApellidos());
                
                for (int j = i; j < numeroAlumnosActual - 1; j++) {
                    this.alumnos[j] = this.alumnos[j+1];
                }
                
                // Pone el último elemento (que ahora está duplicado o es el hueco libre original) a null
                this.alumnos[numeroAlumnosActual - 1] = null;
                this.numeroAlumnosActual--;
            }
        }
        System.out.println("No se encontró ningún alumno con el nombre: " + nombre + " en el Aula " + this.identificador);
    }

    /**
     * Muestra la lista de alumnos en el aula.
     */
    public void mostrarAlumnos() {
        System.out.println("\n*** Listado de Alumnos en Aula ID: " + this.identificador + " (Capacidad: " + this.capacidadMaxima + ", Actual: " + this.numeroAlumnosActual + ") ***");
        if (numeroAlumnosActual == 0) {
            System.out.println("No hay alumnos en esta aula.");
        } else {
            for (int i = 0; i < numeroAlumnosActual; i++) {
                // Se asegura de que no imprime nulls
                if (this.alumnos[i] != null) {
                    alumnos[i].toString();
                    
                    
                }
            }
        }
    }

    /**
     * Ordena los alumnos por apellidos de forma ascendente.
     */
    public void ordenarAlumnos() {
        // Se crea un array temporal con solo los alumnos que hay (sin nulls)
        Alumno[] alumnosPresentes = new Alumno[numeroAlumnosActual];
        System.arraycopy(alumnos, 0, alumnosPresentes, 0, numeroAlumnosActual);
        
        // Se utiliza la clase Arrays y un Comparator para ordenar
        Arrays.sort(alumnosPresentes, Comparator.comparing(Alumno::dameApellidos));
        
        // Se copian los alumnos ordenados de vuelta al array principal
        System.arraycopy(alumnosPresentes, 0, alumnos, 0, numeroAlumnosActual);
        System.out.println("Alumnos del Aula " + this.identificador + " ordenados por apellidos.");
    }
    
    // Getter para el identificador (necesario para la clase Instituto)
    public int dameIdentificador() {
        return this.identificador;
    }
}