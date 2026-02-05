package main;

import java.io.*;

import com.google.gson.*;


import persona.Persona;

public class MainB {

	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(BufferedReader br = new BufferedReader(new FileReader("datos_Ej17_v2.json")); BufferedWriter bw = new BufferedWriter(new FileWriter("datos_salida_v2.json"))){
			Persona[] personas = gson.fromJson(br, Persona[].class);
			for(Persona p : personas) {
				System.out.println(p);
			}
			
			String json = gson.toJson(personas);
			bw.write(json);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
