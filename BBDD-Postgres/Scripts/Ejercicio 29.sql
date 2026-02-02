create table alumnos(
documento char(8),
nombre varchar(30),
nota decimal(4,2)
);

insert into alumnos values('30111111','Ana Algarbe', 5.1);
insert into alumnos values('30222222','Bernardo Bustamante', 3.2);
insert into alumnos values('30333333','Carolina Conte', 4.5);
insert into alumnos values('30444444','Diana Dominguez', 9.7);
insert into alumnos values('30555555','Fabian Fuentes', 8.5);
insert into alumnos values('30666666','Gaston Gonzalez', 9.7);

-- punto 3
select *
from alumnos
where nota =
	(select max(nota)
	from alumnos);

-- punto 4
select *
from alumnos
where nota =
	(select max(nota)
	from alumnos) and nombre in(select nombre from alumnos);

-- punto 5
select nombre, nota,
(select avg(nota)::numeric(6,2) from alumnos) - nota as diferencia,
	(select avg(nota)::numeric(6,2) from alumnos)
from alumnos
where nota < ( select avg(nota)
				from alumnos)
group by nombre, nota;

-- punto 6
update alumnos
set nota = 4
where nota = (select min(nota) from alumnos);

-- punto 7
delete from alumnos
where nota < ( select avg(nota)
				from alumnos);





















