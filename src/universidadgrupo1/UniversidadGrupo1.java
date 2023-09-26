/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo1;

import accesoADatos.Conexion;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
import vistas.VistaPrincipal;

/**
 *
 * @author SANTIAGONB
 */
public class UniversidadGrupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        limpiarDatos();
        crearDatos();
        VistaPrincipal principal = new VistaPrincipal();
        principal.setVisible(true);
    }
    
    public static void limpiarDatos(){
        
        System.out.println("Reiniciando base de datos...");
        Connection con = Conexion.conectar();
        PreparedStatement ps;
        try {
            String insc = "DROP TABLE IF EXISTS inscripcion";
            ps = con.prepareStatement(insc);
            ps.executeUpdate();
            
            String mat = "DROP TABLE IF EXISTS materia";
            ps = con.prepareStatement(mat);
            ps.executeUpdate();
            
            String alu = "DROP TABLE IF EXISTS alumno";
            ps = con.prepareStatement(alu);
            ps.executeUpdate();
            
            String crinsc = "CREATE TABLE IF NOT EXISTS universidad_grupo1.inscripcion (idInscripto INT(11) NOT NULL AUTO_INCREMENT , nota INT(11) NOT NULL , idAlumno INT(11) NOT NULL , idMateria INT(11) NOT NULL , PRIMARY KEY (idInscripto)) ENGINE = InnoDB";
            ps = con.prepareStatement(crinsc);
            ps.executeUpdate();
            
            String cralu = "CREATE TABLE IF NOT EXISTS universidad_grupo1.alumno (idAlumno INT(11) NOT NULL AUTO_INCREMENT , dni INT(11) NOT NULL , apellido VARCHAR(100) NOT NULL , nombre VARCHAR(100) NOT NULL , fechaNacimiento DATE NOT NULL , estado TINYINT(1) NOT NULL , PRIMARY KEY (idAlumno), UNIQUE dni (dni)) ENGINE = InnoDB";
            ps = con.prepareStatement(cralu);
            ps.executeUpdate();
            
            String crmat = "CREATE TABLE IF NOT EXISTS universidad_grupo1.materia (idMateria INT(11) NOT NULL AUTO_INCREMENT , nombre VARCHAR(100) NOT NULL , anio INT(11) NOT NULL , estado TINYINT(1) NOT NULL , PRIMARY KEY (idMateria), UNIQUE nombre (nombre)) ENGINE = InnoDB";
            ps = con.prepareStatement(crmat);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener datos");
        }
        
        System.out.println("Reinicio completado con éxito");
        
    }
    
    public static void crearDatos(){
        
        System.out.println("Cargando base de datos");
        
        Connection con = Conexion.conectar();
        
        Alumno messi = new Alumno(11111111, "Messi", "Lionel", LocalDate.of(1987, Month.JUNE, 24), true);
        Alumno sanM = new Alumno(22222222, "de San Martin", "Jose Francisco", LocalDate.of(1778, Month.FEBRUARY, 25), true);
        Alumno lali = new Alumno(33333333, "Esposito", "Lali", LocalDate.of(1991, Month.OCTOBER, 10), true);
        Alumno goku = new Alumno(44444444, "Son", "Goku", LocalDate.of(1986, Month.MAY, 9), true);
        Alumno miley = new Alumno(55555555, "Cyrus", "Miley", LocalDate.of(1992, Month.NOVEMBER, 23), true);
        Alumno chino = new Alumno(66666666, "Maidana", "Marcos", LocalDate.of(1983, Month.JULY, 17), true);
        Alumno serena = new Alumno(77777777, "Williams", "Serena", LocalDate.of(1981, Month.SEPTEMBER, 26), true);
        
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(messi);
        alumnos.add(sanM);
        alumnos.add(lali);
        alumnos.add(goku);
        alumnos.add(miley);
        alumnos.add(chino);
        alumnos.add(serena);
        
        for (Alumno alumno: alumnos) {
            String sql= "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado)"+
                "VALUES(?,?,?,?,?)";
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, alumno.getDni());
                ps.setString(2, alumno.getApellido());
                ps.setString(3, alumno.getNombre());
                ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
                ps.setBoolean(5, alumno.isActivo());//idem atributo "estado" se llama activo

                ps.executeUpdate();
                ResultSet rs= ps.getGeneratedKeys();
                if(rs.next()){

                    alumno.setIdAlumno(rs.getInt(1));
                }

                ps.close();


            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno "+ ex.getMessage());

            }
        }

        System.out.println("Alumnos agregados con éxito");
        
        
        
        Materia mat1 = new Materia("Matemática 1", 1, true);
        Materia ef1 = new Materia("Educación Física 1", 1, true);
        Materia mat2 = new Materia("Matemática 2", 2, true);
        Materia mus1 = new Materia("Música 1", 2, true);
        Materia mus2 = new Materia("Música 2", 3, true);
        Materia ef2 = new Materia("Educación Física 2", 3, true);
        
        ArrayList<Materia> materias = new ArrayList<>();
        
        materias.add(mat1);
        materias.add(ef1);
        materias.add(mat2);
        materias.add(mus1);
        materias.add(mus2);
        materias.add(ef2);
        
        for (Materia materia: materias) {
            String sql = "INSERT INTO materia (nombre, anio, estado) VALUES (?, ?, ?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, materia.getNombre());
                ps.setInt(2, materia.getAnio());
                ps.setBoolean(3, materia.isActivo());

                ps.executeUpdate();
                
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    materia.setIdMateria(rs.getInt(1));

                }

                ps.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());

            }

        }
        
        System.out.println("Materias agregadas con éxito");
        
        Inscripcion ins1 = new Inscripcion(10, messi, ef2);
        Inscripcion ins2 = new Inscripcion(10, messi, mat1);
        Inscripcion ins3 = new Inscripcion(10, sanM, mat2);
        Inscripcion ins4 = new Inscripcion(9, sanM, mus1);
        Inscripcion ins5 = new Inscripcion(10, lali, mus2);
        Inscripcion ins6 = new Inscripcion(7, lali, ef1);
        Inscripcion ins7 = new Inscripcion(10, goku, ef2);
        Inscripcion ins8 = new Inscripcion(1, goku, mat1);
        Inscripcion ins9 = new Inscripcion(8, chino, ef2);
        Inscripcion ins10 = new Inscripcion(7, chino, mus1);
        Inscripcion ins11 = new Inscripcion(10, miley, mus2);
        Inscripcion ins12 = new Inscripcion(6, miley, mat2);
        Inscripcion ins13 = new Inscripcion(10, serena, ef1);
        Inscripcion ins14 = new Inscripcion(8, serena, mat1);
        
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        
        inscripciones.add(ins1);
        inscripciones.add(ins2);
        inscripciones.add(ins3);
        inscripciones.add(ins4);
        inscripciones.add(ins5);
        inscripciones.add(ins6);
        inscripciones.add(ins7);
        inscripciones.add(ins8);
        inscripciones.add(ins9);
        inscripciones.add(ins10);
        inscripciones.add(ins11);
        inscripciones.add(ins12);
        inscripciones.add(ins13);
        inscripciones.add(ins14);
        
        for (Inscripcion inscripcion: inscripciones) {
            String sql = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES (?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);

                ps.setDouble(1, inscripcion.getNota());
                ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
                ps.setInt(3, inscripcion.getMateria().getIdMateria());
                ps.executeUpdate();

                ps.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al guardar");
            }
        }
        
        System.out.println("Inscripciones agregadas con éxito");
        
        System.out.println("Base de datos cargada con éxito");
        
    }
    
}
