package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import persona.Persona;

public class MainB {

	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(BufferedReader br = new BufferedReader(new FileReader("datos_Ej16_v2.json")); BufferedWriter bw = new BufferedWriter(new FileWriter("datos_salida.json")) ){
			Persona[] personas = gson.fromJson(br, Persona[].class);
			for(int i = 0; i < personas.length; i++) {
				System.out.println(personas[i]);
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
