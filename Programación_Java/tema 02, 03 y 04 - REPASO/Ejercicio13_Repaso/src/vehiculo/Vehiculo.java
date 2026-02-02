package vehiculo;

import java.time.LocalDate;
import java.time.Period;

import propietario.Propietario;

public class Vehiculo {
	private String marca;
    private String matricula;
    private int numKM;
    private LocalDate fechaMatriculacion;
    private String color;
    private double precio;
    private Propietario propietario;

    public Vehiculo() {
    	this.marca = "Peugeot";
    	this.matricula = "7894MKJ";
    	this.numKM = 14500;
    	this.fechaMatriculacion = LocalDate.of(2019, 11, 15);
    	this.precio = 21500;
    	this.color = "negro";
    }

    public Vehiculo(String marca, String matricula, int numKM, 
    		LocalDate fechaMatriculacion, String color, double precio, 
    		Propietario propietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.numKM = numKM;
        this.fechaMatriculacion = fechaMatriculacion;
        this.color = color;
        this.precio = precio;
        this.propietario = propietario;
    }

    public String dameMarca() {
        return marca;
    }

    public void modificaMarca(String marca) {
        this.marca = marca;
    }

    public String dameMatricula() {
        return matricula;
    }

    public void modificaMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int dameNumKM() {
        return numKM;
    }

    public void modificaNumKM(int numKM) {
        this.numKM = numKM;
    }

    public LocalDate dameFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void modificaFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String dameColor() {
        return color;
    }

    public void modificaColor(String descripcion) {
        this.color = descripcion;
    }

    public double damePrecio() {
        return precio;
    }

    public void modificaPrecio(double precio) {
        this.precio = precio;
    }

    public Propietario damePropietario() {
        return this.propietario;
    }

    public void modificaPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public int dameAnios(){
        
        LocalDate f1 = this.fechaMatriculacion;
        LocalDate f2 = LocalDate.now();
        
        Period p = Period.between(f1, f2);
        
        return p.getYears();
        
    }

    //@Override
    /*public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", matricula=" + matricula + ", numKM=" + numKM + ", fechaMatriculacion=" + fechaMatriculacion + ", color=" + color + ", precio=" + precio + ", nombrePropietario=" + nombrePropietario + ", dniPropietario=" + dniPropietario + '}';
    }*/
    
    public void mostrarInfo() {
    	System.out.println("Las características del vehículo son: \n"+
    						"\tMarca: "+this.marca+"\n"+
    						"\tMatricula: "+this.matricula+"\n"+
    						"\tNúmero de KM: "+this.numKM+"\n"+
    						"\tFecha de matriculación: "+this.fechaMatriculacion+"\n"+
    						"\tColor: "+this.color+"\n"+
    						"\tPrecio: "+this.precio);
    						this.propietario.mostrarInfo();
    }
    
    public String toString() {
    	return "Las características del vehículo son: \n"+
    						"\tMarca: "+this.marca+"\n"+
    						"\tMatricula: "+this.matricula+"\n"+
    						"\tNúmero de KM: "+this.numKM+"\n"+
    						"\tFecha de matriculación: "+this.fechaMatriculacion+"\n"+
    						"\tColor: "+this.color+"\n"+
    						"\tPrecio: "+this.precio+"\n"+
    						this.propietario;
    }

}
