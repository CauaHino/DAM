-- 1. BORRADO (Orden inverso)
DROP TABLE SUMINISTROS CASCADE CONSTRAINTS;
DROP TABLE FACTURAS CASCADE CONSTRAINTS;
DROP TABLE PROVEEDORES CASCADE CONSTRAINTS;
DROP TABLE ARTICULOS CASCADE CONSTRAINTS;
DROP TABLE CLIENTES CASCADE CONSTRAINTS;
DROP TABLE MONEDAS CASCADE CONSTRAINTS;

-- 2. CREACIÓN DE TABLAS
CREATE TABLE MONEDAS (
    PAIS VARCHAR2(15) PRIMARY KEY,
    NOMBRE VARCHAR2(20),
    PCOMPRA NUMBER(9,6) CHECK (PCOMPRA > 0),
    PVENTA NUMBER(9,6) CHECK (PVENTA > 0)
);

CREATE TABLE CLIENTES(
    CODC CHAR(8) PRIMARY KEY,
    DNI CHAR(10) UNIQUE,
    NOMBRE VARCHAR2(50) UNIQUE,
    DIRECCION VARCHAR2(50),
    TLF CHAR(9)
);

CREATE TABLE ARTICULOS (
    CODA CHAR(8) PRIMARY KEY,
    NOMBRE VARCHAR2(50),
    PVP NUMBER(7,2), 
    COLOR CHAR(10),
    CTD NUMBER(7,0) CHECK (CTD >= 0),
    IVA NUMBER(2,0) CHECK (IVA BETWEEN 4 AND 18)
);

CREATE TABLE PROVEEDORES(
    CODP CHAR(8) PRIMARY KEY,
    DNI CHAR (10) UNIQUE, 
    NOMBRE VARCHAR2(20),
    DIRECCION VARCHAR2(15),
    TLF CHAR(9), 
    CIUDAD VARCHAR2(15),
    PAIS VARCHAR2(15) NOT NULL,
    CONSTRAINT FK_PROV_PAIS FOREIGN KEY (PAIS) REFERENCES MONEDAS(PAIS)
);

CREATE TABLE FACTURAS (
    NF NUMBER(4) PRIMARY KEY,
    CTD NUMBER(7,0),
    FECHA DATE NOT NULL,
    PRECIO NUMBER(7,0),
    PAGADA DATE,
    CODA CHAR(8) NOT NULL REFERENCES ARTICULOS(CODA),
    CODC CHAR(8) NOT NULL REFERENCES CLIENTES(CODC)
);

CREATE TABLE SUMINISTROS (
    CODP CHAR(8) REFERENCES PROVEEDORES(CODP),
    CODA CHAR(8) REFERENCES ARTICULOS(CODA),
    PUC NUMBER(7,0) NOT NULL,
    PRIMARY KEY (CODP, CODA)
);

-- 3. INSERCIÓN DE DATOS (ORDEN CORREGIDO)

-- A. PRIMERO MONEDAS (Obligatorio para que existan los países)
INSERT INTO monedas (pais, nombre, pcompra, pventa) VALUES ('Alemania', 'Euro', 1, 1);
INSERT INTO monedas (pais, nombre, pcompra, pventa) VALUES ('Argentina', 'Peso argentino', 0.27844, 0.27879);
INSERT INTO monedas (pais, nombre, pcompra, pventa) VALUES ('Australia', 'Dólar australiano', 0.62331, 0.62398);
INSERT INTO monedas (pais, nombre, pcompra, pventa) VALUES ('Dinamarca', 'Corona danesa', 0.13396, 0.1340);
INSERT INTO monedas (pais, nombre, pcompra, pventa) VALUES ('EE.UU.', 'Dólar', 0.82768, 0.82802);
INSERT INTO monedas (pais, nombre, pcompra, pventa) VALUES ('España', 'Euro', 1, 1);
INSERT INTO monedas (pais, nombre, pcompra, pventa) VALUES ('Francia', 'Euro', 1, 1);
INSERT INTO monedas (pais, nombre, pcompra, pventa) VALUES ('G. Bretaña', 'Libra', 1.46351, 1.46505);
INSERT INTO monedas (pais, nombre, pcompra, pventa) VALUES ('Hungría', 'Forint', 0.003947, 0.003964);
INSERT INTO monedas (pais, nombre, pcompra, pventa) VALUES ('Japón', 'Yen', 0.007248, 0.007251);

