package eventos;

import apuestas.Apuesta;

public class EventoFutbol extends Evento{
	private String equipoLocal;
	private String equipoVisitante;
	private String resultado;
	private final double COTIZACION1 = 1.5;
	private final double COTIZACION2 = 5.5;
	private final double COTIZACIONX = 3.5;
	
	public EventoFutbol(String equipoLocal, String equipoVisitante) {
		super();
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.resultado = this.getResultado();
	}
	
	public String getResultado() {
		int x;
		x = (int)(Math.random()*3);
		if(x == 0)
			return "X";
		else if(x == 1)
			return "1";
		else if(x == 2)
			return "2";
		return null;
	}
	
	public void procesarApuesta(Apuesta apuesta) {
		double dineroActual = 0;
		if(apuesta.getPronostico().equals(this.resultado)) {
			dineroActual = apuesta.getCliente().getDinero();
			if("1".equals(this.resultado)) {
				this.dineroEntregado += apuesta.getCantidad()*COTIZACION1;
				apuesta.getCliente().setDinero(dineroActual += 
						(apuesta.getCantidad()*COTIZACION1));
			}
			else if("X".equals(this.resultado)) {
				this.dineroEntregado += apuesta.getCantidad()*COTIZACIONX;
				apuesta.getCliente().setDinero(dineroActual += 
						(apuesta.getCantidad()*COTIZACIONX));
			}
			else if("2".equals(this.resultado)) {
				this.dineroEntregado += apuesta.getCantidad()*COTIZACION2;
				apuesta.getCliente().setDinero(dineroActual += 
						(apuesta.getCantidad()*COTIZACION2));
			}
		}
		else {
			this.dineroRecaudado += apuesta.getCantidad();
		}
	}
	
	@Override
	public String toString() {
		return "EVENTO FÚTBOL: \n"+
				"\tId: "+this.idEvento+"\n"+
				"\tEquipo Local: "+this.equipoLocal+"\n"+
				"\tEquipo Visitante: "+this.equipoVisitante+"\n"+
				"\tResultado: "+this.resultado+"\n";
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

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}
