SET SERVEROUTPUT ON;
-- Punto 1
begin 
dbms_output.put_line('hola');
end;
/
-- Punto 2
drop table if exists agenda;
create table agenda(
    apellido varchar(30),
    nombre varchar(20),
    domicilio varchar(30),
    telefono varchar(11)
);

-- Punto 3
insert into agenda (apellido, nombre, domicilio, telefono) values
('Moreno', 'Alberto', 'Colon 123', '642345671'),
('Torres', 'Juan', 'Avellaneda 428', '658947852'),
('López', 'Ana', 'La Paz 85', '626547984'),
('Gutiérrez', 'María', 'Avda. Cid 97', '677556971'),
('Cárceles', 'Miguel', 'Puerta Murcia 20', '666848721'),
('Torres', 'Lucía', 'Mayor 57', '626547984');

-- Punto 4
declare 
    v_numFilas number;
begin
    select count(*) into v_numFilas
    from agenda;
    
    dbms_output.put_line('El número de filas en la tabla agenda es: ' || v_numFilas);
end;
/

