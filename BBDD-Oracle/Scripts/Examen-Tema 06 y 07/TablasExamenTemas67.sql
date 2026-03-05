-- Tabla clientes
drop table clientes;

create table clientes(
    codc char(8) primary key,
    dni char(10) unique,
    nombre varchar(20) unique,
    direccion varchar(15),
    tlf char(9)
);
-- Tabla art�culos
drop table articulos;

create table articulos(
coda char(8) primary key,
nombre varchar(20),
pvp decimal(7,0), 
color char(10),
ctd decimal(7,0) check(ctd >= 0),
iva decimal(2,0) check(iva between 4 and 18)
);
-- Tabla facturas
drop table facturas;

create table facturas(
nf char(4) primary key,
ctd decimal(7,0),
fecha date not null,
precio decimal (7,0),
pagada date,
coda char(8) not null references articulos(coda),
codc char(8) not null references clientes(codc)
);
/
-- Insercci�n de datos
INSERT INTO articulos VALUES ('A1','ARTICULO UNO',NULL,'VERDE',150,12);
INSERT INTO articulos VALUES ('A2','ARTICULO DOS',NULL,'AZUL',350,6);
INSERT INTO articulos VALUES ('A3','ARTICULO TRES',NULL,'AZUL',550,6);
INSERT INTO articulos VALUES ('A4','ARTICULO CUATRO',NULL,'BLANCO',1000,12);
INSERT INTO articulos VALUES ('A5','ARTICULO CINCO',NULL,'NEGRO',500,12);
INSERT INTO articulos VALUES ('A6','ARTICULO SEIS',NULL,'NEGRO',550,12);
INSERT INTO articulos VALUES ('A7','ARTICULO SIETE',NULL,'AMARILLO',350,6);
INSERT INTO articulos VALUES ('A8','ARTICULO OCHO',NULL,'ROJO',3050,12);
INSERT INTO articulos VALUES ('A9','ARTICULO NUEVE',NULL,'ROJO',50,12);
INSERT INTO articulos VALUES ('A10','ARTICULO DIEZ',NULL,'AZUL',30,6);

INSERT INTO clientes VALUES ('C1','0123456701','CLIENTE UNO','c/cuno,1','999234546');
INSERT INTO clientes VALUES ('C2','0123456702','CLIENTE DOS','c/cdos,2','999343434');
INSERT INTO clientes VALUES ('C3','0123456703','CLIENTE TRES','c/ctres,3','666123455');
INSERT INTO clientes VALUES ('C4','0123456704','CLIENTE CUATRO','c/ccuatro,4','666445566');
INSERT INTO clientes VALUES ('C5','0123456705','CLIENTE CINCO','c/ccinco,5','777553434');
INSERT INTO clientes VALUES ('C6','0123456706','CLIENTE SEIS','c/cseis,6','777664567');
INSERT INTO clientes VALUES ('C7','0123456707','CLIENTE SIETE','c/csiete,7','444773457');
INSERT INTO clientes VALUES ('C8','0123456708','CLIENTE OCHO','c/cocho,8','444887865');
INSERT INTO clientes VALUES ('C9','0123456709','CLIENTE NUEVE','c/cnueve,9','998776');
INSERT INTO clientes VALUES ('C10','0123456710','CLIENTE DIEZ','c/cdiez,10','101010');


INSERT INTO facturas VALUES (1,10,'13/02/2020',350,'13/02/2020','A1','C1');
INSERT INTO facturas VALUES (2,21,'12/04/2020',550,'12/04/2020','A2','C7');
INSERT INTO facturas VALUES (3,80,'12/04/2020',1000,NULL,'A1','C1');
INSERT INTO facturas VALUES (4,23,'12/04/2020',550,'17/05/2020','A3','C2');
INSERT INTO facturas VALUES (5,100,'12/04/2020',446,NULL,'A1','C3');
INSERT INTO facturas VALUES (6,21,'21/05/2020',1150,'21/05/2020','A4','C4');
INSERT INTO facturas VALUES (7,80,'31/05/2020',1040,NULL,'A4','C5');
INSERT INTO facturas VALUES (8,623,'21/07/2020',460,'26/07/2020','A5','C8');
INSERT INTO facturas VALUES (9,5000,'10/08/2020',1350,'10/08/2020','A8','C9');
INSERT INTO facturas VALUES (10,2100,'12/09/2020',1550,NULL,'A8','C9');
INSERT INTO facturas VALUES (11,800,'22/09/2020',1000,'24/11/2020','A3','C10');
INSERT INTO facturas VALUES (12,230,'07/10/2020',234,'07/10/2020','A10','C2');
INSERT INTO facturas VALUES (13,100,'12/11/2020',129,'12/11/2020','A1','C10');
INSERT INTO facturas VALUES (14,1221,'21/11/2020',1350,'11/08/2021','A2','C3');
INSERT INTO facturas VALUES (15,79,'10/12/2020',40,NULL,'A2','C10');
/