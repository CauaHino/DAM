package opciones;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import alumno.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionBBDD;

public class Opciones {
    private Connection conexion;
    private String query;

    public Opciones(Connection conexion) {
        this.conexion = conexion;
    }

    public void crearTabla() {
        try (Statement sentencia = conexion.createStatement();) {
           query = "create table if not exists aula ( "
							+ "idalumno int primary key,"
							+ "nombre varchar(20),"
							+ "fechanacimiento date,"
							+ "notamedia decimal(4,2),"
							+ "curso varchar(10)"
							+ ");";	
            
            sentencia.executeUpdate(query);
            
            System.out.println();
            System.out.println("Se ha creado la tabla correctamente");
            System.out.println(); 
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla");
        }

    }

    public void insertarAlumnos(Alumno alumno) {
        if(alumno != null){
            query = "insert into aula (idalumno, nombre, fechanacimiento, notamedia, curso) values (?,?,?,?,?);";

            try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(query);){
                sentenciaPreparada.setInt(1, alumno.getIdAlumno());
                sentenciaPreparada.setString(2, alumno.getNombre());
                sentenciaPreparada.setDate(3, alumno.getFechaNacimiento());
                sentenciaPreparada.setDouble(4, alumno.getNotaMedia());
                sentenciaPreparada.setString(5, alumno.getCurso());
                sentenciaPreparada.executeUpdate();
                
                System.out.println("Alumno: " + alumno.getNombre() + ", ha sido agregado a la base de datos");
            } catch (SQLException e) {
                System.out.println("Error al insertar el alumno");
            }
        }
			
    }

    public void mostrarAlumnos() {
        ArrayList<Alumno> aulaBBDD = new ArrayList<Alumno>();
        query = "select * from aula;";
        
        try (Statement sentencia = conexion.createStatement();
             ResultSet resulSet = sentencia.executeQuery(query);) {
            
            while(resulSet.next()) {
                aulaBBDD.add(new Alumno(resulSet.getInt("idalumno"),
												resulSet.getString("nombre"), 
												resulSet.getDate("fechanacimiento"),
												resulSet.getDouble("notamedia"),
												resulSet.getString("curso")));
            }
            
            for(Alumno alumno : aulaBBDD) {
                System.out.println(alumno);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar los alumnos");
        }
    }

    public void mostrarAlumno(int idAlumno) {
        Alumno alumno = null;
        query = "select * from aula where idalumno = ?;";
        
        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(query)) {
            sentenciaPreparada.setInt(1, idAlumno);
            ResultSet resulSet = sentenciaPreparada.executeQuery();
            
            if(resulSet.next()) {
                alumno = new Alumno(resulSet.getInt("idalumno"),
                                            resulSet.getString("nombre"), 
                                            resulSet.getDate("fechanacimiento"),
                                            resulSet.getDouble("notamedia"),
                                            resulSet.getString("curso"));
            }else{
                System.out.println("No se ha encontrado el alumno con id: " + idAlumno);
            }
            
            System.out.println(alumno);

        } catch (SQLException e) {
            System.out.println("Error al mostrar el alumno");
        }
    }

    public void actualizarNotaMedia(int idAlumno, double nuevaNota, Scanner see) {
        query = "select * from aula where idalumno = ?;";
        
        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(query)) {
            sentenciaPreparada.setInt(1, idAlumno);
            ResultSet resulSet = sentenciaPreparada.executeQuery();
            
            Alumno alumno = null;
            if(resulSet.next()) {
                alumno = new Alumno(resulSet.getInt("idalumno"),
                                            resulSet.getString("nombre"), 
                                            resulSet.getDate("fechanacimiento"),
                                            resulSet.getDouble("notamedia"),
                                            resulSet.getString("curso"));
                
                System.out.println();
				System.out.println(alumno);
				
				System.out.print("Estas seguro que quieres cambiar la nota media de este alumno (S/N): ");
				String cambiar = see.nextLine();
				
				if(cambiar.equalsIgnoreCase("s")) {
					System.out.println();
					System.out.print("Indique la nota media nueva: ");
					Double notaMedia = see.nextDouble();
					see.nextLine();
					
					query = "update aula set notamedia = ? where idalumno = ?;";
                    try(PreparedStatement sentenciaPreparada2 = conexion.prepareStatement(query)) {
                        sentenciaPreparada2.setDouble(1, notaMedia);
                        sentenciaPreparada2.setInt(2, idAlumno);
                        
                        sentenciaPreparada2.executeUpdate();
                        System.out.println("Nota media cambiada!!!");
                        System.out.println();
                    } catch(SQLException e) {
                        System.out.println("Error al actualizar la nota media");
                    }	
				}                            
            }else{
                System.out.println("No se ha encontrado el alumno con id: " + idAlumno);
            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar el alumno");
        }
    }

    public void eliminarAlumno(int idAlumno) {
        query = "delete from aula where idalumno = ?;";
        
        try (PreparedStatement sentenciaPreparada = conexion.prepareStatement(query);){
            sentenciaPreparada.setInt(1, idAlumno);
            sentenciaPreparada.executeUpdate();

            System.out.println("Alumno con id: " + idAlumno + ", eliminado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al eliminar el alumno");
        }
    }

    public void eliminarDatos() {
        query = "delete from aula;";
        
        try (Statement sentencia = conexion.createStatement();) {
            sentencia.executeUpdate(query);
            
            System.out.println();
            System.out.println("Se ha eliminado los datos de la tabla correctamente");
            System.out.println(); 
        } catch (SQLException e) {
            System.out.println("Error al eliminar la tabla");
        }
    }

    public void sincronizarAlumnos(ArrayList<Alumno> aula) {
        ArrayList<Integer> idAlumnos = new ArrayList<Integer>();
        query = "select idalumno from aula;";
        
        try (Statement sentencia = conexion.createStatement();
             ResultSet resulSet = sentencia.executeQuery(query);) {
            
            while(resulSet.next()) {
                idAlumnos.add(resulSet.getInt("idalumno"));
            }
            
            for(int i = 0; i < aula.size(); i++) {
                for(int j = 0; j < idAlumnos.size(); j++) {
                    if(aula.size() < idAlumnos.size()) {
                        aula.clear();
                    } else if(aula.get(i).getIdAlumno() == idAlumnos.get(j)) {
                        aula.remove(aula.get(i));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al sincronizar los alumnos");
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
