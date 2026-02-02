abstract class Juego {
    protected String nombreMesa;
    protected double importeRecaudado;
    protected double importePremios;

    public Juego(String nombreMesa) {
        this.nombreMesa = nombreMesa;
        this.importeRecaudado = 0;
        this.importePremios = 0;
    }

    public void mostrarEstadisticas() {
        System.out.println("--- Estado de la mesa: " + nombreMesa + " ---");
        System.out.println("Recaudado: $" + importeRecaudado);
        System.out.println("Entregado en premios: $" + importePremios);
        System.out.println("Beneficio del Casino: $" + (importeRecaudado - importePremios));
        System.out.println("---------------------------------------");
    }
}