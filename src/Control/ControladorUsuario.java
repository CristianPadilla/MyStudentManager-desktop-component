package Control;

import Modelo.Lectura;
import Modelo.ConnectionBD;
import Modelo.Usuario;
import Vista.VistaUsuario;
import com.sun.jdi.connect.spi.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;

public class ControladorUsuario implements ActionListener, KeyListener {

    private VistaUsuario vista;
    private Usuario user;
    ConnectionBD con;
    private String nombreRol;

    public ControladorUsuario(VistaUsuario v, String nombreRol) {
        this.vista = v;
        this.user = new Usuario();
        this.con = new ConnectionBD();
        this.nombreRol = nombreRol;
        this.user.setId_rol(user.validarRol(nombreRol));
        vista.btnModificar.setVisible(false);
        vista.btnLimpiar.setVisible(false);

        this.vista.btnCrear.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.FilaEditar.addActionListener(this);
        this.vista.FilaCambiarEstado.addActionListener(this);
        this.vista.txtBuscar.addKeyListener(this);
        this.vista.txtBuscar2.addKeyListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnActivar.addActionListener(this);
        vista.txtidUsuario.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnCrear) {
            user.setNombre(vista.txtNombre.getText());
            user.setNombre_usuario(vista.txtUsuario.getText());
            user.setCorreo_electronico(vista.txtCorreo.getText());
            user.setDocumento_identidad(Integer.parseInt(vista.txtDocumento.getText()));
            if (user.crearUsuario()) {
                Lectura.mostrar("Se registró con exito");

                clean();
            } else {
                Lectura.mostrar("error al crear");
            }
            refrescar("");
            refrescar2("");

        }

        if (e.getSource() == vista.btnModificar) {
            user.setNombre(vista.txtNombre.getText());
            user.setNombre_usuario(vista.txtUsuario.getText());
            user.setCorreo_electronico(vista.txtCorreo.getText());
            user.setDocumento_identidad(Long.parseLong(vista.txtDocumento.getText()));
            user.setId_usuario(Integer.parseInt(vista.txtidUsuario.getText()));
//            user.setId_usuario(Integer.parseInt(vista.txtIdUsuario.getText()));
            if (user.modificarUsuario()) {
                Lectura.mostrar("Se modificó con exito");
                clean();
            } else {
                Lectura.mostrar("error al modificar");
            }
            refrescar("");
            refrescar2("");
            vista.btnModificar.setVisible(false);
            vista.btnCrear.setVisible(true);

        }

        // for rightclick button´s table
        if (e.getSource() == vista.FilaEditar) {
            vista.txtNombre.setText((String) vista.tblUsuarios.getValueAt(vista.tblUsuarios.getSelectedRow(), 0));
            vista.txtUsuario.setText((String) vista.tblUsuarios.getValueAt(vista.tblUsuarios.getSelectedRow(), 1));
            vista.txtCorreo.setText((String) vista.tblUsuarios.getValueAt(vista.tblUsuarios.getSelectedRow(), 2));
            vista.txtDocumento.setText((String) vista.tblUsuarios.getValueAt(vista.tblUsuarios.getSelectedRow(), 3));
            int id = user.consultarIdUsuario((String) vista.tblUsuarios.getValueAt(vista.tblUsuarios.getSelectedRow(), 0));
//            user.setId_usuario(id);
            vista.txtidUsuario.setText(String.valueOf(id));
            vista.btnModificar.setVisible(true);
            vista.btnCrear.setVisible(false);
            vista.btnLimpiar.setVisible(true);
        }

        if (e.getSource() == vista.FilaCambiarEstado) {
            int id = user.consultarIdUsuario((String) vista.tblUsuarios.getValueAt(vista.tblUsuarios.getSelectedRow(), 0));
            user.setId_usuario(id);
            if (user.cambiarEstadoUsuario(true)) {
                Lectura.mostrar("El usuario ahora se encuentra inactivo");
                clean();
            } else {
                Lectura.mostrar("error al desactivar el usuario");
            }
            refrescar("");
            refrescar2("");

        }

        if (e.getSource() == vista.btnLimpiar) {
            vista.btnModificar.setVisible(false);
            vista.btnCrear.setVisible(true);
            vista.btnLimpiar.setVisible(false);
            clean();
        }
        if (e.getSource() == vista.btnActivar) {
            int id = user.consultarIdUsuario((String) vista.tblInactivos.getValueAt(vista.tblInactivos.getSelectedRow(), 0));
            user.setId_usuario(id);
            if (user.cambiarEstadoUsuario(false)) {
                Lectura.mostrar("El usuario ahora se encuentra activo");
            } else {
                Lectura.mostrar("Error al activar el usuario");
            }
            refrescar("");
            refrescar2("");
        }

    }

    public void start() {
        vista.setVisible(true);
        refrescar("");
        refrescar2("");
    }

    public void clean() {

        vista.txtNombre.setText(null);
        vista.txtUsuario.setText(null);
        vista.txtCorreo.setText(null);
        vista.txtDocumento.setText(null);

    }

    public void refrescar(String filtro) {
        vista.tblUsuarios.setModel(user.ListarUsuarios(filtro));
    }

    public void refrescar2(String filtro) {
        vista.tblInactivos.setModel(user.ListarUsuariosInactivos(filtro));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vista.txtBuscar) {
            refrescar(vista.txtBuscar.getText());
        }
        if (e.getSource() == vista.txtBuscar2) {
            refrescar2(vista.txtBuscar2.getText());
        }     
    }
}
