<?php
    class Habitacion {
        private $numero;
        private $camas;
        private $disponible;
        private $limpia;
        private $capacidad;

        public function __construct($numero, $camas, $disponible = true, $limpia = true, $capacidad) {
            $this->numero = $numero;
            $this->camas = $camas;
            $this->disponible = $disponible;
            $this->limpia = $limpia;
            $this->capacidad = $capacidad; 
        }
        
        public function actualizarEstado($disponible, $limpia) {
            $this->disponible = $disponible;
            $this->limpia = $limpia;
        }

        public function marcarcomoSucia(): void {
            $this->limpia = false;
        }

        public function marcarcomoLimpia(): void {
            $this->limpia = true;
        }
         
        public function marcarcomoOcupada(): void {
            $this->disponible = false;
        }
        public function marcarcomoDisponible(): void {
            $this->disponible = true;
        }
        public function getNumero(): mixed {
            return $this->numero;
        }
        public function getCapacidad(): mixed {
            return $this->capacidad;
        }

        public function mostrarInfo() {
            echo "Número de Habitación: " . $this->numero . "<br>";
            echo "Número de Camas: " . $this->camas . "<br>";
            echo "Disponible: " . ($this->disponible ? "Sí" : "No") . "<br>";
            echo "Limpia: " . ($this->limpia ? "Sí" : "No") . "<br>";
            echo "Capacidad: " . $this->capacidad . " personas<br>";
        }
    }
?>

<?php
class Main {
    public static function run() {
        $habitaciones = [
            new Habitacion(101, 2, true, true, 2),
            new Habitacion(102, 1, false, false, 1),
            new Habitacion(103, 3, true, false, 3),
        ];
          
        echo "<h2>Información inicial de la habitación:</h2>";      
        $habitaciones[0]->mostrarInfo();
        echo "<br>";
        echo "<h2>Actualizando estado de la habitación...</h2>";
        

        $habitaciones[0]->actualizarEstado(false, false);
        $habitaciones[0]->mostrarInfo();

        echo "<br>";
        echo "<h2>Marcando la habitación como limpia y disponible...</h2>";
        
        $habitaciones[0]->marcarcomoLimpia();
        $habitaciones[0]->marcarcomoDisponible();
        $habitaciones[0]->mostrarInfo();

        echo "<br>";
        $habitaciones[0]->marcarcomoOcupada();
        echo "<h2>Después de marcar como ocupada:</h2>";
        $habitaciones[0]->mostrarInfo();

        $habitaciones[0]->marcarcomoSucia();
        echo "<br><h2>Después de marcar como sucia:</h2>";
        $habitaciones[0]->mostrarInfo();
       echo "<br>";
       echo "<h2> Información final de la habitación:</h2>";
       $habitaciones[0]->mostrarInfo();

       echo "<h2> Números de las habitaciones:</h2>";
       for ($i = 0; $i < count($habitaciones); $i++) {
           echo "<p>" . $habitaciones[$i]->getNumero() . "</p>";
       }

    }
}

Main::run();
?>