package frames;

import conexion.conexionOracle;
import entidad.registro_citas;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class citas extends javax.swing.JFrame {

    private Connection con;
    int id;
    private DefaultTableModel tabla;

    public citas() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        con = conexionOracle.conectar();
        registro_citas objeto = new registro_citas();
    }

    public void insertar(registro_citas objeto) throws SQLException {

        CallableStatement sql = con.prepareCall("{call CITAS_DB.INSERTAR_CITA(?,?,?,?,?)}");
        try {
            sql.setInt(1, objeto.getId_cita());
            sql.setString(2, objeto.getNombre_paciente());
            sql.setString(3, objeto.getMotivo_cita());
            sql.setString(4, objeto.getFecha_cita());
            sql.setString(5, objeto.getHora_cita());

            ResultSet rs = sql.executeQuery();
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "ERROR AL INSERTAR DATOS" + ex);
        }
    }

    public void actualizar(registro_citas objeto) throws SQLException {

        CallableStatement sql = con.prepareCall("{call CITAS_DB.MODIFICAR_CITA(?,?,?,?,?)}");
        try {
            sql.setInt(1, objeto.getId_cita());
            sql.setString(2, objeto.getNombre_paciente());
            sql.setString(3, objeto.getMotivo_cita());
            sql.setString(4, objeto.getFecha_cita());
            sql.setString(5, objeto.getHora_cita());
            

            ResultSet rs = sql.executeQuery();
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "ERROR AL ACTUALIZAR DATOS" + ex);
        }
    }

    public void eliminar(int id) throws SQLException {

        CallableStatement sql = con.prepareCall("{call CITAS_DB.ELIMINAR_CITA(?)}");
        sql.setInt(1, id);
        sql.execute();

        sql.close();

    }

    public void MostrarRegistro() {

        String sql = "SELECT * FROM CITAS";

        DefaultTableModel tabla = (DefaultTableModel) this.JTDETALLE_CITAS.getModel();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getString("id_cita");
                fila[1] = rs.getString("nombre_paciente");
                fila[2] = rs.getString("motivo_cita");
                fila[3] = rs.getString("fecha_cita");
                fila[4] = rs.getString("hora_cita");

                tabla.addRow(fila);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "ERROR AL MOSTRAR DATOS" + ex);
        }

    }

    public void limpiar_tabla() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTDETALLE_CITAS.getModel();
        modelo.setRowCount(0);

    }

    public void cargo_seleccionado() {
        int fila = this.JTDETALLE_CITAS.getSelectedRow();
        if (fila != -1) {
            this.JTFid_cita.setText(this.JTDETALLE_CITAS.getValueAt(fila, 0).toString().trim());
            this.JTFnombre_paciente.setText(this.JTDETALLE_CITAS.getValueAt(fila, 1).toString().trim());
            this.JTFmotivo_cita.setText(this.JTDETALLE_CITAS.getValueAt(fila, 2).toString().trim());
            this.JTFfecha_cita.setText(this.JTDETALLE_CITAS.getValueAt(fila, 3).toString().trim());
            this.JTFhora_cita.setText(this.JTDETALLE_CITAS.getValueAt(fila, 4).toString().trim());
        }
    }





    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTDETALLE_CITAS = new javax.swing.JTable();
        JTFid_cita = new javax.swing.JTextField();
        JTFnombre_paciente = new javax.swing.JTextField();
        JTFmotivo_cita = new javax.swing.JTextField();
        JTFfecha_cita = new javax.swing.JTextField();
        JTFhora_cita = new javax.swing.JTextField();
        JBELIMINAR = new javax.swing.JButton();
        JBGUARDAR = new javax.swing.JButton();
        JBMODIFICAR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTDETALLE_CITAS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE ", "MOTIVO", "FECHA", "HORA"
            }
        ));
        jScrollPane1.setViewportView(JTDETALLE_CITAS);

        JTFid_cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFid_citaActionPerformed(evt);
            }
        });

        JTFnombre_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFnombre_pacienteActionPerformed(evt);
            }
        });

        JTFmotivo_cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFmotivo_citaActionPerformed(evt);
            }
        });

        JTFfecha_cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFfecha_citaActionPerformed(evt);
            }
        });

        JTFhora_cita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFhora_citaActionPerformed(evt);
            }
        });

        JBELIMINAR.setText("Eliminar");
        JBELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBELIMINARActionPerformed(evt);
            }
        });

        JBGUARDAR.setText("Guardar");
        JBGUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGUARDARActionPerformed(evt);
            }
        });

        JBMODIFICAR.setText("Modificar");
        JBMODIFICAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBMODIFICARActionPerformed(evt);
            }
        });

        jLabel1.setText("Citas");

        jLabel2.setText("ID");

        jLabel3.setText("Nombre del paciente");

        jLabel4.setText("Motivo de cita");

        jLabel5.setText("Fecha de cita");

        jLabel6.setText("Hora de cita");

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Mostras Citas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBGUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBMODIFICAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTFmotivo_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(JTFfecha_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFnombre_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(JTFid_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(JTFhora_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFid_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFnombre_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFmotivo_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFfecha_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTFhora_cita, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBGUARDAR)
                    .addComponent(JBMODIFICAR)
                    .addComponent(JBELIMINAR))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGUARDARActionPerformed
          if (this.JTFid_cita.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR EL ID");
        }
        if (this.JTFnombre_paciente.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR EL NOMBRE");
        }
        if (this.JTFmotivo_cita.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR EL MOTIVO");
        }
        if (this.JTFfecha_cita.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR LA FECHA");
        }
        if (this.JTFhora_cita.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR LA HORA");

        } else {
            {

                int id_cita = Integer.parseInt(JTFid_cita.getText());
                String nombre_paciente = JTFnombre_paciente.getText();
                String motivo_cita = JTFmotivo_cita.getText();
                String fecha_cita = JTFfecha_cita.getText();
                String hora_cita = JTFhora_cita.getText();

                try {
                    entidad.registro_citas objetos = new registro_citas(id_cita, nombre_paciente, motivo_cita, fecha_cita, hora_cita);
                    insertar(objetos);

                    JOptionPane.showMessageDialog(rootPane, "DATOS GUARDADOS");
                    JTFid_cita.setText(null);
                    JTFnombre_paciente.setText(null);
                    JTFmotivo_cita.setText(null);
                    JTFfecha_cita.setText(null);
                    JTFhora_cita.setText(null);

                    limpiar_tabla();
                    MostrarRegistro();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "ERROR" + ex);
                }

            }
        }
    }//GEN-LAST:event_JBGUARDARActionPerformed

    private void JBMODIFICARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBMODIFICARActionPerformed
                try {

            Connection cn = conexionOracle.conectar();
            String sql = ("{call CITAS_DB.MODIFICAR_CITA(?,?,?,?,?)}");

            CallableStatement ps = cn.prepareCall(sql);
            ps.setInt(1, Integer.valueOf(JTFid_cita.getText()));
            ps.setString(2, JTFnombre_paciente.getText());
            ps.setString(3, JTFmotivo_cita.getText());
            ps.setString(4, JTFfecha_cita.getText());
            ps.setString(5, JTFmotivo_cita.getText());

            ps.execute();
            ps.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO");

            limpiar_tabla();
            MostrarRegistro();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL MODFICAR REGISTRO");
        }
    }//GEN-LAST:event_JBMODIFICARActionPerformed

    private void JBELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBELIMINARActionPerformed
           try {
            JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
            id = Integer.parseInt(String.valueOf(this.JTDETALLE_CITAS.getValueAt(this.JTDETALLE_CITAS.getSelectedRow(), 0)));
            eliminar(id);
            entidad.registro_citas en = new registro_citas();

            limpiar_tabla();
            MostrarRegistro();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "SELECCIONE EL REGISTRO QUE DESEA ELIMINAR");
        }
        
    }//GEN-LAST:event_JBELIMINARActionPerformed

    private void JTFid_citaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFid_citaActionPerformed
        // TODO add your handling code here:
        cargo_seleccionado();
    }//GEN-LAST:event_JTFid_citaActionPerformed

    private void JTFnombre_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFnombre_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFnombre_pacienteActionPerformed

    private void JTFmotivo_citaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFmotivo_citaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFmotivo_citaActionPerformed

    private void JTFfecha_citaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFfecha_citaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFfecha_citaActionPerformed

    private void JTFhora_citaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFhora_citaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFhora_citaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        inicio menu = new inicio();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MostrarRegistro();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new citas().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(citas.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBELIMINAR;
    private javax.swing.JButton JBGUARDAR;
    private javax.swing.JButton JBMODIFICAR;
    private javax.swing.JTable JTDETALLE_CITAS;
    private javax.swing.JTextField JTFfecha_cita;
    private javax.swing.JTextField JTFhora_cita;
    private javax.swing.JTextField JTFid_cita;
    private javax.swing.JTextField JTFmotivo_cita;
    private javax.swing.JTextField JTFnombre_paciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
