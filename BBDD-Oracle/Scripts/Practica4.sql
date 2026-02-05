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

-- Punto 3
declare
    v_pvp number(7,2) := &pvpProducto;
    v_iva number(2,0) := &ivaAplicar;
begin
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














