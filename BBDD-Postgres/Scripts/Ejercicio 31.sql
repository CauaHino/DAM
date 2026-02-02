create table socios(
numero serial primary key,
documento char(8),
nombre varchar(30),
domicilio varchar(30)
);

drop table if exists inscritos;

create table inscritos(
numerosocio int not null,
deporte varchar(20) not null,
cuotas smallint,
primary key(numerosocio,deporte)
);

insert into inscritos values(1,'tenis',1);
insert into inscritos values(1,'baloncesto',2);
insert into inscritos values(1,'natacion',1);
insert into inscritos values(2,'tenis',9);
insert into inscritos values(2,'natacion',1);
insert into inscritos values(2,'baloncesto',default);
insert into inscritos values(2,'futbol',2);
insert into inscritos values(3,'tenis',8);
insert into inscritos values(3,'baloncesto',9);
insert into inscritos values(3,'natacion',0);
insert into inscritos values(4,'baloncesto',10);

insert into socios(documento,nombre,domicilio) values('23333333','Alberto Paredes','Colon 111');
insert into socios(documento,nombre,domicilio) values('24444444','Carlos Conte','Sarmiento 755');
insert into socios(documento,nombre,domicilio) values('25555555','Fabian Fuentes','Caseros 987');
insert into socios(documento,nombre,domicilio) values('26666666','Hector Lopez','Sucre 344');

-- punto 3
select s.numero, s.nombre, i.deporte
from socios as s
join inscritos as i
on i.numerosocio = s.numero;

-- punto 4
SELECT nombre
FROM socios
WHERE numero IN (
    SELECT numerosocio
    FROM inscritos
    WHERE deporte = 'tenis'
    AND numerosocio IN (
        SELECT numerosocio
        FROM inscritos
        WHERE deporte = 'natacion')
);
-- punto 5
SELECT deporte
FROM inscritos
WHERE numerosocio = 1
AND deporte IN (
    SELECT deporte
    FROM inscritos
    WHERE numerosocio = 2
);

-- punto 6
SELECT deporte
FROM inscritos as i
JOIN socios as s
on numero =
WHERE numerosocio = 1

);





