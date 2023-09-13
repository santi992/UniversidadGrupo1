/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import accesoADatos.AlumnoData;
import accesoADatos.InscripcionData;
import entidades.Alumno;
import entidades.Inscripcion;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class CargaNotas extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            if (c==2){
                return true;
            }else{
                return false;
            }
        }

    };
private AlumnoData aData = new AlumnoData();
private InscripcionData iData = new InscripcionData();
    /**
     * Creates new form CargaNotas
     */

    public CargaNotas() {
        initComponents();
        armarCabecera();
        armarCombo();
        armarTabla();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaN = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 153, 255));
        setTitle("                                                  Carga de notas");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Carga de notas");

        jLabel2.setText("Seleccione un alumno: ");

        jcbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoActionPerformed(evt);
            }
        });

        jTablaN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title1", "Title2", "Title3"
            }
        ));
        jScrollPane1.setViewportView(jTablaN);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jbGuardar)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jbGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSalir)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed
       armarTabla();
    
    }//GEN-LAST:event_jcbAlumnoActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        actualizarNotas();
               
    }//GEN-LAST:event_jbGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaN;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");
        jTablaN.setModel(modelo);

    }
    private void armarCombo(){
        List alumnos = aData.listarAlumnos();
        for (Object alu: alumnos){
            Alumno alumno = (Alumno) alu;
            jcbAlumno.addItem(alumno);
        }
    }

    private void armarTabla() {
        limpiarTabla();
        Alumno alumno = (Alumno) jcbAlumno.getSelectedItem();
        List materia = iData.obtenerInscripcionesPorAlumno(alumno.getIdAlumno());
        for (Object mat : materia) {
            Inscripcion materias = (Inscripcion) mat;
            modelo.addRow(new Object[]{materias.getMateria().getIdMateria(), materias.getMateria().getNombre(), materias.getNota()});
        }
    }

    private void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(0);
        }
    }

    public void actualizarNotas() {
        int fila = modelo.getRowCount();

        for (int i = 0; i < fila; i++) {
            int nota = Integer.parseInt((String)this.modelo.getValueAt(i, 2)) ;
            int idMateria =(int) this.modelo.getValueAt(i, 0);
            iData.actualizarNota(((Alumno) jcbAlumno.getSelectedItem()).getIdAlumno(), idMateria, nota);
            
        }
    }
}