package Control;

import Modelo.Usuario;
import Vista.Login;
import Vista.VistaHome;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener {

    private Login vista;

    private Usuario usuario;

    public ControladorLogin() {
        this.usuario = new Usuario();
        vista = new Login();
        vista.btnIngresar.addActionListener(this);
        vista.chckVer.addActionListener(this);
    }

    public void start() {
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnIngresar) {
            vista.dispose();
            ControladorHome c = new ControladorHome();
            c.start();

//            if (vista.txtUsuario.getText().isEmpty() || vista.txtDocumento.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(null, "Por favor, llene los campos", "Error al iniciar sesión", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                usuario.setNombre_usuario(vista.txtUsuario.getText());
//                usuario.setDocumento_identidad(Long.parseLong(vista.txtDocumento.getText()));
//                System.out.println(usuario.getNombre_usuario());
//                System.out.println(usuario.getDocumento_identidad());
//                if (usuario.Login()) {
//                    
//                    vista.dispose();
//                    ControladorHome c = new ControladorHome();
//                    c.start();
//                } else {
//                    JOptionPane.showMessageDialog(null, "Acceso Denegado", "ERROR", JOptionPane.ERROR_MESSAGE);
//                }                
//            }          
        }
        if (e.getSource()==vista.chckVer) {
            if (vista.chckVer.isSelected()) {
                vista.txtDocumento.setEchoChar((char) 0);
            } else {
                vista.txtDocumento.setEchoChar('*');
            }
        }
    }
}
