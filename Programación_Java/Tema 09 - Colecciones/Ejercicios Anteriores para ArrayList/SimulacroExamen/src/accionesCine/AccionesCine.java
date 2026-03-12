package accionesCine;

import Personas.Espectadores;
import excepciones.EdadRecomendada;

public interface AccionesCine {
	/** 
	* Indicamos si hay sitio en el cine, es decir, quedan asientos sin ocupar 
	* @return true si hay sitio en el cine, false en caso contrario 
	*/ 
	public boolean haySitio(); 
	/** 
	* Indicamos si el espectador cumple lo necesario para entrar a ver la película:  
	* 1) Tiene dinero suficiente para comprar la entrada 
	* 2) Tiene la edad mínima recomendada: si no cumple con la edad mínima  
	* recomendada lanzará la excepción EdadRecomendada (debe estar en un 
	paquete llamado  
	* “excepciones”). 
	* @param e --> Espectador que quiere entrar al cine a ver la película 
	* @return true si ha podido entrar al cine, false en caso contrario 
	*/ 
	
	public boolean puedeEntrar(Espectadores e) throws 
	EdadRecomendada; 
	
	/** 
	* Sentamos al espectador en el asiento ubicado en fila-columna y reducimos el 
	número 
	* de asientos disponibles. 
	* @param fila    --> fila en la que se encuentra el asiento 
	* @param columna --> columna en la que se encuentra el asiento 
	* @param e       --> Espectador que queremos sentar 
	*/ 
	public void sentar (int fila, int columna, Espectadores e);

}
