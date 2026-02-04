SET SERVEROUTPUT ON;

--Bucle LOOP
declare 
 i number := 1;
begin
    loop
        dbms_output.put_line('Bucle LOOP en la interación: '|| i);
        i := i + 1;
        exit when i > 10;
    end loop;
end;
/

-- Bucle While
declare
    i number := 1;
begin
    while i < 11 loop
        dbms_output.put_line('Bucle WHILE en la interación: '|| i);
        i := i + 1;
    end loop;
end;
/

-- Bucle FOR
begin
    for i in 1..10 loop
        dbms_output.put_line('Bucle FOR en la interación: '|| i);
    end loop;
end;
/









