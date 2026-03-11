drop table empleados;

-- Punto 1
create table empleados(
documento char(8),
nombre varchar2(20),
apellido varchar2(20), 
sueldo number(6,2),
cantidadhijos number(2,0),
fechaingreso date,
primary key(documento)
);

-- Punto 2
INSERT INTO empleados VALUES ('22222222', 'Juan', 'Perez', 200, 2, '10/10/1980');
INSERT INTO empleados VALUES ('22333333', 'Luis', 'Lopez', 250, 0, '01/02/1990');
INSERT INTO empleados VALUES ('22444444', 'Marta', 'Perez', 350, 1, '02/05/1995');
INSERT INTO empleados VALUES ('22555555', 'Susana', 'Garcia', 400, 2, '15/12/2018');
INSERT INTO empleados VALUES ('22666666', 'Jose Maria', 'Morales', 500, 3, '25/08/2015');

-- Punto 3
create or replace procedure pa_aumentarsueldo as
begin
    update empleados
    set sueldo = sueldo + (sueldo*0.20)
    where sueldo < (select avg(sueldo) from empleados);
end;
/

-- Punto 4
begin
    pa_aumentarsueldo;
end;
/

-- Punto 5
select * from empleados;

-- Punto 6
begin
    pa_aumentarsueldo;
end;
/

-- Punto 7
select * from empleados;

-- Punto 8
create table empleados_antiguos(
documento char(8),
nombre varchar2(40)
);

-- Punto 9
create or replace procedure p_empleadosAntiguos as
begin
        insert into empleados_antiguos
        select documento,
            nombre || ' ' || apellido
    from empleados
    where (extract(year from current_date) - extract(year from fechaingreso)) > 10;
end;
/

-- Punto 10
begin
    p_empleadosAntiguos;
end;
/

-- Punto 11
select * from empleados_antiguos;
