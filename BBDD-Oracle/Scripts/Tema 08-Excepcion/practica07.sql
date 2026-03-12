SET SERVEROUTPUT ON
-- Ejercicio 01

CREATE TABLE RESULTADO_PROVEEDORES(
    MENSAJE VARCHAR2(100)
);

DECLARE
    v_nombre PROVEEDORES.NOMBRE%TYPE;
    v_ciudad PROVEEDORES.CIUDAD%TYPE := '&ciudad';
    v_cont NUMBER;

    varios_proveedores EXCEPTION;

BEGIN

    SELECT COUNT(*)
    INTO v_cont
    FROM proveedores
    WHERE ciudad = v_ciudad;

    IF v_cont = 1 THEN

        SELECT nombre
        INTO v_nombre
        FROM proveedores
        WHERE ciudad = v_ciudad;

        INSERT INTO resultado_proveedores
        VALUES (v_nombre || ' - ' || v_ciudad);

    ELSIF v_cont = 0 THEN
        RAISE NO_DATA_FOUND;

    ELSE
        RAISE varios_proveedores;

    END IF;

EXCEPTION

    WHEN NO_DATA_FOUND THEN
        INSERT INTO resultado_proveedores
        VALUES ('No existen proveedores en "' || v_ciudad || '"');

    WHEN varios_proveedores THEN
        INSERT INTO resultado_proveedores
        VALUES ('Existen varios proveedores en "' || v_ciudad || '"');

    WHEN OTHERS THEN
        INSERT INTO resultado_proveedores
        VALUES ('Se ha producido un error');

END;
/

SELECT * FROM RESULTADO_PROVEEDORES;

-- Punto 2
declare 
    v_codc clientes.codc%type;
    v_direccion clientes.direccion%type;
    
    CLIENTE_NO_ENCONTRADO exception;
begin
    v_codc := '&codC';
    v_direccion := '&direccion';
    
        update clientes
        set direccion = v_direccion
        where codc = v_codc;
           
        if sql%found then
            dbms_output.put_line('La dirección del cliente ' || trim(v_codc) || ' fue actualizada para ' || v_direccion);
        end if;
    
        if sql%notfound then
            raise CLIENTE_NO_ENCONTRADO;
        end if;
    commit;
    
    exception 
        when CLIENTE_NO_ENCONTRADO then
            dbms_output.put_line('El cliente con ' ||trim( v_codc) || ' no existe');
        when others then
            dbms_output.put_line('Hubo un error al ejecutar el programa');
end;
/

-- Punto 3
declare
    v_precio_base  NUMBER;
    v_contador     NUMBER;
    v_rango_min    NUMBER;
    v_rango_max    NUMBER;
    
    error_inesperado exception;
begin
    v_precio_base := &introduzca_precio;
    v_rango_min := v_precio_base - 100;
    v_rango_max := v_precio_base + 100;
    
    select count(*) into v_contador
    from articulos
    where pvp between v_rango_min and v_rango_max;
    
        if v_contador = 0 then
            dbms_output.put_line('No hay artículos con un PVP entre ' || v_rango_min || ' y ' || v_rango_max || ' euros.');
        else
            dbms_output.put_line('Se han encontrado ' || v_contador || ' artículos en el rango de precio establecido.');
        end if;
    exception
        when VALUE_ERROR then
            dbms_output.put_line('Error: Por favor, introduce un valor numérico válido.');   
        when others then
            dbms_output.put_line('Se ha producido un error inesperado.');    
end;
/