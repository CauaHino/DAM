create or replace trigger tr_actualizar_empleados
    after update 
    on empleados
BEGIN 
    insert into control values (user, sysdate);
end;
/

-- Punto 2
select * from USER_TRIGGERS where TRIGGER_NAME = 'TR_ACTUALIZAR_EMPLEADOS';

-- Punto 3
update empleados set nombre = 'Graciela' where documento = '23444555';

-- Punto 4  
select * from control;

-- Punto 5
update empleados 
set sueldo = sueldo + (sueldo * 0.10)
where seccion = 'Secretaria';

select * from EMPLEADOS;

-- Punto 6
select * from control;

-- Punto 7
create or replace trigger tr_actualizar_empleados
    after update 
    on empleados
    for each row
BEGIN 
    insert into control values (user, sysdate);
end;
/
-- Punto 8
update empleados 
set sueldo = sueldo + (sueldo * 0.15)
where seccion = 'Secretaria';

-- Punto 9
select * from control;

-- Punto 10
select * from USER_TRIGGERS where TRIGGER_NAME = 'TR_ACTUALIZAR_EMPLEADOS';