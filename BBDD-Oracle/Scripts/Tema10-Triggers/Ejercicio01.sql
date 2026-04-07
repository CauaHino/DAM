-- Punto 1
create table libros(
    codigo number(6),
    titulo varchar2(40),
    autor varchar2(30),
    editorial varchar(20), 
    precio number(6,2)
);

create table ofertas(
    titulo VARCHAR2(40),
    autor varchar(30),
    precio number(6,2)
);

create table control(
    usuario varchar2(30),
    fecha DATE
);

-- Punto 2
alter SESSION set nls_date_format = 'DD/MM/YYYY HH24:MI';

-- Punto 3
create or replace trigger tr_insertar_oferta
 after INSERT
 on ofertas
 for each row
begin 
    insert into control values (user, sysdate);
end;

-- Punto 4
-- Visualizar si fue creada en el diccionario 'user_triggers'

-- Punto 5
insert into libros values (100,'Uno', 'Richard Bach', 'Planeta', 25);
insert into libros values (102,'Matematicas estas ahi', 'Paenza', 'Nuevo Siglo', 12);
insert into libros values (105,'El aleph', 'Borges', 'Emece', 32);
insert into libros values (120,'Aprende PHP', 'Molina Mario', 'Nuevo siglo', 55);

-- Punto 6
insert into ofertas select titulo, autor, precio from libros where precio < 30;

-- Punto 7
select * from control;