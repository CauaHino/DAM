create table libros (
codigo int PRIMARY KEY,
titulo varchar (40) not null,
autor varchar (20) default 'Desconocido',
editorial VARCHAR(15),
precio NUMERIC(5, 2) CHECK (precio >= 0),
cantidad SMALLINT DEFAULT 0
)
SELECT *
FROM information_schema.columns
WHERE table_name = 'libros';

ALTER TABLE libros
ADD CONSTRAINT chk_precio_positivo
CHECK (precio >= 0);

ALTER TABLE libros
ALTER COLUMN autor SET NOT NULL;