-- Ejercicio 06
create or replace trigger trg_clientes_mayus
    before insert or update on clientes
    for each row 
begin 
    :new.nombre := upper(:new.nombre);
end;
/

-- Ejercicio 07
create or replace trigger trg_tlf_cliente
    before insert or update on clientes
    for each row
begin
    if length(trim(:new.tlf)) < 9 then
        raise_application_error(-20001, 'El telefono dene tener 9 digitos');
    end if;
end;
/

-- Ejercicio 08
create or replace trigger trg_stock_factura
    before insert on facturas
    for each row 
declare 
    v_stock articulos.ctd%type;
begin 
    select ctd into v_stock 
    from articulos 
    where coda = :new.codA;

    if v_stock < :new.ctd then
        RAISE_APPLICATION_ERROR(-20050, 'NO TIENE STOCK SUFICIENTE');
    else
        update articulos
        set ctd = ctd - :new.ctd
        where coda = :new.coda;
    end if;
end;
/

-- Ejercicio 09
create or replace trigger trg_incrementar_pvp
    after insert 
    on suministros
    for each row 
begin 
    update articulos
    set pvp = :new.puc + (:new.puc * 0.2)
    where coda = :new.coda;
end;
/

-- Ejercicio 10
create or replace trigger trg_no_borrar_cliente
    before delete
    on clientes
    for each row
declare 
    contador number;
begin 
    select count(*) into contador
    from facturas
    where codc = :old.codc;

    if contador > 0 then 
        raise_application_error(-20100, 'El cliente tiene factura');
    end if;
end;
/

-- Ejercicio 11
create or replace trigger trg_fecha_pago
    before insert 
    on facturas
    for each row 
begin 
    if :new.pagada is null then 
        :new.pagada := sysdate;
    end if;
end;

-- Ejercicio 12
create or replace trigger trg_control_iva
    before insert
    on articulos
    for each row 
begin 
    if :new.iva not in (4,6,12) then 
        raise_application_error(-20003, 'Iva no permitido');
    end if;
end;
/

-- Ejercicio 13
create or replace trigger trg_factura_completo
    before insert
    on facturas
    for each row 
declare 
    v_stock number;
    v_pvp number;
BEGIN
    select ctd, pvp into v_stock, v_pvp
    from articulos 
    where coda = :new.coda;

    if v_stock < :new.ctd then
        raise_application_error(-20010, 'Stock insuficiente');
    else 
        update articulos 
        set ctd = ctd - :new.ctd
        where coda = :new.coda;
    end if;

    :new.precio := :new.ctd * v_pvp;

    if :new.pagada is null then 
        :new.pagada := sysdate;
    end if;
end;
/

-- Ejercicio 14

-- a
CREATE OR REPLACE TRIGGER DISP_PEDIDOS
BEFORE INSERT OR UPDATE ON pedidos
FOR EACH ROW
BEGIN
    -- Validar fechas
    IF (:NEW.fecha_pedido >= :NEW.fecha_esperada OR :NEW.fecha_pedido >= :NEW.fecha_entrega) THEN
        RAISE_APPLICATION_ERROR(-20001, 'La fecha de pedido debe ser anterior a la de entrega y esperada.');
    END IF;

    -- Validar estado (P, E, D)
    IF (:NEW.estado NOT IN ('P', 'E', 'D')) THEN
        RAISE_APPLICATION_ERROR(-20002, 'Estado no válido. Use P (Pendiente), E (Entregado) o D (Devuelto).');
    END IF;

    -- Validar PedidoPagado (S, N)
    IF (:NEW.PedidoPagado NOT IN ('S', 'N')) THEN
        RAISE_APPLICATION_ERROR(-20003, 'Columna PedidoPagado solo acepta S o N.');
    END IF;
END;
/
-- b
CREATE OR REPLACE TRIGGER DISP_DETALLEPEDIDOS
BEFORE INSERT OR UPDATE ON detallepedidos
FOR EACH ROW
DECLARE
    v_stock productos.cantidad_en_stock%TYPE;
BEGIN
    SELECT cantidad_en_stock INTO v_stock 
    FROM productos 
    WHERE codigo_producto = :NEW.codigo_producto;

    IF (:NEW.unidadespedidas > v_stock) THEN
        RAISE_APPLICATION_ERROR(-20004, 'Error: La cantidad pedida supera el stock disponible.');
    END IF;
END;
/

-- Ejercicio 15
CREATE OR REPLACE TRIGGER trg_pvp_minimo
AFTER INSERT OR UPDATE ON suministros
FOR EACH ROW
DECLARE
    CURSOR c_puc IS 
        SELECT precio_unidad_compra 
        FROM suministros 
        WHERE codigo_articulo = :NEW.codigo_articulo;
    
    v_puc_min NUMBER := 999999999; -- Valor inicial alto para comparar
    v_puc_actual NUMBER;
    v_hay_suministros BOOLEAN := FALSE;
BEGIN
    OPEN c_puc;
    LOOP
        FETCH c_puc INTO v_puc_actual;
        EXIT WHEN c_puc%NOTFOUND;
        
        v_hay_suministros := TRUE;
        IF v_puc_actual < v_puc_min THEN
            v_puc_min := v_puc_actual;
        END IF;
    END LOOP;
    CLOSE c_puc;

    IF NOT v_hay_suministros THEN
        RAISE_APPLICATION_ERROR(-20005, 'No hay suministros');
    END IF;

    -- Actualizar el precio del artículo (PVP = Min + 30%)
    UPDATE articulos 
    SET pvp = v_puc_min * 1.30
    WHERE codigo_articulo = :NEW.codigo_articulo;
END;
/

-- Ejercicio 16
CREATE OR REPLACE TRIGGER trg_limite_cliente
BEFORE INSERT ON facturas
FOR EACH ROW
DECLARE
    CURSOR c_ventas IS 
        SELECT cantidad 
        FROM facturas 
        WHERE codc = :NEW.codc 
          AND fecha = :NEW.fecha;
    
    v_total NUMBER := 0;
    v_cantidad_hist NUMBER;
BEGIN
    -- Recorrer ventas del día
    OPEN c_ventas;
    LOOP
        FETCH c_ventas INTO v_cantidad_hist;
        EXIT WHEN c_ventas%NOTFOUND;
        v_total := v_total + v_cantidad_hist;
    END LOOP;
    CLOSE c_ventas;

    -- Sumar la nueva cantidad que se intenta insertar
    v_total := v_total + :NEW.cantidad;

    -- Validar límite
    IF v_total > 5000 THEN
        RAISE_APPLICATION_ERROR(-20006, 'Límite diario superado');
    END IF;
END;
/


