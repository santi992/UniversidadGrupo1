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
        setTitle("Carga de notas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ulp_icon.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(450, 410));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Carga de notas");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
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

        jbGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 169, Short.MAX_VALUE)
                                    .addComponent(jLabel1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbGuardar)
                                    .addGap(11, 11, 11)))
                            .addGap(83, 83, 83)
                            .addComponent(jbSalir))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addGap(0, 17, Short.MAX_VALUE))
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
        for (int i = modelo.getRowCount(); i > 0; i--) {
            modelo.removeRow(i-1);
        }
    }

    public void actualizarNotas() {
        int filas = modelo.getRowCount();
        Alumno alumno = (Alumno) jcbAlumno.getSelectedItem();
        List<Inscripcion> inscripciones = iData.obtenerInscripcionesPorAlumno(alumno.getIdAlumno());
        double nota;
        for (int i = 0; i < filas; i++) {
            
            int idMateria =(int) this.modelo.getValueAt(i, 0);
            
            try {
                nota = (double)this.modelo.getValueAt(i, 2) ;
            } catch (java.lang.ClassCastException ce) {
                nota = Double.parseDouble((String)this.modelo.getValueAt(i, 2)) ;
            }
            
            if(nota != inscripciones.get(i).getNota()){
                iData.actualizarNota(alumno.getIdAlumno(), idMateria, nota);
            }
            
        }
    }
}
