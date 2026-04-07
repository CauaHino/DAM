-- Punto 1
create table empleados(
    documento char(8),
    apellido varchar2(30),
    nombre varchar2(30),
    seccion varchar2(20),
    sueldo number(8,2)
);

create table control(
    usuario varchar2(30),
    fecha date
);

create or replace trigger tr_ingresar_empleado
    after insert 
    on empleados
    for each row 
begin 
    insert into control values (user,sysdate);
end;

INSERT INTO Empleados (documento, apellido, nombre, seccion, sueldo) VALUES ('22333444', 'ACOSTA', 'Ana', 'Secretaria', 500);
INSERT INTO Empleados (documento, apellido, nombre, seccion, sueldo) VALUES ('22777888', 'DOMINGUEZ', 'Daniel', 'Secretaria', 560);
INSERT INTO Empleados (documento, apellido, nombre, seccion, sueldo) VALUES ('22999000', 'FUENTES', 'Federico', 'Sistemas', 680);
INSERT INTO Empleados (documento, apellido, nombre, seccion, sueldo) VALUES ('22555666', 'CASEROS', 'Carlos', 'Contaduria', 900);
INSERT INTO Empleados (documento, apellido, nombre, seccion, sueldo) VALUES ('23444555', 'GOMEZ', 'Gabriela', 'Sistemas', 1200);
INSERT INTO Empleados (documento, apellido, nombre, seccion, sueldo) VALUES ('23666777', 'JUAREZ', 'Juan', 'Contaduria', 1000);

-- Punto 5
select * from control;

-- Punto 6
create or replace trigger tr_borrar_empleado
    after delete
    on empleados
    for each row 
begin 
    insert into control values (user,sysdate);
end;

-- Punto 8
delete from empleados where sueldo > 800;

-- Punto 9
select * from control;

-- Punto 10
create or replace trigger tr_borrar_empleado
    after delete
    on empleados
begin 
    insert into control values (user,sysdate);
end;

-- Punto 12
delete from empleados where empleados.SECCION = 'Secretaria';

-- Punto 13
select * from control;