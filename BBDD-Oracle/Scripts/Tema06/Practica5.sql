SET SERVEROUTPUT ON;
-- Punto 1
create table MENSAJES(
valor varchar2(5)
);

declare
    valor number := 1;
begin
    loop
        insert into mensajes(valor) values
        (to_char(valor));
        valor:= valor + 1;
            if valor = 4 then
                valor := valor + 2;
            end if;
        exit when valor = 11;
    end loop;
    
    commit;
end;
/

-- Punto 2
-- No puedo controlar la excepcion que sale al poner un articulo que no existe, porque todavía no hemos dado el tema.
declare 
    v_codA articulos.coda%type;
    v_pvp articulos.pvp%type;
begin 
    v_codA := '&CodA';
    
    select pvp into v_pvp
    from articulos 
    where coda = v_codA;
    
    if sql%notfound then
            dbms_output.put_line('El articulo ' || trim(v_codA) || ' no existe');
        end if;
    
    if sql%found then
        if v_pvp < 300 then
            v_pvp := v_pvp + 20;
            
            update articulos
            set pvp = v_pvp
            where coda = v_codA;
        elsif v_pvp >= 300 and v_pvp <= 1000 then
            v_pvp := v_pvp + 50;
            
            update articulos
            set pvp = v_pvp
            where coda = v_codA;
        elsif v_pvp > 1000 then
            v_pvp := v_pvp + 100;
            
            update articulos
            set pvp = v_pvp
            where coda = v_codA;
        else 
            dbms_output.put_line('El articulo ' || trim(v_codA) || ' tiene precio null');
        end if;
    end if;
    commit;
end;
/
    
    

-- Punto 3
-- Modificamos la tabla de Articulos para añadir una nueva columna
ALTER TABLE ARTICULOS
ADD ESTRELLAS VARCHAR2(50);

-- Creamos un bloque PL/SQL para que almacene '*' cada 200€
DECLARE
    v_coda      ARTICULOS.CODA%TYPE := '&CODIGO_ARTICULO';
    v_pvp       ARTICULOS.PVP%TYPE;
    v_estrellas VARCHAR2(50) := '';
    v_cont      NUMBER;
    v_aux       NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_cont
    FROM ARTICULOS
    WHERE CODA = v_coda;

    IF v_cont = 0 THEN
        DBMS_OUTPUT.PUT_LINE('El artículo no existe');
    ELSE
        SELECT PVP
        INTO v_pvp
        FROM ARTICULOS
        WHERE CODA = v_coda;

        IF v_pvp IS NOT NULL THEN
            v_aux := v_pvp;

            WHILE v_aux >= 200 LOOP
                v_estrellas := v_estrellas || '*';
                v_aux := v_aux - 200;
            END LOOP;
        END IF;

        UPDATE ARTICULOS
        SET ESTRELLAS = v_estrellas
        WHERE CODA = v_coda;

        DBMS_OUTPUT.PUT_LINE(
            'Artículo ' || v_coda ||
            ' se ha actualizado correctamente con *: ' || v_estrellas
        );
    END IF;
END;
/