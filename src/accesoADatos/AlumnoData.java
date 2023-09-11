/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class AlumnoData {
    
    private Connection con = null;
    
    public AlumnoData(){
        con= Conexion.conectar();
    }
    public void guardarAlumno(Alumno alumno){
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
                JOptionPane.showMessageDialog(null, "Alumno añadido con éxito");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno "+ ex.getMessage());
            
        }
        
    }
        public Alumno buscarAlumno(int id){
            Alumno alumno=null;
            String sql= " SELECT dni, apellido, nombre, fechaNacimiento FROM alumno Where idAlumno=? AND estado=1";
            PreparedStatement ps= null;
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                alumno=new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getNString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);// es estado, me toma como activo xq el atributo en la clase alumno del paquete entidades se llama activo
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
                ps.close();
            }
        }
           catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Alumno "+ ex.getMessage());
            
           } return alumno;
            
        
        }
       public Alumno buscarAlumnoPorDniGuardar(int dni){
            Alumno alumno=null;
            String sql= " SELECT  idAlumno,dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni = ? ";
            PreparedStatement ps= null;
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getNString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);// es estado, me toma como activo xq el atributo en la clase alumno del paquete entidades se llama activo
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno, ni existio");
                ps.close();
            }
        }
           catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Alumno "+ ex.getMessage());
            
           } return alumno;
            
        
        }
       
       public Alumno buscarAlumnoPorDni(int dni){
            Alumno alumno=null;
            String sql= " SELECT  idAlumno,dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni = ? AND estado = 1"; //aca estaba el cambio dni
            PreparedStatement ps= null;
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getNString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);// es estado, me toma como activo xq el atributo en la clase alumno del paquete entidades se llama activo
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
                ps.close();
            }
        }
           catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Alumno "+ ex.getMessage());
            
           } return alumno;
            
        
        } 
       public List<Alumno> listarAlumnos(){
           List<Alumno> alumnos= new ArrayList<>();
          
               
        try {
            String sql= "SELECT * From alumno Where estado =1";
        
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Alumno alumno= new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(rs.getBoolean("estado"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex.getMessage());
        }
           return alumnos;
       }


public void modificarAlumno(Alumno alumno){
    String sql="UPDATE alumno SET dni=?, apellido=?,nombre=?,fechaNacimiento=? WHERE idAlumno=?";
    PreparedStatement ps=null;
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito= ps.executeUpdate();
            if (exito==1){
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }else{
                JOptionPane.showMessageDialog(null, "El alumno no existe.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex.getMessage());
        }
}
public void modificarEstado(Alumno alumno){
    String sql="UPDATE alumno SET estado = ? WHERE idAlumno = ?" ;
    PreparedStatement ps=null;
        try {
            ps= con.prepareStatement(sql);
            ps.setBoolean(1, alumno.isActivo());
            ps.setInt(2, alumno.getIdAlumno());
            int exito= ps.executeUpdate();
            if (exito==1){
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }else{
                JOptionPane.showMessageDialog(null, "El alumno no existe.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex.getMessage());
        }
}
public void eliminarAlumno(int id){
    
        String sql= "UPDATE alumno SET estado=0 WHERE idAlumno=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int fila=ps.executeUpdate();
            if (fila==1){
                JOptionPane.showMessageDialog(null, "Se eliminó el alumno.");
            }
        }
      catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno");
        }
}
}


      