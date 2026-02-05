package main;

import java.io.*;

import com.google.gson.*;


import persona.Persona;

public class Main {

	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(BufferedReader br = new BufferedReader(new FileReader("datos_Ej17.json")); BufferedWriter bw = new BufferedWriter(new FileWriter("datos_salida.json"))){
			Persona persona = gson.fromJson(br, Persona.class);
			System.out.println(persona);
			
			String json = gson.toJson(persona);
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
