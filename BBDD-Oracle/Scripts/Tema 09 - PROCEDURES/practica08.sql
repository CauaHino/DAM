-- Punto 1
CREATE OR REPLACE PROCEDURE inserta_articulo (

    p_coda   IN CHAR,
    p_nombre IN VARCHAR2,
    p_pvp    IN NUMBER,
    p_color  IN CHAR,
    p_ctd    IN NUMBER,
    p_iva    IN NUMBER
)
AS
BEGIN
    INSERT INTO ARTICULOS (CODA, NOMBRE, PVP, COLOR, CTD, IVA)
    VALUES (p_coda, p_nombre, p_pvp, p_color, p_ctd, p_iva);
END;
/

-- INSERCCION DEL ARTICULO
BEGIN
    inserta_articulo('A21', 'ARTICULO NUEVO', 500, 'AZUL', 100, 12);
END;
/
-- Punto 2
CREATE OR REPLACE PROCEDURE modifica_articulo (
    p_coda   IN CHAR,
    p_nombre IN VARCHAR2
)
AS
    no_existe EXCEPTION;
    v_coda ARTICULOS.CODA%TYPE;
BEGIN
    -- Comprobamos si existe el artículo
    SELECT CODA
    INTO v_coda
    FROM ARTICULOS
    WHERE CODA = p_coda;

    -- Si existe, hacemos el UPDATE
    UPDATE ARTICULOS
    SET NOMBRE = p_nombre
    WHERE CODA = p_coda;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: el articulo no existe');
END;
/

-- EJECUCION DEL PROCEDIMIENTO
BEGIN
    modifica_articulo('A1', 'ARTICULO MODIFICADO');
END;
/
-- Punto 3
CREATE OR REPLACE PROCEDURE consulta_articulo (
    p_coda IN CHAR
)
AS
    v_nombre ARTICULOS.NOMBRE%TYPE;
    v_pvp    ARTICULOS.PVP%TYPE;
BEGIN
    -- Obtener los datos
    SELECT NOMBRE, PVP
    INTO v_nombre, v_pvp
    FROM ARTICULOS
    WHERE CODA = p_coda;

    -- Mostrar resultado
    DBMS_OUTPUT.PUT_LINE('Nombre articulo: ' || v_nombre || ' - PVP: ' || v_pvp || '€');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: el articulo no existe');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('Error: hay mas de un articulo con ese codigo');
END;
/

-- EJECUCION DEL PROCEDIMIENTO
BEGIN
    consulta_articulo('A1');
END;
/
-- Punto 4
create or replace function existe_articulo(fcodA articulos.codA%type) 
return boolean as 
    v_contador number;
    v_returnValor boolean;
begin
    select count(*) into v_contador
    from articulos
    where codA = fcodA;

    if(v_contador > 0) then
        v_returnValor := true;
    else
        v_returnValor := false;
    end if;
    
    return v_returnValor;
end;
/

create or replace function existe_cliente(fcodC clientes.codC%type)
return boolean as
    v_contador number;
    v_returnValor boolean;
begin
    select count(*) into v_contador
    from clientes
    where codC = fcodC;
    
    if(v_contador > 0) then
        v_returnValor := true;
    else
        v_returnValor := false;
    end if;
    
    return v_returnValor;
end;
/

create or replace procedure insertar_factura(p_nf facturas.nf%type,
                                             p_ctd facturas.ctd%type,
                                             p_fecha facturas.fecha%type,
                                             p_precio facturas.precio%type,
                                             p_pagada facturas.pagada%type,
                                             p_codA facturas.coda%type,
                                             p_codC facturas.codc%type) as
begin
    if (existe_articulo(p_codA) and existe_cliente(p_codC)) then
        insert into facturas values(p_nf, p_ctd, p_fecha, p_precio, p_pagada, p_codA, p_codC);
        dbms_output.put_line('Factura ' || p_nf || ' insertada correctamente.');
        commit;
    else
        if(existe_articulo(p_codA) = false) then
            dbms_output.put_line('No existe el artículo: ' || p_codA);
        elsif (existe_cliente(p_codC) = false) then
            dbms_output.put_line('No existe el cliente: ' || p_codC);
        end if;
    end if;
    
    exception
        when dup_val_on_index then
            dbms_output.put_line('Error: el número de factura ' || p_nf || ' ya existe');
        when value_error then
            dbms_output.put_line('Error: algún dato puesto está mal');
        when others then
            dbms_output.put_line('Error: error inesperado al ejecutar el procedimiento');
        
end;
/

-- Procedimiento donde deberia insertar
BEGIN
    insertar_factura(1001, 5, SYSDATE, 150, NULL, 'A2', 'C1');
END;
/
-- Procedimiento donde deberia salir que el articulo no existe
BEGIN
    insertar_factura(68, 15, '12/08/20', 150, NULL, 'A28', 'C1');
END;
/

-- Procedimiento donde deberia salir que el Cliente no existe
BEGIN
    insertar_factura(70, 10, '15/06/23', 150, NULL, 'A2', 'C68');
END;
/
-- Punto 5
CREATE OR REPLACE PROCEDURE borra_articulo (
    p_coda IN CHAR
)
AS
    no_existe EXCEPTION;
    v_coda ARTICULOS.CODA%TYPE;
BEGIN
    -- Comprobamos si existe el artículo
    SELECT CODA
    INTO v_coda
    FROM ARTICULOS
    WHERE CODA = p_coda;
    
    -- si existe, primero borramos de las tablas donde codA es FK
    DELETE FROM suministros
    WHERE CODA = p_coda;
    
    DELETE FROM facturas
    WHERE CODA = p_coda;

    -- Luego borramos de la tabla articulos
    DELETE FROM ARTICULOS
    WHERE CODA = p_coda;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: el articulo no existe');
END;
/

-- EJECUCION DEL PROCEDIMIENTO
BEGIN
    borra_articulo('A1');
END;
/
-- Punto 6
create or replace function nombre_articulo(fcodA articulos.coda%type)
return varchar2 as
    v_nombreArticulo articulos.nombre%type;
begin
    select nombre into v_nombreArticulo
    from articulos
    where coda = fcodA;
    
    return v_nombreArticulo;

exception
    when no_data_found then
        dbms_output.put_line('Error: El articulo buscado no existe');
    when others then
        dbms_output.put_line('Error: ocurrio un error inesperado al llamar la función');
end;
/

-- Llamamos la función
declare
    v_codA articulos.coda%type;
begin
    v_codA := '&codA_a_buscar';
    dbms_output.put_line('El articulos buscado es: ' || nombre_articulo(v_codA));
end;
/
-- Punto 7
create or replace function descontar_iva(fcodA articulos.coda%type)
return number as
    v_pvpNeto articulos.pvp%type;
    v_pvpIva articulos.pvp%type;
    v_iva articulos.iva%type;
begin
    select pvp, iva into v_pvpIva, v_iva
    from articulos
    where coda = fcodA;
    
    v_pvpNeto := v_pvpIva - (v_pvpIva * (v_iva / 100));
    
    return v_pvpNeto;
end;
/

-- Llamamos la función
declare
    v_codA articulos.coda%type;
    v_pvpIva articulos.pvp%type;
    v_iva articulos.iva%type;
begin
    v_codA := '&codA_a_buscar';
    
    select pvp, iva into v_pvpIva, v_iva
    from articulos
    where coda = v_codA;
    
    dbms_output.put_line('PRECIO CON IVA: ' || v_pvpIva);
    dbms_output.put_line('IVA: ' || v_iva);
    dbms_output.put_line('PRECIO SIN IVA: ' || descontar_iva(v_codA));
end;
/