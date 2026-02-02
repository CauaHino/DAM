package main;

import Directivo.Directivo;
import Oficial.Oficial;
import Persona.Persona;
import Tecnicos.Tecnicos;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GESTIÓN DE EMPLEADOS ---\n");

        // 1. Crear 2 empleados que sean socios y 1 que no lo sea (Usamos clase Directivo)
        Directivo d1 = new Directivo("Laura", "Gonzalez", 18,"TechCorp", 5000, true);
        Directivo d2 = new Directivo("Carlos", "Gutierrez", 25,"TechCorp", 5200, true);
        Directivo d3 = new Directivo("Ana", "Mendez", 30,"TechCorp", 3000, false); // No es socio

        // 2. Crear 2 empleados con más de 15 años en la empresa (Usamos clase Oficial)
        // El enunciado dice > 15, Oficial es > 10, así que cumple.
        Oficial o1 = new Oficial("Pepe","Gonzalez",  16,"Construcciones SA", 2000, 5);
        Oficial o2 = new Oficial("Marta","Gonzalez", 20,"Construcciones SA", 2100, 0);

        // 3. Crear 2 empleados con 10 años en la empresa (Usamos clase Tecnico)
        // Tecnico es <= 10, así que 10 entra aquí.
        Tecnicos t1 = new Tecnicos("Luis","Santiago",1500, "Reparaciones SL", 10, 0);
        Tecnicos t2 = new Tecnicos("Sofia", "Santiago",1450, "Reparaciones SL", 2, 0);

        // 4. Crear 1 persona que no sea empleado
        Persona p1 = new Persona("Jaimito", "Perez", 12); // Un niño, no puede trabajar legalmente

        // --- IMPRESIÓN DE RESULTADOS ---
        
        System.out.println("--- DIRECTIVOS (Socios y No Socios) ---");
        System.out.println(d1.toString());
        System.out.println(d2.toString());
        System.out.println(d3.toString());

        System.out.println("\n--- OFICIALES (> 10 años antigüedad) ---");
        System.out.println(o1.toString());
        System.out.println(o2.toString());

        System.out.println("\n--- TÉCNICOS (<= 10 años antigüedad) ---");
        System.out.println(t1.toString());
        System.out.println(t2.toString());

        System.out.println("\n--- NO EMPLEADOS ---");
        System.out.println(p1.toString());
    }
}