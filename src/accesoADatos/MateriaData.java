/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Materia;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author SANTIAGONB
 */
public class MateriaData {

    private Connection con = null;

    public MateriaData() {

        con = Conexion.conectar();
    }

    public void guardarMateria(Materia materia) {
        
        String sql = "INSERT INTO materia (nombre, anio, estado) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isActivo());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt("idMateria"));
                JOptionPane.showMessageDialog(null, "Materia añadida con exito.");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());

        }

    }

    public Materia buscarMateria(int id) {
        Materia materia = null;
        String sql1 = "SELECT nombre, anio FROM materia WHERE idMateria = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql1);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setActivo(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe la materia");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia " + ex.getMessage());

        }

        return materia;

    }


    public void modificarMateria(Materia materia) {

        String sql = "UPDATE materia SET nombre = ? , anio = ? WHERE idMateria = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setInt(3, materia.getIdMateria());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "La materia no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia " + ex.getMessage());
        }

    }

    public void eliminarMateria(int id) {

        try {
            String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó la materia.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Materia");
        }
    }
    
    public List<Materia> listarMaterias() {

        List<Materia> materias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM materia WHERE estado = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();

                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setActivo(rs.getBoolean("estado"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Materia " + ex.getMessage());
        }
        return materias;
    }

}