-- B. SEGUNDO PROVEEDORES (Ahora sí encontrará los países)
INSERT ALL 
  INTO proveedores VALUES ('P1', '1234567801', 'PROVEEDOR UNO', 'c/ uno, 1', '111111110', 'Albacete', 'España')
  INTO proveedores VALUES ('P2', '1234567802', 'PROVEEDOR DOS', 'c/ dos, 2', '222222220', 'Aalborg', 'Dinamarca')
  INTO proveedores VALUES ('P3', '1234567803', 'PROVEEDOR TRES', 'c/ tres, 3', '333333330', 'Perth', 'Australia')
  INTO proveedores VALUES ('P4', '1234567804', 'PROVEEDOR CUATRO', 'c/ cuatro, 4', '444444440', 'Budapest', 'Hungría')
  INTO proveedores VALUES ('P5', '1234567805', 'PROVEEDOR CINCO', 'c/ cinco, 5', '555555550', 'Hiroshima', 'Japón')
  INTO proveedores VALUES ('P6', '1234567806', 'PROVEEDOR SEIS', 'c/ seis, 6', '666666660', 'La Plata', 'Argentina')
  INTO proveedores VALUES ('P7', '1234567807', 'PROVEEDOR SIETE', 'c/ siete, 7', '777777770', 'Liverpool', 'G. Bretaña')
  INTO proveedores VALUES ('P8', '1234567808', 'PROVEEDOR OCHO', 'c/ ocho, 8', '888888880', 'Adelaida', 'Australia')
  INTO proveedores VALUES ('P9', '1234567809', 'PROVEEDOR NUEVE', 'c/ nueve, 9', '999999990', 'Alicante', 'España')
  INTO proveedores VALUES ('P10', '1234567810', 'PROVEEDOR DIEZ', 'c/ diez, 10', '000000000', 'Paris', 'Francia')
  INTO proveedores VALUES ('P11', '1234567811', 'PROVEEDOR ONCE', 'c/ once, 11', '111111111', 'Odense', 'Dinamarca')
  INTO proveedores VALUES ('P12', '1234567812', 'PROVEEDOR DOCE', 'c/ doce, 12', '222222221', 'Madrid', 'España')
  INTO proveedores VALUES ('P13', '1234567813', 'PROVEEDOR TRECE', 'c/ trece, 13', '333333331', 'Paris', 'Francia')
  INTO proveedores VALUES ('P14', '1234567814', 'PROVEEDOR CATORCE', 'c/ catorce, 14', '444444441', 'Bonn', 'Alemania')
  INTO proveedores VALUES ('P15', '1234567815', 'PROVEEDOR QUINCE', 'c/ quince, 15', '555555551', 'Albacete', 'España')
SELECT * FROM dual;

-- C. TERCERO ARTÍCULOS Y CLIENTES
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A1', 'ARTICULO UNO', NULL, 'VERDE', 150, 12);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A2', 'ARTICULO DOS', NULL, 'AZUL', 350, 6);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A3', 'ARTICULO TRES', NULL, 'AZUL', 550, 6);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A4', 'ARTICULO CUATRO', NULL, 'BLANCO', 1000, 12);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A5', 'ARTICULO CINCO', NULL, 'NEGRO', 500, 12);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A6', 'ARTICULO SEIS', NULL, 'NEGRO', 550, 12);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A7', 'ARTICULO SIETE', NULL, 'AMARILLO', 350, 6);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A8', 'ARTICULO OCHO', NULL, 'ROJO', 3050, 12);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A9', 'ARTICULO NUEVE', NULL, 'ROJO', 50, 12);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A10', 'ARTICULO DIEZ', NULL, 'AZUL', 30, 6);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A11', 'ARTICULO ONCE', NULL, 'VERDE', 150, 12);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A12', 'ARTICULO DOCE', NULL, 'ROJO', 700, 12);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A13', 'ARTICULO TRECE', NULL, 'METALICO', 1350, 12);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A14', 'ARTICULO CATORCE', NULL, 'BLANCO', 1100, 6);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A15', 'ARTICULO QUINCE', NULL, 'NEGRO', 500, 12);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A16', 'ARTICULO DIECISEIS', NULL, 'AMBAR', 50, 12);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A17', 'ARTICULO DIECISIETE', NULL, 'OCRE', 2350, 6);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A18', 'ARTICULO DIECIOCHO', NULL, 'GRIS', 3250, 12);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A19', 'ARTICULO DIECINUEVE', NULL, 'ROJO', 5000, 6);
INSERT INTO articulos (coda, nombre, pvp, color, ctd, iva) VALUES ('A20', 'ARTICULO VEINTE', NULL, 'AZUL', 300, 12);

INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C1', '0123456701', 'CLIENTE UNO', 'c/ cuno,1', '999234546');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C2', '0123456702', 'CLIENTE DOS', 'c/ cdos, 2', '999343434');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C3', '0123456703', 'CLIENTE TRES', 'c/ ctres, 3', '666123455');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C4', '0123456704', 'CLIENTE CUATRO', 'c/ ccuatro, 4', '666445566');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C5', '0123456705', 'CLIENTE CINCO', 'c/ ccinco,5', '777553434');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C6', '0123456706', 'CLIENTE SEIS', 'c/ cseis, 6', '777664567');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C7', '0123456707', 'CLIENTE SIETE', 'c/ csiete, 7', '444773457');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C8', '0123456708', 'CLIENTE OCHO', 'c/ cocho, 8', '444887865');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C9', '0123456709', 'CLIENTE NUEVE', 'c/ cnueve, 9', '998776');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C10', '0123456710', 'CLIENTE DIEZ', 'c/ cdiez, 10', '101010');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C11', '0123456711', 'CLIENTE ONCE', 'c/ conce, 11', '111122');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C12', '0123456712', 'CLIENTE DOCE', 'c/ cdoce, 12', '123432');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C13', '0123456713', 'CLIENTE TRECE', 'c/ ctrece, 13', '131323');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C14', '0123456714', 'CLIENTE CATORCE', 'c/ ccatorce, 14', '143442');
INSERT INTO clientes (codc, dni, nombre, direccion, tlf) VALUES ('C15', '0123456715', 'CLIENTE QUINCE', 'c/ cquince,15', '152345');

-- D. CUARTO FACTURAS Y SUMINISTROS (Los hijos finales)
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (1, 10, DATE '2009-02-13', 350, DATE '2009-02-13', 'A1', 'C1');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (2, 21, DATE '2009-04-12', 550, DATE '2009-04-12', 'A2', 'C7');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (3, 80, DATE '2009-04-12', 1000, NULL, 'A1', 'C1');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (4, 23, DATE '2009-04-12', 550, DATE '2009-05-17', 'A3', 'C2');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (5, 100, DATE '2009-04-12', 446, NULL, 'A1', 'C3');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (6, 21, DATE '2009-05-21', 1150, DATE '2009-05-21', 'A4', 'C4');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (7, 80, DATE '2009-05-31', 1040, NULL, 'A4', 'C5');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (8, 623, DATE '2009-07-21', 460, DATE '2009-07-26', 'A5', 'C8');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (9, 5000, DATE '2009-08-10', 1350, DATE '2009-08-10', 'A8', 'C9');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (10, 2100, DATE '2009-09-12', 1550, NULL, 'A8', 'C9');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (11, 800, DATE '2009-09-22', 1000, DATE '2009-11-24', 'A3', 'C10');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (12, 230, DATE '2009-10-07', 234, DATE '2009-10-07', 'A10', 'C2');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (13, 100, DATE '2009-11-12', 129, DATE '2009-11-12', 'A11', 'C11');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (14, 1221, DATE '2009-11-21', 1350, DATE '2010-08-11', 'A12', 'C3');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (15, 79, DATE '2009-12-10', 40, NULL, 'A12', 'C10');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (16, 523, DATE '2009-12-11', 3478, DATE '2009-12-11', 'A9', 'C8');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (17, 5330, DATE '2010-01-10', 350, DATE '2010-01-10', 'A13', 'C15');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (18, 1450, DATE '2010-01-22', 323, NULL, 'A4', 'C13');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (19, 121, DATE '2010-02-02', 1123, NULL, 'A4', 'C13');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (20, 446, DATE '2010-02-02', 234, DATE '2010-04-12', 'A13', 'C2');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (21, 1100, DATE '2010-02-14', 1129, NULL, 'A1', 'C8');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (22, 251, DATE '2010-02-21', 150, DATE '2010-02-21', 'A7', 'C12');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (23, 179, DATE '2010-02-28', 400, DATE '2009-05-28', 'A10', 'C12');
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES (24, 223, DATE '2010-03-10', 2178, DATE '2010-03-15', 'A2', 'C3');

