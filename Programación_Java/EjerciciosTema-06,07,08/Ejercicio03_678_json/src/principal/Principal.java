package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.*;
import apuestas.Apuesta;
import clientes.Cliente;
import clientes.ClienteOnline;
import clientes.ClientePresencial;
import eventos.Evento;
import eventos.EventoFutbol;
import eventos.EventoTenis;
import excepciones.SaldoInsuficiente;

public class Principal {

	public static void main(String[] args) {
		Cliente clientes[] = new Cliente[5];
		BufferedReader infoClientes = null;
		try {
			infoClientes = new BufferedReader(new FileReader("datosClientes.json"));
			String nombre ="";
			int edad=0;
			double dinero=0;
			boolean presencial = false;
			
			JsonArray jsonArray = JsonParser.parseReader(infoClientes).getAsJsonArray();

			// Para cada elemento del array
			for (int i = 0; i < jsonArray.size() || i < clientes.length; i++) {

				// Obtenemos el JsonObject del JSONArray
				JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
				nombre = jsonObject.get("nombre").getAsString();
				edad = jsonObject.get("edad").getAsInt();
				dinero = jsonObject.get("dinero").getAsDouble();
				presencial = jsonObject.get("presencial").getAsBoolean();
				if(presencial) {
					clientes[i] = new ClientePresencial(nombre, edad, dinero);
				}
				else {
					clientes[i] = new ClienteOnline(nombre, edad, dinero);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(infoClientes != null) {
				try {
					infoClientes.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("INFORMACIÓN DE LOS CLIENTES ANTES DE APOSTAR");
		for(Cliente c : clientes)
			System.out.println(c);
		System.out.println("-----------------------------------------------------------------");
		// Genero los 2 eventos que habrá
		Evento eventos[] = new Evento[2];
		eventos[0] = new EventoFutbol("Barça", "Real Madrid");
		eventos[1] = new EventoTenis("Alcaraz", "Djokovic");
		System.out.println("INFORMACIÓN DE LOS EVENTOS");
		for(Evento e : eventos)
			System.out.println(e);
		System.out.println("-----------------------------------------------------------------");
		
		Apuesta apuestas[] = new Apuesta[10];
		try {
			apuestas[0] = new Apuesta(true, clientes[0], 100, "1");
			apuestas[1] = new Apuesta(false, clientes[0], 50, "Alcaraz");
			apuestas[2] = new Apuesta(true, clientes[1], 80, "X");
			apuestas[3] = new Apuesta(false, clientes[1], 50, "Djokovic");
			apuestas[4] = new Apuesta(true, clientes[2], 60, "2");
			apuestas[5] = new Apuesta(false, clientes[2], 40, "Djokovic");
			apuestas[6] = new Apuesta(true, clientes[3], 120, "2");
			apuestas[7] = new Apuesta(false, clientes[3], 70, "Alcaraz");
			apuestas[8] = new Apuesta(true, clientes[4], 200, "1");
			apuestas[9] = new Apuesta(false, clientes[4], 140, "Djokovic");
		} catch (SaldoInsuficiente e1) {
			System.err.println(e1);
		}
		System.out.println("INFORMACIÓN DE LAS APUESTAS");
		for(Apuesta a : apuestas)
			System.out.println(a);
		System.out.println("-----------------------------------------------------------------");
		// Asociamos las apuestas a cada evento
		for(Apuesta a : apuestas) {
			if(a.isFutbol()) {
				((EventoFutbol)eventos[0]).procesarApuesta(a);
			}
			else {
				((EventoTenis)eventos[1]).procesarApuesta(a);
			}
		}
		System.out.println("Dinero ENTREGADO a los clientes por las apuestas en eventos de FÚTBOL: "+eventos[0].getDineroEntregado()+" €");
		//System.out.println(eventos[0].getDineroEntregado());
		System.out.println("Dinero RECAUDADO por las apuestas en eventos de FÚTBOL: "+eventos[0].getDineroRecaudado()+" €");
		//System.out.println(eventos[0].getDineroRecaudado());
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Dinero ENTREGADO a los clientes por las apuestas en eventos de TENIS: "+eventos[1].getDineroEntregado()+ " €");
		//System.out.println(eventos[1].getDineroEntregado());
		System.out.println("Dinero RECAUDADO por las apuestas en eventos de TENIS: "+eventos[1].getDineroRecaudado()+" €");
		//System.out.println(eventos[1].getDineroRecaudado());
		System.out.println("-----------------------------------------------------------------");
		System.out.println("INFORMACIÓN DE LOS CLIENTES DESPUÉS DE APOSTAR");
		for(Cliente c : clientes)
			System.out.println(c);
		System.out.println("-----------------------------------------------------------------");
	}

}
