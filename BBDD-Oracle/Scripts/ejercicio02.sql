SET SERVEROUTPUT ON;
-- Punto 1
accept entrada prompt 'Introduce un número de 0 hasta 100';
declare
    v_numero number(3) := &entrada;
begin 
    if(v_numero >= 0 AND v_numero <= 100) then
        if(v_numero = 10) then
            dbms_output.put_line('Has ganado el primer premio con el número: ' || v_numero);
        elsif(v_numero = 20) then
            dbms_output.put_line('Has ganado el segundo premio con el número: ' || v_numero);
        elsif(v_numero = 30) then
            dbms_output.put_line('Has ganado el tercer premio con el número: ' || v_numero);
        else
        dbms_output.put_line('El número introducido fue: ' || v_numero);
        end if;
    else
        dbms_output.put_line('El número introducido no es válido');
     end if;
end;
/