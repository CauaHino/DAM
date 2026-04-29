package principal;

import java.util.ArrayList;
import java.util.Scanner;

import banco.Banco;
import cuentas.CuentaAhorro;
import cuentas.CuentaBancaria;
import cuentas.CuentaCorrienteEmpresa;
import cuentas.CuentaCorrientePersonal;
import dao.BancoDAO;
import dao.CuentaAhorroDAO;
import dao.CuentaBancariaDAO;
import dao.CuentaCorrienteDAO;
import dao.CuentaCorrienteEmpresaDAO;
import dao.CuentaCorrientePersonalDAO;
import dao.PersonaDAO;
import excepciones.IBANIncorrecto;
import excepciones.TitularMenorDeEdad;
import personas.Persona;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		boolean salir = false;
		int opcion, tipoCuenta, edadTitular;
		String nombreTitular, apellidosTitular, DNITitular, IBAN, listaEntidades, infoCuenta;
		ArrayList<String> listaCuentas;
		Persona titular;
		double saldo, tipoInteres, comisionMantenimiento, tipoInteresDescubierto, maxDescubierto, comisionDescubierto,
				cantidad;
		
		boolean primeraVez = true;
		
		Banco banco = new Banco();
		Banco bancoBBDD = null;
	
		CuentaBancaria cuentaBancaria = null;
		ArrayList<String> listadoIBAN = null;
		
		// Conexión a BBDD
		PersonaDAO personaDAO = null;
		CuentaBancariaDAO cuentaBancariaDAO = null;
		CuentaAhorroDAO cuentaAhorroDAO = null;
		CuentaCorrienteDAO cuentaCorrienteDAO = null;
		CuentaCorrientePersonalDAO cuentaCorrientePersonalDAO = null;
		CuentaCorrienteEmpresaDAO cuentaCorrienteEmpresaDAO = null;
		BancoDAO bancoDAO = null;
				
		while (!salir) {
			System.out.println("1. Abrir una nueva cuenta.");
			System.out.println("2. Ver listado de las cuentas disponibles.");
			System.out.println("3. Obtener los datos de una cuenta concreta.");
			System.out.println("4. Realizar un ingreso en una cuenta.");
			System.out.println("5. Retirar efectivo de una cuenta.");
			System.out.println("6. Consultar el saldo actual de una cuenta.");
			System.out.println("7. Crear tablas en base de datos");
			System.out.println("8. Salir de la aplicación");
			opcion = entrada.nextInt();
			entrada.nextLine();
			switch (opcion) {
			case 1:
				// Antes de abrir una nueva cuenta debemos verificar que el banco existe, en este caso, consideramos que solo tendremos un único banco
				// Recupero el idBanco del último banco registrado en bbdd
				bancoDAO = new BancoDAO();
				bancoBBDD = bancoDAO.readBanco();
				if(bancoBBDD != null) {
					banco.setIdBanco(bancoBBDD.getIdBanco());
					banco.setNumeroCuentas(bancoBBDD.getNumeroCuentas());
				}
				else {
					bancoDAO.create(banco);
				}
				bancoDAO.getConexion().cerrarConexion();
				
				cuentaBancariaDAO = new CuentaBancariaDAO();
				listadoIBAN = cuentaBancariaDAO.readAllIBAN();
				cuentaBancariaDAO.getConexion().cerrarConexion();
				
				
				System.out.println("Introduce el nombre del titular");
				nombreTitular = entrada.nextLine();
				
				System.out.println("Introduce los apellidos del titular");
				apellidosTitular = entrada.nextLine();

				System.out.println("Introduce el DNI del titular");
				DNITitular = entrada.nextLine();

				System.out.println("Introduce la edad del titular");
				edadTitular = entrada.nextInt();
				entrada.nextLine();
				titular = new Persona(nombreTitular, apellidosTitular, DNITitular, edadTitular);
				
				// Insertar en BBDD
				personaDAO = new PersonaDAO();
				ArrayList<Persona> personas = personaDAO.read();
				if(personas.isEmpty())
					personaDAO.create(titular);
				else {
					titular.setIdPersona(personas.get(personas.size()-1).getIdPersona()+1);
					personaDAO.create(titular);
				}
				personaDAO.getConexion().cerrarConexion();
				try {
					// Mientras el IBAN sea incorrecto o ya exista en BBDD se vuelve a pedir por teclado
					boolean IBANCorrecto;
					do {
						IBANCorrecto = true;
						System.out.println("Introduce el IBAN");
						IBAN = entrada.nextLine();
						if (!IBAN.matches("^ES[0-9]{22}$")) {
							throw new IBANIncorrecto();
						}
						if(listadoIBAN != null) {
							for(String iban : listadoIBAN) {
								if(iban.equalsIgnoreCase(IBAN)) {
									System.out.println("El IBAN introducido ya existe en BBDD");
									IBANCorrecto = false;
									break;
								}
							}
						}
					}while(!IBANCorrecto);

					System.out.println("Introduce el saldo inicial");
					saldo = entrada.nextDouble();
					entrada.nextLine();
					
					// Seleccionamos el último idCuenta
					cuentaBancariaDAO = new CuentaBancariaDAO();
					int lastIdCuenta = cuentaBancariaDAO.readLastIdCuenta();
					
					System.out.println("Elige el tipo de cuenta");
					System.out.println("1. Cuenta de Ahorro");
					System.out.println("2. Cuenta de Corriente Personal");
					System.out.println("3. Cuenta de Corriente Empresa");
					tipoCuenta = entrada.nextInt();
					entrada.nextLine();
					switch (tipoCuenta) {
					case 1:
						System.out.println("Introduce el tipo de interés");
						tipoInteres = entrada.nextDouble();

						cuentaBancaria = new CuentaAhorro(tipoInteres, titular, saldo, IBAN);
						cuentaBancaria.setIdBanco(banco.getIdBanco());
						
						// Insertamos en BBDD la CuentaBancaria	
						if(lastIdCuenta == 0)
							cuentaBancariaDAO.create(cuentaBancaria);
						else {
							cuentaBancaria.setIdCuenta(lastIdCuenta+1);
							cuentaBancariaDAO.create(cuentaBancaria);
						}
						cuentaBancariaDAO.getConexion().cerrarConexion();
						
						// Insertamos en BBDD la CuentaAhorro	
						cuentaAhorroDAO = new CuentaAhorroDAO();
						cuentaAhorroDAO.create(cuentaBancaria);
						cuentaAhorroDAO.getConexion().cerrarConexion();					
						
						break;
					case 2:
						System.out.println("Introduce una lista de entidades autorizadas");
						listaEntidades = entrada.nextLine();
						System.out.println("Introduce la comisión de mantenimiento");
						comisionMantenimiento = entrada.nextDouble();
						cuentaBancaria = new CuentaCorrientePersonal(comisionMantenimiento, listaEntidades, titular,
								saldo, IBAN);
						cuentaBancaria.setIdBanco(banco.getIdBanco());
						// Insertamos en BBDD la CuentaBancaria		
						if(lastIdCuenta == 0)
							cuentaBancariaDAO.create(cuentaBancaria);
						else {
							cuentaBancaria.setIdCuenta(lastIdCuenta+1);
							cuentaBancariaDAO.create(cuentaBancaria);
						}
						cuentaBancariaDAO.getConexion().cerrarConexion();
						
						// Insertamos en BBDD la CuentaCorriente	
						cuentaCorrienteDAO = new CuentaCorrienteDAO();
						cuentaCorrienteDAO.create(cuentaBancaria);
						cuentaCorrienteDAO.getConexion().cerrarConexion();
						
						// Insertamos en BBDD la CuentaCorrientePersonal
						cuentaCorrientePersonalDAO = new CuentaCorrientePersonalDAO();
						cuentaCorrientePersonalDAO.create(cuentaBancaria);
						cuentaCorrientePersonalDAO.getConexion().cerrarConexion();
						
						break;
					case 3:
						System.out.println("Introduce una lista de entidades autorizadas");
						listaEntidades = entrada.nextLine();
						System.out.println("Introduce el tipo de interés por descubierto");
						tipoInteresDescubierto = entrada.nextDouble();
						entrada.nextLine();
						System.out.println("Introduce el máximo descubierto permitido");
						maxDescubierto = entrada.nextDouble();
						entrada.nextLine();
						System.out.println("Introduce la comisión por descubierto");
						comisionDescubierto = entrada.nextDouble();
						entrada.nextLine();
						cuentaBancaria = new CuentaCorrienteEmpresa(maxDescubierto, tipoInteresDescubierto,
								comisionDescubierto, listaEntidades, titular, saldo, IBAN);
						cuentaBancaria.setIdBanco(banco.getIdBanco());
						// Insertamos en BBDD la CuentaBancaria		
						if(lastIdCuenta == 0)
							cuentaBancariaDAO.create(cuentaBancaria);
						else {
							cuentaBancaria.setIdCuenta(lastIdCuenta+1);
							cuentaBancariaDAO.create(cuentaBancaria);
						}
						cuentaBancariaDAO.getConexion().cerrarConexion();
						
						// Insertamos en BBDD la CuentaCorriente	
						cuentaCorrienteDAO = new CuentaCorrienteDAO();
						cuentaCorrienteDAO.create(cuentaBancaria);
						cuentaCorrienteDAO.getConexion().cerrarConexion();
						
						// Insertamos en BBDD la CuentaCorrienteEmpresa
						cuentaCorrienteEmpresaDAO = new CuentaCorrienteEmpresaDAO();
						cuentaCorrienteEmpresaDAO.create(cuentaBancaria);
						cuentaCorrienteEmpresaDAO.getConexion().cerrarConexion();
						
						break;
					default:
						System.out.println("Debes elegir un tipo de cuenta");
					}
				} catch (TitularMenorDeEdad e) {
					System.err.println(e);
					e.printStackTrace();
				} catch (IBANIncorrecto e) {
					System.err.println(e);
					e.printStackTrace();
				}
				if (banco.abrirCuenta(cuentaBancaria)) {
					// Actualizar tabla Banco para incrementar el nº de cuentas
					bancoDAO = new BancoDAO();
					bancoDAO.updateNumCuentas(banco);
					bancoDAO.getConexion().cerrarConexion();
					
					System.out.println("Se ha abierto la cuenta correctamente");
				} else {
					System.out.println("Ha habido un error al abrir la cuenta");
				}
				break;
			case 2:
				System.out.println("Elige el tipo de cuenta");
				System.out.println("1. Cuenta de Ahorro");
				System.out.println("2. Cuenta de Corriente Personal");
				System.out.println("3. Cuenta de Corriente Empresa");
				tipoCuenta = entrada.nextInt();
				entrada.nextLine();
				switch (tipoCuenta) {
				case 1:
					cuentaAhorroDAO = new CuentaAhorroDAO();
					ArrayList<CuentaBancaria> cuentasAhorroBBDD = cuentaAhorroDAO.read();
					cuentaAhorroDAO.getConexion().cerrarConexion();
					for(int i=0; i < cuentasAhorroBBDD.size(); i++) {
						System.out.println(cuentasAhorroBBDD.get(i).devolverInfoString());
					}
					break;
				case 2:
					cuentaCorrientePersonalDAO = new CuentaCorrientePersonalDAO();
					ArrayList<CuentaBancaria> cuentasCorrientePersonalBBDD = cuentaCorrientePersonalDAO.read();		
					cuentaCorrientePersonalDAO.getConexion().cerrarConexion();
					for(int i=0; i < cuentasCorrientePersonalBBDD.size(); i++) {
						System.out.println(cuentasCorrientePersonalBBDD.get(i).devolverInfoString());
					}
					break;
				case 3:
					cuentaCorrienteEmpresaDAO = new CuentaCorrienteEmpresaDAO();
					ArrayList<CuentaBancaria> cuentasCorrienteEmpresaBBDD = cuentaCorrienteEmpresaDAO.read();
					cuentaCorrienteEmpresaDAO.getConexion().cerrarConexion();
					for(int i=0; i < cuentasCorrienteEmpresaBBDD.size(); i++) {
						System.out.println(cuentasCorrienteEmpresaBBDD.get(i).devolverInfoString());
					}
					break;
				default:
					System.out.println("Debes elegir un tipo de cuenta");
				}
				break;
			case 3:
				System.out.println("Elige el tipo de cuenta");
				System.out.println("1. Cuenta de Ahorro");
				System.out.println("2. Cuenta de Corriente Personal");
				System.out.println("3. Cuenta de Corriente Empresa");
				tipoCuenta = entrada.nextInt();
				entrada.nextLine();
				switch (tipoCuenta) {
				case 1:
					System.out.println("Introduce el IBAN");
					IBAN = entrada.nextLine();
					cuentaAhorroDAO = new CuentaAhorroDAO();
					cuentaBancaria = cuentaAhorroDAO.readIBAN(IBAN);
					cuentaAhorroDAO.getConexion().cerrarConexion();
					if(cuentaBancaria != null)
						System.out.println(cuentaBancaria);
					else
						System.out.println("La cuenta no EXISTE");
					break;
				case 2:				
					System.out.println("Introduce el IBAN");
					IBAN = entrada.nextLine();
					cuentaCorrientePersonalDAO = new CuentaCorrientePersonalDAO();
					cuentaBancaria = cuentaCorrientePersonalDAO.readIBAN(IBAN);
					cuentaCorrientePersonalDAO.getConexion().cerrarConexion();
					if(cuentaBancaria != null)
						System.out.println(cuentaBancaria);
					else
						System.out.println("La cuenta no EXISTE");
					break;
				case 3:
					System.out.println("Introduce el IBAN");
					IBAN = entrada.nextLine();
					cuentaCorrienteEmpresaDAO = new CuentaCorrienteEmpresaDAO();
					cuentaBancaria = cuentaCorrienteEmpresaDAO.readIBAN(IBAN);
					cuentaCorrienteEmpresaDAO.getConexion().cerrarConexion();
					if(cuentaBancaria != null)
						System.out.println(cuentaBancaria);
					else
						System.out.println("La cuenta no EXISTE");
					break;
				default:
					System.out.println("Debes elegir un tipo de cuenta");	
				}
				break;
			case 4:
				System.out.println("Introduce el IBAN");
				IBAN = entrada.nextLine();
				System.out.println("Introduce una cantidad a ingresar");
				cantidad = entrada.nextDouble();
				entrada.nextLine();
				cuentaBancariaDAO = new CuentaBancariaDAO();
				if(cuentaBancariaDAO.ingresarSaldo(IBAN, cantidad)) {
					System.out.println("El ingreso se realizó correctamente");
				}
				else {
					System.out.println("El ingreo no se pudo realizar");
				}
				cuentaBancariaDAO.getConexion().cerrarConexion();
				break;
			case 5:
				System.out.println("Introduce el IBAN");
				IBAN = entrada.nextLine();
				System.out.println("Introduce una cantidad a retirar");
				cantidad = entrada.nextDouble();
				entrada.nextLine();
				cuentaBancariaDAO = new CuentaBancariaDAO();
				if(cuentaBancariaDAO.retirarSaldo(IBAN, cantidad)) {
					System.out.println("El ingreso se realizó correctamente");
				}
				else {
					System.out.println("El ingreso no se pudo realizar");
				}
				cuentaBancariaDAO.getConexion().cerrarConexion();
				break;
			case 6:
				System.out.println("Introduce el IBAN");
				IBAN = entrada.nextLine();
				//saldo = banco.obtenerSaldo(IBAN);
				cuentaBancariaDAO = new CuentaBancariaDAO();
				saldo = cuentaBancariaDAO.consultarSaldo(IBAN);
				cuentaBancariaDAO.getConexion().cerrarConexion();
				if (saldo != -1) {
					System.out.println("El saldo es: " + saldo);
				} else {
					System.out.println("La cuenta no existe");
				}
				break;
			case 7:
				//Creamos la tabla personas
				personaDAO = new PersonaDAO();
				personaDAO.createTable();
				personaDAO.getConexion().cerrarConexion();
				System.out.println("Tabla Personas creada correctamente");
				
				bancoDAO = new BancoDAO();
				bancoDAO.createTable();
				System.out.println("Tabla Banco creada correctamente");
				
				cuentaBancariaDAO = new CuentaBancariaDAO();
				cuentaBancariaDAO.createTable();
				cuentaBancariaDAO.getConexion().cerrarConexion();	
				System.out.println("Tabla CuentaBancaria creada correctamente");
				
				cuentaAhorroDAO = new CuentaAhorroDAO();
				cuentaAhorroDAO.createTable();
				cuentaAhorroDAO.getConexion().cerrarConexion();
				System.out.println("Tabla CuentaAhorro creada correctamente");
				
				cuentaCorrienteDAO = new CuentaCorrienteDAO();
				cuentaCorrienteDAO.createTable();
				cuentaCorrienteDAO.getConexion().cerrarConexion();
				System.out.println("Tabla CuentaCorriente creada correctamente");
				
				cuentaCorrientePersonalDAO = new CuentaCorrientePersonalDAO();
				cuentaCorrientePersonalDAO.createTable();;
				cuentaCorrientePersonalDAO.getConexion().cerrarConexion();
				System.out.println("Tabla CuentaCorrientePersonal creada correctamente");
				
				cuentaCorrienteEmpresaDAO = new CuentaCorrienteEmpresaDAO();
				cuentaCorrienteEmpresaDAO.createTable();
				cuentaCorrienteEmpresaDAO.getConexion().cerrarConexion();
				System.out.println("Tabla CuentaCorrienteEmpresa creada correctamente");
				
				
				break;
			case 8:
				salir = true;
				break;
			}
		}

	}

}
