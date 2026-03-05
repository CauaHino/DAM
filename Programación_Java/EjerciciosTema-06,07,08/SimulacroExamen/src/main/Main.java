package main;

import java.io.*;

import Personas.*;
import cine.Cine;
import excepciones.EdadRecomendada;
import peliculas.Pelicula;

public class Main {

	public static void main(String[] args) {
		Cine cine = new Cine(4, 4, null, 2);
		Espectadores[] espectadores = new Espectadores[16];
		Director director = null;

		try (BufferedReader br = new BufferedReader(new FileReader("datosPersonas.txt"))) {
			String linea = "", nombre = "", edad = "", dinero = "", numFilmes = "";
			linea = br.readLine();

			for (int i = 0; i < espectadores.length + 1 && linea != null; i++) {
				if ("Espectador".equalsIgnoreCase(linea)) {
					nombre = br.readLine();
					edad = br.readLine();
					dinero = br.readLine();

					espectadores[i] = new Espectadores(nombre, Integer.parseInt(edad), Double.parseDouble(dinero));
				} else if ("Director".equalsIgnoreCase(linea)) {
					nombre = br.readLine();
					edad = br.readLine();
					numFilmes = br.readLine();

					director = new Director(nombre, Integer.parseInt(edad), Integer.parseInt(numFilmes));
				}
				linea = br.readLine();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader("datosPelicula.txt"))) {
			String linea = "", nombre = "", genero = "", edadMinima = "";
			linea = br.readLine();

			while (linea != null) {
				if ("Pelicula".equalsIgnoreCase(linea)) {
					nombre = br.readLine();
					genero = br.readLine();
					edadMinima = br.readLine();

					Pelicula p = new Pelicula(nombre, genero, director, Integer.parseInt(edadMinima));
					cine.setPelicula(p);
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

		try {
			double dineroRecaudado= 0;
			for (int i = cine.getAsientos().length - 1; i >= 0; i--) {
				for (int j = 0; j < cine.getAsientos()[0].length; j++) {
					for(Espectadores e : espectadores)
					if (cine.puedeEntrar(e)) {
						cine.sentar(i, j, e);
						dineroRecaudado += cine.getPrecioEntrada();
						cine.setDineroRecaudado(dineroRecaudado);
					}
					break;
				}
			}
		} catch (EdadRecomendada e) {
			System.err.println(e);
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("InfoCine.txt"))){
			bw.write(cine.escribirInfo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
