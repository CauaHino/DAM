package main;

import java.io.*;
import java.util.*;

import apuesta.Apuesta;
import clientes.*;
import evento.*;
import excepciones.SaldoInsuficiente;

public class Main {

	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader("datosClientes.txt"))) {
			String nombre = "", edad = "", dinero = "", presencial = "";
			String linea = br.readLine();
			
			while(linea != null) {
				if("cliente".equalsIgnoreCase(linea)) {
					nombre = br.readLine();
					edad = br.readLine();
					dinero = br.readLine();
					presencial = br.readLine();
					
					if(Boolean.parseBoolean(presencial)) {
						clientes.add(new ClientePresencial(nombre, Integer.parseInt(edad), Double.parseDouble(dinero)));
					} else {
						clientes.add(new ClienteOnline(nombre, Integer.parseInt(edad), Double.parseDouble(dinero)));
					}
				}
				linea = br.readLine();
			}
				linea = br.readLine();
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
		
		ArrayList<Evento> eventos = new ArrayList<>();
		eventos.add(new EventoFutebol("Barça", "Real Madrid"));
		eventos.add(new EventoTenis("Alcaraz", "Djokovic"));
		
		System.out.println("=========== INFO EVENTOS ===========");
		for(Evento e : eventos) {
			System.out.println(e);
			System.out.println("-----------------------------------------");
		}
		
		ArrayList<Apuesta> apuestas = new ArrayList<>();
		
		try {
			apuestas.add(new Apuesta(true, clientes.get(0), 100, "Local"));
			apuestas.add(new Apuesta(false, clientes.get(0), 50, "Alcaraz"));
			apuestas.add(new Apuesta(true, clientes.get(1), 80, "Empate"));
			apuestas.add(new Apuesta(false, clientes.get(1), 50, "Djokovic"));
			apuestas.add(new Apuesta(true, clientes.get(2), 60, "Visitante"));
			apuestas.add(new Apuesta(false, clientes.get(2), 40, "Djokovic"));
			apuestas.add(new Apuesta(true, clientes.get(3), 120, "Visitante"));
			apuestas.add(new Apuesta(false, clientes.get(3), 70, "Alcaraz"));
			apuestas.add(new Apuesta(true, clientes.get(4), 200, "Local"));
			apuestas.add(new Apuesta(false, clientes.get(4), 140, "Djokovic"));
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
				((EventoFutebol)eventos.get(0)).procesarApuesta(a);
			} else {
				((EventoTenis)eventos.get(1)).procesarApuesta(a);
			}
		}
		System.out.println("=========== DINERO ENTRAGADO A LOS CLIENTES(FÚTBOL) ===========");
		System.out.println(eventos.get(0).getDineroEntregado());
		System.out.println("=========== DINERO RECAUDADO POR LAS APUESTAS(FÚTBOL) ===========");
		System.out.println(eventos.get(0).getDineroRecaudado());
		
		System.out.println("=========== DINERO ENTRAGADO A LOS CLIENTES(TENIS) ===========");
		System.out.println(eventos.get(1).getDineroEntregado());
		System.out.println("=========== DINERO RECAUDADO POR LAS APUESTAS(TENIS) ===========");
		System.out.println(eventos.get(1).getDineroRecaudado());
	}

}
