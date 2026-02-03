package leer.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class LeerJson {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		try(BufferedReader br =new BufferedReader(new FileReader("Futbolista.json"))){
			Futbolista futbolistas = gson.fromJson(br, Futbolista.class);
			System.out.println("La información leida del fichero Json es: \n " + futbolistas);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
