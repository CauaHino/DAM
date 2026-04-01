package principal;

import java.util.ArrayList;
import java.util.Scanner;

import banco.Banco;
import bbdd.conexion.ConexionBBDD;
import cuentas.CuentaAhorro;

import cuentas.CuentaBancaria;

import cuentas.CuentaCorrienteEmpresa;

import cuentas.CuentaCorrientePersonal;

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
		
		CuentaBancaria cuentaBancaria = null;
		// Conexión a BBDD
		ConexionBBDD conexion = new ConexionBBDD();		
		// Recupero el idBanco del último banco registrado en bbdd
		
		
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
				
				try {
					System.out.println("Introduce el IBAN");
					IBAN = entrada.nextLine();
					if (!IBAN.matches("^ES[0-9]{20}$")) {
						throw new IBANIncorrecto();
					}

					System.out.println("Introduce el saldo inicial");
					saldo = entrada.nextDouble();
					entrada.nextLine();
					// Extraemos el último idCuenta para que cuando insertemos una nueva cuenta su idCuenta sea el último + 1

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
						entrada.nextLine();
						cuentaBancaria = new CuentaAhorro(tipoInteres, titular, saldo, IBAN);
						
						// Insertamos en BBDD la CuentaBancaria	comprobando el idCuenta
						
								
						// Insertamos en BBDD la CuentaAhorro	

						
						break;
					case 2:
						System.out.println("Introduce una lista de entidades autorizadas");
						listaEntidades = entrada.nextLine();
						
						System.out.println("Introduce la comisión de mantenimiento");
						comisionMantenimiento = entrada.nextDouble();
						entrada.nextLine();
						cuentaBancaria = new CuentaCorrientePersonal(comisionMantenimiento, listaEntidades, titular, saldo, IBAN);
						
						// Insertamos en BBDD la CuentaBancaria	comprobando el idCuenta	
						
						// Insertamos en BBDD la CuentaCorriente	
						
						// Insertamos en BBDD la CuentaCorrientePersonal

						
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
						
						// Insertamos en BBDD la CuentaBancaria	comprobando el idCuenta		

						
						// Insertamos en BBDD la CuentaCorriente	

						
						// Insertamos en BBDD la CuentaCorrienteEmpresa

						
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
					// Registrar la cuenta en el banco
					
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
					// Consultar información de Cuenta de Ahorro
					
					break;
				case 2:
					// Consultar información de Cuenta Corriente Personal
					
					break;
				case 3:
					// Consultar información de Cuenta Corriente Empresa
					
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
					// Consultar cuenta por IBAN en BBDD
					
					if(cuentaBancaria != null)
						System.out.println(cuentaBancaria);
					else
						System.out.println("La cuenta no EXISTE");
					break;
				case 2:				
					System.out.println("Introduce el IBAN");
					IBAN = entrada.nextLine();
					// Consultar cuenta por IBAN en BBDD
					
					if(cuentaBancaria != null)
						System.out.println(cuentaBancaria);
					else
						System.out.println("La cuenta no EXISTE");
					break;
				case 3:
					System.out.println("Introduce el IBAN");
					IBAN = entrada.nextLine();
					// Consultar cuenta por IBAN en BBDD
					
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
				// Consultar cuenta en BBDD a partir de IBAN
				// Realizar ingreso
				
				/*if(ingreso realizado) {
					System.out.println("El ingreso se realizó correctamente");
				}
				else {
					System.out.println("El ingreo no se pudo realizar");
				}*/

				break;
			case 5:
				System.out.println("Introduce el IBAN");
				IBAN = entrada.nextLine();
				System.out.println("Introduce una cantidad a retirar");
				cantidad = entrada.nextDouble();
				entrada.nextLine();
				// Consultar cuenta en BBDD a partir de IBAN
				// Retirar salgo
				/*if() {
					System.out.println("El ingreso se realizó correctamente");
				}
				else {
					System.out.println("El ingreso no se pudo realizar");
				}*/
				
				break;
			case 6:
				System.out.println("Introduce el IBAN");
				IBAN = entrada.nextLine();
				// Consultar saldo
				
				/*if (saldo != -1) {
					System.out.println("El saldo es: " + saldo);
				} else {
					System.out.println("La cuenta no existe");
				}*/
				break;
			case 7:
				
				
				System.out.println("Tabla Personas creada correctamente");
				
				
				System.out.println("Tabla Banco creada correctamente");
				
					
				System.out.println("Tabla CuentaBancaria creada correctamente");
				
				
				System.out.println("Tabla CuentaAhorro creada correctamente");
				
				
				System.out.println("Tabla CuentaCorriente creada correctamente");
				
				
				System.out.println("Tabla CuentaCorrientePersonal creada correctamente");
				
				
				System.out.println("Tabla CuentaCorrienteEmpresa creada correctamente");
				
				
				
				
				
				
				break;
			case 8:
				salir = true;
				break;
			}
		}

	}

}
