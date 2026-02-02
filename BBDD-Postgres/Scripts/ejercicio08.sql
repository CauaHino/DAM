drop table if exists agenda;

create table agenda(
apellido varchar (30),
nombre varchar (20) not null,
domicilio varchar(30),
telefono varchar(30),
email varchar (30)
);

insert into agenda values ('Perez', 'Juan', 'Sarmiento 345', '4334455', 'juancito@gmail.com');
insert into agenda values ('Garcia', 'Ana', 'Urquiza 367', '4226677', 'anamariagarcia@hotmail.com');
insert into agenda values ('Lopez', 'Juan', 'Avellaneda 900', null, 'juancitolopez@gmail.com');
insert into agenda values ('Juarez', 'Mariana', 'Sucre 123', '0525657687', 'marianaJuarez2@gmail.com');
insert into agenda values ('Molinari', 'Lucia', 'Peru 1254', '4590987', 'molinarilucia@hotmail.com');
insert into agenda values ('Ferreyra', 'Patricia', 'Colon 1534', '4585858', null);
insert into agenda values ('Perez', 'Susana', 'San Martin 333', null, null);
insert into agenda values ('Perez', 'Luis', 'Urquiza 444', '0354545256', 'perezluisalberto@hotmail.com');
insert into agenda values ('Lopez', 'Maria', 'Salta 314', null, 'lopezmariayo@gmail.com');

create index i_agenda_apellido on agenda(apellido);

create unique index i_agenda_email on agenda (email);

-- 1 punto
select *
from agenda;

-- 2 punto
select *
from agenda as a
where nombre = 'Maria'

-- 3 punto
select a.nombre, a.domicilio
from agenda as a
where apellido = 'Perez'

-- 4 punto
select a.nombre
from agenda as a
where telefono = '4585858'












