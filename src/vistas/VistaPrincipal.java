/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.JInternalFrame;

/**
 *
 * @author SANTIAGONB
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form vistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jAlumno = new javax.swing.JMenu();
        jFormulA = new javax.swing.JMenuItem();
        jMateria = new javax.swing.JMenu();
        jFormulM = new javax.swing.JMenuItem();
        jAdmin = new javax.swing.JMenu();
        jMInscripciones = new javax.swing.JMenuItem();
        jMNotas = new javax.swing.JMenuItem();
        jConsultas = new javax.swing.JMenu();
        jAlumxMat = new javax.swing.JMenuItem();
        jSalir = new javax.swing.JMenu();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        jDesktopPane1.setBackground(new java.awt.Color(138, 181, 224));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );

        jAlumno.setText("Alumno");

        jFormulA.setText("Formulario de Alumno");
        jFormulA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormulAActionPerformed(evt);
            }
        });
        jAlumno.add(jFormulA);

        jMenuBar1.add(jAlumno);

        jMateria.setText("Materia");

        jFormulM.setText("Formulario de Materia");
        jMateria.add(jFormulM);

        jMenuBar1.add(jMateria);

        jAdmin.setText("Administracion");

        jMInscripciones.setText("Manejo de Inscripciones");
        jAdmin.add(jMInscripciones);

        jMNotas.setText("Manipulacion de Notas");
        jMNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNotasActionPerformed(evt);
            }
        });
        jAdmin.add(jMNotas);

        jMenuBar1.add(jAdmin);

        jConsultas.setText("Consultas");

        jAlumxMat.setText("Alumnos por Materia");
        jAlumxMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlumxMatActionPerformed(evt);
            }
        });
        jConsultas.add(jAlumxMat);

        jMenuBar1.add(jConsultas);

        jSalir.setText("Salir");
        jMenuBar1.add(jSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAlumxMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlumxMatActionPerformed
        AlumnosXMateria alXM = new AlumnosXMateria();
        mostrarVista(alXM);
    }//GEN-LAST:event_jAlumxMatActionPerformed

    private void jFormulAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormulAActionPerformed
        FormularioAlumno formA = new FormularioAlumno();
        mostrarVista(formA);
    }//GEN-LAST:event_jFormulAActionPerformed

    private void jMNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMNotasActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        CargaNotas formN = new CargaNotas();
        formN.setVisible(true);
        jDesktopPane1.add(formN);
        jDesktopPane1.moveToFront(formN); 
        
    }//GEN-LAST:event_jMNotasActionPerformed
                                         
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jAdmin;
    private javax.swing.JMenu jAlumno;
    private javax.swing.JMenuItem jAlumxMat;
    private javax.swing.JMenu jConsultas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuItem jFormulA;
    private javax.swing.JMenuItem jFormulM;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JMenuItem jMInscripciones;
    private javax.swing.JMenuItem jMNotas;
    private javax.swing.JMenu jMateria;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu jSalir;
    // End of variables declaration//GEN-END:variables

    // Funcion que muestra una vista en en escritorio interno
    private void mostrarVista(JInternalFrame vista){
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        vista.setVisible(true);
        jDesktopPane1.add(vista);
        jDesktopPane1.moveToFront(vista);
    }

    
}
