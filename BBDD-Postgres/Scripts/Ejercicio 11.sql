-- Punto 1
CREATE TABLE VISITAS(
numero_de_visitas SERIAL PRIMARY KEY,
nombre varchar(30) default 'Anonimo',
email varchar(50), 
pais varchar(20),
fecha timestamp
);

-- Punto 2
Insert into VISITAS(nombre, email, pais, fecha) values
('Ana Maria Lopez','AnaMaria@hotmail.com','Argentina','2006-10-10 10:10'),
('Gustavo Gonzalez','GustavoGGonzalez@hotmail.com','Chile','2006-10-10 21:30'),
('Juancito','JuanJosePerez@hotmail.com','Argentina','2006-10-11 15:45'),
('Fabiola Martinez','MartinezFabiola@hotmail.com','Mexico','2006-10-12 08:15'),
('Fabiola Martinez','MartinezFabiola@hotmail.com','Mexico','2006-09-12 20:45'),
('Juancito','JuanJosePerez@hotmail.com','Argentina','2006-09-12 16:20'),
('Juancito','JuanJosePerez@hotmail.com','Argentina','2006-09-15 16:25');

-- Punto 3
select *
from VISITAS
order by fecha DESC;

-- Punto 4
select v.nombre, v.pais,
EXTRACT(MONTH from fecha) as mes
from VISITAS as v
order by pais ASC, mes DESC;

-- Punto 5
select v.pais, 
	extract(month from fecha) as mes,
	extract(day from fecha) as dia,
	extract(hour from fecha) as hora
from VISITAS as v
Order by mes, dia, hora;

-- Punto 6
select v.email, v.pais
from VISITAS as v
where extract(month from v.fecha) = 10
order by pais ASC;

-- Punto 7
select v.nombre
from VISITAS as v
where (v.fecha between '2006-09-12' and '2006-10-11')

-- Punto 8
select *
from VISITAS as v
where (v.numero_de_visitas between 2 and 5);
	









