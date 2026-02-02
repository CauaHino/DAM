// 3. Clase Ruleta: Hereda de Juego

import java.util.Random;

class Ruleta extends Juego {
    private boolean esAmericana; // true si tiene doble cero
    private Random random;

    // Constructor 1: Ruleta Normal (Europea)
    public Ruleta(String nombreMesa) {
        super(nombreMesa);
        this.esAmericana = false;
        this.random = new Random();
    }

    // Constructor 2: Ruleta Americana
    public Ruleta(String nombreMesa, boolean esAmericana) {
        super(nombreMesa);
        this.esAmericana = esAmericana;
        this.random = new Random();
    }

    // Método auxiliar para girar la ruleta
    // Retorna un número entre 0 y 36 (o 37 para representar el 00 americano)
    private int girarRuleta() {
        int limite = esAmericana ? 38 : 37; // 37 números (0-36) o 38 (0-36 + 00)
        int resultado = random.nextInt(limite);
        
        // Lógica de color visual
        String color = "Verde"; // El 0 es verde
        if (resultado > 0 && resultado != 37) {
            color = (resultado % 2 == 0) ? "Rojo" : "Negro"; // Simplificación: Pares Rojos
        }
        
        String numeroStr = (resultado == 37) ? "00" : String.valueOf(resultado);
        System.out.println(">> La bola cae en: " + numeroStr + " (" + color + ")");
        
        return resultado;
    }

    // --- FORMA DE JUGAR 1: Apostar a NÚMERO ---
    public void jugar(Cliente cliente, int numeroApostado, double importe) {
        if (cliente.getSaldo() < importe) {
            System.out.println("El cliente no tiene saldo suficiente.");
            return;
        }

        // Gestión del dinero inicial
        cliente.pagar(importe);
        this.importeRecaudado += importe;

        System.out.println(cliente.getNombre() + " apuesta $" + importe + " al número " + numeroApostado);
        
        int resultado = girarRuleta();

        // 37 representa el "00". Si el usuario apuesta al 00, debe pasar un número específico (ej. -1 o 37)
        // Para simplificar, asumiremos que si sale 37, nadie gana en apuesta directa numérica estándar (0-36)
        
        if (resultado == numeroApostado) {
            double premio = importe * 36; // Paga 36 a 1
            this.importePremios += premio;
            cliente.cobrar(premio);
            System.out.println("¡GANADOR! " + cliente.getNombre() + " gana $" + premio);
        } else {
            System.out.println("Pierde la apuesta.");
        }
    }

    // --- FORMA DE JUGAR 2: Apostar a COLOR ---
    public void jugar(Cliente cliente, String colorApostado, double importe) {
        if (cliente.getSaldo() < importe) {
            System.out.println("Saldo insuficiente.");
            return;
        }

        cliente.pagar(importe);
        this.importeRecaudado += importe;

        System.out.println(cliente.getNombre() + " apuesta $" + importe + " al color " + colorApostado);
        
        int resultado = girarRuleta();
        
        // Determinamos el color ganador
        String colorGanador = "Verde"; // 0 y 00 son verdes (pierden apuestas rojo/negro)
        if (resultado != 0 && resultado != 37) {
            colorGanador = (resultado % 2 == 0) ? "Rojo" : "Negro";
        }

        if (colorGanador.equalsIgnoreCase(colorApostado)) {
            double premio = importe * 2; // Paga 2 a 1
            this.importePremios += premio;
            cliente.cobrar(premio);
            System.out.println("¡GANADOR! El color coincide. Gana $" + premio);
        } else {
            System.out.println("Pierde la apuesta. Salió " + colorGanador);
        }
    }
}