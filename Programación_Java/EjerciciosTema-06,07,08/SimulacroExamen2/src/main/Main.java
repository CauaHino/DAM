package main;

import java.io.*;

import Pasajeros.Pasajeros;
import excepciones.NumAsientosNegativo;
import excepciones.PotenciaNegativa;
import locomotoras.Locomotora;
import trenes.Tren;
import vagones.*;

public class Main {

	public static void main(String[] args) {
		Tren[] trenes = new Tren[3];
		Vagones[] vagonesMixtos = new Vagones[4];
		vagonPasajero[] vagonesPasajeros = new vagonPasajero[3];
		VagonesMercancia[] vagonesMercancia = new VagonesMercancia[3];
		Locomotora[] locomotoras = new Locomotora[2];
		Pasajeros pasajero = null;
		Pasajeros[] pasajeros = new Pasajeros[4];
		String tipo ="", marca = "", modelo = "", nombre = "", potencia = "", infoBillete = "", numAsientos = "", capacidad = "";
		
		try(BufferedReader br = new BufferedReader(new FileReader("datosPasajeros.txt"))){
			String linea = "";
			linea = br.readLine();
			
			for(int i = 0; i < pasajeros.length && linea != null; i++) {
				if("Pasajero".equalsIgnoreCase(linea)) {
					nombre = br.readLine();
					infoBillete = br.readLine();
					pasajero = new Pasajeros(nombre, infoBillete);
					pasajeros[i] = pasajero;	
					}
				linea = br.readLine();
			}
			System.out.println("--------------------------INFO DEL PASAJERO ANTES DE SUBIR--------------------------");
			for(Pasajeros p : pasajeros) {
				if(p != null) {
					System.out.println(p.toString());
					System.out.println("----------------------------------------------------");
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader("datosTrenes.txt"))) {
			String linea = br.readLine();
			int iLoc = 0, iVagP = 0, iVagMer = 0, iVagMix = 0;
			
			while(linea != null) {
				if("locomotora".equalsIgnoreCase(linea)) {
					marca = br.readLine();
					modelo = br.readLine();
					tipo = br.readLine();
					potencia = br.readLine();
					
					locomotoras[iLoc] = new Locomotora(marca, modelo, tipo, Double.parseDouble(potencia));
					iLoc++;
				} else if("vagonPasajeros".equalsIgnoreCase(linea)) {
					marca = br.readLine();
					modelo = br.readLine();
					numAsientos = br.readLine();
					
					vagonesPasajeros[iVagP] = new vagonPasajero(marca, modelo, Integer.parseInt(numAsientos));
					iVagP++;
				} else if ("VagonMercancias".equalsIgnoreCase(linea)) {
					marca = br.readLine();
					modelo = br.readLine();
					capacidad = br.readLine();
					
					vagonesMercancia[iVagMer] = new VagonesMercancia(marca, modelo, Double.parseDouble(capacidad));
					iVagMer++;
					vagonesMixtos[iVagMix] = new VagonesMercancia(marca, modelo, Double.parseDouble(capacidad));
					iVagMix++;
				}
				linea = br.readLine();
			}
			
			System.out.println("--------------------------INFO LOCOMOTORA--------------------------");
			for(Locomotora l : locomotoras) {
				if(l != null) {
					System.out.println(l.toString());
					System.out.println("----------------------------------------------------");
				}
			}
			for(Pasajeros p : pasajeros) {
				for(vagonPasajero vp : vagonesPasajeros) {
					vp.sentarPasajero(p);
				}
			}
			
			for(int i = 0; i < vagonesPasajeros.length; i++) {
				if(vagonesPasajeros[i].getNumPasajeros() == 0) {
					vagonesMixtos[iVagMix] = vagonesPasajeros[i];
					iVagMix++;
					vagonesPasajeros[i] = null;
				}
			}
			
			System.out.println("INFORMACIÓN DE LOS VAGONES DE PASAJEROS");
			for (vagonPasajero vp : vagonesPasajeros) {
				if(vp != null)
				System.out.println(vp.toString());
			}
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("INFORMACIÓN DE LOS VAGONES DE MERCANCÍAS");
			for (VagonesMercancia vm : vagonesMercancia) {
				System.out.println(vm.toString());
			}
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("INFORMACIÓN DE LOS VAGONES DE MIXTOS");
			for (Vagones v : vagonesMixtos)
				System.out.println(v);
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PotenciaNegativa e) {
			// TODO Auto-generated catch block
			System.err.println(e.toString());
		} catch (NumAsientosNegativo e) {
			// TODO Auto-generated catch block
			System.err.println(e.toString());
		}
		
		Locomotora locElec = null;
		Locomotora locDiesel = null;
		for(Locomotora l : locomotoras) {
			if(l.getTipo().equalsIgnoreCase("Eléctrica")) {
				locElec = l;
			} else {
				locDiesel = l;
			}
		}
		trenes[0] = new Tren(locDiesel, vagonesPasajeros);
		trenes[1] = new Tren(locElec, vagonesMercancia);
		trenes[2] = new Tren(locElec, vagonesMixtos);

		System.out.println("INFORMACIÓN DE LOS TRENES");
		for(Tren t : trenes) {
			System.out.println(t);
			System.out.println("-------------------------------------------------------------------------------");
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("InfoTrenes.txt"))){
			for(Tren t : trenes) {
				bw.write("TREN: \tID: " + t.getId());
				bw.newLine();
				bw.write("\t" + t.getLocomotora().toString());
				bw.newLine();
				for (int iFich = 0; iFich < t.getVagones().length; iFich++) {
					if (t.getVagones()[iFich] != null) {
						bw.write("\t" + t.getVagones()[iFich].toString());
						bw.newLine();
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
