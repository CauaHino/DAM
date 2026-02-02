package Instituto;

import Aula.Aula;

public class Instituto {
	// Atributos
	private Aula[] aulas;

	// Constructor
	public Instituto(int numAulas) {
		this.aulas = new Aula[numAulas];
	}
		//int indice = 0;

		// 1. 10 aulas de 35 alumnos
		/*for (int i = 0; i < 10; i++) {
			this.aulas[indice++] = new Aula(35);
		}

		// 2. 5 aulas de 25 alumnos
		for (int i = 0; i < 5; i++) {
			this.aulas[indice++] = new Aula(25);
		}

		// 3. 5 aulas de 15 alumnos
		for (int i = 0; i < 5; i++) {
			this.aulas[indice++] = new Aula(15);
		}
	} */

	public Aula[] dameAulas() {
		return this.aulas;
	}

	public void setAulas(Aula[] aulas) {
		this.aulas = aulas;
	}
	
}