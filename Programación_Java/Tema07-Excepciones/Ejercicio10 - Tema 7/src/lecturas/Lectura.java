package lecturas;

import java.io.*;

public class Lectura {
	/**
	 * Este método devuelve un int capturado por teclado
	 * 
	 * @return Devuelve un int.
	 * @exception NumberFormatException en error de conversión, al introducir una
	 *                                  letra por ejemplo.
	 */
	public static int etInt() throws NumberFormatException {
		String str;
		int i = 0;
		BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));
		try {
			str = dato.readLine();
			i = Integer.parseInt(str);
		} catch (IOException e) {
			System.out.println(e);
		}
		return i;
	}
}