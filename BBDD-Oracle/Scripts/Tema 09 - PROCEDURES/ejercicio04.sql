set serveroutput on;
-- Punto 1
create or replace procedure cambiarAgentesFamilia(idFamiliaOrigen in number, idFamiliaDestino in number)as
    
    v_familiaFamiliaOrigen familias.familia%type;
    v_familiaFamiliaDestino familias.familia%type;
    v_idFamiliaOrigen familias.idFamilia%type;
    v_idFamiliaDestino familias.idFamilia%type;
    
    contador number;
    mismaFamilia exception;
begin

    if IdFamiliaOrigen = idFamiliaDestino then
        raise mismaFamilia;
    end if;

    select familia, idFamilia into v_familiaFamiliaOrigen, v_idFamiliaOrigen
    from familias 
    where idFamilia = idFamiliaOrigen;
    
    select familia, idFamilia into v_familiaFamiliaDestino, v_idFamiliaDestino
    from familias 
    where idFamilia = idFamiliaDestino;
    
    if sql%rowcount = 0 then
        raise_application_error(-20002, 'No existe la familia de destino');
    end if;

    update agentes
    set familia = v_familiaFamiliaDestino
    where familia = v_familiaFamiliaOrigen;
    
    contador := sql%rowcount;
    
    dbms_output.put_line('Fueron cambiados ' || contador || ' Agentes');

    exception 
        when mismaFamilia then
            dbms_output.put_line('Las familias son iguales');
        
end;
/

select * 
from familias f
join agentes a on a.familia = f.familia;

execute cambiarAgentesFamilia(112,1121);