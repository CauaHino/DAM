package evento;

import apuesta.Apuesta;

public class EventoFutebol extends Evento {

	private String equipoLocal;
	private String equipoVisitante;
	private String resultado;
	private final double COTIZACION_1 = 1.5;
	private final double COTIZACION_X = 3.5;
	private final double COTIZACION_2 = 5.5;

	public EventoFutebol(String equipoLocal, String equipoVisitante) {
		super();
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.resultado = this.generarResultado();
	}

	@Override
	public String generarResultado() {
		int x;
		x = (int) (Math.random() * 3);
		if(x == 0) {
			return "Empate";
		} else if(x == 1) {
			return "Local";
		}else if(x == 2){
			return "Visitante";
		}
		return null;
	}

	@Override
	public void procesarApuesta(Apuesta apuesta) {
		double dineroActual = 0;
		if (apuesta.getPronostico().equals(this.resultado)) {
			dineroActual = apuesta.getCliente().getDinero();
			if ("Local".equals(this.resultado)) {
				this.dineroEntregado += apuesta.getCantidadApostada() * COTIZACION_1;
				apuesta.getCliente().setDinero(dineroActual += (apuesta.getCantidadApostada() * COTIZACION_1));
			} else if ("Empate".equalsIgnoreCase(this.resultado)) {
				this.dineroEntregado += apuesta.getCantidadApostada() * COTIZACION_X;
				apuesta.getCliente().setDinero(dineroActual += (apuesta.getCantidadApostada() * COTIZACION_X));
			} else if ("Visitante".equalsIgnoreCase(this.resultado)) {
				this.dineroEntregado += apuesta.getCantidadApostada() * COTIZACION_2;
				apuesta.getCliente().setDinero(dineroActual += (apuesta.getCantidadApostada() * COTIZACION_2));
			}
		} else {
			this.dineroRecaudado += apuesta.getCantidadApostada();
		}

	}
	
	 public String toString() {
	        return "EVENTO FÚTBOL: \n"
	                + "\tID: "+this.id+"\n"
	                + "\tEquipo Local: "+this.equipoLocal+"\n"
	                + "\tEquipo Visitante: "+this.equipoVisitante+"\n"
	                + "\tResultado: "+this.resultado+"\n";
	    }

	 public String getEquipoLocal() {
		 return equipoLocal;
	 }

	 public void setEquipoLocal(String equipoLocal) {
		 this.equipoLocal = equipoLocal;
	 }

	 public String getEquipoVisitante() {
		 return equipoVisitante;
	 }

	 public void setEquipoVisitante(String equipoVisitante) {
		 this.equipoVisitante = equipoVisitante;
	 }

	 public String getResultado() {
		 return resultado;
	 }

	 public void setResultado(String resultado) {
		 this.resultado = resultado;
	 }
	 
	 

}
