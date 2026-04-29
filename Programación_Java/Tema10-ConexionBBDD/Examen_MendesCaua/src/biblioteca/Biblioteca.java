package biblioteca;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import clientes.Cliente;
import dao.*;
import excepciones.SinSuscripcion;
import recursos.Libro;
import recursos.Pelicula;
import recursos.Recurso;
import recursos.VideoJuego;

public class Biblioteca {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		BufferedReader datosEntrada = null;
		Cliente cliente = null;
		String nombre, dni, tipo;
		String titulo, autor, isbn, director, categoria, fechaEstreno, digital;
		int numDias = 0, opcion;
		Libro libro = null;
		Pelicula pelicula = null;
		VideoJuego videojuego = null;
		boolean salir = false;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Recurso> recursos = new ArrayList<Recurso>();
		ClienteDAO clienteDAO;
		LibroDAO libroDAO;
		PeliculaDAO peliculaDAO;
		RecursoDAO recursoDAO;
		VideoJuegoDAO videoJuegoDAO;
		
		

		try {
			datosEntrada = new BufferedReader(new FileReader("datosClientes.txt"));

			String linea = datosEntrada.readLine();
			while (linea != null) {
				if ("Cliente".equals(linea)) {
					nombre = datosEntrada.readLine();
					dni = datosEntrada.readLine();
					cliente = new Cliente(nombre, dni);
					tipo = datosEntrada.readLine();
					if("basic".equals(tipo)) {
						cliente.setBasic(true);
					}
					else if("estandar".equals(tipo)) {
						cliente.setBasic(true);
						cliente.setEstandar(true);
					}
					else if("premium".equals(tipo)) {
						cliente.setBasic(true);
						cliente.setEstandar(true);
						cliente.setPremium(true);
					}
					clientes.add(cliente);					
				}
				linea = datosEntrada.readLine();
			}
			System.out.println("INFORMACIÓN DE LOS CLIENTES ANTES DE TOMAR PRESTADO ALGÚN RECURSO");
			for (Cliente c : clientes)
				System.out.println(c);
			System.out.println("-------------------------------------------------------------------------------");

			datosEntrada = new BufferedReader(new FileReader("datosRecursos.txt"));
			linea = datosEntrada.readLine();
			while (linea != null) {
				if ("Libro".equals(linea)) {
					titulo = datosEntrada.readLine();
					autor = datosEntrada.readLine();
					isbn = datosEntrada.readLine();
					libro = new Libro(titulo, autor, isbn);
					recursos.add(libro);
					
					
				} else if ("Pelicula".equals(linea)) {
					titulo = datosEntrada.readLine();
					director = datosEntrada.readLine();
					fechaEstreno = datosEntrada.readLine();
					pelicula = new Pelicula(titulo, director, Date.valueOf(fechaEstreno));
					recursos.add(pelicula);
					
					
				} else if ("VideoJuego".equals(linea)) {
					titulo = datosEntrada.readLine();
					categoria = datosEntrada.readLine();
					digital = datosEntrada.readLine();
					videojuego = new VideoJuego(titulo, categoria, Boolean.valueOf(digital));
					recursos.add(videojuego);					
					
				}
				linea = datosEntrada.readLine();
			}
			System.out.println("INFORMACIÓN DE LOS RECURSOS ANTES DE SER PRESTADOS");
			for (Recurso r : recursos)
				System.out.println(r);
			System.out.println("-------------------------------------------------------------------------------");

			
			while (!salir) {
				System.out.println("1. Ubicar recursos en estantería");
				System.out.println("2. Prestar recursos(libros, películas o videojuegos) a clientes.");
				System.out.println("3. Crear tablas en base de datos");
				System.out.println("4. Guardar la información de los clientes.");
				System.out.println("5. Guardar la información de los recursos.");
				System.out.println("6. Consultar la información de los clientes con sus recursos asociados.");
				System.out.println("7. Salir de la aplicación");
				opcion = entrada.nextInt();
				entrada.nextLine();
				switch (opcion) {
				case 1:
					// Creamos la estanteria y ubicamos los recursos en ella
					Recurso[][] estanteria = new Recurso[3][3];
					for(int i = 0; i < estanteria.length; i++) {
						for(int j = 0; j < estanteria[0].length; j++) {
							for(Recurso r : recursos) {
								if(!r.isUbicado()) {
									estanteria[i][j] = r;
									r.setUbicado(true);
									break;
								}
							}
						}
					}
					break;
					
				case 2:
					// Asignamos recursos al cliente que pueda tomarlos prestados
					for(Cliente c : clientes) {
						for(Recurso r : recursos) {
							try {
								c.prestar(r, generarAleatorio(1, 7));
								for(int i = 0; i < c.getRecursos().size(); i++) {
									if(c.getRecursos().get(i).getIdRecurso() == r.getIdRecurso()) {
										r.setIdCliente(c.getIdCliente());
									}
								}
							} catch (SinSuscripcion e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}

					System.out.println("INFORMACIÓN DE LOS CLIENTES DESPUÉS DE PRESTAR");
					for (Cliente c : clientes)
						System.out.println(c);
					System.out.println("-------------------------------------------------------------------------------");
					break;
					
				case 3:
					// Creamos todas las tablas de BBDD
					clienteDAO = new ClienteDAO();
					clienteDAO.createTable();
					clienteDAO.getConexion().cerrarConexion();
					
					recursoDAO = new RecursoDAO();
					recursoDAO.createTable();
					recursoDAO.getConexion().cerrarConexion();
					
					libroDAO = new LibroDAO();
					libroDAO.createTable();
					libroDAO.getConexion().cerrarConexion();
					
					peliculaDAO = new PeliculaDAO();
					peliculaDAO.createTable();
					peliculaDAO.getConexion().cerrarConexion();
					
					videoJuegoDAO = new VideoJuegoDAO();
					videoJuegoDAO.createTable();
					videoJuegoDAO.getConexion().cerrarConexion();
					
					break;
				
				case 4:
					// Guardar la información de los clientes controlando las PRIMARY KEY
					clienteDAO = new ClienteDAO();
					ArrayList<Cliente> clientesBBDD = clienteDAO.readAll();
					for(int i = 0; i < clientesBBDD.size(); i++) {
						for(int j = 0; j < clientes.size(); j++) {
							if(clientesBBDD.get(i).getIdCliente() == clientes.get(j).getIdCliente()) {
								clientes.remove(clientes.get(j));
								j--;
							}
						}
					}
					for(Cliente c : clientes) {
						int lastID = clienteDAO.readID();
						if(lastID != 0) {
							c.setIdCliente(lastID + 1);
							clienteDAO.create(c);
						} else {
							clienteDAO.create(c);
						}
					}		
					clienteDAO.getConexion().cerrarConexion();
					break;
				
				
				case 5:
					// Guardar la información de los recursos controlando las PRIMARY KEY
					recursoDAO = new RecursoDAO();
					libroDAO = new LibroDAO();
					peliculaDAO = new PeliculaDAO();
					videoJuegoDAO = new VideoJuegoDAO();
					for(Recurso r : recursos) {
						int lastIdRecurso = recursoDAO.readId();
						if(lastIdRecurso != 0) {
							r.setIdRecurso(lastIdRecurso + 1);
						}
						recursoDAO.create(r);
						if(r instanceof Libro) {
							libroDAO.create((Libro)r);
						} else if (r instanceof Pelicula) {
							peliculaDAO.create((Pelicula) r);
						} else if(r instanceof VideoJuego) {
							videoJuegoDAO.create((VideoJuego)r);
						}
					}
					recursoDAO.getConexion().cerrarConexion();
					libroDAO.getConexion().cerrarConexion();
					peliculaDAO.getConexion().cerrarConexion();
					videoJuegoDAO.getConexion().cerrarConexion();
					break;
					
				case 6:
					// Extramos toda la información de la BBDD, creamos los objetos a partir de esa información
					// y mostramos por pantalla
					clienteDAO = new ClienteDAO();
					recursoDAO = new RecursoDAO();
					ArrayList<Cliente> clientesBBDD2 = clienteDAO.readAll();
					for(Cliente c : clientesBBDD2) {
						ArrayList<Recurso> recursosBBDD = recursoDAO.readAll(c);
						c.setRecursos(recursosBBDD);
						System.out.println(c);
					}
					clienteDAO.getConexion().cerrarConexion();
					recursoDAO.getConexion().cerrarConexion();
					
					break;
				
				case 7:
					salir = true;
					break;
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
		} finally {
			if (datosEntrada != null)
				try {
					datosEntrada.close();
					entrada.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public static int generarAleatorio(int minimo, int maximo) {
		return (int) (minimo + Math.random() * ((maximo + 1) - minimo));
	}

}
