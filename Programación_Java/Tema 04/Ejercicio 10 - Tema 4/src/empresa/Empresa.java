package empresa;

import empleadoa.Empleado;

public class Empresa {
	private String CIF;
	private String nombreEmpresa;
	private Empleado empleado;
	
	public Empresa (String cif, String empresa, Empleado empleado) {
		this.CIF = cif;
		this.nombreEmpresa = empresa;
		this.empleado = empleado;
	}
	public String toString() {
		return "EMPRESA: "+ "\n" + "\tCIF: "+ this.CIF + "\n" + "\tNombre: " + this.nombreEmpresa + "\n" +empleado.mostrarInfo();
	}
	

}
