SET SERVEROUTPUT ON;
-- Punto 1
DECLARE
    v_id NUMBER(4); -- VÁLIDA: está bien declarado ya que indica el tipo del dato correctamente
    v_xx, v_y, v_z VARCHAR2(10); -- VÁLIDA: debido a que las variables son del mismo tipo
    v_birthdate DATE NOT NULL; -- NO VÁLIDA: NOT NULL exige inicialización
    v_in_stock BOOLEAN := 1; -- NO VÁLIDA: BOOLEAN solo admite TRUE/FALSE/NULL NO VALORES ENTEROS
    emp_record emp_record_type; -- NO VÁLIDA: el tipo no está declarado
    TYPE name_table_type IS TABLE OF VARCHAR2(20); -- NO VÁLIDA: falta INDEX BY en la definición
    INDEX BY BINARY_INTEGER; -- NO VÁLIDA: no puede declararse de forma independiente
    dept_name_table name_table_type; -- NO VÁLIDA: el tipo está mal definido
    
-- Punto 2
DECLARE
    v_customer VARCHAR2(50) := ' Womansport ';
    -- v_customer = ' Womansport '

    v_weight   NUMBER(3) := 600;
    -- v_weight = 600

    v_message  VARCHAR2(255) := ' Producto 10012 ';
    -- v_message = ' Producto 10012 '
BEGIN
    DECLARE
        v_customer NUMBER(7) := 201;
        -- v_customer = 201
        -- v_customer sigue siendo ' Womansport '

        v_message  VARCHAR2(255) := ' Producto 11001 ';
        -- v_message = ' Producto 11001 '
        -- v_message sigue siendo ' Producto 10012 '

        v_new_locn VARCHAR2(50) := ' Europa ';
        -- v_new_locn (interno) = ' Europa '
    BEGIN
        v_weight := v_weight + 1;
        -- v_weight = 601
        -- (se modifica la variable del bloque externo)

        v_new_locn := ' Oeste ' || v_new_locn;
        -- v_new_locn = ' Oeste  Europa '
    END;
    -- Fin del bloque interno

    v_weight := v_weight + 1;
    -- v_weight = 602

    v_message := v_message || ' está en stock ';
    -- v_message = ' Producto 10012  está en stock '

    v_customer := ' Carmen ' || v_customer;
    -- v_customer = ' Carmen  Womansport '

    v_new_locn := ' Oeste ' || v_new_locn;
    -- v_new_locn NO EXISTE en este bloque
END;
/
-- Punto 3
declare
    v_pvp articulos.pvp%type;
    v_iva articulos.iva%type;
begin
    v_pvp := &pvpProducto;
    v_iva := &ivaAplicar;
    v_pvp := v_pvp * (1 + v_iva / 100.0);
    dbms_output.put_line('El valor total del producto dedspués de aplicar el IVA es: ' || v_pvp);
end;
/

-- Punto 4
DECLARE
    v_pvp_max ARTICULOS.PVP%TYPE;
BEGIN
    SELECT MAX(PVP)
    INTO v_pvp_max
    FROM ARTICULOS;

    DBMS_OUTPUT.PUT_LINE('El PVP más alto es: ' || v_pvp_max);
END;
/

-- Punto 5
declare 
    v_codc char(8) := '&codC';
    v_direccion varchar(50) := '&direccion';
begin
    update clientes
    set direccion = v_direccion
    where codc = v_codc;
    dbms_output.put_line('La dirección del cliente ' || trim(v_codc) || ' fue actualizada para ' || v_direccion);
    
    commit;
end;
/

-- Punto 6
declare 
    coda articulos.coda%type;
    nombre articulos.nombre%type;
begin
    coda := '&coda';
    nombre := '&nombre';
    insert into articulos (coda,nombre) values
    (coda, nombre);
    dbms_output.put_line('El Articulo ' || nombre || ' fue introducido correctamente');
    
    commit;
end;
/

-- Punto 7
declare 
    v_pais proveedores.pais%type;
begin
    v_pais := '&paisBorrar';
    
    delete from suministros
    where codp in ( select codp
                    from proveedores 
                    where pais = v_pais);
    
    delete from proveedores
    where pais = v_pais;
    
    dbms_output.put_line('Los proveedores de ' || v_pais || ' Fueron Borrados');
    
    commit;
end;
/
















