-- Crear la tabla “libros”

create table libros (
codigo int PRIMARY KEY,
titulo varchar (40) not null,
autor varchar (20) default 'Desconocido',
editorial varchar (15), 
precio decimal (5,2),
cantidad smallint default 0
)
-- Añade una comprobación para indicar que el precio debe ser mayor or igual que cero

mayor o igual que cero
alter table libros
add constraint chk_pecio_positivo
check (precio >= 0);