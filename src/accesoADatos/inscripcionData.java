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
    
    public void guardarInscripcion(Inscripcion inc) {
        String sql = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES (?,?,?)";
        boolean disponible = true;
        for (Inscripcion insc: obtenerInscripciones()) {
            if (inc.getAlumno().getIdAlumno() == insc.getAlumno().getIdAlumno() && inc.getMateria().getIdMateria() == insc.getMateria().getIdMateria()) {
                disponible = false;
                break;
            }
        }
        
        if (disponible) {
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setDouble(1, inc.getNota());
                ps.setInt(2, inc.getAlumno().getIdAlumno());
                ps.setInt(3, inc.getMateria().getIdMateria());
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    inc.setIdInscripto(rs.getInt(1));
                    JOptionPane.showMessageDialog(null,"Inscripción guardada con éxito");
                }

                ps.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al guardar");
            }

        } else {
            JOptionPane.showMessageDialog(null,"El alumno ya se encuentra inscripto en la materia");
        }
        
    }
    
    public List<Inscripcion> obtenerInscripciones() {
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        
        String sql = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
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
    
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = "+idAlumno;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
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
    
    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList<>();
        
        String sql = "SELECT inscripcion.idMateria, nombre, anio, estado FROM inscripcion JOIN materia ON inscripcion.idMateria = materia.idMateria WHERE idAlumno = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            
            ResultSet rs = ps.executeQuery();
            Materia mat;
            while (rs.next()) {
                mat = new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anio"));
                mat.setActivo(rs.getBoolean("estado"));
                materias.add(mat);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener datos");
        }
        
        return materias;
    }  
    
    public List<Materia> obtenerMateriasNoCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList<>();
        List<Materia> materiasSi = obtenerMateriasCursadas(idAlumno);
        String sqlIds = "";
        for (int i = 0; i < materiasSi.size(); i++) {
            if (i != 0) {
                sqlIds += " AND NOT";
            }
            sqlIds += " idMateria = "+materiasSi.get(i).getIdMateria();
            
        }
        
        String sql = "SELECT idMateria, nombre, anio, estado FROM materia WHERE NOT "+sqlIds;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            
            ResultSet rs = ps.executeQuery();
            Materia mat;
            while (rs.next()) {
                mat = new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anio"));
                mat.setActivo(rs.getBoolean("estado"));
                materias.add(mat);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener datos");
        }
        
        return materias;
    }  
    
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Inscripción borrada con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al borrar (La inscripción no existe)");
            }

            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener datos");
        }
        
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Nota cambiada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al cambiar.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener datos " + ex.getMessage());
        }

    }
    
    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        
        String sql = "SELECT alumno.idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM inscripcion JOIN alumno ON alumno.idAlumno = inscripcion.idAlumno WHERE idMateria = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            
            ResultSet rs = ps.executeQuery();
            Alumno alu;
            while (rs.next()) {
                alu = new Alumno();
                alu.setIdAlumno(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setActivo(rs.getBoolean("estado"));
                alumnos.add(alu);
            } 
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener datos");
        }
        
        return alumnos;
    }
    
}


