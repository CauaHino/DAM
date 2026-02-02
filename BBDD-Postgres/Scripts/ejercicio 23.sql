create table clientes(
codigo serial primary key,
nombre varchar(30),
domicilio varchar(30),
ciudad varchar(25),
codigoProvincia smallint not null
);

create table provincias(
codigo serial primary key,
nombre varchar(20)
);

insert into clientes (nombre,domicilio,ciudad,codigoProvincia) values('Lopez Marcos','Colon 111','Ocaña',1);
insert into clientes (nombre,domicilio,ciudad,codigoProvincia)values('Perez Ana','San Martin 222','Dosbarrios',1);
insert into clientes (nombre,domicilio,ciudad,codigoProvincia)values('Garcia Juan','Rivadavia 333','La Roda',2);
insert into clientes (nombre,domicilio,ciudad,codigoProvincia)values('Perez Luis','Sarmiento 444','Tarancón',3);
insert into clientes (nombre,domicilio,ciudad,codigoProvincia)values('Pereyra Lucas','San Martin 555','Tarazona de la Mancha',2);
insert into clientes (nombre,domicilio,ciudad,codigoProvincia)values('Gomez Ines','San Martin 666','Toledo',1);
insert into clientes (nombre,domicilio,ciudad,codigoProvincia)values('Torres Fabiola','Alem 777','Albacete',2);

insert into provincias(nombre) values ('Toledo');
insert into provincias(nombre) values ('Albacete');
insert into provincias(nombre) values ('Cuenca');

select *
from clientes as c
join provincias as p
on c.codigoProvincia = p.codigo
order by p.nombre;

select c.nombre, p.nombre
from clientes as c
join provincias as p
on c.codigoProvincia = p.codigo
where p.nombre = 'Toledo'
order by p.nombre;

-- Ejercicio 25

select *
from clientes as c
join provincias as p
on c.codigoProvincia = p.codigo;

-- punto 2

select *
from provincias as p
join clientes as c
on p.codigo = c.codigoProvincia;

-- punto 4
SELECT c.*, p.nombre
FROM clientes AS c
LEFT JOIN provincias AS p
  ON c.codigoProvincia = p.codigo
WHERE p.codigo IS NULL
order by c.nombre;

-- punto 5

select c.*, p.nombre
from clientes as c
join provincias as p
on c.codigoProvincia = p.codigo
where p.nombre = 'Toledo'
order by p.nombre;

-- Ejercicio 26

SELECT c.*
FROM clientes AS c
Right JOIN provincias AS p
ON c.codigoProvincia = p.codigo

-- punto 2
SELECT c.*
FROM clientes AS c
left JOIN provincias AS p
ON c.codigoProvincia = p.codigo

SELECT c.*
FROM clientes AS c
RIGHT JOIN provincias AS p
  ON c.codigoProvincia = p.codigo
WHERE codigoProvincia IS NOT NULL

SELECT c.*, p.nombre
FROM clientes AS c
RIGHT JOIN provincias AS p
  ON c.codigoProvincia = p.codigo
WHERE codigoProvincia IS NULL
ORDER BY ciudad;

-- Ejercicio 30
select p.nombre
from provincias as p
where p.codigo in (select codigoProvincia
					from clientes
					where domicilio like 'San Martin%');

-- punto 2 
select distinct (p.nombre)
from clientes as c
join provincias as p
on c.codigoProvincia = p.codigo
where c.domicilio  like 'San Martin%';

-- punto 3
select nombre
from provincias
where codigo in (select codigoProvincia
					from clientes as c
					where nombre not like 'P%');

-- punto 4
select codigoProvincia
from clientes as c
where nombre not like '% P%';


















