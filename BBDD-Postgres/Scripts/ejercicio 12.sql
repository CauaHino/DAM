-- Punto 1
create table medicamentos(
codigo serial primary key,
nombre varchar(20),
laboratorio varchar(20),
precio decimal(5,2),
cantidad smallint
);

-- Punto 2
insert into medicamentos (nombre, laboratorio, precio, cantidad) values
('Sertal','Roche',5.2,100),
('Buscapina','Roche',4.10,200),
('Amoxidal500','Bayer',15.60,100),
('Paracetamol 500','Bago',1.90,200),
('Bayaspirina','Bayer',2.10,150),
('Amoxidaljarabe','Bayer',5.10,250);

-- Punto 3
select m.codigo, m.nombre
from medicamentos as m
where laboratorio = 'Roche' and precio < 5;

--Punto 4
select *
from medicamentos as m
where laboratorio = 'Roche' or precio < 5;

-- Punto 5
select *
from medicamentos
where laboratorio != 'Bayer' and cantidad = 100;

-- Punto 6
select *
from medicamentos
where laboratorio = 'Bayer' and cantidad != 100;

-- Punto 7
DELETE FROM
    medicamentos
WHERE
    laboratorio = 'Bayer' AND precio > 10;

-- Punto 8
update medicamentos 
set cantidad = 200
where 
	laboratorio = 'Roche' and precio > 5;

-- Punto 9
DELETE FROM
    medicamentos
WHERE
    laboratorio = 'Bayer' AND precio < 3;

-- Verifico si todo salió bien
select *
from medicamentos

-- Ejercicio 14

-- Punto 1
alter table medicamentos
add column fechaVencimiento DATE;

delete from medicamentos
where fechaVencimiento is NULL;

alter table medicamentos
alter column fechaVencimiento set not null;

-- Punto 2

delete from medicamentos;

-- punto 3
insert into medicamentos (nombre, laboratorio, precio, cantidad, fechaVencimiento) values
('Sertal','Roche',5.2,1,'2005-02-01'),
('Buscapina','Roche',4.10,3,'2006-03-01'),
('Amoxidal 500','Bayer',15.60,100, '2007-05-01'),
('Paracetamol 500','Bago',1.90,20, '2008-02-01'),
('Bayaspirina','Bayer',2.10,150, '2009-12-01'),
('Amoxidal jarabe','Bayer',5.10,250, '2010-10-01');

-- Punto 4

select m.precio, m.precio
from medicamentos as m
where laboratorio in ('Bayer', 'Bago');

-- Punto 5
select m.nombre
from medicamentos as m
where cantidad between 1 and 5;

-- Ejercicio 17
alter table medicamentos
add column numerolote int default null;

-- punto 2
delete from medicamentos;

--punto 3
INSERT INTO medicamentos(nombre, laboratorio, precio, cantidad, fechaVencimiento, numerolote)
VALUES
  ('Sertal', 'Roche', 5.2, 1, '2015-02-01', NULL),
  ('Buscapina', 'Roche', 4.10, 3, '2016-03-01', NULL),
  ('Amoxidal 500', 'Bayer', 15.60, 100, '2017-05-01', NULL),
  ('Paracetamol 500', 'Bago', 1.90, 20, '2018-02-01', NULL),
  ('Bayaspirina', 'Bayer', 2.10, 150, '2019-12-01', NULL),
  ('Amoxidal jarabe', 'Bayer', 5.10, 250, '2019-10-01', NULL);

-- punto 4
select count(*)
from medicamentos;

-- punto 5
select count(laboratorio)
from medicamentos

-- punto 6
select count(precio) as conprecio,
	count(cantidad) as concantidad
	from medicamentos;

-- punto 7
select count(precio) as conprecio
from medicamentos
where laboratorio like '%B';

-- punto 8
select count(cantidad)
from medicamentos
where numerolote <> null;







































