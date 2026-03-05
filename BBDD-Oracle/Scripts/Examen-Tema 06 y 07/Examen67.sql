set serveroutput on;

-- Ejercicio 1
declare
    v_fecha1 facturas.fecha%type;
    v_fecha2 facturas.fecha%type;
    v_importeTotal decimal(6,2);
    v_numFacturas int;
begin
    v_fecha1 := '&primeraFecha';
    v_fecha2 := '&segundaFecha';
    
    if v_fecha1 > v_fecha2 then
        dbms_output.put_line('NO EXISTE EL INTERVALO DADO');
    else   
    
        dbms_output.put_line('1ª Fecha: ' || v_fecha1 || ' - ' || '2ª Fecha: ' || v_fecha2);
        
        select count(*) into v_numFacturas
        from facturas
        where pagada is not null and fecha in (select fecha
                                            from facturas
                                            where fecha between v_fecha1 and v_fecha2);
                                            
        select sum(precio) into v_importeTotal
        from facturas
        where pagada is not null and fecha in (select fecha
                                            from facturas
                                            where fecha between v_fecha1 and v_fecha2);
                    
        dbms_output.put_line('Nº facturas pagadas entre las dos fechas dadas ' || v_numfacturas);
        dbms_output.put_line('Importe total ' || v_importeTotal || '€');
        
        select count(*) into v_numFacturas
        from facturas
        where pagada is null or fecha not in (select fecha
                                            from facturas
                                            where fecha between v_fecha1 and v_fecha2);
                                            
        select sum(precio) into v_importeTotal
        from facturas
        where pagada is null or fecha not in (select fecha
                                            from facturas
                                            where fecha between v_fecha1 and v_fecha2);
                    
        dbms_output.put_line('Nº facturas pedientes de ser pagadas ' || v_numfacturas);
        dbms_output.put_line('Importe total pendiente ' || v_importeTotal || '€');
    end if;
end;
/

-- Ejercicio 2
declare 
    cursor c_fecha is
        select distinct fecha 
        from facturas
        order by fecha asc;

    cursor c_factura(v_fecha date) is
        select *
        from facturas
        where fecha = v_fecha;
        
verFecha c_fecha%rowtype;
verFactura c_factura%rowtype;
begin   
    open c_fecha;
    loop
        fetch c_fecha into verFecha;
        exit when c_fecha%notfound;
        open c_factura(verFecha.fecha);
                        dbms_output.put_line('Fecha: ' || verFecha.fecha);
            loop
                fetch c_factura into verFactura;
                exit when c_factura%notfound;
                
                dbms_output.put_line('Nº Factura: ' || verFactura.nf || ' Código Artículo: ' || verFactura.coda || ' Precio: ' || verFactura.precio || '€' );
            end loop;
            close c_factura;
        end loop;
        close c_fecha;
    end;
    /
                
    
    







