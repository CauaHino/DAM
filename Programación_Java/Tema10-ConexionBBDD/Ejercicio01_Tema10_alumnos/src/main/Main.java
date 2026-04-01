package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.LocomotoraDAO;
import dao.PasajeroDAO;
import dao.TrenDAO;
import dao.VagonDAO;
import dao.VagonMercanciasDAO;
import dao.VagonPasajerosDAO;
import excepciones.NumAsientosNegativo;
import excepciones.PotenciaNegativa;
import locomotoras.Locomotora;
import pasajeros.Pasajero;
import trenes.Tren;
import vagones.Vagon;
import vagones.VagonMercancias;
import vagones.VagonPasajeros;

public class Main {

	public static void main(String[] args) {
		BufferedReader datosEntrada = null;
		BufferedWriter infoTrenes = null;
		String marca, modelo, tipo, potencia, numAsientos, capacidad, nombre, infoBillete;
		ArrayList<Pasajero> pasajeros = new ArrayList<>();
		ArrayList<Locomotora> locomotoras = new ArrayList<>();
		ArrayList<Vagon> vagonesPasajeros = new ArrayList<>();
		ArrayList<Vagon> vagonesMercancias = new ArrayList<>();
		ArrayList<Vagon> vagonesMixtos = new ArrayList<>();
		Tren trenes[] = new Tren[3];
		try {
			// Rellenamos los datos de los pasajeros
			datosEntrada = new BufferedReader(new FileReader("datosPasajeros.txt"));
			String linea = datosEntrada.readLine();
			while (linea != null) {
				if ("Pasajero".equals(linea)) {
					nombre = datosEntrada.readLine();
					infoBillete = datosEntrada.readLine();
					pasajeros.add(new Pasajero(nombre, infoBillete));
				}
				linea = datosEntrada.readLine();
			}
			System.out.println("INFORMACIÓN DE LOS PASAJEROS ANTES DE SUBIR AL TREN");
			System.out.println(pasajeros);
			System.out.println("-------------------------------------------------------------------------------");

			// Rellenamos los datos de vagones y locomotoras
			datosEntrada = new BufferedReader(new FileReader("datosTrenes.txt"));

			linea = datosEntrada.readLine();
			while (linea != null) {
				if ("Locomotora".equals(linea)) {
					marca = datosEntrada.readLine();
					modelo = datosEntrada.readLine();
					tipo = datosEntrada.readLine();
					potencia = datosEntrada.readLine();
					locomotoras.add(new Locomotora(marca, modelo, tipo, Double.valueOf(potencia)));

				} else if ("VagonPasajeros".equals(linea)) {
					marca = datosEntrada.readLine();
					modelo = datosEntrada.readLine();
					numAsientos = datosEntrada.readLine();
					vagonesPasajeros.add(new VagonPasajeros(marca, modelo, Integer.valueOf(numAsientos)));

				} else if ("VagonMercancias".equals(linea)) {
					marca = datosEntrada.readLine();
					modelo = datosEntrada.readLine();
					capacidad = datosEntrada.readLine();
					vagonesMercancias.add(new VagonMercancias(marca, modelo, Double.valueOf(capacidad)));
					vagonesMixtos.add(new VagonMercancias(marca, modelo, Double.valueOf(capacidad)));
				}
				linea = datosEntrada.readLine();
			}
			// Mostramos la información de las locomotoras y vagones
			System.out.println("INFORMACIÓN DE LAS LOCOMOTORAS");
			for (Locomotora l : locomotoras)
				System.out.println(l);
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("INFORMACIÓN DE LOS VAGONES DE PASAJEROS");
			for (Vagon vp : vagonesPasajeros) {
				System.out.println(vp);
			}
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("INFORMACIÓN DE LOS VAGONES DE MERCANCÍAS");
			for (Vagon vm : vagonesMercancias) {
				System.out.println(vm);
			}
			System.out.println("-------------------------------------------------------------------------------");

			// Asignamos los pasajeros a los vagones de pasajeros
			for (Pasajero pa : pasajeros) {
				for (Vagon va : vagonesPasajeros) {
					((VagonPasajeros) va).agregarPasajeros(pa);
				}
			}
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("INFORMACIÓN DE LOS VAGONES DE PASAJEROS DESPUÉS DE SUBIR PASAJEROS");
			for (Vagon vp : vagonesPasajeros) {
				System.out.println(vp);
			}

			// Elimino los vagones de pasajeros que no llevan pasajeros y los añado al mixto
			 for (int i = 0; i < vagonesPasajeros.size(); i++) {
			//for (Vagon vp : vagonesPasajeros) {
				 if (((VagonPasajeros)vagonesPasajeros.get(i)).getPasajeros().size() == 0) {
				//if (((VagonPasajeros) vp).getNumPasajeros() == 0) {
					vagonesMixtos.add(vagonesPasajeros.get(i));
					vagonesPasajeros.remove(vagonesPasajeros.get(i));
				}

			}

			/*
			 * System.out.println("INFORMACIÓN DE LAS LOCOMOTORAS");
			 * System.out.println(locomotoras); System.out.println(
			 * "-------------------------------------------------------------------------------"
			 * ); System.out.println();
			 * System.out.println("INFORMACIÓN DE LOS VAGONES DE PASAJEROS");
			 * System.out.println(vagonesPasajeros); System.out.println(
			 * "-------------------------------------------------------------------------------"
			 * ); System.out.println();
			 * System.out.println("INFORMACIÓN DE LOS VAGONES DE MERCANCÍAS");
			 * System.out.println(vagonesMercancias);
			 */
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("INFORMACIÓN DE LOS VAGONES DE MIXTOS");
			System.out.println(vagonesMixtos);
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println();

			//Tren trenes[] = new Tren[3];

			// FORMA ADECUADA
			Locomotora locElectrica = null;
			Locomotora locDiesel = null;
			for (Locomotora l : locomotoras) {
				if ("Eléctrica".equals(l.getTipo())) {
					locElectrica = l;
				} else {
					locDiesel = l;
				}
			}
			trenes[0] = new Tren(locDiesel, vagonesPasajeros);
			trenes[0].setTipo("Pasajeros");
			trenes[1] = new Tren(locElectrica, vagonesMercancias);
			trenes[1].setTipo("Mercancías");
			trenes[2] = new Tren(locElectrica, vagonesMixtos);
			trenes[2].setTipo("Mixto");

			System.out.println("INFORMACIÓN DE LOS PASAJEROS DESPUÉS DE SUBIR AL TREN");
			System.out.println(pasajeros);
			System.out.println("-------------------------------------------------------------------------------");

			System.out.println("INFORMACIÓN DE LOS TRENES");
			for (Tren t : trenes) {
				System.out.println(t);
			}

			// Guardamos la información de los trenes en un fichero externo
			infoTrenes = new BufferedWriter(new FileWriter("informacionTrenes.txt"));
			for (Tren t : trenes) {
				infoTrenes.write("TREN: \tID: " + t.getIdentificador());
				infoTrenes.newLine();
				infoTrenes.write("\t" + t.getLocomotora().toString());
				infoTrenes.newLine();
				for (Vagon v : t.getVagones()) {
					infoTrenes.write("\t" + v);
					infoTrenes.newLine();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PotenciaNegativa e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		} catch (NumAsientosNegativo e) {
			// TODO Auto-generated catch block
			System.err.println(e);
		} finally {
			if (datosEntrada != null && infoTrenes != null) {
				try {
					datosEntrada.close();
					infoTrenes.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		// INTERACCIÓN CON BBDD
		Scanner entrada = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		PasajeroDAO pasajeroDAO = null;
		LocomotoraDAO locomotoraDAO = null;
		VagonDAO vagonDAO = null;
		VagonPasajerosDAO vagonPasajerosDAO = null;
		VagonMercanciasDAO vagonMercanciasDAO = null;
		TrenDAO trenDAO = null;
		ArrayList<Pasajero> pasajerosBBDD = null;
		while(!salir) {
			System.out.println("1. Guardar la información de los pasajeros");
			System.out.println("2. Guardar la información de las locomotoras");
			System.out.println("3. Guardar la información de los vagones");
			System.out.println("4. Guardar la información de los trenes");
			System.out.println("5. Consultar la información de los pasajeros");
			System.out.println("6. Consultar la información de los trenes");
			System.out.println("7. Crear tablas en base de datos");
			System.out.println("8. Salir de la aplicación");
			opcion = entrada.nextInt();
			switch(opcion) {
			case 1:
				pasajeroDAO = new PasajeroDAO();
				// Guardo todos los pasajeros de BBDD en un ArrayList
				pasajerosBBDD = pasajeroDAO.readAll();
				// Elimino aquellos pasajeros cuyo idPasajero ya exista en BBDD
				for(int i = 0; i < pasajerosBBDD.size(); i++)
					for(int j = 0; j < pasajeros.size(); j++)
						if(pasajerosBBDD.get(i).getIdPasajero() == 
							pasajeros.get(j).getIdPasajero())
							pasajeros.remove(j);
				
				for(Pasajero p : pasajeros)			
					pasajeroDAO.create(p);
				
				pasajeroDAO.getConexion().cerrarConexion();
				break;
			case 2:
				locomotoraDAO = new LocomotoraDAO();
				ArrayList<Integer> idsLocomotoras = locomotoraDAO.readAll();
				for(int i = 0; i < idsLocomotoras.size(); i++)
					for(int j = 0; j < locomotoras.size(); j++)
						if(idsLocomotoras.get(i) == 
								locomotoras.get(j).getIdLocomotora())
							locomotoras.remove(j);
				for(Locomotora loc : locomotoras) {
					locomotoraDAO.create(loc);
				}
				locomotoraDAO.getConexion().cerrarConexion();
				break;
			case 3:
				vagonDAO = new VagonDAO();
				vagonMercanciasDAO = new VagonMercanciasDAO();
				vagonPasajerosDAO = new VagonPasajerosDAO();
				ArrayList<Integer> idsVagon = vagonDAO.readAll();
				for(int i= 0; i < idsVagon.size(); i++) {
					for(int j = 0; j < vagonesMercancias.size(); j++) {
						if(idsVagon.get(i) == vagonesMercancias.get(j).getIdentificador()) {
							vagonesMercancias.remove(j);
						}
					}
				}
				for(int i= 0; i < idsVagon.size(); i++) {
					for(int j = 0; j < vagonesPasajeros.size(); j++) {
						if(idsVagon.get(i) == vagonesPasajeros.get(j).getIdentificador()) {
							vagonesPasajeros.remove(j);
						}
					}
				}
				for(int i= 0; i < idsVagon.size(); i++) {
					for(int j = 0; j < vagonesMixtos.size(); j++) {
						if(idsVagon.get(i) == vagonesMixtos.get(j).getIdentificador()) {
							vagonesMixtos.remove(j);
						}
					}
				}
				for(Vagon vm : vagonesMercancias) {
					vagonDAO.create(vm);
					vagonMercanciasDAO.create((VagonMercancias)vm);
				}
				for(Vagon vp : vagonesPasajeros) {
					vagonDAO.create(vp);
					vagonPasajerosDAO.create((VagonPasajeros)vp);
				}
				for(Vagon vmix : vagonesMixtos) {
					vagonDAO.create(vmix);
					if(vmix instanceof VagonMercancias) {
						vagonMercanciasDAO.create((VagonMercancias)vmix);
					}
					else if(vmix instanceof VagonPasajeros) {
						vagonPasajerosDAO.create((VagonPasajeros)vmix);
					}
				}
				vagonDAO.getConexion().cerrarConexion();
				vagonMercanciasDAO.getConexion().cerrarConexion();
				vagonPasajerosDAO.getConexion().cerrarConexion();
				break;
			case 4:
				trenDAO = new TrenDAO();
				ArrayList<Integer> idsTrenes = trenDAO.readAll();
				for(int i = 0; i < idsTrenes.size(); i++) {
					for(int j = 0; j < trenes.length; j++) {
						if(trenes[j] != null && idsTrenes.get(i) == trenes[j].getIdentificador())
							trenes[j] = null;
					}
				}
				// Insertar en tabla Tren y TrenLocomotoraVagon
				for(Tren t : trenes) {
					trenDAO.create(t);
					trenDAO.insertTernaria(t);
				}
				trenDAO.getConexion().cerrarConexion();
				break;
			case 5:
				pasajeroDAO = new PasajeroDAO();
				pasajerosBBDD = pasajeroDAO.readAll();
				for(Pasajero p : pasajerosBBDD)
					System.out.println(p);
				
				pasajeroDAO.getConexion().cerrarConexion();
				break;
			case 6:
				trenDAO = new TrenDAO();
				vagonDAO = new VagonDAO();
				locomotoraDAO = new LocomotoraDAO();
				pasajeroDAO = new PasajeroDAO();
				ArrayList<Tren> trenesBBDD = trenDAO.readTrenes();
				for(Tren t : trenesBBDD) {
					Locomotora locomotora = locomotoraDAO.readLocomotora(t.getIdentificador());
					t.setLocomotora(locomotora);
					ArrayList<Vagon> vagonesPasajerosBBDD = vagonDAO.readVagonesPasajeros(t.getIdentificador());
					for(Vagon v : vagonesPasajerosBBDD) {
						pasajerosBBDD = pasajeroDAO.readPasajeros(v.getIdentificador());
						((VagonPasajeros)v).setPasajeros(pasajerosBBDD);
					}
					ArrayList<Vagon> vagonesMercanciaBBDD = vagonDAO.readVagonesMercancia(t.getIdentificador());
					t.setLocomotora(locomotora);
					ArrayList<Vagon> vagonesMixtosBBDD = vagonDAO.readVagonesMixtos(t.getIdentificador());
					if("pasajeros".equalsIgnoreCase(t.getTipo())) {
						t.setVagones(vagonesPasajerosBBDD);
					} else if("mercancías".equalsIgnoreCase(t.getTipo())) {
						t.setVagones(vagonesMercanciaBBDD);
					} else {
						// t.setVagones(vagonesPasajerosBBDD);
						// t.getVagones().addAll(vagonesMercanciaBBDD);
						t.setVagones(vagonesMixtosBBDD);
					}
					System.out.println(t);
				}
				
				
				pasajeroDAO.getConexion().cerrarConexion();
				locomotoraDAO.getConexion().cerrarConexion();
				vagonDAO.getConexion().cerrarConexion();
				trenDAO.getConexion().cerrarConexion();
				break;
			case 7:
				locomotoraDAO = new LocomotoraDAO();
				locomotoraDAO.createTable();
				locomotoraDAO.getConexion().cerrarConexion();
				
				vagonDAO = new VagonDAO();
				vagonDAO.createTable();
				vagonDAO.getConexion().cerrarConexion();
				
				vagonMercanciasDAO = new VagonMercanciasDAO();
				vagonMercanciasDAO.createTable();
				vagonMercanciasDAO.getConexion().cerrarConexion();
				
				vagonPasajerosDAO = new VagonPasajerosDAO();
				vagonPasajerosDAO.createTable();
				vagonPasajerosDAO.getConexion().cerrarConexion();
				
				pasajeroDAO = new PasajeroDAO();
				pasajeroDAO.createTable();
				pasajeroDAO.getConexion().cerrarConexion();
				
				trenDAO = new TrenDAO();
				trenDAO.createTable();
				trenDAO.createTableTrenLocVagon();
				trenDAO.getConexion().cerrarConexion();
				break;
			case 8:
				salir = true;
				break;
			}
		}
	}

}
