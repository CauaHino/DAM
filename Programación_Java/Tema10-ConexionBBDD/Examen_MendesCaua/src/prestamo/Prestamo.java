package prestamo;

import excepciones.SinSuscripcion;
import recursos.Recurso;

public interface Prestamo {
	/**
	 * Método para decidir prestar un recurso de la biblioteca. Si es posible el préstamo muestra los detalles
	 * @param recurso  --> recurso de la biblioteca que toma prestado el cliente
	 * @param numDias 	--> número de días que se quiere tomar prestado el recurso
	 * @return true si se puede prestar, false si no se puede prestar.
	 * Lanzará una excepción si el cliente no dispone de ninguna suscripción.
	 */
	public boolean prestar(Recurso recurso, int numDias) throws SinSuscripcion;

}
