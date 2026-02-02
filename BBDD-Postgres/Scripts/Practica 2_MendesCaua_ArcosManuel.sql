-- Punto 1
select *
from proveedores 
where pais = 'España'
order by ciudad;

-- Punto 2
select *
from articulos
where ctd < 1000 and iva=6;

-- Punto 3
select p.*
from proveedores as p
left join suministros as s
on s.codp = p.codp
where s.coda is null
order by p.codp;

-- Punto 4
update articulos as a
set pvp = (
    select max (s.puc * m.pcompra)
    from suministros as s
    join proveedores as p on s.codp = p.codp
    join monedas as m on p.pais = m.pais
    where s.coda = a.coda
);
select pvp from articulos;

-- Punto 5
update facturas f
set precio = (
    select f.ctd * a.pvp * (1 + a.iva / 100.0)
    from articulos a
    where a.coda = f.coda
);

select precio from facturas;

-- Punto 6
select coda,nombre, 
    pvp * (1 + iva / 100.0) :: numeric(6,2) as "precio con iva",
    color
from articulos
where pvp is not null
  and (color like 'A%' or color = 'ROJO');

-- Punto 7
select c.*
from clientes c
join facturas f
on c.codc = f.codc
group by c.codc,c.dni,c.nombre,c.direccion,c.tlf
having sum(f.precio) > 2000
order by c.dni;


-- Punto 8
select a.coda, a.nombre as articulo, a.pvp, p.codp,p.nombre as proveedor
from articulos a
join suministros s on a.coda = s.coda
join proveedores p on s.codp = p.codp
where a.pvp > (
    select avg(pvp)
    from articulos
    where pvp is not null
);
-- Punto 9
select p.*,s.*
from proveedores p
join suministros s 
on p.codp = s.codp
where s.coda = any (
    select coda
    from suministros
    where codp = 'P2'
)
order by p.codp;

-- Punto 10
select coda, sum(f.ctd) as cantidad_total_vendida, avg(ctd):: numeric(6,2) as "Cantidad Media vendida"
from facturas as f
group by coda;

-- Punto 11
select nombre, pvp
from articulos
where pvp = (select max(pvp) from articulos)
or pvp = (select min(pvp) from articulos);

-- Punto 12
select distinct p.nombre
from proveedores p
join suministros s on p.codp = s.codp
join articulos a on s.coda = a.coda
where a.pvp > 300;

-- Punto 13
select coda
from suministros
group by coda
having count(codp) > 1;

-- Punto 14	
select c.*
from clientes c
where not exists (
select 1
from facturas as f
join articulos as a
on f.coda = a.coda
where f.codc = c.codc and a.pvp < 1000
);



