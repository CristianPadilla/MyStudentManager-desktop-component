package Vista;

import Modelo.Usuario;
import javax.swing.JTable;
import javax.swing.UIManager;

public class VistaUsuario extends javax.swing.JInternalFrame {

    public VistaUsuario() {
       
        initComponents();
//        Usuario u = new Usuario();
//        u.ListarUsuarios();       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        FilaEditar = new javax.swing.JMenuItem();
        FilaCambiarEstado = new javax.swing.JMenuItem();
        principal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        txtidUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        secundaria = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInactivos = new javax.swing.JTable();
        btnActivar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtBuscar2 = new javax.swing.JTextField();

        FilaEditar.setText("Editar");
        FilaEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilaEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(FilaEditar);

        FilaCambiarEstado.setText("Desactivar");
        jPopupMenu1.add(FilaCambiarEstado);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestión Usuarios");

        principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre y Apellidos");
        principal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        txtNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        principal.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 280, 30));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Correo Electronico");
        principal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        txtCorreo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        principal.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 270, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Usuario");
        principal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        txtUsuario.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        principal.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 180, 30));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Documento Identidad");
        principal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        txtDocumento.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        principal.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 190, 30));

        btnCrear.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnCrear.setText("Registrar");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        principal.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, 40));

        Titulo.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(51, 51, 51));
        Titulo.setText("name");
        principal.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        btnModificar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        principal.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 120, 40));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUsuarios.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblUsuarios);

        principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 416, 530, 170));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });
        principal.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 120, -1));

        btnLimpiar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnLimpiar.setText("Cancelar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        principal.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 110, 30));

        txtidUsuario.setBorder(null);
        principal.add(txtidUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 113, -1, -1));

        jLabel1.setText("Buscar");
        principal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        secundaria.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuarios Inactivos"));
        secundaria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInactivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblInactivos);

        secundaria.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 390, 340));

        btnActivar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnActivar.setText("Activar");
        secundaria.add(btnActivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 120, 40));

        jLabel6.setText("Buscar");
        secundaria.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        txtBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar2ActionPerformed(evt);
            }
        });
        txtBuscar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscar2KeyPressed(evt);
            }
        });
        secundaria.add(txtBuscar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(principal, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secundaria, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(principal, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(secundaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void FilaEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilaEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FilaEditarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar2ActionPerformed

    private void txtBuscar2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar2KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem FilaCambiarEstado;
    public javax.swing.JMenuItem FilaEditar;
    public javax.swing.JLabel Titulo;
    public javax.swing.JButton btnActivar;
    public javax.swing.JButton btnCrear;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel principal;
    private javax.swing.JPanel secundaria;
    public javax.swing.JTable tblInactivos;
    public javax.swing.JTable tblUsuarios;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtBuscar2;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtDocumento;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtUsuario;
    public javax.swing.JTextField txtidUsuario;
    // End of variables declaration//GEN-END:variables
}
