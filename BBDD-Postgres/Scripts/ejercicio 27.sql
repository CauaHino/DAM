DROP TABLE IF EXISTS inscritos;
DROP TABLE IF EXISTS deportes;

CREATE TABLE deportes (
    codigo SERIAL PRIMARY KEY,
    nombre VARCHAR(30),
    profesor VARCHAR(30)
);

-- 2. Tabla INSCRITOS
CREATE TABLE inscritos (
    documento CHAR(8),
    codigodeporte SMALLINT NOT NULL,
    matricula BOOLEAN
);

-- Insertar datos en DEPORTES
INSERT INTO deportes (nombre, profesor) VALUES
    ('tenis', 'Rafa Nadal'),
    ('natación', 'Mireia Belmonte'),
    ('baloncesto', 'Pau Gasol'),
    ('fútbol', 'Andrés Iniesta');

-- Insertar datos en INSCRITOS
INSERT INTO inscritos (documento, codigodeporte, matricula) VALUES
    ('22222222', 3, TRUE),
    ('23333333', 3, TRUE),
    ('24444444', 3, FALSE),
    ('22222222', 2, TRUE),
    ('23333333', 2, TRUE),
    ('22222222', 4, FALSE),
    ('22222222', 5, FALSE);
-- punto 4
select i.*, d.nombre
from inscritos as i
join deportes as d
	on d.codigo = i.codigodeporte;

-- punto 5
select i.*, d.nombre
from inscritos as i
left join deportes as d
	on d.codigo = i.codigodeporte;

-- punto 6
select i.*, d.nombre
from inscritos as i
right join deportes as d
	on d.codigo = i.codigodeporte;

-- punto 7
select d.*
from deportes as d
left join inscritos as i
	on d.codigo = i.codigodeporte
where i.documento is null;

-- punto 8
select i.documento
from inscritos as i
left join deportes as d
	on d.codigo = i.codigodeporte
where d.codigo is null;

-- punto 9
select i.*, d.*
from deportes as d
full join inscritos as i
	on d.codigo = i.codigodeporte




















