CREATE TABLE inscritos (
    nombre VARCHAR(30),
    documento CHAR(8),
    deporte VARCHAR(15),
    matricula BOOLEAN,
    PRIMARY KEY (documento, deporte)
);

CREATE TABLE inasistencias (
    documento CHAR(8),
    deporte VARCHAR(15),
    fecha DATE
);

INSERT INTO inscritos (nombre, documento, deporte, matricula) VALUES
    ('Juan Perez', '22222222', 'tenis', TRUE),
    ('Maria Lopez', '23333333', 'tenis', TRUE),
    ('Agustin Juarez', '24444444', 'tenis', FALSE),
    ('Marta Garcia', '25555555', 'fútbol', TRUE),
    ('Juan Perez', '22222222', 'fútbol', TRUE),
    ('Maria Lopez', '23333333', 'fútbol', FALSE);

INSERT INTO inasistencias (documento, deporte, fecha) VALUES
    ('22222222', 'tenis', '2022-12-01'),
    ('22222222', 'tenis', '2022-12-08'),
    ('23333333', 'tenis', '2022-12-01'),
    ('24444444', 'tenis', '2022-12-08'),
    ('22222222', 'fútbol', '2022-12-02'),
    ('23333333', 'fútbol', '2022-12-02');

-- punto 4
select i.nombre, i.deporte, f.fecha
from inscritos as i
join inasistencias as f
on i.documento = f.documento
order by i.nombre, i.deporte;

-- punto 5
select i.nombre, i.deporte, f.fecha
from inscritos as i
join inasistencias as f
on i.documento = f.documento
where i.deporte = 'fútbol'
order by i.nombre, i.deporte;

-- punto 6
select i.nombre, i.deporte, f.fecha
from inscritos as i
join inasistencias as f
on i.documento = f.documento
where i.matricula = true
order by i.nombre, i.deporte;

















