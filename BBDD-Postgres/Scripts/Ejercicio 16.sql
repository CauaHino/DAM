create table empleados(
nombre varchar(30),
documento char(8) primary key,
domicilio varchar(30),
fechaIngreso date,
seccion varchar(20),
sueldo decimal(6,2)
);
--- punto 2
INSERT INTO empleados (nombre, documento, domicilio, fechaIngreso, seccion, sueldo)VALUES
  ('Juan Perez', '22333444', 'Colon 123', '1990-10-08', 'Gerencia', 900.50),
  ('Ana Acosta', '23444555', 'Caseros 987', '1995-12-18', 'Secretaria', 590.30),
  ('Lucas Duarte', '25666777', 'Sucre 235', '2005-05-15', 'Sistemas', 790),
  ('Pamela Gonzalez', '26777888', 'Sarmiento 873', '1999-02-12', 'Secretaria', 550),
  ('Marcos Juarez', '30000111', 'Rivadavia 801', '2002-09-22', 'Contaduria', 630.70),
  ('Yolanda Perez', '35111222', 'Colon 180', '1990-10-08', 'Administracion', 400),
  ('Rodolfo Perez', '35555888', 'Coronel Olmedo 588', '1990-05-28', 'Sistemas', 800);

 -- punto 3
select *
from empleados 
where nombre like ('%Perez%');

--punto 4
select *
from empleados 
where domicilio like ('Co%') and domicilio like ('%8%');

-- punto 5
select * 
from empleados
where sueldo % 1 <> 0;

-- punto 6
select *
from empleados 
where extract(year from fechaIngreso) = 1990;

-- ejercicio 18

-- punto 1
alter table empleados
add column numHijos smallint;

-- punto 2
delete from empleados;

alter table empleados
drop fechaIngreso;

-- punto 3
INSERT INTO empleados (nombre, documento, domicilio, seccion, sueldo, numHijos) VALUES
('Juan Perez', '22333444', 'Colon 123', 'Gerencia', 5000, 2),
  ('Ana Acosta', '23444555', 'Caseros 987', 'Secretaria', 2000, 0),
  ('Lucas Duarte', '25666777', 'Sucre 235', 'Sistemas', 4000, 1),
  ('Pamela Gonzalez', '26777888', 'Sarmiento 873', 'Secretaria', 2200, 3),
  ('Marcos Juarez', '30000111', 'Rivadavia 801', 'Contaduria', 3000, 0),
  ('Yolanda Perez', '35111222', 'Colon 180', 'Administracion', 3200, 1),
  ('Rodolfo Perez', '35555888', 'Coronel Olmedo 588', 'Sistemas', 4000, 3),
  ('Martina Rodriguez', '30141414', 'Sarmiento 1234', 'Administracion', 3800, 4),
  ('Andres Costa', '28444555', DEFAULT, 'Secretaria', NULL, NULL);

-- punto 4
select count(sueldo) as cantidadEmpleados
from empleados;

-- punto 5
select count (*) as cantidadEmpleados
from empleados
where seccion = 'Secretaria';

-- punto 6
select max(sueldo) as sueldoMax,
		min(sueldo) as sueldoMin
from empleados;

-- punto 7
select max(numHijos) as cantidadHijos
from empleados
where nombre like '%Perez%';

-- punto 8
select avg(sueldo) :: numeric(6,2) as promedio 
from empleados;

-- punto 9
select avg(sueldo):: numeric(6,2)
from empleados
where seccion = 'Secretaria';

-- punto 10
select avg(numhijos):: numeric(6,2)
from empleados 
where seccion = 'Sistemas';


