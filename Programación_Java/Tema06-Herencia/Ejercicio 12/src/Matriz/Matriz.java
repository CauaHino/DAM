package Matriz;

public class Matriz {
	private double[][] tabla;

	public Matriz(int n) {
		this.tabla = new double[n][n];
	}

	public Matriz(int n, double val) {
		this(n);
		// this.tabla = new double [n][n];
		for (int fila = 0; fila < tabla.length; fila++) {
			for (int columna = 0; columna < tabla[0].length; columna++) {
				this.tabla[fila][columna] = val;
			}
		}
	}

	public Matriz(int n, int m) {
		this.tabla = new double[n][m];
	}

	public Matriz(int n, int m, double val) {
		this(n, m);
		for (int fila = 0; fila < tabla.length; fila++) {
			for (int columna = 0; columna < tabla[0].length; columna++) {
				this.tabla[fila][columna] = val;
			}
		}
	}
	

	public double[][] getTabla() {
		return tabla;
	}

	public void setTabla(double[][] tabla) {
		this.tabla = tabla;
	}

	public Matriz(double ini_val[][]) {
		this.tabla = new double[ini_val.length][ini_val[0].length];
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[0].length; j++) {
				this.tabla[i][j] = ini_val[i][j];
			}
		}
	}
	// rellenar de forma inversa
	/*
	 * public Matriz(double ini_val[][]) { this.tabla = new
	 * double[ini_val.length][ini_val[0].length]; for (int i = 0; i < tabla.length;
	 * i++) { for (int j = 0; j < tabla[0].length; j++) { this.tabla[i][j] =
	 * ini_val[tabla.length-1-i][tabla[0].length-1-j]; } } }
	 */

	public Matriz(Matriz otra) {
		this(otra.tabla);
	}

	// Si los indices se salen del rango de la matriz devuelve -1

	public double getElem(int i, int j) {
		if (i < 0 || i >= this.tabla.length || j < 0 || j >= tabla[0].length) {
			return -1;
		}
		return this.tabla[i][j];
	}

	public void putElem(int i, int j, double val) {
		if (i >= 0 && i < tabla.length && j >= 0 && j < this.tabla[0].length) {
			this.tabla[i][j] = val;
		} else {
			System.out.println("La posición " + i + " , " + j + " no existe");
		}
	}

	public Matriz suma(Matriz m2) {
		if (tabla.length == m2.tabla.length && tabla[0].length == m2.tabla[0].length) {
			Matriz resultado = new Matriz(m2);
			for (int i = 0; i < tabla.length; i++) {
				for (int j = 0; j < tabla[0].length; j++) {
					resultado.tabla[i][j] = tabla[i][j] + m2.tabla[i][j];
				}
			}
			return resultado;
		}
		return null;
	}
	public double traza() {
		double resultado = 1;
		
		if (tabla.length != tabla[0].length) {
			System.out.println("La matriz no es válida");
			return 0;
		}
		for (int i = 0; i < tabla.length && i < tabla[0].length; i++) {
			resultado *= tabla[i][i];
		}
		return resultado;
	} 
	public Matriz traspuesta() {
	    Matriz resultado = new Matriz(this.tabla[0].length, this.tabla.length);
	    for (int i = 0; i < this.tabla.length; i++) {
	        for (int j = 0; j < this.tabla[0].length; j++) {
	            resultado.tabla[j][i] = this.tabla[i][j];
	        }
	    }
	    return resultado;
	}
	public double sumaFila(int fila) {
		double suma = 0;
		if (fila >= 0 && fila < this.tabla.length) {
			for (int i = 0; i< tabla [0].length; i++)
			suma += tabla[fila][i];
		} else {
	        System.out.println("Error: La fila " + fila + " no existe.");
	    }
		return suma;
	}
	public double sumaColumna(int columna) {
		double suma = 0;
		if (columna >= 0 && columna < this.tabla[0].length) {
			for (int i = 0; i< tabla.length; i++)
			suma += tabla[i][columna];
		} else {
	        System.out.println("Error: La columna " + columna + " no existe.");
	    }
		return suma;
	}
	public double sumaDiagonal() {
		double resultado = 0;
		
		if (tabla.length != tabla[0].length) {
			System.out.println("La matriz no es válida");
			return 0;
		}
		for (int i = 0; i < tabla.length && i < tabla[0].length; i++) {
			resultado += tabla[i][i];
		}
		return resultado;
	}
	public double sumaDiagonalInversa() {
		double resultado = 0;
		
		if (tabla.length != tabla[0].length) {
			System.out.println("La matriz no es válida");
			return 0;
		}
		for (int i = 0; i < tabla.length && i < tabla[0].length; i++) {
			resultado += tabla[i][tabla.length - 1 - i];
		}
		return resultado;
	}
	
	public double media() {
		double suma = 0;
		int numElementos = tabla.length * tabla[0].length;
		for(int i = 0; i < tabla.length; i++) {
			for(int j = 0; j < tabla[0].length; j++) {
				suma += tabla[i][j];
			}
		}
		return suma/numElementos;
	}
	
	public void mostrarMatriz() {
		for (int i = 0; i < tabla.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < tabla[0].length; j++) {
				System.out.print(tabla[i][j] + " | ");
			}
			System.out.println("");
		}
		
	}
}
