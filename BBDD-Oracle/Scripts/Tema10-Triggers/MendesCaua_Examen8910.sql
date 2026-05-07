-- Ejercicio 1
create or replace function beneficio_articulos(fcoda articulos.coda%type)
return number as        
    cursor c_articulos(c_coda articulos.coda%type) is
        select ctd, pvp
        from articulos
        where codA = c_coda;
        
    cursor c_facturas(c_coda articulos.coda%type) is
        select precio, ctd
        from facturas
        where coda = c_coda;
        
    v_cantidad articulos.ctd%type;
    v_cantidadFacturas facturas.ctd%type;
    v_contador number;
    v_precio articulos.pvp%type;
    v_pucArticulo suministros.puc%type;
    v_precioMedio number;
    v_precioMedioFacturas number;
    v_beneficioTotal number;
    excep_no_existe_coda exception;
begin
    select count(*) into v_contador
    from articulos
    where coda = fcoda;
    
    if v_contador = 0 then
        raise excep_no_existe_coda;
    end if;
    
    for i in c_articulos(fcoda) loop
        exit when sql%notfound;
        
        v_pucArticulo := v_pucArticulo + i.pvp;
        v_cantidad := v_cantidad + i.ctd;
    end loop;
    
        v_precioMedio := v_pucArticulo / v_cantidad;
    for facturas in c_facturas(fcoda) loop
    exit when sql%notfound;
        v_precio := v_precio + facturas.precio;
        v_cantidadFacturas := v_cantidadFacturas + facturas.ctd;
    end loop;
        
    v_precioMedioFacturas := v_precio / v_cantidadFacturas;
    
    v_beneficioTotal := (v_precio - v_precioMedio) * v_cantidadFacturas;
    
    return v_beneficioTotal;
    
exception
    when excep_no_existe_coda then
        raise_application_error(-20001, 'EL CODA: ' || fcoda || ' NO EXISTE EN LA TABLA ARTICULOS');
end;
/

-- Como llamar
declare
    v_coda articulos.coda%type;
begin
    v_coda := '&coda_que_desee_buscar';
    
    dbms_output.put_line('Beneficio del ARTICULO:' || v_coda || ' es: ' || beneficio_articulos(v_coda));
end;
/
select
beneficio_articulos('A1');

-- Ejercicio 02
create or replace procedure ajustar_precio as
    cursor c_articulos is
        select *
        from articulos;
        
    cursor c_facturas(c_coda articulos.coda%type) is
        select ctd, precio
        from facturas
        where coda = c_coda;
    v_pvp number;
    v_ctd articulos.ctd%type;
    v_pvpCompra articulos.pvp%type;
    v_pvpVenta facturas.precio%type;
begin
    for i in c_articulos loop
        exit when sql%notfound;
        
        v_pvpCompra := i.pvp / i.ctd;
         
        for factura in c_facturas(i.coda) loop
            exit when sql%notfound;
            v_ctd := v_ctd + factura.ctd;
            v_pvpVenta := v_pvpVenta + factura.precio;
        end loop;                
        v_pvpVenta := v_pvpVenta / v_ctd;
        
        if v_pvpVenta < v_pvpCompra then
            update articulos
            set pvp = pvp * 1.15
            where coda = i.coda;
        elsif (v_pvpVenta - v_pvpCompra) / v_pvpCompra < 0.20 then
            update articulos
            set pvp = pvp * 1.05
            where coda = i.coda;
        elsif (v_pvpVenta - v_pvpCompra) / v_pvpCompra >= 0.20 then
            update articulos
            set pvp = pvp * 0.95
            where coda = i.coda;
        end if;   
            
        dbms_output.put_line('Articulo ' || i.coda || ' actualizado para ' || i.pvp);
    end loop;
end;
/

execute ajustar_precio;

-- Ejercicio 03
create or replace trigger control_precio_venta
    before insert or update
    on facturas
    for each row 
declare
    v_ctd facturas.ctd%type;
    v_pvp articulos.pvp%type;
    v_precioMedio number;
begin
         select ctd, pvp into v_ctd, v_pvp
         from articulos
         where coda = :new.coda;

    if sql%notfound then
        raise_application_error(-20001,'No existen suministros para el articulo: ' || :new.coda);
    end if;
    
    v_precioMedio := v_pvp / v_ctd;
    
    if :new.precio < v_precioMedio then
        raise_application_error(-20002, 'Precio de venta inferior al de compra');
    else 
        insert into auditoria_facturas values (:new.nf, 'Insertar' , sysdate, :old.precio, :new.precio);
    end if;
end;
/

-- Caso de Prueba
insert into facturas values (11, 20, sysdate, 3, null, 'A1', 'C2');

update facturas
set precio = 2
where nf = 11;

insert into facturas values (12, 20, sysdate, 1, null, 'A1', 'C1');

update facturas
set precio = -5
where nf = 10;
    