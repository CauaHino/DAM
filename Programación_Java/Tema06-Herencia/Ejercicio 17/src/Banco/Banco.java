package Banco;

import Cuenta_bancaria.Cuenta_bancaria;

public class Banco {
	private Cuenta_bancaria[] cuentaBancaria;
	private int numCuentas;

	public Banco(int totalCuentas) {
		cuentaBancaria = new Cuenta_bancaria[totalCuentas];
		this.numCuentas = 0;
	}

	public Cuenta_bancaria buscarCuenta(String iban) {
		for (int i = 0; i < numCuentas; i++) {
			if (cuentaBancaria[i].getIban().equalsIgnoreCase(iban)) {
				return cuentaBancaria[i];
			}
		}
		return null;
	}

	public boolean abrirCuenta(Cuenta_bancaria nuevaCuenta) {
		if (numCuentas == cuentaBancaria.length) {
			System.out.println("No se puede abrir una nueva cuenta");
			return false;
		}
		if (buscarCuenta(nuevaCuenta.getIban()) != null) {
			System.out.println("Ese IBAN ya existe");
			return false;
		}
		cuentaBancaria[numCuentas] = nuevaCuenta;
		System.out.println("Cuenta creada con éxito");
		numCuentas++;
		return true;
	}

	public double obtenerSaldo(String iban) {
		if (buscarCuenta(iban) != null) {
			return buscarCuenta(iban).getSaldo();
		}
		return -1;
	}

	public boolean ingresoCuenta(String iban, double cantidad) {
		Cuenta_bancaria c = buscarCuenta(iban);
		if (c == null) {
			System.out.println("La cuenta buscada no existe");
			return false;
		} else {
			c.setSaldo(c.getSaldo() + cantidad);
			return true;
		}
	}

	public boolean retiradaCuenta(String iban, double cantidad) {
		Cuenta_bancaria c = buscarCuenta(iban);
		if (c == null) {
			System.out.println("La cuenta buscada no existe");
			return false;
		}
		if (cantidad > c.getSaldo()) {
			System.out.println("No fue posible hacer la retirada");
			return false;
		} else {
			c.setSaldo(c.getSaldo()-cantidad);
			System.out.println("La retirada fue hecha con éxito!");
			return true;
		}
	}
	public String[] listarCuentas () {
		String [] infoCuentas = new String [numCuentas];
		for(int i = 0; i < numCuentas; i++) {
			infoCuentas[i] = this.cuentaBancaria[i].toString();
		}
		return infoCuentas;
	}
		
		public String informacionCuenta (String iban) {
			Cuenta_bancaria c = buscarCuenta(iban);
			if (c == null) {
				System.out.println("La cuenta buscada no existe");
		}
			return c.toString();
		}

		public int getNumCuentas() {
			return numCuentas;
		}

		public void setNumCuentas(int numCuentas) {
			this.numCuentas = numCuentas;
		}

		public Cuenta_bancaria[] getCuentaBancaria() {
			return cuentaBancaria;
		}

		public void setCuentaBancaria(Cuenta_bancaria[] cuentaBancaria) {
			this.cuentaBancaria = cuentaBancaria;
		}
		
	}

