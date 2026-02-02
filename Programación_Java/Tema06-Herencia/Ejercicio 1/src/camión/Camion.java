package camión;

import VehiculoConMotor.VehiculoConMotor;

public class Camion extends VehiculoConMotor {
		private int capacidadCarga;
		
		public Camion(String c, double p, String m, double cc, int cv, int capacidadCarga ) {
			super(c,p,m,cc,cv);
			this.capacidadCarga = capacidadCarga;
		}

		public int getCapacidadCarga() {
			return capacidadCarga;
		}

		public void setCapacidadCarga(int capacidadCarga) {
			this.capacidadCarga = capacidadCarga;
		}
		
		public String toString() {
			return super.toString() + "CAMIÓN: " +"\n" +"\tCapacidad de Carga: " + this.capacidadCarga;
		}
}
