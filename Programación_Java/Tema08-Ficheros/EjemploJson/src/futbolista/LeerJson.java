package futbolista;

import com.google.gson.*;

public class LeerJson {

	public static void main(String[] args) {

		String json =  "[" +
			                "{" +
				                "dorsal:6," +
				                "nombre:'Iniesta'," +
				                "demarcacion:['Centrocampista', 'Inferior Izquierdo']," +
				                "equipo:'FC Barcelona'" +
			            "}" +
			            "]";

		JsonParser parser = new JsonParser();

		// Obtenemos el Array
		JsonArray jsonArray = parser.parse(json).getAsJsonArray();

		// Para cada elemento del array
		for (JsonElement jsonElement : jsonArray) {

			// Obtenemos el JsonObject del JsonArray

			JsonObject jsonObject = jsonElement.getAsJsonObject();

			// Obtenemos los elementos primitivos del JsonObject
			int dorsal = jsonObject.get("dorsal").getAsInt();
			String nombre = jsonObject.get("nombre").getAsString();
			String equipo = jsonObject.get("equipo").getAsString();
			JsonArray demarcacionJson = jsonObject.get("demarcacion").getAsJsonArray();
			String [] demarcaciones = new String[demarcacionJson.size()];
			
			for(int i = 0; i < demarcaciones.length; i++) {
				demarcaciones[i] = demarcacionJson.get(i).getAsString();
			}

			// Creamos nuestro objeto Futbolista
			Futbolista iniesta = new Futbolista(dorsal, nombre, demarcaciones, equipo);

			// Mostramos la información del futbolista por pantalla
			System.out.println(iniesta);
		}
	}

}
