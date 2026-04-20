package es.ercilla.animales;

import java.util.ArrayList;

public class ClinicaVeterinaria {
	private ArrayList<Animal> animales = new ArrayList<Animal>();

	public void altaInicial() {
		//Los animales se consideran iguales si tienen misma especie y peso
		Animal a1 = new Animal("Perro", "Mamífero", 3);
		Animal a2 = new Animal("Gato", "Mamífero", 2);
		Animal a3 = new Animal("Loro", "Ave", 1);
		Animal a4 = new Animal("Serpiente", "Ofidio", 3);
		Animal a5 = new Animal("Cucaracha", "Insecto", 3);
		getAnimales().add(a1);
		getAnimales().add(a2);
		getAnimales().add(a3);
		getAnimales().add(a4);
		getAnimales().add(a5);

	}

	public void insertaAnimal(Animal animal) {
		if (!animales.contains(animal)) {
			animales.add(animal);
		}

	}

	public void eliminaAnimal(Animal animal) {
		if (animales.contains(animal)) {
			animales.remove(animal);
		}
	}

	public String listaAnimales() {
		return animales.toString();
	}

	public ArrayList<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(ArrayList<Animal> animales) {
		this.animales = animales;
	}

	public static void main(String[] args) {
		ClinicaVeterinaria clinicaVeterinaria = new ClinicaVeterinaria();
		clinicaVeterinaria.altaInicial();
		clinicaVeterinaria.insertaAnimal(new Animal("Cocodrilo", "Reptil", 1500));
		System.out.println("Actualmente tenemos los siguientes animales: " + "\n" +clinicaVeterinaria.getAnimales());
		clinicaVeterinaria.insertaAnimal(new Animal("Serpiente", "Ofidio", 3));
		System.out.println("Actualmente tenemos los siguientes animales: " + "\n" + clinicaVeterinaria.getAnimales());
		clinicaVeterinaria.insertaAnimal(new Animal("Serpiente", "Ofidios", 3));
		System.out.println("Actualmente tenemos los siguientes animales: " + "\n" + clinicaVeterinaria.getAnimales());
		clinicaVeterinaria.insertaAnimal(new Animal("Perro", "Mamífero", 3));
		System.out.println("Actualmente tenemos los siguientes animales: " + "\n" + clinicaVeterinaria.getAnimales());
	}
}
