/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacion;

/**
 *
 * @author Emily, 02/09/21
 */

import capaNegocio.*;
import java.sql.*;
import javax.swing.JOptionPane;
public class jdInicioSesion extends javax.swing.JDialog {
 clsUsuario objUsuario = new clsUsuario();
 public String strUsuario;
   
    public jdInicioSesion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        chkPregunta = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRespuesta = new javax.swing.JTextField();
        txtPregunta = new javax.swing.JTextField();
        btnValidar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnIniciarSesion = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".:INICIO DE SESIÓN");

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 148, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 145, 166, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 188, -1, -1));

        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 186, 166, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/login128.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 130, 130));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/password32.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 40, 30));

        chkPregunta.setBackground(new java.awt.Color(255, 255, 204));
        chkPregunta.setText("Pregunta secreta");
        chkPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPreguntaActionPerformed(evt);
            }
        });
        jPanel1.add(chkPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        jLabel5.setText("Pregunta:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabel6.setText("Respuesta:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        txtRespuesta.setEnabled(false);
        jPanel1.add(txtRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 150, -1));

        txtPregunta.setEnabled(false);
        txtPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPreguntaActionPerformed(evt);
            }
        });
        jPanel1.add(txtPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 150, -1));

        btnValidar.setText("Validar");
        btnValidar.setEnabled(false);
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });
        jPanel1.add(btnValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnIniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnIniciarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iniciar-sesion24.png"))); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesión");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/error24.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIniciarSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
     
        try {
            if(!txtUsuario.getText().equals("")&&! txtContraseña.getText().equals("")){
                if (objUsuario.validarVigencia(txtUsuario.getText())) {
               strUsuario= objUsuario.inicioSesion(txtUsuario.getText(), txtContraseña.getText());
            if(strUsuario.isEmpty()){
                JOptionPane.showMessageDialog(this,"Datos incorrectos, intente nuevamente");
            
              
            } else{
                JOptionPane.showMessageDialog(this,"Bienvenido "+strUsuario+" al Sistema");
                this.dispose();
            } 
            }else{
                JOptionPane.showMessageDialog(this,"El usuario no está activo");
            } 
            }else{
                JOptionPane.showMessageDialog(this, "Ingresa datos de acceso al sistema");
            }
           
            
        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void txtPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPreguntaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPreguntaActionPerformed

    private void chkPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPreguntaActionPerformed
        // TODO add your handling code here:
        if(chkPregunta.isSelected()){
           if (txtUsuario.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Primero debe ingresar el nombre de usuario.");  
        }else{
            try {
                 txtPregunta.setText(objUsuario.preguntaSecreta(txtUsuario.getText()));
                 txtRespuesta.setEnabled(true);
                 btnValidar.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,e.getMessage());  
            }
           
        }  
        }else{ 
            txtPregunta.setText("");
            txtRespuesta.setText("");
            txtRespuesta.setEnabled(false);
            btnValidar.setEnabled(false);
        }
       
    }//GEN-LAST:event_chkPreguntaActionPerformed

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
         // TODO add your handling code here:
        jdModificarContrasena objModificar=new jdModificarContrasena(null, true);
        try {
            if(txtRespuesta.getText().equals("")){
             JOptionPane.showMessageDialog(this,"Ingrese una respuesta a la pregunta secreta.");      
            }else{
            if (objUsuario.validarPregunta(txtUsuario.getText(), txtRespuesta.getText())){
                  JOptionPane.showMessageDialog(this,"Validacion correcta, por favor camviar contraseña."); 
                  //objModificar.setUsuario(txtUsuario.getText());
                  objModificar.usuario=txtUsuario.getText();
                  objModificar.setVisible(true);
                  //despu[es de cerrar el formulario de modificacion
                  //System.exit(0); //equivalente al end
                  strUsuario=objUsuario.usuInicioSesion(txtUsuario.getText());
                  this.dispose(); //equivalente al close
            }else{
                  JOptionPane.showMessageDialog(this,"Respuesta incorrecta, intente nuevamente."); 
            }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnValidarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(jdInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdInicioSesion dialog = new jdInicioSesion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnValidar;
    private javax.swing.JCheckBox chkPregunta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtPregunta;
    private javax.swing.JTextField txtRespuesta;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
