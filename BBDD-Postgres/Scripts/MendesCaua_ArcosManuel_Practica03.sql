-- Ejercicio 1
create view vproveedor as 
select codp as codigo,dni,nombre, ciudad, pais
from proveedores
where pais = 'España';

-- Ejercicio 2
-- A)
insert into vproveedor(codigo,dni,nombre,ciudad,pais) values
('P16','1234567816','PROVEEDOR DIECISEIS', 'Albacete', 'España');
insert into vproveedor(codigo,dni,nombre,ciudad,pais) values
('P17','1234567817','PROVEEDOR DIECISIETE', 'Toledo', 'España');
insert into vproveedor(codigo,dni,nombre,ciudad,pais) values
('P18','1234567818','PROVEEDOR DIECIOCHO', 'Buenos Aires', 'Argentina');

-- B)
update vproveedor
set ciudad = 'Valencia'
where codigo = 'P16';

update vproveedor
set nombre = 'NUEVO DIECISIETE'
where codigo = 'P17';

-- C) 
delete from vproveedor
where codigo = 'P16';

delete from vproveedor
where codigo = 'P17';

delete from vproveedor
where codigo = 'P18';

-- Justificativa
/* No es posible borrar el proveedor P18, porque en la vista
existe la condición de que estén solamente los proveedores de España
y el proveedor P18 tiene su País = Argentina, lo que imposibilita que le borremos 
a través de la vista creada */

-- EJERCICIO 3
-- ELIMINAMOS LA VISTA DEL EJERCICIO 1
DROP VIEW vproveedor;
-- CREAMOS DE NUEVO LA VISTA CON WITH CHECK OPTION
CREATE VIEW vproveedor AS
SELECT codp, dni, nombre, ciudad, pais
FROM proveedores
WHERE pais = 'España'
WITH CHECK OPTION;

-- INSERTAMOS DATOS A LA VISTA vproveedor
INSERT INTO vproveedor VALUES ('P16','1234567816','PROVEEDOR DIECISEIS','Buenos Aires','Argentina');
INSERT INTO vproveedor VALUES ('P17','1234567817','PROVEEDOR DIECISIETE','Paris','Francia');
INSERT INTO vproveedor VALUES ('P18','1234567818','PROVEEDOR DIECIOCHO','Albacete','España');

-- RESPUESTA
/* NO DEJA INSERTAR EL 'PROVEEDOR DIECIOCHO' DEBIDO A QUE NO CUMPLE CON LA CONDICION DE QUE EL PROVEEDOR
DEBE SER DE ESPAÑA, YA QUE EL WITH CHECK OPTION OBLIGA A QUE SE CUMPLA Y SEAN PROVEEDORES 
PROVENIENTES DE ESPAÑA, ADEMÁS DE ESO, EL PROVEEDOR P18 YA FUE INSERTADO ANTERIORMENTE, Y COMO NO FUE POSIBLE BORRARLO, 
EL CODIGO P18 SE QUEDA DUPLICADO, IMPOSIBILITANDO QUE INSERTEMOS EL P18, AUNQUE CUMPLA LA CONDICIÓN NECESÁRIA*/

-- EJERCICIO 4
-- CREAMOS LA VISTA llamada varticuloscomprados
CREATE VIEW varticuloscomprados AS
SELECT 
    c.dni, 
    c.nombre, 
    SUM(f.ctd) AS ctd_total, 
    SUM(f.precio) AS importe_total
FROM clientes AS c
JOIN facturas AS f ON c.codc = f.codc
JOIN articulos AS a ON f.coda = a.coda
GROUP BY c.dni, c.nombre
ORDER BY c.dni;

-- MOSTRAMOS LA VISTA PARA VER SI SE HA CREADO CORRECTAMENTE
SELECT * FROM varticuloscomprados;

-- Ejercicio 5
insert into varticuloscomprados (dni, nombre, ctd_total, importe_total) 
values ('0123456750', 'CLIENTE NUEVO 1', 10, 3000);

delete from varticuloscomprados where dni = '0123456701'; 

-- Justificativa
/* No es posible ejecutar las query porque las vistas contienen GROUP BY lo que las hacen que no sean automáticamente actualizables */

-- EJERCICIO 6
SELECT p.codp,p.nombre,a.color,
COUNT(*) AS "Número Artículos"
FROM proveedores p
JOIN suministros s
ON p.codp = s.codp
JOIN articulos a
ON s.coda = a.coda
GROUP BY p.codp,p.nombre,a.color
ORDER BY p.codp,a.color;

-- Ejercicio 7
SELECT c.nombre,
COUNT(DISTINCT f.coda) AS cantidad_articulos_distintos
FROM clientes c
JOIN facturas f
ON c.codc = f.codc
GROUP BY c.codc,c.nombre
HAVING COUNT(DISTINCT f.coda) >= 2;

-- Ejercicio 8
SELECT c.codc, c.nombre, a.coda, a.nombre
FROM clientes c
JOIN facturas f ON c.codc = f.codc
JOIN articulos a ON f.coda = a.coda
WHERE a.coda IN (
    SELECT s.coda
    FROM suministros s
    JOIN proveedores p ON s.codp = p.codp
    WHERE p.pais = 'España'
    
    EXCEPT
	
    SELECT s.coda
    FROM suministros s
    JOIN proveedores p ON s.codp = p.codp
    WHERE p.pais <> 'España'
)
ORDER BY c.nombre ASC;

-- Ejercicio 9
SELECT p.codp, p.pais, m.nombre AS moneda
FROM proveedores p
JOIN monedas m ON p.pais = m.pais
WHERE (m.pventa - m.pcompra) < 0.1
  AND p.codp NOT IN (
      SELECT s.codp
      FROM suministros s
      JOIN articulos a ON s.coda = a.coda
      WHERE a.color = 'AZUL'
  )
ORDER BY p.codp;

-- Ejercicio 10

-- Creamos la secuencia partiendo del valor superior al máximo actual (24)
CREATE SEQUENCE num_facturas
  START WITH 25
  INCREMENT BY 1;
  
-- insertamos una nueva factura
INSERT INTO facturas (nf, ctd, fecha, precio, pagada, coda, codc) VALUES 
(nextval('num_facturas'), 10, '2009-02-13', 350, '2023-02-13', 'A6', 'C1');

-- comprobamos si está bien
select *
from facturas
where nf = '25';









