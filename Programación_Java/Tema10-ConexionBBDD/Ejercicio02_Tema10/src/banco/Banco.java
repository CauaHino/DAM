package banco;

import java.util.ArrayList;

import cuentas.CuentaBancaria;
import cuentas.CuentaCorrienteEmpresa;

public class Banco {
	private static int contador = 0;
	private int idBanco;
	private ArrayList<CuentaBancaria> cuentas;
	private int numeroCuentas;
	
	public Banco() {
		contador++;
		this.idBanco = contador;
		this.cuentas = new ArrayList<CuentaBancaria>();
		this.numeroCuentas = 0;
	}
	
	public Banco(int idBanco, int numCuentas) {
		this.idBanco = idBanco;
		this.numeroCuentas = numCuentas;
	}
	
	public CuentaBancaria buscarCuenta(String IBAN) {
		/*for(int i=0; i < this.numeroCuentas; i++) {
			if(this.cuentas.get(i).getIBAN().equals(IBAN)) {
				return this.cuentas.get(i);
			}
		}*/
		for(CuentaBancaria c : this.cuentas) {
			if(c.getIBAN().equals(IBAN))
				return c;
		}
		return null;
	}
	
	public boolean abrirCuenta(CuentaBancaria c) {
		CuentaBancaria existe = this.buscarCuenta(c.getIBAN());
		if(existe != null) {
			System.out.println("La cuenta ya existe");
			return false;
		}
		this.cuentas.add(c);
		this.numeroCuentas++;
		return true;
	}
	
	public ArrayList<String> listadoCuentas() {
		ArrayList<String> infoCuentas = new ArrayList<String>();
		for(int i=0; i < this.numeroCuentas; i++) {
			infoCuentas.add(this.cuentas.get(i).devolverInfoString());
		}
		return infoCuentas;
	}
	
	public String informacionCuenta(String IBAN) {
		CuentaBancaria cuenta = this.buscarCuenta(IBAN);
		if(cuenta != null) {
			return cuenta.devolverInfoString();
		}
		return null;
	}
	
	public boolean ingresoCuenta(String IBAN, double cantidad) {
		CuentaBancaria cuenta = this.buscarCuenta(IBAN);
		if(cuenta != null) {
			cuenta.setSaldo(cuenta.getSaldo() + cantidad);
			return true;
		}
		return false;
	}
	
	public boolean retiradaCuenta(String IBAN, double cantidad) {
		CuentaBancaria cuenta = this.buscarCuenta(IBAN);
		if(cuenta != null) {
			boolean sePuedeRetirarDinero = false;
			if(cuenta.getSaldo() - cantidad >= 0) {
				sePuedeRetirarDinero = true;
			}
			else if(cuenta instanceof CuentaCorrienteEmpresa) {
				CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa)cuenta;
				if(Math.abs(cuenta.getSaldo() - cantidad) < aux.getMaximoDescubierto()) {
					sePuedeRetirarDinero = true;
				}
			}
			if(sePuedeRetirarDinero) {
				cuenta.setSaldo(cuenta.getSaldo() - cantidad);
			}
			return sePuedeRetirarDinero;
		}
		return false;
	}
	public double obtenerSaldo(String IBAN) {
		CuentaBancaria cuenta = this.buscarCuenta(IBAN);
		if(cuenta != null) {
			return cuenta.getSaldo();
		}
		return -1;
	}

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public ArrayList<CuentaBancaria> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<CuentaBancaria> cuentas) {
		this.cuentas = cuentas;
	}

	public int getNumeroCuentas() {
		return numeroCuentas;
	}

	public void setNumeroCuentas(int numeroCuentas) {
		this.numeroCuentas = numeroCuentas;
	}
	
}
