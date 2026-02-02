create table agenda (
apellido varchar (30),
nombre varchar (20),
domicilio varchar (30),
telefono char (11)
);

insert into agenda (nombre, apellido, domicilio, telefono) values
('Alberto', 'Moreno', 'Colon 123', '34642345671'),
(' Juan', 'Torres', 'Avellaneda 428', '34658947852'),
('Ana', 'López', 'La Paz 85', '34626547984'),
('María', 'Gutiérrez', 'Avda. Cid 97', '34677556971'),
('Miguel', 'Cárceles', 'Puerta Murcia 20', '34666848721'),
('Lucía', 'Torres', 'Mayor 57', '34626547984');

select *
from agenda

update agenda
set nombre = 'Juan Jose'
where nombre = ' Juan';

update agenda
set telefono = '34111223344'
where telefono = '34626547984'

update agenda 
set domicilio = 'Falsa 123'
where apellido = 'Torres'

delete 
from agenda
where nombre = 'Miguel'

delete from agenda 
where telefono = '34111223344'



