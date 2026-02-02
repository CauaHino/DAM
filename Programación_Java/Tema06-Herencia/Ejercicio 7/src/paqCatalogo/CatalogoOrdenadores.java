package paqCatalogo;

import ordenadores.OrdenadorIncompleto;
import ordenadores.OrdenadorPersonal;
import otrosOrdenadores.OrdenadorPortatil;

public class CatalogoOrdenadores {

	public static void main(String[] args) {
	OrdenadorIncompleto[] catalogo = new OrdenadorIncompleto[8];
			
	catalogo[0] = new OrdenadorPortatil("Dell", "D-001", 899.99, 3, 512, 16, 2.1);
    catalogo[1] = new OrdenadorPortatil("HP", "H-202", 750.50, 2, 256, 8, 1.9);
    catalogo[2] = new OrdenadorPortatil("Apple", "M4 Pro", 1200.00, 3, 1024, 32, 1.4);
		
    catalogo[3] = new OrdenadorPersonal("Lenovo", "L-101", 500.00, 3, 1000, 8, 24.0);
    catalogo[4] = new OrdenadorPersonal("Asus", "A-205", 650.00, 3, 2000, 16, 27.0);
    catalogo[5] = new OrdenadorPersonal("Acer", "AC-99", 450.00, 2, 500, 8, 21.5);
    catalogo[6] = new OrdenadorPersonal("MSI", "M-Gm", 1500.00, 4, 2048, 32, 32.0);
    catalogo[7] = new OrdenadorPersonal("Cyber", "CP-X", 900.00, 3, 1000, 16, 24.0);
    
    	mostrarCatalogo(catalogo);
	}
	
	public static void mostrarCatalogo(OrdenadorIncompleto c[]) {
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < 8; j++) {
				c[i].mostrarCaracteristicas(j);
			}
		}
	}


	}


