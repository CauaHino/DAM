package locomotoras;

import comunes.CaractComunes;
import excepciones.PotenciaNegativa;

public class Locomotora implements CaractComunes{
	private int idLocomotora;
	private static int contador = 0;
	private String marca;
	private String modelo;
	private String tipo;
	private double potencia;
	
	public Locomotora(String marca, String modelo, String tipo, double potencia) throws PotenciaNegativa {
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		if(potencia < 0) {
			throw new PotenciaNegativa(marca, modelo);
		}
		else {
			this.potencia = potencia;
		}
		contador++;
		this.idLocomotora = contador;
	}
	
	
	
	public Locomotora(int idLocomotora, String marca, String modelo, String tipo, double potencia) {
		this.idLocomotora = idLocomotora;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.potencia = potencia;
	}



	@Override
	public String getMarca() {
		// TODO Auto-generated method stub
		return this.marca;
	}

	@Override
	public String getModelo() {
		// TODO Auto-generated method stub
		return this.modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
		
	public int getIdLocomotora() {
		return idLocomotora;
	}

	public void setIdLocomotora(int idLocomotora) {
		this.idLocomotora = idLocomotora;
	}


	public String toString() {
		return "\tLOCOMOTORA: \n" + 
				"\tID: "+this.idLocomotora+"\n"+
				"\tMarca: "+this.marca+"\n"+
				"\tModelo: "+this.modelo+"\n"+
				"\tTipo: "+this.tipo+"\n"+
				"\tPotencia: "+this.potencia+" kW\n";  
	}

}
