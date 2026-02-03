package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import persona.Persona;

public class Main {

	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try(BufferedReader br = new BufferedReader(new FileReader("datos_Ej16.json"))){
			Persona persona = gson.fromJson(br, Persona.class);
			System.out.println(persona);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
