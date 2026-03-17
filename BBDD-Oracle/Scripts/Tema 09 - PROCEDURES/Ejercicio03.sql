set SERVEROUTPUT on;
-- Punto 1
create table libros(
codigo number(3),
titulo varchar2(40),
autor varchar(30),
precio number(5,2)
);

-- Punto 2
INSERT INTO libros (codigo, titulo, autor, precio) VALUES
(100, 'Uno', 'Richard Bach', 15),
(300, 'Aprenda PHP', 'Mario Molina', 55),
(102, 'Matematica estas ahi', 'Paenza', 18),
(105, 'El aleph', 'Borges', 25),
(109, 'El experto en laberintos', 'Gaskin', 20),
(204, 'Alicia en el pais de las maravillas', 'Carroll', 31);

-- Punto 3
create or replace function incrementarValor(valor in number) 
    return number as
begin
    return valor * 1.10;
end;
/

-- Punto 4
select titulo, precio, incrementarvalor(precio)as precioIncrementado
from libros;

-- Punto 5
create or replace function incrementarValor2(valor in number, porcentaje in number)
    return number as
v_porcentaje number;
begin
    v_porcentaje := 1 + (porcentaje / 100);
    return valor * v_porcentaje;
end;

-- Punto 6
select titulo, precio, incrementarValor2(precio, 20)as precioIncrementado
from libros;

-- Punto 7
select titulo, precio, incrementarValor2(precio, 100)as precioIncrementado
from libros;

-- Punto 8
create or replace function verTexto(valor in number)
    return varchar2 as
    valorRetornado varchar2;
begin
    if valor <= 20 then
        valorRetornado := 'economico';
    else
        valorRetornado := 'costoso';
    end if;
    return valorRetornado;
end;

-- Punto 9
select titulo, precio, verTexto(precio) as Coste
from libros;




