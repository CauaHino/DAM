<?php

class Cuenta {
    private $nombre;
    private $apellidos;
    private $dni;
    private $saldo;
    private $activa;

    public function __construct($nombre, $apellidos, $dni, $saldo = 0, $activa = true) {
        $this->nombre = $nombre;
        $this->apellidos = $apellidos;
        $this->dni = $dni;
        $this->saldo = $saldo;
        $this->activa = $activa;
    }
    public function getNombre() {
        return $this->nombre;
    }
    public function getApellidos() {
        return $this->apellidos;
    }
    public function getDni() {
        return $this->dni;
    }
    public function getSaldo() {
        return $this->saldo;
    }
    public function isActiva() {
        return $this->activa;
    }
    public function setNombre($nombre) {
        $this->nombre = $nombre;
    }
    public function setApellidos($apellidos) {
        $this->apellidos = $apellidos;
    }
    public function setDni($dni) {
        $this->dni = $dni;
    }
    public function setSaldo($saldo) {
        $this->saldo = $saldo;
    }

    public function ingresar($cantidad) {
        if ($cantidad >= 0 && $this->activa) {
            $this->saldo += $cantidad;
            return true;
        }
        return false;
    }
    public function retirar($cantidad) {
        if ($cantidad >= 0 && $cantidad <= $this->saldo && $this->activa) {
            $this->saldo -= $cantidad;
            return true;
        }
        return false;
    }

    public function bloquear() {
        $this->activa = false;
    }
    public function desbloquear() {
        $this->activa = true;
    }

    public function mostrarInfo() {
        echo "Nombre: " . $this->nombre . " " . $this->apellidos . "<br>";
        echo   "DNI: " . $this->dni . "<br>";
        echo   "Saldo: " . $this->saldo . "<br>";
        echo   "Estado: " . ($this->activa ? "Activa" : "Bloqueada") . "<br>";
    }
}
class Main {
    public static function main() {
        $cuenta = new Cuenta("Juan", "Pérez", "12345678A", 1000);
        echo"<h2>Información inicial de la cuenta:</h2>";
        echo $cuenta->mostrarInfo();
        echo"<h2>Ingresando 500:</h2>";
        $cuenta->ingresar(500);
        echo $cuenta->mostrarInfo();
        echo"<h2>Retirando 200:</h2>";
        $cuenta->retirar(200);
        echo $cuenta->mostrarInfo();
        echo"<h2>Bloqueando la cuenta e intentando retirar 100:</h2>";
        $cuenta->bloquear();    
        $cuenta->retirar(100);
        echo $cuenta->mostrarInfo();
        $cuenta->setNombre("Carlos");
        $cuenta->setApellidos("Gómez");
        $cuenta->setDni("87654321B");
        echo"<h2>Información actualizada de la cuenta:</h2>";
        echo $cuenta->mostrarInfo();

    }
}
?>
<?php
Main::main();
?>
 