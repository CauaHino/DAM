package Alumno;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Year;

public class Alumno {
    // Atributos
    private static int contadorId = 0;
    private final int identificador; // Identificador único
    private String nombre;
    private String apellidos;
    private String dni;
    private int edad;

    
    public Alumno() {
        this.identificador = ++contadorId;
       
    }

    // Constructor parametrizado
    public Alumno(String nombre, String apellidos, String dni, int edad) {
        this.identificador = ++contadorId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
    }

    // --- Métodos de caracteres ---

    /**
     * Devuelve el número de caracteres del nombre.
     */
    public int nCaracteresNombre() {
        return this.nombre.length();
    }

    /**
     * Devuelve el número de caracteres del apellido.
     */
    public int nCaracteresApellidos() {
        return this.apellidos.length();
    }

    /**
     * Convierte el nombre y apellidos a mayúsculas.
     */
    public void convertirMayusculas() {
        this.nombre = this.nombre.toUpperCase();
        this.apellidos = this.apellidos.toUpperCase();
    }

    /**
     * Convierte el nombre y apellidos a minúsculas.
     */
    public void convertirAMinusculas() {
        this.nombre = this.nombre.toLowerCase();
        this.apellidos = this.apellidos.toLowerCase();
    }

    // --- Método de fecha de nacimiento ---

    /**
     * Calcula y devuelve el año de nacimiento del alumno.
     * Asume que la edad es correcta para el año actual.
     */
    public int anoNacimiento() {
        // Obtenemos el año actual
        int anoActual = Year.now().getValue();
        // El año de nacimiento es el año actual menos la edad
        return anoActual - this.edad;
    }

    // --- Métodos para obtener/modificar atributos (Dame/Modifica Atributo) ---

    // Nombre
    public String dameNombre() { return this.nombre; }
    public void modificaNombre(String nombre) { this.nombre = nombre; }

    // Apellidos
    public String dameApellidos() { return this.apellidos; }
    public void modificaApellidos(String apellidos) { this.apellidos = apellidos; }

    // DNI
    public String dameDni() { return this.dni; }
    public void modificaDni(String dni) { this.dni = dni; }

    // Edad
    public int dameEdad() { 
    	return this.edad;
    }
    public String toString() {
        return "--- Información del Alumno ---\n" +
               "ID: " + this.identificador + "\n" +
               "Nombre: " + this.nombre + " (" + nCaracteresNombre() + " caracteres)\n" +
               "Apellidos: " + this.apellidos + " (" + nCaracteresApellidos() + " caracteres)\n" +
               "DNI: " + this.dni + "\n" +
               "Edad: " + this.edad + "\n" +
               "Año de Nacimiento (Estimado): " + anoNacimiento() + "\n" +
               "------------------------------";
    }

	public int getIdentificador() {
		return identificador;
	}
}
    
    