package frames;

import conexion.conexionOracle;
import entidad.registro_recetas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class recetas extends javax.swing.JFrame {

    private Connection con;
    int id;
    private DefaultTableModel tabla;

    public recetas() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        con = conexionOracle.conectar();
        registro_recetas objeto = new registro_recetas();
        
    }

    public void insertar(registro_recetas objeto) throws SQLException {

        CallableStatement sql = con.prepareCall("{call RECETAS_DB.INSERTAR_RECETA(?,?,?,?)}");
        try {
            sql.setInt(1, objeto.getId_receta());
            sql.setString(2, objeto.getCodigo_receta());
            sql.setString(3, objeto.getNombre_paciente_e());
            sql.setString(4, objeto.getFechade_entrega());

            ResultSet rs = sql.executeQuery();
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "ERROR AL INSERTAR RECETA" + ex);
        }
    }

    public void eliminar(int id) throws SQLException {

        CallableStatement sql = con.prepareCall("{call RECETAS_DB.ELIMINAR_RECETA(?)}");
        sql.setInt(1, id);
        sql.execute();

        sql.close();

    }

    public void MostrarRegistro() {

        String sql = "SELECT * FROM RECETAS";

        DefaultTableModel tabla = (DefaultTableModel) this.JTDETALLE_RECETAS.getModel();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getString("id_receta");
                fila[1] = rs.getString("codigo_receta");
                fila[2] = rs.getString("nombre_paciente_e");
                fila[3] = rs.getString("fechade_entrega");

                tabla.addRow(fila);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "ERROR AL MOSTRAR REGISTRO" + ex);
        }

    }

    public void limpiar_tabla() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTDETALLE_RECETAS.getModel();
        modelo.setRowCount(0);

    }

    public void cargo_seleccionado() {
        int fila = this.JTDETALLE_RECETAS.getSelectedRow();
        if (fila != -1) {
            this.JTFid_receta.setText(this.JTDETALLE_RECETAS.getValueAt(fila, 0).toString().trim());
            this.JTFcodigo_receta.setText(this.JTDETALLE_RECETAS.getValueAt(fila, 1).toString().trim());
            this.JTFnombre_paciente_e.setText(this.JTDETALLE_RECETAS.getValueAt(fila, 2).toString().trim());
            this.JTFfechade_entrega.setText(this.JTDETALLE_RECETAS.getValueAt(fila, 3).toString().trim());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTDETALLE_RECETAS = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        JBIMPRIMIR = new javax.swing.JButton();
        JBGUARDAR = new javax.swing.JButton();
        JBELIMINAR = new javax.swing.JButton();
        JTFcodigo_receta = new javax.swing.JTextField();
        JTFid_receta = new javax.swing.JTextField();
        JTFnombre_paciente_e = new javax.swing.JTextField();
        JTFfechade_entrega = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTDETALLE_RECETAS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "CODIGO RECETA", "NOMBRE PACIENTE", "ENTREGADO EL:"
            }
        ));
        jScrollPane1.setViewportView(JTDETALLE_RECETAS);

        jLabel1.setText("Recetas");

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JBIMPRIMIR.setText("Mostrar Registros");
        JBIMPRIMIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBIMPRIMIRActionPerformed(evt);
            }
        });

        JBGUARDAR.setText("Guardar");
        JBGUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGUARDARActionPerformed(evt);
            }
        });

        JBELIMINAR.setText("Eliminar");
        JBELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBELIMINARActionPerformed(evt);
            }
        });

        JTFcodigo_receta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFcodigo_recetaActionPerformed(evt);
            }
        });

        JTFid_receta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFid_recetaActionPerformed(evt);
            }
        });

        JTFnombre_paciente_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFnombre_paciente_eActionPerformed(evt);
            }
        });

        JTFfechade_entrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFfechade_entregaActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        jLabel3.setText("Codigo de receta");

        jLabel4.setText("Entregado al paciente");

        jLabel5.setText("Fecha de entrega");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(JBIMPRIMIR, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTFfechade_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFnombre_paciente_e, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFid_receta, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFcodigo_receta, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBGUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JBIMPRIMIR)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JTFid_receta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFcodigo_receta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFnombre_paciente_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFfechade_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBGUARDAR)
                    .addComponent(JBELIMINAR))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        inicio menu = new inicio();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JTFfechade_entregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFfechade_entregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFfechade_entregaActionPerformed

    private void JBGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGUARDARActionPerformed
        if (this.JTFid_receta.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR EL ID");
        }
        if (this.JTFcodigo_receta.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR EL NOMBRE");
        }
        if (this.JTFnombre_paciente_e.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR EL PUESTO");
        }
        if (this.JTFfechade_entrega.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR LA FECHA");

        } else {
            {

                int id_receta = Integer.parseInt(JTFid_receta.getText());
                String codigo_receta = JTFcodigo_receta.getText();
                String nombre_paciente_e = JTFnombre_paciente_e.getText();
                String fechade_entrega = JTFfechade_entrega.getText();

                try {
                    entidad.registro_recetas objetos = new registro_recetas(id_receta, codigo_receta, nombre_paciente_e, fechade_entrega);
                    insertar(objetos);

                    JOptionPane.showMessageDialog(rootPane, "RECETA REGISTRADA");
                    JTFid_receta.setText(null);
                    JTFcodigo_receta.setText(null);
                    JTFnombre_paciente_e.setText(null);
                    JTFfechade_entrega.setText(null);

                    limpiar_tabla();
                    MostrarRegistro();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "ERROR" + ex);
                }

            }
        }
    }//GEN-LAST:event_JBGUARDARActionPerformed

    private void JBELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBELIMINARActionPerformed
        try {
            JOptionPane.showMessageDialog(null, "RECETA ELIMINADA");
            id = Integer.parseInt(String.valueOf(this.JTDETALLE_RECETAS.getValueAt(this.JTDETALLE_RECETAS.getSelectedRow(), 0)));
            eliminar(id);
            entidad.registro_recetas en = new registro_recetas();

            limpiar_tabla();
            MostrarRegistro();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "SELECCIONE LA RECETA QUE DESEA ELIMINAR");
        }
    }//GEN-LAST:event_JBELIMINARActionPerformed

    private void JTFid_recetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFid_recetaActionPerformed
        cargo_seleccionado();
    }//GEN-LAST:event_JTFid_recetaActionPerformed

    private void JTFcodigo_recetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFcodigo_recetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFcodigo_recetaActionPerformed

    private void JTFnombre_paciente_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFnombre_paciente_eActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFnombre_paciente_eActionPerformed

    private void JBIMPRIMIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBIMPRIMIRActionPerformed
        MostrarRegistro();

    }//GEN-LAST:event_JBIMPRIMIRActionPerformed

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
            java.util.logging.Logger.getLogger(recetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(recetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(recetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(recetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new recetas().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBELIMINAR;
    private javax.swing.JButton JBGUARDAR;
    private javax.swing.JButton JBIMPRIMIR;
    private javax.swing.JTable JTDETALLE_RECETAS;
    private javax.swing.JTextField JTFcodigo_receta;
    private javax.swing.JTextField JTFfechade_entrega;
    private javax.swing.JTextField JTFid_receta;
    private javax.swing.JTextField JTFnombre_paciente_e;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
