create table empleados (
documento varchar(8) primary key,
nombre varchar (30),
fechaNacimiento date,
cantidadHijos smallint default 0,
seccion varchar(20),
sueldo decimal (6,2)
)

alter table empleados
add constraint chk_sueldo_positivo
check (sueldo >= 0);

alter table empleados
add constraint chk_fecha_nacimiento_valida
check (fechaNacimiento <= current_date)

alter table empleados
add constraint chk_cantidad_hijos_valida
check (cantidadHijos between 0 and 15);

SELECT *
FROM information_schema.columns
WHERE table_name = 'empleados';