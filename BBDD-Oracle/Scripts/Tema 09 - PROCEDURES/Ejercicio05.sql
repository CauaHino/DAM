-- Actividad 1

create or replace function calcularPedido(p_codigoPedido e_pedidos.codigopedido%type)
return number as
    cursor productos_pedidos is
        SELECT p.precioventa, dp.unidadespedidas
        FROM e_productos p
        INNER JOIN e_detallepedidos dp ON p.codigoproducto = dp.codigoproducto
        WHERE dp.codigopedido = p_codigoPedido;
        
    v_total number := 0;
begin 
    for registro in productos_pedidos loop
        if registro.unidadespedidas >= 0 and registro.unidadespedidas <= 5 then
            v_total := v_total + (registro.unidadespedidas * registro.precioventa);
        elsif registro.unidadespedidas >= 6 and registro.unidadespedidas <= 10 then
            v_total := v_total + (registro.unidadespedidas * registro.precioventa * 0.95);
        elsif registro.unidadespedidas >= 11 and registro.unidadespedidas <= 15 then
            v_total := v_total + (registro.unidadespedidas * registro.precioventa * 0.93);
        else
            v_total := v_total + (registro.unidadespedidas * registro.precioventa * 0.9);
        end if;
    end loop;
    
    return v_total;
end;
/

select calcularpedido(3);


-- Actividad 2
create or replace procedure calcularCliente(p_ano in number, p_codCliente in e_pedidos.codigocliente%type, totalPagado out number, totalNoPagado out number) as
    
    numPedidos number;
    existeCliente e_clientes.codigocliente%type;
    pedidosInsuficientes exception;

    cursor pedidos_pagados is
        select codigopedido
        from e_pedidos
        where codigocliente = p_codCliente
        and pedidopagado = 'S'
        and fechaentrega like ('%' || p_ano);

    cursor pedidos_no_pagados is
        select codigopedido
        from e_pedidos
        where codigocliente = p_codcliente
        and pedidopagado = 'N'
        and fechaentrega like ('%' || p_ano);
begin 
    totalPagado := 0;
    totalNoPagado := 0;
    
    select codigoCliente into existeCliente
    from e_clientes
    where codigocliente = p_codcliente;
    
    select count(*) into numPedidos
    from e_pedidos
    where codigoCliente = p_codCliente
    and fechaentrega like('%' || p_ano);
    
    if numPedidos < 2 then
        raise pedidosInsuficientes;
    end if;
    
     for registro in pedidos_pagados loop
        totalPagado := totalPagado + calcularpedido(registro.codigopedido);
    end loop;
    
    for registro in pedidos_no_pagados loop
        totalNoPagado := totalNoPagado + calcularpedido(registro.codigopedido);
    end loop;
    
    dbms_output.put_line('El total Pagada del cliente ' || p_codCliente || ' es ' || totalPagado);
    dbms_output.put_line('El total no Pagada del cliente ' || p_codCliente || ' es ' || totalNoPagado);
exception
    when no_data_found then
        totalPagado := -1;
        totalNoPagado := -1;
        dbms_output.put_line('El cliente no existe');
    when pedidosInsuficientes then
        totalPagado := -1;
        totalNoPagado := -1;
        dbms_output.put_line('No hay pedidos suficientes');
end;
/

declare 
    v_totalPagado number(8);
    v_totalNoPagado number(8);    
    v_ano number;
    v_codCliente e_pedidos.codigocliente%type;
begin
    v_codCliente := &codCliente;
    v_ano := &ano;
    calcularCliente(v_ano, v_codCliente, v_totalPagado, v_totalNoPagado);
end;
/

