package Vista;

import Modelo.Programa;
import Modelo.Usuario;

public class VistaCursos extends javax.swing.JInternalFrame {

    public VistaCursos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        FilaEditar = new javax.swing.JMenuItem();
        FilaCambiarEstado = new javax.swing.JMenuItem();
        Principal = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        txtGrupo = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        cbxDocentes = new javax.swing.JComboBox<>();
        txtAsignatura = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        cbxPrograma = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        txtIdCurso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        FilaEditar.setText("Editar");
        jPopupMenu1.add(FilaEditar);

        FilaCambiarEstado.setText("Cambiar estado");
        jPopupMenu1.add(FilaCambiarEstado);

        setClosable(true);
        setMaximizable(true);
        setTitle("Gestión Cursos");

        Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(51, 51, 51));
        Titulo.setText("Cursos");
        Principal.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Docente");
        Principal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Codigo");
        Principal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Grupo");
        Principal.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Asignatura");
        Principal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Hora");
        Principal.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Día");
        Principal.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Programa");
        Principal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        txtHora.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });
        Principal.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 110, 30));

        txtGrupo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGrupoActionPerformed(evt);
            }
        });
        Principal.add(txtGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 80, 30));

        txtDia.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaActionPerformed(evt);
            }
        });
        Principal.add(txtDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 100, 30));

        cbxDocentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDocentesActionPerformed(evt);
            }
        });
        Principal.add(cbxDocentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 210, 32));

        txtAsignatura.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAsignaturaActionPerformed(evt);
            }
        });
        Principal.add(txtAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 250, 30));

        txtCodigo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        Principal.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 120, 30));

        Principal.add(cbxPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 230, 30));

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCursos.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblCursos);

        Principal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 970, 190));

        btnCrear.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnCrear.setText("Registrar");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        Principal.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 130, 40));

        btnModificar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        Principal.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 130, 40));

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
        Principal.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 120, -1));

        btnLimpiar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnLimpiar.setText("Cancelar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        Principal.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, 110, -1));
        Principal.add(txtIdCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, -1, -1));

        jLabel1.setText("Buscar");
        Principal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Principal, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaActionPerformed

    private void txtAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsignaturaActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGrupoActionPerformed

    private void cbxDocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDocentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDocentesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem FilaCambiarEstado;
    public javax.swing.JMenuItem FilaEditar;
    private javax.swing.JPanel Principal;
    public javax.swing.JLabel Titulo;
    public javax.swing.JButton btnCrear;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JComboBox<Usuario> cbxDocentes;
    public javax.swing.JComboBox<Programa> cbxPrograma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblCursos;
    public javax.swing.JTextField txtAsignatura;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtDia;
    public javax.swing.JTextField txtGrupo;
    public javax.swing.JTextField txtHora;
    public javax.swing.JTextField txtIdCurso;
    // End of variables declaration//GEN-END:variables
}
