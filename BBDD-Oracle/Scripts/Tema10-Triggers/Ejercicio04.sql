-- Punto 1
create table articulos(
    codigo number(6),
    descripcion varchar(40),
    precio number(6,2),
    stock number(4)
);
/
drop table control;

create table control(
    usuario varchar2(30),
    fecha date,
    codigo number(6)
);

-- Punto 2
INSERT INTO articulos VALUES
(100, 'regla 20 cm.', 5.4, 100),
(102, 'lapices color x12', 15, 80),
(109, 'lapices color x12', 6, 150),
(130, 'lapices color x6', 4.5, 100),
(201, 'compas metal', 21.8, 50);

-- Punto 3
create or replace trigger tr_insert_articulo
    before insert
    on articulos
    for each row
begin
    insert into control values(user, sysdate, :new.codigo);
end;
/

-- Punto 4
insert into ARTICULOS values (110, 'ARTICULO UNO', 6, 10);

-- Punto 5
select * from control;

-- Punto 6
create or replace trigger tr_codigo_articulo
    before insert
    on articulos
    for each row 
begin 
    select max(codigo)+1
    from articulos;

    if :new.codigo is null THEN
        :new.codigo := 1;
    end if;

    insert into control values (user, sysdate, :new.codigo);
end;
/

-- Punto 7
insert into ARTICULOS values (10, 'ARTICULO DOS', 60, 100);

-- Punto 8
select * from ARTICULOS;

-- Punto 9
select * from control;

-- Punto 10
insert into ARTICULOS (DESCRIPCION, PRECIO, STOCK) values ('ARTICULO TRES', 60, 100);

-- Punto 11
select * from ARTICULOS;

-- Punto 12
select * from control;
