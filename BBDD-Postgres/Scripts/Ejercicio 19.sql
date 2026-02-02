create table visitantes(
nombre varchar(30),
edad smallint,
sexo char(1) default 'f',
domicilio varchar(30),
ciudad varchar(20) default 'Cordoba',
telefono varchar(11),
email varchar(30) default 'No tiene',
precioCompra decimal(6,2)
);
 -- Punto 2
insert into visitantes (nombre, edad, sexo, domicilio, ciudad, telefono, email, precioCompra) values
('Susana Molina', 35, DEFAULT, 'Colon 123', DEFAULT, NULL, NULL, 59.80),
  ('Marcos Torres', 29, 'm', DEFAULT, 'Carlos Paz', DEFAULT, 'marcostorres@hotmail.com', 150.50),
  ('Mariana Juarez', 45, DEFAULT, DEFAULT, 'Carlos Paz', NULL, DEFAULT, 23.90),
  ('Liliana Torres', 40, DEFAULT, 'Sarmiento 876', DEFAULT, DEFAULT, DEFAULT, 85),
  ('Gabriela Duarte', 21, NULL, NULL, 'Rio Tercero', DEFAULT, 'gabrielaltorres@hotmail.com', 321.50);

INSERT INTO visitantes (nombre, edad, sexo, telefono, email)
VALUES ('Fabian Perez', 36, 'm', '4556677', 'fabianperez@xaxamail.com');

INSERT INTO visitantes (nombre, ciudad, precioCompra)
VALUES ('Alejandra Gonzalez', 'La Falda', 280.50);

INSERT INTO visitantes (nombre, edad, sexo, ciudad, email, precioCompra)
VALUES ('Gaston Perez', 29, 'm', 'Carlos Paz', 'gastonperez1@gmail.com', 95.40);

-- Punto 3

select ciudad, count(*) as cantidad
from visitantes
group by ciudad;

-- punto 4
select ciudad, count(telefono) as cantidad
from visitantes
group by ciudad

-- punto 5
select sexo, sum(precioCompra)
from visitantes
group by sexo;

-- punto 6
select sexo, ciudad, MAX(precioCompra) as valorMax,
		MIN(precioCompra) as valorMin
from visitantes
group by sexo, ciudad;

-- Punto 7
select ciudad, avg(precioCompra) :: numeric(6,2)
from visitantes
group by ciudad;

-- Punto 8
select ciudad, count(*) as cantidadconmail
from visitantes
where email is not null and email <>'No tiene'
group by ciudad;

-- Ejercicio 21

-- punto 1
select ciudad, sexo, SUM(precioCompra) :: numeric(6,2) as total
from visitantes
group by ciudad, sexo
having sum(precioCompra) > 50;

-- punto 2

select ciudad, sexo, 
	count(*), sum(precioCompra) as total, avg(precioCompra) :: numeric(6,2) as promedio
from visitantes
group by ciudad, sexo
having avg(precioCompra) > 30
order by total, promedio;




















