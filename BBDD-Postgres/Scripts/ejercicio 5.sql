create table vehiculos (
numero serial primary key,
numeroBastidor varchar (17),
marcaModelo varchar(40),
fechaHoraEntrada timestamp,
fechaHoraSalida timestamp
);
-- restriccion horario entrada
alter table vehiculos
add constraint chk_fecha_entrada_actual
check (fechaHoraEntrada <= current_timestamp);

-- restriccion horario de entrada menor que salida
alter table vehiculos
add constraint chk_fecha_entrada_salida
check (fechaHoraEntrada <= fechaHoraSalida);

-- bastidor exclusivo
alter table vehiculos 
add constraint UQ_vehiculos_numeroBastidor
unique(numeroBastidor);

-- tabla cliente
create table clientes(
codigo serial primary key,
nombre varchar(30),
domicilio varchar(30), 
ciudad varchar(20),
codigoProvincia smallint not null
);

-- tabla provincia
create table provincia(
codigo serial, 
nombre varchar(20)
);

-- codigo provincia pk
alter table provincia
add constraint chk_codigo_pk
primary key(codigo);

-- codigo como fk
alter table clientes
add constraint chk_codigo_fk
foreign key (codigoProvincia)
references provincia(codigo);

-- inserto la el codigo y el nombre de la provincia
insert into provincia (nombre) values
('Toledo'),
('Albacete'),
('Cuenca'),
('Ciudad Real');



ALTER TABLE clientes
DROP CONSTRAINT chk_codigo_fk;

-- inserto los clientos
insert into clientes (nombre, domicilio, ciudad, codigoProvincia) values
('Lopez Marcos', 'Colon 111', 'Ocaña', 1),
('Perez Ana', 'San Martin 222', 'Valdepeñas', 6),
('Garcia Juan', 'Rivadavia 333', 'La Roda', 2),
('Perez Luis', 'Sarmiento 444', 'Tarancón', 3);

-- veo si los datos fueron insertados bien 
select *
from provincia

select *
from clientes

-- Eliminar el registro de "clientes" que no cumple con la restricción y establezca la restricción nuevamente.
delete 
from clientes 
where codigoProvincia = 6;

-- Eliminar el registro con código "4" de "provincias"
delete 
from provincia 
where codigo = 4;

