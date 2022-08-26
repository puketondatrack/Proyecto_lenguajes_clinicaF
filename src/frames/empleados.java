package frames;

import conexion.conexionOracle;
import entidad.registro_empleados;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class empleados extends javax.swing.JFrame {

    private Connection con;
    int id;
    private DefaultTableModel tabla;

    public empleados() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        con = conexionOracle.conectar();
        registro_empleados objeto = new registro_empleados();
    }

    public void insertar(registro_empleados objeto) throws SQLException {

        CallableStatement sql = con.prepareCall("{call EMPLEADOS_DB.INSERTAR_EMPLEADO(?,?,?,?)}");
        try {
            sql.setInt(1, objeto.getId_empleado());
            sql.setString(2, objeto.getNombre_empleado());
            sql.setString(3, objeto.getPuesto_empleado());
            sql.setString(4, objeto.getFecha_ingreso());

            ResultSet rs = sql.executeQuery();
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "ERROR AL INSERTAR EMPLEADO" + ex);
        }
    }

    public void actualizar(registro_empleados objeto) throws SQLException {

        CallableStatement sql = con.prepareCall("{call EMPLEADOS_DB.MODIFICAR_EMPLEADO(?,?,?,?)}");
        try {
            sql.setInt(1, objeto.getId_empleado());
            sql.setString(2, objeto.getNombre_empleado());
            sql.setString(3, objeto.getPuesto_empleado());
            sql.setString(4, objeto.getFecha_ingreso());

            ResultSet rs = sql.executeQuery();
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "ERROR AL ACTUALIZAR EMPLEADO" + ex);
        }
    }

    public void eliminar(int id) throws SQLException {

        CallableStatement sql = con.prepareCall("{call EMPLEADOS_DB.ELIMINAR_EMPLEADO(?)}");
        sql.setInt(1, id);
        sql.execute();

        sql.close();

    }

    public void MostrarRegistro() {

        String sql = "SELECT * FROM EMPLEADOS";

        DefaultTableModel tabla = (DefaultTableModel) this.JTDETALLE_EMPLEADOS.getModel();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getString("id_empleado");
                fila[1] = rs.getString("nombre_empleado");
                fila[2] = rs.getString("puesto_empleado");
                fila[3] = rs.getString("fecha_ingreso");

                tabla.addRow(fila);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "ERROR AL MOSTRAR EMPLEADOS" + ex);
        }

    }

    public void limpiar_tabla() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTDETALLE_EMPLEADOS.getModel();
        modelo.setRowCount(0);

    }

    public void cargo_seleccionado() {
        int fila = this.JTDETALLE_EMPLEADOS.getSelectedRow();
        if (fila != -1) {
            this.JTFid_empleado.setText(this.JTDETALLE_EMPLEADOS.getValueAt(fila, 0).toString().trim());
            this.JTFnombre_empleado.setText(this.JTDETALLE_EMPLEADOS.getValueAt(fila, 1).toString().trim());
            this.JTFpuesto_empleado.setText(this.JTDETALLE_EMPLEADOS.getValueAt(fila, 2).toString().trim());
            this.JTFfecha_ingreso.setText(this.JTDETALLE_EMPLEADOS.getValueAt(fila, 3).toString().trim());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTDETALLE_EMPLEADOS = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JTFid_empleado = new javax.swing.JTextField();
        JTFnombre_empleado = new javax.swing.JTextField();
        JTFpuesto_empleado = new javax.swing.JTextField();
        JTFfecha_ingreso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JBGUARDAR = new javax.swing.JButton();
        JBMODIFICAR = new javax.swing.JButton();
        JBELIMINAR = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTDETALLE_EMPLEADOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "PUESTO", "FECHA INGRESO"
            }
        ));
        jScrollPane1.setViewportView(JTDETALLE_EMPLEADOS);

        jLabel1.setText("Empleados");

        JTFid_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFid_empleadoActionPerformed(evt);
            }
        });

        JTFnombre_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFnombre_empleadoActionPerformed(evt);
            }
        });

        JTFpuesto_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFpuesto_empleadoActionPerformed(evt);
            }
        });

        JTFfecha_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFfecha_ingresoActionPerformed(evt);
            }
        });

        jLabel2.setText("ID");

        jLabel3.setText("Nombre de empleado");

        jLabel4.setText("Puesto");

        jLabel5.setText("Fecha de ingreso");

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

        JBELIMINAR.setText("Eliminar");
        JBELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBELIMINARActionPerformed(evt);
            }
        });

        jButton4.setText("Atras");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Mostrar Empleados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JBGUARDAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBMODIFICAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBELIMINAR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(JTFid_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTFnombre_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTFpuesto_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTFfecha_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFid_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFnombre_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFpuesto_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFfecha_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBGUARDAR)
                    .addComponent(JBMODIFICAR)
                    .addComponent(JBELIMINAR))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBGUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGUARDARActionPerformed
        if (this.JTFid_empleado.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR EL ID");
        }
        if (this.JTFnombre_empleado.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR EL NOMBRE");
        }
        if (this.JTFpuesto_empleado.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR EL PUESTO");
        }
        if (this.JTFfecha_ingreso.getText().trim() == "") {
            JOptionPane.showMessageDialog(rootPane, "DEBE INGRESAR LA FECHA");

        } else {
            {

                int id_empleado = Integer.parseInt(JTFid_empleado.getText());
                String nombre_empleado = JTFnombre_empleado.getText();
                String puesto_empleado = JTFpuesto_empleado.getText();
                String fecha_ingreso = JTFfecha_ingreso.getText();

                try {
                    entidad.registro_empleados objetos = new registro_empleados(id_empleado, nombre_empleado, puesto_empleado, fecha_ingreso);
                    insertar(objetos);

                    JOptionPane.showMessageDialog(rootPane, "EMPLEADO REGISTRADO");
                    JTFid_empleado.setText(null);
                    JTFnombre_empleado.setText(null);
                    JTFpuesto_empleado.setText(null);
                    JTFfecha_ingreso.setText(null);

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
            String sql = ("{call EMPLEADOS_DB.MODIFICAR_EMPLEADO(?,?,?,?)}");

            CallableStatement ps = cn.prepareCall(sql);
            ps.setInt(1, Integer.valueOf(JTFid_empleado.getText()));
            ps.setString(2, JTFnombre_empleado.getText());
            ps.setString(3, JTFpuesto_empleado.getText());
            ps.setString(4, JTFfecha_ingreso.getText());

            ps.execute();
            ps.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "EMPLEADO MODIFICADO");

            limpiar_tabla();
            MostrarRegistro();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL MODFICAR EMPLEADO");
        }
    }//GEN-LAST:event_JBMODIFICARActionPerformed

    private void JBELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBELIMINARActionPerformed
        try {
            JOptionPane.showMessageDialog(null, "EMPLEADO ELIMINADO");
            id = Integer.parseInt(String.valueOf(this.JTDETALLE_EMPLEADOS.getValueAt(this.JTDETALLE_EMPLEADOS.getSelectedRow(), 0)));
            eliminar(id);
            entidad.registro_empleados en = new registro_empleados();

            limpiar_tabla();
            MostrarRegistro();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "SELECCIONE EL EMPLEADO QUE DESEA ELIMINAR");
        }
    }//GEN-LAST:event_JBELIMINARActionPerformed

    private void JTFid_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFid_empleadoActionPerformed
        cargo_seleccionado();
    }//GEN-LAST:event_JTFid_empleadoActionPerformed

    private void JTFnombre_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFnombre_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFnombre_empleadoActionPerformed

    private void JTFpuesto_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFpuesto_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFpuesto_empleadoActionPerformed

    private void JTFfecha_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFfecha_ingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFfecha_ingresoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        inicio menu = new inicio();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MostrarRegistro();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new empleados().setVisible(true);
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
    private javax.swing.JTable JTDETALLE_EMPLEADOS;
    private javax.swing.JTextField JTFfecha_ingreso;
    private javax.swing.JTextField JTFid_empleado;
    private javax.swing.JTextField JTFnombre_empleado;
    private javax.swing.JTextField JTFpuesto_empleado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
