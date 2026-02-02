CREATE TABLE PROVEEDORES(
CODP CHAR(8) PRIMARY KEY,
DNI CHAR (10) UNIQUE, 
NOMBRE VARCHAR(20),
DIRECCION VARCHAR(15),
TLF CHAR(9), 
CIUDAD VARCHAR(15),
PAIS VARCHAR(10) NOT NULL 
);

CREATE TABLE ARTICULOS (
CODA CHAR(8) PRIMARY KEY,
NOMBRE VARCHAR(20),
PVP DECIMAL(7,0), 
COLOR CHAR (10),
CTD DECIMAL (7,0),
IVA DECIMAL (2,0)
);

ALTER TABLE ARTICULOS
ADD CONSTRAINT CHK_CTD
CHECK (CTD >= 0);

ALTER TABLE ARTICULOS
ADD CONSTRAINT CHK_IVA
CHECK (IVA BETWEEN 4 AND 18);

CREATE TABLE CLIENTES(
CODC CHAR(8) PRIMARY KEY,
DNI CHAR(10) UNIQUE,
NOMBRE VARCHAR(20) UNIQUE,
DIRECCION VARCHAR(15),
TLF CHAR(9)
);

-- Insertamos las informaciones en la tabla proveedores
INSERT INTO proveedores (codp, dni, nombre, direccion, tlf, ciudad, pais) VALUES
('P1', '1234567801', 'PROVEEDOR UNO', 'c/ uno, 1', '111111110', 'Albacete', 'España'),
('P2', '1234567802', 'PROVEEDOR DOS', 'c/ dos, 2', '222222220', 'Aalborg', 'Dinamarca'),
('P3', '1234567803', 'PROVEEDOR TRES', 'c/ tres, 3', '333333330', 'Perth', 'Australia'),
('P4', '1234567804', 'PROVEEDOR CUATRO', 'c/ cuatro, 4', '444444440', 'Budapest', 'Hungría'),
('P5', '1234567805', 'PROVEEDOR CINCO', 'c/ cinco, 5', '555555550', 'Hiroshima', 'Japón'),
('P6', '1234567806', 'PROVEEDOR SEIS', 'c/ seis, 6', '666666660', 'La Plata', 'Argentina'),
('P7', '1234567807', 'PROVEEDOR SIETE', 'c/ siete, 7', '777777770', 'Liverpool', 'G. Bretaña'),
('P8', '1234567808', 'PROVEEDOR OCHO', 'c/ ocho, 8', '888888880', 'Adelaida', 'Australia'),
('P9', '1234567809', 'PROVEEDOR NUEVE', 'c/ nueve, 9', '999999990', 'Alicante', 'España'),
('P10', '1234567810', 'PROVEEDOR DIEZ', 'c/ diez, 10', '000000000', 'Paris', 'Francia'),
('P11', '1234567811', 'PROVEEDOR ONCE', 'c/ once, 11', '111111111', 'Odense', 'Dinamarca'),
('P12', '1234567812', 'PROVEEDOR DOCE', 'c/ doce, 12', '222222221', 'Madrid', 'España'),
('P13', '1234567813', 'PROVEEDOR TRECE', 'c/ trece, 13', '333333331', 'Paris', 'Francia'),
('P14', '1234567814', 'PROVEEDOR CATORCE', 'c/ catorce, 14', '444444441', 'Bonn', 'Alemania'),
('P15', '1234567815', 'PROVEEDOR QUINCE', 'c/ quince, 15', '555555551', 'Albacete', 'España');
-- AHORA INSERTAMOS LAS INFORMACIONES DE LA TABLA ARTICULO

INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES
('A1', 'ARTICULO UNO', NULL, 'VERDE', 150, 12),
('A2', 'ARTICULO DOS', NULL, 'AZUL', 350, 6),
('A3', 'ARTICULO TRES', NULL, 'AZUL', 550, 6),
('A4', 'ARTICULO CUATRO', NULL, 'BLANCO', 1000, 12),
('A5', 'ARTICULO CINCO', NULL, 'NEGRO', 500, 12),
('A6', 'ARTICULO SEIS', NULL, 'NEGRO', 550, 12),
('A7', 'ARTICULO SIETE', NULL, 'AMARILLO', 350, 6),
('A8', 'ARTICULO OCHO', NULL, 'ROJO', 3050, 12),
('A9', 'ARTICULO NUEVE', NULL, 'ROJO', 50, 12),
('A10', 'ARTICULO DIEZ', NULL, 'AZUL', 30, 6),
('A11', 'ARTICULO ONCE', NULL, 'VERDE', 150, 12),
('A12', 'ARTICULO DOCE', NULL, 'ROJO', 700, 12),
('A13', 'ARTICULO TRECE', NULL, 'METALICO', 1350, 12),
('A14', 'ARTICULO CATORCE', NULL, 'BLANCO', 1100, 6),
('A15', 'ARTICULO QUINCE', NULL, 'NEGRO', 500, 12),
('A16', 'ARTICULO DIECISEIS', NULL, 'AMBAR', 50, 12),
('A17', 'ARTICULO DIECISIETE', NULL, 'OCRE', 2350, 6),
('A18', 'ARTICULO DIECIOCHO', NULL, 'GRIS', 3250, 12),
('A19', 'ARTICULO DIECINUEVE', NULL, 'ROJO', 5000, 6),
('A20', 'ARTICULO VEINTE', NULL, 'AZUL', 300, 12);
-- Insertamos las informaciones en la tabla clientes
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES
('C1', '0123456701', 'CLIENTE UNO', 'c/ cuno,1', '999234546'),
('C2', '0123456702', 'CLIENTE DOS', 'c/ cdos, 2', '999343434'),
('C3', '0123456703', 'CLIENTE TRES', 'c/ ctres, 3', '666123455'),
('C4', '0123456704', 'CLIENTE CUATRO', 'c/ ccuatro, 4', '666445566'),
('C5', '0123456705', 'CLIENTE CINCO', 'c/ ccinco,5', '777553434'),
('C6', '0123456706', 'CLIENTE SEIS', 'c/ cseis, 6', '777664567'),
('C7', '0123456707', 'CLIENTE SIETE', 'c/ csiete, 7', '444773457'),
('C8', '0123456708', 'CLIENTE OCHO', 'c/ cocho, 8', '444887865'),
('C9', '0123456709', 'CLIENTE NUEVE', 'c/ cnueve, 9', '998776'),
('C10', '0123456710', 'CLIENTE DIEZ', 'c/ cdiez, 10', '101010'),
('C11', '0123456711', 'CLIENTE ONCE', 'c/ conce, 11', '111122'),
('C12', '0123456712', 'CLIENTE DOCE', 'c/ cdoce, 12', '123432'),
('C13', '0123456713', 'CLIENTE TRECE', 'c/ ctrece, 13', '131323'),
('C14', '0123456714', 'CLIENTE CATORCE', 'c/ ccatorce, 14', '143442'),
('C15', '0123456715', 'CLIENTE QUINCE', 'c/ cquince,15', '152345');
-- Creamos la sentencia para eliminar la tabla FACTURAS 
-- en caso de que exista
DROP TABLE IF EXISTS facturas;
-- Creamos la tabla FACTURAS con sus atributos
CREATE TABLE facturas (
	NF CHAR(4) PRIMARY KEY,
	CTD DECIMAL (7,0),
	FECHA DATE NOT NULL,
	PRECIO DECIMAL(7,0),
	PAGADA DATE,
	CODA CHAR(8) NOT NULL,
	CODC CHAR(8) NOT NULL
);

-- Añadimos la restriccion a la tabla FACTURAS
-- para añadir la FK
ALTER TABLE facturas
ADD CONSTRAINT FK_Facturas_CODA
FOREIGN KEY (CODA)
REFERENCES ARTICULOS(CODA);

-- Añadimos una nueva restriccion a la TABLA FACTURAS
-- para añadir la FK de CODC
ALTER TABLE facturas
ADD CONSTRAINT FK_Facturas_CODC
FOREIGN KEY(CODC)
REFERENCES CLIENTES(CODC);

