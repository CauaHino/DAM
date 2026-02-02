package leerFichero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class LeerFichero {
	public static void main(String[] args) {
		String texto = "";
		BufferedReader ficheroEntrada = null;	
		
		try {
			FileReader fichero = new FileReader("C:\\Users\\cauah\\Desktop\\Main.java");
			ficheroEntrada = new BufferedReader(fichero) ;
			String linea = ficheroEntrada.readLine();
			
			
			while(linea != null) {
				texto += linea + "\n";
				linea = ficheroEntrada.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(ficheroEntrada != null) {
				try{
					ficheroEntrada.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(texto);
	}
}
