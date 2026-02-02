import java.util.Scanner;

import Excepciones.AgendaLlena;

		public class Main {
		    public static void main(String[] args) {
		        // Creamos la agenda con 10 huecos
		        Agenda miAgenda = new Agenda(10);

		        try {
		            miAgenda.anadirContacto(new Contacto("Javier García", 612345678));
		            miAgenda.anadirContacto(new Contacto("Maria Rodriguez", 698765432));
		            miAgenda.anadirContacto(new Contacto("Alejandro Fernández", 712233445));
		            miAgenda.anadirContacto(new Contacto("Lucía Martínez", 655443322));
		            miAgenda.anadirContacto(new Contacto("Carlos López", 600112233));
		            miAgenda.anadirContacto(new Contacto("Elena Sánchez", 912344556));
		            miAgenda.anadirContacto(new Contacto("David Pérez", 622334455));

		        } catch (AgendaLlena e) {
		            System.out.println("Error: La agenda está completa.");
		        }

		        // Probar métodos
		        miAgenda.huecosLibres();
		        miAgenda.buscarContacto("Maria Rodriguez");
		        
		        miAgenda.listarContacto();
		    }


	}


