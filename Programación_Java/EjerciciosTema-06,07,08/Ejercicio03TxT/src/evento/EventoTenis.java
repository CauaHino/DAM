package evento;

import apuesta.Apuesta;

public class EventoTenis extends Evento{

    private String jugador1;
    private String jugador2;
    private String resultado;
    private final double COTIZACION1 = 4.5;
    private final double COTIZACION2 = 5.5;


    public EventoTenis(String jugador1, String jugador2) {
        super();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.resultado = this.generarResultado();
    }


    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String toString() {
        return "EVENTO FÚTBOL: \n"
                + "\tID: "+this.id+"\n"
                + "\tEquipo Local: "+this.jugador1+"\n"
                + "\tEquipo Visitante: "+this.jugador2+"\n"
                + "\tResultado: "+this.resultado+"\n";
    }

	@Override
	public String generarResultado() {
		int x;
        x = (int)(Math.random()*2)+1;
        if (x == 1) {
            return getJugador1();
        }else if (x == 2) {
            return getJugador2();
	}
        return null;
	}

	@Override
	public void procesarApuesta(Apuesta apuesta) {
		double dineroActual = 0;
		if (apuesta.getPronostico().equals(this.resultado)) {
			dineroActual = apuesta.getCliente().getDinero();
			if ("1".equals(this.resultado)) {
				this.dineroEntregado += apuesta.getCantidadApostada() * COTIZACION1;
				apuesta.getCliente().setDinero(dineroActual += (apuesta.getCantidadApostada() * COTIZACION1));
			} else if ("2".equals(this.resultado)) {
				this.dineroEntregado += apuesta.getCantidadApostada() * COTIZACION2;
				apuesta.getCliente().setDinero(dineroActual += (apuesta.getCantidadApostada() * COTIZACION2));
			}
		} else {
			this.dineroRecaudado += apuesta.getCantidadApostada();
		}
		
	}

}