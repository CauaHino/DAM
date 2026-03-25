drop table oficinas cascade constraint;
drop table familias cascade constraint;
drop table agentes cascade constraint;

create table oficinas (
     idOficina     		number(6) not null primary key,
     nombre          	varchar2(40) not null unique,
     domicilio     		varchar2(40),
     localidad     		varchar2(20),
     codigo_postal      varchar2(5)
);

create table familias (
     idFamilia	     	number(6) not null primary key,
     nombre          	varchar2(40) not null unique,
     familia          	number(6) references familias,
     oficina          	number(6) references oficinas
);

create table agentes (
     idAgentes     		number(6) not null primary key,
     nombre          	varchar2(60) not null,
     usuario          	varchar2(20) not null unique,
     clave          	varchar2(20) not null,
     habilidad     		number(1) not null,
     categoria     		number(1) not null,
     familia          	number(6) references familias,
     oficina          	number(6) references oficinas
);

-- Informaci�n de las tablas
-- Tabla oficinas
insert into oficinas values (1, 'Madrid', 'Gran v�a, 37', 'Madrid', '28000');
insert into oficinas values (2, 'Albacete', 'Dionisio Guardiola, 50', 'Albacete', '02004');
insert into oficinas values (3, 'Toledo', 'Gran Eje, 80', 'Toledo', '45004');

-- Tabla familias
insert into familias values (11, 'Madrid-1', NULL, 1);
insert into familias values (111, 'Madrid-1.1', 11, NULL);
insert into familias values (112, 'Madrid-1.2', 11, NULL);
insert into familias values (1121, 'Madrid-1.2.1', 112, NULL);
insert into familias values (1122, 'Madrid-1.2.2', 112, NULL);
insert into familias values (1123, 'Madrid-1.2.3', 112, NULL);
insert into familias values (21, 'Albacete-1', NULL, 2);
insert into familias values (211, 'Albacete-1.1', 21, NULL);
insert into familias values (212, 'Albacete-1.2', 21, NULL);
insert into familias values (213, 'Albacete-1.3', 21, NULL);
insert into familias values (31, 'Toledo-1', NULL, 3);
insert into familias values (311, 'Toledo-1.1', 31, NULL);
insert into familias values (312, 'Toledo-1.2', 31, NULL);

