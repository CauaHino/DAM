drop table if exists libros;

create table libros (
titulo varchar (20),
autor varchar (30), 
editorial varchar(15)
);

-- punto 2
select *
from libros;

-- punto 3
insert into libros(titulo, autor, editorial) values
('El aleph', 'Borges', 'Planeta');

insert into libros(titulo, autor, editorial) values
('Martin Fierro', 'Jose Hernández', 'Emece');

insert into libros(titulo, autor, editorial) values
('Aprenda SQL', 'Mario Molina', 'Emece');

insert into libros(titulo, autor, editorial) values
('Cervantes', 'Borges', 'Emece');

insert into libros(titulo, autor, editorial) values
('Matemática estas ahí', 'Paenza', 'Siglo XXI');

-- punto 4

update libros
set autor = 'Adrián Paenza'
where autor = 'Paenza';

-- Ejercicio 10


select *
from libros
where autor = 'Borges';

select l.titulo
from libros as l
where editorial = 'Emece'

select l.editorial
from libros as l
where titulo = 'Martin Fierro'

-- Ejercicio 15
select *
from libros
where autor = 'Borges';

-- punto 2
select *
from libros
where titulo LIKE ('M%');

-- punto 3
select *
from libros
where titulo NOT LIKE ('M%');

-- Punto 4
SELECT * 
FROM libros
WHERE autor LIKE 'Lewis Carrol_';

-- punto 5
select *
from libros
where precio between 10 and 19.99;












