create table peliculas(
codigo serial primary key,
titulo varchar(40) not null,
actor varchar(20),
duracion smallint
);

-- Punto 2
insert into peliculas(titulo, actor, duracion) values
('Mision imposible','Tom Cruise',120),
('Harry Potter y la piedra filosofal','Daniel R.',180),
('Harry Potter y la camara secreta','Daniel R.',190),
('Mision imposible 2','Tom Cruise',120),
('Mujer bonita','Richard Gere',120),
('Tootsie','D. Hoffman',90),
('Un oso rojo','Julio Chavez', 100),
('Elsa y Fred','China Zorrilla',110);

-- punto 3
select *
from peliculas
where
	actor = 'Tom Cruise' or actor = 'Richard Gere';

-- punto 4
select *
from peliculas
where actor = 'Tom Cruise' and duracion < 100;

-- Punto 5
select *
from peliculas
where actor = null;

-- punto 6
update peliculas
set duracion = 200
where 
	actor = 'Daniel R' and duracion = 180;

-- Punto 7
Delete from peliculas
where 
	actor != 'Tom Cruise' and duracion >= 100

-- Verifico si funciono todo
select *
from peliculas



