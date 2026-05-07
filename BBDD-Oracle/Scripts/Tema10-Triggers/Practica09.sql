-- EJERCICIO 1

CREATE OR REPLACE TRIGGER tr_min_pvp
BEFORE INSERT OR UPDATE OF pvp
ON articulos
FOR EACH ROW
DECLARE
    v_max_puc suministros.puc%TYPE;
BEGIN
    /* Buscar el precio de compra más alto del artículo */
    SELECT MAX(puc)
    INTO v_max_puc
    FROM suministros
    WHERE coda = :NEW.coda;

    /* Si el PVP es menor que el precio máximo de compra */
    IF :NEW.pvp < v_max_puc THEN
        RAISE_APPLICATION_ERROR(
            -20001,
            'Error: El PVP no puede ser menor que el precio de compra debe ser mas alto'
        );
    END IF;

EXCEPTION
    /* Si el artículo no tiene proveedores en suministros */
    WHEN NO_DATA_FOUND THEN
        NULL;
END;
/

-- EJERCICIO 2
create table morosos as
select c.*, f.nf
from clientes c, facturas f
where '1' = '2';

create or replace trigger tr_morosidad
after logon on schema
when (user = 'nombre_usuario')
begin
    -- eliminamos los registros actuales para evitar duplicados o datos obsoletos
    delete from morosos;

    -- insertamos los clientes con facturas de más de 90 días sin pagar
    insert into morosos
    select c.*, f.nf
    from clientes c
    join facturas f on c.codc = f.codc
    where f.pagada is null and f.fecha < sysdate - 90;

    commit;
end;
/

-- EJERCICIO 3
-- A)
CREATE SEQUENCE sec_nfact
START WITH 25
MINVALUE 25
INCREMENT BY 1
NOCYCLE;
-- B)
create or replace trigger tr_nf_factura
before insert on facturas
for each row
begin
    :new.nf := sec_nfact.nextval;
end;
/

