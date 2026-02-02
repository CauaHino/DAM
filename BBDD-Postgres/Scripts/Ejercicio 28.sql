create table mujeres(
nombre varchar(30),
domicilio varchar(30),
edad int
);

create table hombres(
nombre varchar(30),
domicilio varchar(30),
edad int
);

insert into mujeres values
('Maria Lopez','Colon 123',45),
('Liliana Garcia','Sucre 456',35),
('Susana Lopez','Avellaneda 98',41);

insert into hombres values
('Juan Torres','Sarmiento 755',44),
('Marcelo Oliva','San Martin 874',56),
('Federico Pereyra','Colon 234',38),
('Juan Garcia','Peru 333',50);

-- punto 4

select m.nombre,m.edad,h.nombre,h.edad
from mujeres as m
cross join hombres as h;

-- punto 5

select m.nombre,m.edad,h.nombre,h.edad
from mujeres as m
cross join hombres as h
where m.edad > 40 and h.edad > 40;

-- punto 6
select m.nombre,m.edad,h.nombre,h.edad
from mujeres as m
cross join hombres as h
where (m.edad - h.edad) between -10 and 10;












