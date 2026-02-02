create table inmuebles(
documento char(8) not null,
apellido varchar(30),
nombre varchar(30),
domicilio varchar(20),
barrio varchar(20),
ciudad varchar(20),
tipo char(2),
superficie decimal(8,2)
);

alter table inmuebles
add constraint chk_tipo_fijo
check (tipo in ('se', 'ed'));

insert into inmuebles values ('11000000','Perez','Alberto','San Martin 800','Centro','Cordoba','ed',100);
insert into inmuebles values ('11000000','Perez','Alberto','Sarmiento 245','Gral. Paz','Cordoba','ed',200);
insert into inmuebles values ('12222222','Lopez','Maria','San Martin 202','Centro','Cordoba','ed',250);
insert into inmuebles values ('13333333','Garcia','Carlos','Paso 1234','Alberdi','Cordoba','se',200);
insert into inmuebles values ('13333333','Garcia','Carlos','Guemes 876','Alberdi','Cordoba','se',300);
insert into inmuebles values ('14444444','Perez','Mariana','Caseros 456','Flores','Cordoba','se',200);
insert into inmuebles values ('15555555','Lopez','Luis','San Martin 321','Centro','Carlos Paz','ed',500);
insert into inmuebles values ('15555555','Lopez','Luis','Lopez y Planes 853','Flores','Carlos Paz','ed',350);
insert into inmuebles values ('16666666','Perez','Alberto','Sucre 1877','Flores','Cordoba','ed',150);

-- punto 3
select distinct apellido from inmuebles;

-- punto 4
select distinct documento from inmuebles;

-- punto 5
select count(distinct documento)
from inmuebles
where ciudad = 'Cordoba';

-- punto 6
select count(distinct ciudad)
from inmuebles
where domicilio like 'San Martin%';

-- punto 7
select distinct apellido, nombre
from inmuebles as i
order by i.apellido asc, i.nombre asc;

-- punto 8
select documento, count(distinct barrio)
from inmuebles
group by documento;

