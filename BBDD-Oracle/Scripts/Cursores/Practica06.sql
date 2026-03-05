set serveroutput on;

create table aux_articulos(
coda char(8) primary key, 
nombre char(20), 
pvp number(7,0),
color char(10), 
ctd number(7,0),
iva number(2,0)
);

-- Punto 1

-- Con While
declare
    v_numInsert number;
    v_contador number := 0;
    
    cursor c_auxArticulos is
        select *
        from articulos
        where pvp is not null
        order by pvp desc;
        
    verRegistro c_auxArticulos%rowtype;
begin
    delete from aux_articulos;
    
    v_numInsert := &cantidadArticulos;
    
    open c_auxArticulos;
    fetch c_auxArticulos into verRegistro;
    
    while c_auxArticulos%found and v_contador < v_numInsert loop
        insert into aux_articulos(coda, nombre, pvp, color, ctd, iva)
        values (verRegistro.coda, verRegistro.nombre, verRegistro.pvp, verRegistro.color, verRegistro.ctd, verRegistro.iva);
        
        v_contador := v_contador + 1;
        fetch c_auxArticulos into verRegistro;
    end loop;
    close c_auxArticulos;
    commit;
end;
/

-- Con FOR
declare
    v_numInsert number;
    v_contador number := 0;
    
    cursor c_auxArticulos is
        select *
        from articulos
        where pvp is not null
        order by pvp desc;
        
begin
    delete from aux_articulos;    
    v_numInsert := &cantidadArticulos;
    
   for verRegistro in c_auxArticulos loop
   exit when v_contador >= v_numInsert;
        
        insert into aux_articulos(coda, nombre, pvp, color, ctd, iva)
        values (verRegistro.coda, verRegistro.nombre, verRegistro.pvp, verRegistro.color, verRegistro.ctd, verRegistro.iva);
        
        v_contador := v_contador + 1;
    
    end loop;
    commit;
end;
/

-- Punto 2
-- CREAMOS LA TABLA PARA QUE SE GUARDEN LOS DATOS DEL CURSOR
CREATE TABLE PROVEEDORES_POR_PAIS (
    TEXTO VARCHAR2(100)
);

-- CREAMOS UN BLOQUE DECLARE PARA CREAR EL CURSOR
DECLARE

    CURSOR c_paises IS
        SELECT DISTINCT PAIS
        FROM PROVEEDORES;

    CURSOR c_proveedores (v_pais PROVEEDORES.PAIS%TYPE) IS
        SELECT NOMBRE
        FROM PROVEEDORES
        WHERE PAIS = v_pais;

    v_pais PROVEEDORES.PAIS%TYPE;
    v_nombre PROVEEDORES.NOMBRE%TYPE;

BEGIN

    OPEN c_paises;
    LOOP
        FETCH c_paises INTO v_pais;
        EXIT WHEN c_paises%NOTFOUND;

        OPEN c_proveedores(v_pais);
        LOOP
            FETCH c_proveedores INTO v_nombre;
            EXIT WHEN c_proveedores%NOTFOUND;

            INSERT INTO PROVEEDORES_POR_PAIS
            VALUES (v_nombre || ' - País: ' || v_pais);

        END LOOP;

        CLOSE c_proveedores;

    END LOOP;

    CLOSE c_paises;

END;
/

-- VEMOS LOS DATOS DE LA TABLA PROVEEDORES_POR_PAIS
SELECT * FROM PROVEEDORES_POR_PAIS;

-- Punto 3
ALTER TABLE ARTICULOS
ADD ESTRELLAS VARCHAR2(50);

DECLARE
    CURSOR c_articulos IS
        SELECT CODA, PVP
        FROM ARTICULOS
        FOR UPDATE;

    v_estrellas VARCHAR2(50);
    v_aux       NUMBER;
BEGIN
    FOR v_art IN c_articulos LOOP

        v_estrellas := '';

        IF v_art.PVP IS NOT NULL THEN
            v_aux := v_art.PVP;

            WHILE v_aux >= 200 LOOP
                v_estrellas := v_estrellas || '*';
                v_aux := v_aux - 200;
            END LOOP;
        END IF;

        UPDATE ARTICULOS
        SET ESTRELLAS = v_estrellas
        WHERE CURRENT OF c_articulos;

    END LOOP;
END;
/

-- hemos utilizado un cursor con FOR UPDATE para recorrer todos los artículos.
--Para cada artículo se calcula una cadena de asteriscos en función del PVP, añadiendo un * por cada 200€.
--Y La actualización se realiza mediante WHERE CURRENT OF sobre la fila actual del cursor.
    
    