INSERT INTO suministros (codp, coda, puc) VALUES ('P13', 'A1', 1234);
INSERT INTO suministros (codp, coda, puc) VALUES ('P13', 'A4', 234);
INSERT INTO suministros (codp, coda, puc) VALUES ('P13', 'A15', 934);
INSERT INTO suministros (codp, coda, puc) VALUES ('P14', 'A2', 724);
INSERT INTO suministros (codp, coda, puc) VALUES ('P14', 'A3', 134);
INSERT INTO suministros (codp, coda, puc) VALUES ('P14', 'A16', 764);
INSERT INTO suministros (codp, coda, puc) VALUES ('P15', 'A5', 334);
INSERT INTO suministros (codp, coda, puc) VALUES ('P15', 'A6', 224);
INSERT INTO suministros (codp, coda, puc) VALUES ('P15', 'A14', 1123);
INSERT INTO suministros (codp, coda, puc) VALUES ('P9', 'A7', 534);
INSERT INTO suministros (codp, coda, puc) VALUES ('P9', 'A8', 134);
INSERT INTO suministros (codp, coda, puc) VALUES ('P9', 'A13', 54);
INSERT INTO suministros (codp, coda, puc) VALUES ('P10', 'A12', 434);
INSERT INTO suministros (codp, coda, puc) VALUES ('P10', 'A16', 674);
INSERT INTO suministros (codp, coda, puc) VALUES ('P10', 'A4', 1334);
INSERT INTO suministros (codp, coda, puc) VALUES ('P11', 'A18', 324);
INSERT INTO suministros (codp, coda, puc) VALUES ('P11', 'A17', 35);
INSERT INTO suministros (codp, coda, puc) VALUES ('P11', 'A1', 456);
INSERT INTO suministros (codp, coda, puc) VALUES ('P11', 'A3', 754);
INSERT INTO suministros (codp, coda, puc) VALUES ('P2', 'A2', 95);
INSERT INTO suministros (codp, coda, puc) VALUES ('P2', 'A14', 134);
INSERT INTO suministros (codp, coda, puc) VALUES ('P3', 'A5', 174);
INSERT INTO suministros (codp, coda, puc) VALUES ('P3', 'A12', 1000);
INSERT INTO suministros (codp, coda, puc) VALUES ('P3', 'A3', 356);
INSERT INTO suministros (codp, coda, puc) VALUES ('P12', 'A2', 77);
INSERT INTO suministros (codp, coda, puc) VALUES ('P12', 'A7', 336);
INSERT INTO suministros (codp, coda, puc) VALUES ('P5', 'A12', 454);
INSERT INTO suministros (codp, coda, puc) VALUES ('P5', 'A16', 1195);
INSERT INTO suministros (codp, coda, puc) VALUES ('P5', 'A4', 634);
INSERT INTO suministros (codp, coda, puc) VALUES ('P6', 'A1', 374);
INSERT INTO suministros (codp, coda, puc) VALUES ('P13', 'A12', 1000);
INSERT INTO suministros (codp, coda, puc) VALUES ('P3', 'A6', 500);

COMMIT;

-- 4. ÍNDICES
CREATE INDEX IFE ON facturas (FECHA); 
CREATE INDEX INOMBRE ON monedas (NOMBRE);