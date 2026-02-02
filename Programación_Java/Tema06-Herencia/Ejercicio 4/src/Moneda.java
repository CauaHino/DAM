import java.util.Random;

class Moneda extends Juego {
    private Random random;

    public Moneda(String nombreMesa) {
        super(nombreMesa); // Llamamos al constructor del padre (Juego)
        this.random = new Random();
    }

    // Método principal del juego
    public void jugar(Cliente cliente, String apuesta, double importe) {
        // 1. Validar saldo
        if (cliente.getSaldo() < importe) {
            System.out.println("Saldo insuficiente para jugar a la moneda.");
            return;
        }

        // 2. Gestionar la apuesta (El dinero entra a la mesa)
        cliente.pagar(importe);
        this.importeRecaudado += importe;
        
        System.out.println(cliente.getNombre() + " lanza la moneda apostando $" + importe + " a " + apuesta.toUpperCase());

        // 3. Lógica del juego: Lanzar moneda
        // nextBoolean() devuelve true o false. Asignamos: true = Cara, false = Cruz
        boolean salioCara = random.nextBoolean();
        String resultado = salioCara ? "Cara" : "Cruz";

        System.out.println(">> La moneda gira... y sale: " + resultado.toUpperCase());

        // 4. Comprobar ganador (ignorando mayúsculas/minúsculas)
        if (apuesta.equalsIgnoreCase(resultado)) {
            double premio = importe * 2; // Paga 2 a 1
            this.importePremios += premio;
            cliente.cobrar(premio);
            System.out.println("¡ACERTASTE! Ganas $" + premio);
        } else {
            System.out.println("Has fallado. Suerte la próxima vez.");
        }
    }
}