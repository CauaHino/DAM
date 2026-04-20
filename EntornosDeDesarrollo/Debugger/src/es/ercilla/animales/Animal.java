package es.ercilla.animales;

import java.util.Objects;

public class Animal {
	private String especie;
	private String familia;
	private int pesoKgs;

	public Animal(String especie, String familia, int pesoKgs) {
		this.especie = especie;
		this.familia = familia;
		this.pesoKgs = pesoKgs;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public int getPesoKgs() {
		return pesoKgs;
	}

	public void setPesoKgs(int pesoKgs) {
		this.pesoKgs = pesoKgs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(especie, familia, pesoKgs);
	}
	
	public String toString() {
		return "ANIMAL: " + "\n" + "\tEspecie: " + this.especie + "\n"
									+ "\tFamilia: " + this.familia + "\n"
									+ "\tPeso: " + this.pesoKgs + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(especie, other.especie) && Objects.equals(familia, other.familia)
				&& pesoKgs == other.pesoKgs;
	}

	
}
