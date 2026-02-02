
public class Main {

	public static void main(String[] args) {
// --- 1. CONFIGURACIÓN DEL CASINO ---

		// Creamos un Array de 4 huecos para guardar nuestros juegos
		// Gracias a la herencia, un array de 'Juego' puede guardar 'Ruleta' y 'Moneda'
		Juego[] juegos = new Juego[4];

		// Llenamos el array según tus requisitos:
		juegos[0] = new Ruleta("Ruleta Europea 1"); // Ruleta Normal
		juegos[1] = new Ruleta("Ruleta Europea 2"); // Ruleta Normal
		juegos[2] = new Ruleta("Ruleta Americana", true); // Ruleta Americana
		juegos[3] = new Moneda("Mesa de Cara o Cruz"); // Juego Moneda

		// Creamos los 3 clientes
		Cliente c1 = new Cliente("Lucía", 1500);
		Cliente c2 = new Cliente("Marcos", 800);
		Cliente c3 = new Cliente("Sofía", 2000);

		System.out.println("=== EL CASINO ABRE SUS PUERTAS ===");
		System.out.println();

		// --- 2. SIMULACIÓN DE JUEGO (Casting Explicado) ---

		// NOTA: Para jugar, necesitamos decir a Java "Oye, el juego en la posición 0 es
		// una Ruleta".
		// Esto se hace poniendo el tipo entre paréntesis: ((Ruleta) juegos[0])

		// --- Cliente 1 (Lucía) juega en Ruleta 1 y Moneda ---
		System.out.println("-- Turno de Lucía --");
		// Juega al número 7 en la Ruleta 1
		if (juegos[0] instanceof Ruleta) {
			((Ruleta) juegos[0]).jugar(c1, 7, 100);
		}
		// Juega a "Cara" en la Moneda
		if (juegos[3] instanceof Moneda) {
			((Moneda) juegos[3]).jugar(c1, "Cara", 200);
		}

		System.out.println();

		// --- Cliente 2 (Marcos) juega en Ruleta 2 y Ruleta Americana ---
		System.out.println("-- Turno de Marcos --");
		// Juega a Color Rojo en Ruleta 2
		((Ruleta) juegos[1]).jugar(c2, "Rojo", 50);
		// Juega al número 00 (o 37) en la Americana
		// Recuerda: En nuestra lógica interna el 00 es el int 37
		((Ruleta) juegos[2]).jugar(c2, 37, 50);

		System.out.println();

		// --- Cliente 3 (Sofía) juega en Moneda y Ruleta Americana ---
		System.out.println("-- Turno de Sofía --");
		// Juega a "Cruz" en la Moneda
		((Moneda) juegos[3]).jugar(c3, "Cruz", 500);
		// Juega a Color Negro en la Americana
		((Ruleta) juegos[2]).jugar(c3, "Negro", 1000);

		System.out.println("\n=======================================");
		System.out.println("=== CIERRE Y RESULTADOS DEL DÍA ===");
		System.out.println("=======================================\n");

		// --- 3. RESULTADOS DE LAS MESAS (Usando bucle for) ---
		// Aquí NO necesitamos casting, porque 'mostrarEstadisticas' está en la clase
		// padre Juego.
		double recaudacionTotalCasino = 0;

		for (int i = 0; i < juegos.length; i++) {
			juegos[i].mostrarEstadisticas();
			// Podemos acceder a importeRecaudado porque es protected en la clase abstracta,
			// pero lo ideal sería tener un getter. Como estamos en el mismo paquete,
			// funciona:
			recaudacionTotalCasino += (juegos[i].importeRecaudado - juegos[i].importePremios);
		}

		System.out.println("BENEFICIO NETO TOTAL DEL CASINO: $" + recaudacionTotalCasino);
		System.out.println("\n---------------------------------------");

		// --- 4. RESULTADOS DE LOS CLIENTES ---
		System.out.println("Saldo final Lucía:  $" + c1.getSaldo());
		System.out.println("Saldo final Marcos: $" + c2.getSaldo());
		System.out.println("Saldo final Sofía:  $" + c3.getSaldo());
	}

}
