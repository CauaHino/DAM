select *
from libros
where autor = 'Borges';

select l.titulo
from libros as l
where editorial = 'Emece'

select l.editorial
from libros as l
where titulo = 'Martin Fierro'