-- Tabla agentes
insert into agentes values (31, 'Jos� Ram�n Jim�nez Reyes', 'jrjr', 'sup31', 9, 2, NULL, 3);
insert into agentes values (311, 'Pedro Fern�ndez Arias', 'pfa', 'ag311', 5, 0, 31, NULL);
insert into agentes values (312, 'Vanesa S�nchez Rojo', 'vsr', 'ag312', 5, 0, 31, NULL);
insert into agentes values (313, 'Francisco Javier Garc�a Escobedo', 'fjge', 'ag313', 5, 0, 31, NULL);
insert into agentes values (314, 'Pilar Ramirez P�rez', 'prp', 'ag314', 5, 0, 31, NULL);
insert into agentes values (315, 'Jos� Luis Garc�a Mart�nez', 'jlgm', 'ag315', 5, 0, 31, NULL);
insert into agentes values (21, 'Sebasti�n L�pez Ojeda', 'slo', 'sup21', 9, 2, NULL, 2);
insert into agentes values (211, 'Diosdado S�nchez Hern�ndez', 'dsh', 'ag211', 8, 1, 21, NULL);
insert into agentes values (2111, 'Jos� Juan Cano Pardo', 'jjcp', 'ag2111', 5, 0, 211, NULL);
insert into agentes values (2112, 'Flor Moncada A��n', 'ag2112', 'fma', 5, 0, 211, NULL);
insert into agentes values (2113, 'Juan Manuel Alcazar Donaire', 'jmad', 'ag2113', 5, 0, 211, NULL);
insert into agentes values (2121, 'Manuel Jes�s Rubia Mateos', 'mjrm', 'ag2121', 5, 0, 212, NULL);
insert into agentes values (2122, 'Esther L�pez Delgado', 'eld', 'ag2122', 5, 0, 212, NULL);
insert into agentes values (2123, 'Francisco Javier Cabrerizo Membrilla', 'fjcm', 'ag2123', 5, 0, 212, NULL);
insert into agentes values (2124, 'Ver�nica Cabrerizo Menbrilla', 'vcm', 'ag2124', 5, 0, 212, NULL);
insert into agentes values (2125, 'Mar�a Jos� Navascu�s Morales', 'mjnm', 'ag2125', 5, 0, 212, NULL);
insert into agentes values (2131, 'Isabel Cruz Granados', 'icg', 'ag2131', 5, 0, 213, NULL);
insert into agentes values (2132, 'Antonio Casado Fern�ndez', 'acf', 'ag2132', 5, 0, 213, NULL);
insert into agentes values (2133, 'Gabriel Callej�n Garc�a', 'gcg', 'ag2133', 5, 0, 213, NULL);
insert into agentes values (2134, 'Enrique Cano Balsera', 'ecb', 'ag2134', 5, 0, 213, NULL);
insert into agentes values (11, 'Narciso J�imez Toro', 'njt', 'sup11', 9, 2, NULL, 1);
insert into agentes values (111, 'Jes�s Ba�os Sancho', 'jbs', 'ag111', 8, 1, 11, NULL);
insert into agentes values (1111, 'Salvador Romero Villegas', 'srv', 'ag1111', 7, 1, 111, NULL);
insert into agentes values (1112, 'Jos� Javier Berm�dez Hern�ndez', 'jjbh', 'ag1112', 7, 1, 111, NULL);
insert into agentes values (1113, 'Alfonso Bonillo Sierra', 'abs', 'ag1113', 7, 1, 111, NULL);
insert into agentes values (1121, 'Silvia Thomas Barros', 'stb', 'ag1121', 7, 1, 112, NULL);
insert into agentes values (11211, 'Ernesto Osoro Gorrotxategi', 'eog', 'ag11211', 5, 0, 1121, NULL);
insert into agentes values (11212, 'Guillermo Campos Guill�n', 'gcag', 'ag11212', 5, 0, 1121, NULL);
insert into agentes values (11213, 'Antonio Fern�ndez Ru�z', 'afr', 'ag11213', 5, 0, 1121, NULL);
insert into agentes values (11214, 'Mar�a Luisa L�pez Caballero', 'mllc', 'ag11214', 5, 0, 1121, NULL);
insert into agentes values (11221, 'Virginia Morenas Rubio', 'vmr', 'ag11221', 5, 0, 1121, NULL);
insert into agentes values (11222, 'Rosario Castro Garc�a', 'rcg', 'ag11222', 5, 0, 1122, NULL);
insert into agentes values (11223, 'Antonio �lvarez Palomeque', 'aap', 'ag11223', 5, 0, 1122, NULL);
insert into agentes values (11224, 'David Mart�nez Mart�nez', 'dmm', 'ag11224', 5, 0, 1122, NULL);
insert into agentes values (11225, 'Juan Corral Gonz�lez', 'jcg', 'ag11225', 5, 0, 1122, NULL);
insert into agentes values (11226, 'Eduardo Alfada Pereira', 'eap', 'ag11226', 5, 0, 1122, NULL);
insert into agentes values (11231, 'Cayetano Garc�a Herrera', 'cgh', 'ag11231', 5, 0, 1123, NULL);
insert into agentes values (11232, 'Jos� Antonio Sieres Vega', 'jasv', 'ag11232', 5, 0, 1123, NULL);
insert into agentes values (11233, 'Juan Manuel Guzm�n Garc�a', 'jmgg', 'ag11233', 5, 0, 1123, NULL);

commit;