package main;

import java.io.*;

import apuesta.Apuesta;
import clientes.*;
import evento.*;
import excepciones.SaldoInsuficiente;

public class Main {

	public static void main(String[] args) {
		Cliente clientes[] = new Cliente[5];
		
		try(BufferedReader br = new BufferedReader(new FileReader("datosClientes.txt"))) {
			String nombre = "", edad = "", dinero = "", presencial = "";
			String linea = br.readLine();
			
			for(int i = 0; i < clientes.length && linea != null; i++) {
				if("cliente".equalsIgnoreCase(linea)) {
					nombre = br.readLine();
					edad = br.readLine();
					dinero = br.readLine();
					presencial = br.readLine();
					
					if(Boolean.parseBoolean(presencial)) {
						clientes[i] = new ClientePresencial(nombre, Integer.parseInt(edad), Double.parseDouble(dinero));
					} else {
						clientes[i] = new ClienteOnline(nombre, Integer.parseInt(edad), Double.parseDouble(dinero));
					}
				}
				linea = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("=========== INFO CLIENTES ANTES DE APOSTAR ===========");
		for(Cliente c : clientes) {
			System.out.println(c);
			System.out.println("-----------------------------------------");
		}
		
		Evento eventos[] = new Evento[2];
		eventos[0] = new EventoFutebol("Barça", "Real Madrid");
		eventos[1] = new EventoTenis("Alcaraz", "Djokovic");
		
		System.out.println("=========== INFO EVENTOS ===========");
		for(Evento e : eventos) {
			System.out.println(e);
			System.out.println("-----------------------------------------");
		}
		
		Apuesta apuestas[] = new Apuesta[10];
		
		try {
			apuestas[0] = new Apuesta(true, clientes[0], 100, "Local");
			apuestas[1] = new Apuesta(false, clientes[0], 50, "Alcaraz");
			apuestas[2] = new Apuesta(true, clientes[1], 80, "Empate");
			apuestas[3] = new Apuesta(false, clientes[1], 50, "Djokovic");
			apuestas[4] = new Apuesta(true, clientes[2], 60, "Visitante");
			apuestas[5] = new Apuesta(false, clientes[2], 40, "Djokovic");
			apuestas[6] = new Apuesta(true, clientes[3], 120, "Visitante");
			apuestas[7] = new Apuesta(false, clientes[3], 70, "Alcaraz");
			apuestas[8] = new Apuesta(true, clientes[4], 200, "Local");
			apuestas[9] = new Apuesta(false, clientes[4], 140, "Djokovic");
		} catch(SaldoInsuficiente e) {
			System.err.println(e);
		}
		
		System.out.println("=========== INFO APUESTAS ===========");
		for(Apuesta a : apuestas) {
			System.out.println(a);
			System.out.println("-----------------------------------------");
		}
		
		// Asociamos las apuestas a cada evento
		for(Apuesta a : apuestas) {
			if(a.isFutbol()) {
				((EventoFutebol)eventos[0]).procesarApuesta(a);
			} else {
				((EventoTenis)eventos[1]).procesarApuesta(a);
			}
		}
		System.out.println("=========== DINERO ENTRAGADO A LOS CLIENTES(FÚTBOL) ===========");
		System.out.println(eventos[0].getDineroEntregado());
		System.out.println("=========== DINERO RECAUDADO POR LAS APUESTAS(FÚTBOL) ===========");
		System.out.println(eventos[0].getDineroRecaudado());
		
		System.out.println("=========== DINERO ENTRAGADO A LOS CLIENTES(TENIS) ===========");
		System.out.println(eventos[1].getDineroEntregado());
		System.out.println("=========== DINERO RECAUDADO POR LAS APUESTAS(TENIS) ===========");
		System.out.println(eventos[1].getDineroRecaudado());
	}

}
