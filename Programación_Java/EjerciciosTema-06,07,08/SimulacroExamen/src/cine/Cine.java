package cine;

import Personas.Espectadores;
import accionesCine.AccionesCine;
import asientos.Asientos;
import excepciones.EdadRecomendada;
import peliculas.Pelicula;

public class Cine implements AccionesCine {
	private int id;
	private static int contador;
	private Asientos[][] asientos;
	private Pelicula pelicula;
	private double precioEntrada;
	private int numAsientos;
	private double dineroRecaudado;

	public Cine(int fila, int columna, Pelicula pelicula, int precioEntrada) {
		contador++;
		this.id = contador;
		this.asientos = new Asientos[fila][columna];
		this.pelicula = pelicula;
		this.precioEntrada = precioEntrada;
		this.numAsientos = fila * columna;
		this.dineroRecaudado = 0;
		colocarAsientos();
	}

	@Override
	public boolean haySitio() {
		if (numAsientos > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean puedeEntrar(Espectadores e) throws EdadRecomendada {
		if (this.haySitio() == true && e.pagar(this.precioEntrada)) {
			if (pelicula.getEdadMinima() <= e.getEdad()) {
				return true;
			} else {
				throw new EdadRecomendada(e.getId(), e.getNombre(), e.getEdad());
			}
		}
		return false;
	}

	@Override
	public void sentar(int fila, int columna, Espectadores e) {
			asientos[fila][columna].setEspectador(e);
			e.setEstaSentado(true);
			numAsientos--;

	}

	private void colocarAsientos() {
		for (int i = asientos.length - 1; i >= 0; i--) {
			for (int j = 0; j < asientos[0].length; j++) {
				asientos[i][j] = new Asientos(i, j);
			}
		}
	}

	public void mostrarInfo() {
		System.out.println("INFORMACIÓN DEL CINE");
		System.out.println(this.pelicula);
		System.out.println("Precio de Entrada: " + this.precioEntrada + "€");
		System.out.println("Dinero Recaudado: " + this.dineroRecaudado + "€");
		System.out.println("");
		System.out.println("-------------------------------------------------------------------------");

		for (int i = asientos.length - 1; i >= 0; i--) {
			for (int j = 0; j < asientos[0].length; j++) {
				System.out.print(asientos[i][j]);
			}
			System.out.println("");
		}
	}
	
	public String escribirInfo() {
        String asientosMostrar = "";

        for(int i = this.asientos.length - 1; i >= 0; i--) {
            for(int j = 0; j < this.asientos[0].length; j++) {
                asientosMostrar += this.asientos[i][j];
            }
        }

        return this.pelicula.toString() + "\n" +
                "\tPrecio entrada: " + this.precioEntrada + "\n" +
                "\tDinero recaudado: " + this.dineroRecaudado + "\n" +
                "----------------------------------------------------\n" +
                asientosMostrar;
    }

	public Asientos[][] getAsientos() {
		return asientos;
	}

	public void setAsientos(Asientos[][] asientos) {
		this.asientos = asientos;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public int getId() {
		return id;
	}

	public double getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}

	public double getDineroRecaudado() {
		return dineroRecaudado;
	}

	public void setDineroRecaudado(double dineroRecaudado) {
		this.dineroRecaudado = dineroRecaudado;
	}

}
