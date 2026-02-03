package ejemplo.gson;

import com.google.gson.Gson;

import futbolista.Futbolista;

public class Main {

	public static void main(String[] args) {
		String json =   "{" +
				                "dorsal:6," +
				                "nombre:'Iniesta'," +
				                "demarcaciones:['Centrocampista', 'Inferior Izquierdo']," +
				                "equipo:'FC Barcelona'" +
			            "}";
		
		Gson gson = new Gson();
		Futbolista futbolistas = gson.fromJson(json, Futbolista.class);
		System.out.println("Ejemplo con clase Gson");
			System.out.println(futbolistas);

	}

}
