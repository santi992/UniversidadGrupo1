/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SANTIAGONB
 */
public class inscripcionData {
    
    private Connection con;
    private MateriaData materiaData;
    private AlumnoData alumnoData;

    public inscripcionData() {
        con = Conexion.conectar();
        materiaData = new MateriaData();
        alumnoData = new AlumnoData();
    }
    
    private void guardarInscripcion(Inscripcion inc) {
        String sql = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inc.getNota());
            ps.setInt(2, inc.getAlumno().getIdAlumno());
            ps.setInt(3, inc.getMateria().getIdMateria());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inc.setIdInscripto(rs.getInt("id.Inscripto"));
                JOptionPane.showMessageDialog(null,"Inscripción guardada con éxito");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar");
        }
        
    }
    
    private List<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        
        String sql = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = ps.executeQuery();
            Inscripcion inc;
            while (rs.next()) {
                inc = new Inscripcion();
                inc.setIdInscripto(rs.getInt("idInscripto"));
                inc.setAlumno(alumnoData.buscarAlumno(rs.getInt("idAlumno")));
                inc.setMateria(materiaData.buscarMateria(rs.getInt("idMateria")));
                //inc.setNota(rs.getDouble("nota")); ------------------ TIPO DE DATO EN NOTA
                inc.setNota(rs.getInt("nota"));
                inscripciones.add(inc);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener datos");
        }
        
        
        return inscripciones;
    }
    
    private List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        
        return inscripciones;
    }
    
    private List<Materia> obtenerMateriasCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList<>();
        
        return materias;
    }  
    
    
    private List<Materia> obtenerMateriasNoCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList<>();
        
        return materias;
    }  
    
    private void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        
    }
    
    private void actualizarNota(int idAlumno, int idMateria, double nota) {
        
    }
    
    private List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        
        return alumnos;
    }
    
}


