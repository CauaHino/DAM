set serveroutput on;

create table cursos(
    codCurso varchar2(2) primary key,
    curso varchar2(5)
);

create table alumnos(
    codAlumno varchar2(2) primary key,
    nombre varchar2(20),
    apellidos varchar2(30)
);

create table notas(
    codAlumno varchar2(2) references alumnos(codAlumno),
    codCurso varchar2(2) references cursos(codCurso),
    notaParcial decimal(3,2),
    notaPracticas decimal(3,2),
    notaFinal decimal(3,2)
); 

INSERT INTO alumnos (codAlumno, nombre, apellidos) VALUES ('A1', 'Ana', 'García López');
INSERT INTO alumnos (codAlumno, nombre, apellidos) VALUES ('A2', 'Luis', 'Rodríguez Paz');
INSERT INTO alumnos (codAlumno, nombre, apellidos) VALUES ('A3', 'Marta', 'Sánchez Gil');

INSERT INTO cursos (codCurso, curso) VALUES ('C1', 'SQL');
INSERT INTO cursos (codCurso, curso) VALUES ('C2', 'JAVA');
INSERT INTO cursos (codCurso, curso) VALUES ('C3', 'PYTH');

-- Notas para Ana (A1) en SQL (C1) y JAVA (C2)
INSERT INTO notas (codAlumno, codCurso, notaParcial, notaPracticas, notaFinal) 
VALUES ('A1', 'C1', 8.50, 9.00, 8.75);

INSERT INTO notas (codAlumno, codCurso, notaParcial, notaPracticas, notaFinal) 
VALUES ('A1', 'C2', 7.00, 6.50, 6.75);

-- Notas para Luis (A2) en SQL (C1)
INSERT INTO notas (codAlumno, codCurso, notaParcial, notaPracticas, notaFinal) 
VALUES ('A2', 'C1', 5.50, 4.00, 4.75);



-- Punto 1
-- Con un for
declare
    v_codAlumno alumnos.codAlumno%type;
    cursor c_notasAlumno(v_codAlumno varchar2) is 
        select n.codAlumno, a.nombre, a.apellidos, c.curso, n.notaParcial, 
        n.notaPracticas, notaFinal
        from notas n
        join alumnos a
        on a.codAlumno = n.codAlumno
        join cursos c
        on c.codCurso = n.codCurso
        where n.codAlumno = v_codAlumno;
begin
   
    for v_Alumno in c_notasAlumno('&codAlumno') loop
        dbms_output.put_line(v_Alumno.codAlumno || ' ' || v_Alumno.curso ||' ' ||v_Alumno.notaFinal);
    end loop;
    
    dbms_output.put_line('El alumno buscado no existe');
end;
/

declare
    v_codAlumno alumnos.codAlumno%type;
    cursor c_notasAlumno(v_codAlumno varchar2) is 
        select n.codAlumno, a.nombre, a.apellidos, c.curso, n.notaParcial, 
        n.notaPracticas, notaFinal
        from notas n
        join alumnos a
        on a.codAlumno = n.codAlumno
        join cursos c
        on c.codCurso = n.codCurso
        where n.codAlumno = v_codAlumno;
        
    verRegistro c_notasAlumno%rowtype;
begin
    open c_notasAlumno('&codAlumno');
    
    loop
        fetch c_notasAlumno into verRegistro;
        exit when c_notasAlumno%notfound;
            if c_notasAlumno%found then
                dbms_output.put_line(verRegistro.codAlumno || ' ' || verRegistro.curso ||' ' ||verRegistro.notaFinal);
            end if;
    end loop;
end;
/
    














    