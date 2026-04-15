-- Borrar las tablas
drop table libros;
drop table ofertas;

-- Parte 01
create table libros(
    codigo number(6),
    titulo varchar2(50),
    autor varchar2(50),
    editorial varchar2(50),
    precio number(6,2)
);

create table ofertas(
    codigo number(6),
    titulo varchar2(50)
);

commit;
/

-- Parte 02
insert into libros values(1, 'El Quijote', 'Miguel de Cervantes', 'Editorial A', 19.99);
insert into libros values(2, 'Cien Años de Soledad', 'Gabriel García Márquez', 'Editorial B', 24.99);
insert into libros values(3, 'La Sombra del Viento', 'Carlos Ruiz Zafón', 'Editorial C', 14.99);
insert into libros values(4, 'El Alquimista', 'Paulo Coelho', 'Editorial D', 9.99);
insert into libros values(5, '1984', 'George Orwell', 'Editorial E', 12.99);

commit;
/

-- Parte 03
create or replace trigger tr_librosInsert
    before insert on libros
    for each row when(new.precio < 30)
begin
    insert into ofertas values(:new.codigo, :new.titulo);
end;
/

-- Parte 04
insert into libros values(6, 'El Principito', 'Antoine de Saint-Exupéry', 'Editorial F', 8.99);
insert into libros values(7, 'Don Quijote de la Mancha', 'Miguel de Cervantes', 'Editorial A', 19.99);

commit;
/

-- Parte 05 
select * from ofertas;

-- Parte 06
insert into libros values(8, 'El Señor de los Anillos', 'J.R.R. Tolkien', 'Editorial G', 40.00);

commit;
/

-- Parte 07
select * from ofertas;

-- Parte 08
create or replace trigger tr_librosDelete
    before delete on libros
    for each row when(old.precio < 30)
begin
    delete from ofertas where codigo = :old.codigo;
end;
/

-- Parte 09
delete from libros where codigo = 6;

-- Parte 10
select * from libros;
select * from ofertas;

-- Parte 11
delete from libros where codigo = 8;

-- Parte 12
select * from libros;
select * from ofertas;