-- Añadimos datos a la tabla FACTURAS
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES
(1, 10, '2009-02-13', 350, '2009-02-13', 'A1', 'C1'),
(2, 21, '2009-04-12', 550, '2009-04-12', 'A2', 'C7'),
(3, 80, '2009-04-12', 1000, NULL, 'A1', 'C1'),
(4, 23, '2009-04-12', 550, '2009-05-17', 'A3', 'C2'),
(5, 100, '2009-04-12', 446, NULL, 'A1', 'C3'),
(6, 21, '2009-05-21', 1150, '2009-05-21', 'A4', 'C4'),
(7, 80, '2009-05-31', 1040, NULL, 'A4', 'C5'),
(8, 623, '2009-07-21', 460, '2009-07-26', 'A5', 'C8'),
(9, 5000, '2009-08-10', 1350, '2009-08-10', 'A8', 'C9'),
(10, 2100, '2009-09-12', 1550, NULL, 'A8', 'C9'),
(11, 800, '2009-09-22', 1000, '2009-11-24', 'A3', 'C10'),
(12, 230, '2009-10-07', 234, '2009-10-07', 'A10', 'C2'),
(13, 100, '2009-11-12', 129, '2009-11-12', 'A11', 'C11'),
(14, 1221, '2009-11-21', 1350, '2010-08-11', 'A12', 'C3'),
(15, 79, '2009-12-10', 40, NULL, 'A12', 'C10'),
(16, 523, '2009-12-11', 3478, '2009-12-11', 'A9', 'C8'),
(17, 5330, '2010-01-10', 350, '2010-01-10', 'A13', 'C15'),
(18, 1450, '2010-01-22', 323, NULL, 'A4', 'C13'),
(19, 121, '2010-02-02', 1123, NULL, 'A4', 'C13'),
(20, 446, '2010-02-02', 234, '2010-04-12', 'A13', 'C2'),
(21, 1100, '2010-02-14', 1129, NULL, 'A1', 'C8'),
(22, 251, '2010-02-21', 150, '2010-02-21', 'A7', 'C12'),
(23, 179, '2010-02-28', 400, '2010-05-28', 'A10', 'C12'),
(24, 223, '2010-03-10', 2178, '2010-03-15', 'A2', 'C3');
-- Creamos la sentencia para eliminar la tabla SUMINISTROS
-- en caso de que exista
DROP TABLE IF EXISTS suministros;
-- Creamos la tabla SUMINISTROS con sus atributos
CREATE TABLE SUMINISTROS (
	CODP CHAR(8) REFERENCES proveedores(CODP),
	CODA CHAR(8) REFERENCES articulos(CODA),
	PUC DECIMAL(7,0) NOT NULL,
	PRIMARY KEY (CODP,CODA)
);

-- Insertamos los datos en la tabla SUMINISTROS
INSERT INTO suministros (codp, coda, puc) VALUES
('P13', 'A1', 1234),
('P13', 'A4', 234),
('P13', 'A15', 934),
('P14', 'A2', 724),
('P14', 'A3', 134),
('P14', 'A16', 764),
('P15', 'A5', 334),
('P15', 'A6', 224),
('P15', 'A14', 1123),
('P9', 'A7', 534),
('P9', 'A8', 134),
('P9', 'A13', 54),
('P10', 'A12', 434),
('P10', 'A16', 674),
('P10', 'A4', 1334),
('P11', 'A18', 324),
('P11', 'A17', 35),
('P11', 'A1', 456),
('P11', 'A3', 754),
('P2', 'A2', 95),
('P2', 'A14', 134),
('P3', 'A5', 174),
('P3', 'A12', 1000),
('P3', 'A3', 356),
('P12', 'A2', 77),
('P12', 'A7', 336),
('P5', 'A12', 454),
('P5', 'A16', 1195),
('P5', 'A4', 634),
('P6', 'A1', 374),
('P13', 'A12', 1000),
('P3', 'A6', 500);

-- Creamos la sentencia para eliminar la tabla MONEDAS
-- en caso de que exista
DROP TABLE IF EXISTS monedas;
-- Creamos la tabla MONEDAS con sus atributos
CREATE TABLE monedas (
	PAIS VARCHAR(10) PRIMARY KEY,
	NOMBRE VARCHAR(20),
	PCOMPRA DECIMAL(9,6),
	PVENTA DECIMAL(9,6)
);

-- Añadimos las restricciones a la tabla MONEDAS para los campos PCOMPRA & PVENTA
ALTER TABLE monedas
ADD CONSTRAINT CK_Monedas_PCOMPRA
CHECK (
	PCOMPRA > 0
);

ALTER TABLE monedas
ADD CONSTRAINT CK_Monedas_PVENTA
CHECK (
	PVENTA > 0
);

-- Insertamos valores a la tabla MONEDAS
INSERT INTO monedas (pais, nombre, pcompra, pventa) VALUES
('Alemania', 'Euro', 1, 1),
('Argentina', 'Peso argentino', 0.27844, 0.27879),
('Australia', 'Dólar australiano', 0.62331, 0.62398),
('Dinamarca', 'Corona danesa', 0.13396, 0.1340),
('EE.UU.', 'Dólar', 0.82768, 0.82802),
('España', 'Euro', 1, 1),
('Francia', 'Euro', 1, 1),
('G. Bretaña', 'Libra', 1.46351, 1.46505),
('Hungría', 'Forint', 0.003947, 0.003964),
('Japón', 'Yen', 0.007248, 0.007251);
-- Ponemos la FK de Pais en Proveedores
ALTER TABLE PROVEEDORES
ADD CONSTRAINT FK_Proveedores_Pais
FOREIGN KEY (PAIS)
REFERENCES monedas(PAIS);

-- Creamos el index único

-- Para la tabla FACTURAS 
CREATE INDEX IFE ON facturas (FECHA); 

-- Para la tabla MONEDAS 
CREATE INDEX INOMBRE ON monedas (NOMBRE);

