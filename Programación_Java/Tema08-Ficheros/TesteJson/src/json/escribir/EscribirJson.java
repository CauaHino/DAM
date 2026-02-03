package json.escribir;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import leer.json.Futbolista;

public class EscribirJson {

	public static void main(String[] args) {
		String[] demarcaciones = {"Centrocampista", "Interior Izquierdo"};
		Futbolista iniesta = new Futbolista(8, "Iniesta", demarcaciones, "FC Barcelona");

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String json = gson.toJson(iniesta);
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("Iniesta_v1.json"))){
			bw.write(json);
			System.out.println("Fichero escrito con éxito!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
