package Control;

import Modelo.Curso;
import Modelo.Lectura;
import Modelo.Matricula;
import Modelo.Usuario;
import Vista.VistaMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

public class ControladorMatriculas implements ActionListener, KeyListener, ItemListener {

    private VistaMatricula vista;
    private Curso curso;
    private Matricula matricula;
    private Usuario u = new Usuario();

    public ControladorMatriculas(VistaMatricula v) {
        this.matricula = new Matricula();
        this.curso = new Curso();
        vista = v;
        this.vista.btnMatricular.addActionListener(this);
        this.vista.cbxCursos.addItemListener(this);
        this.vista.txtBuscar2.addKeyListener(this);
        this.vista.txtBuscar3.addKeyListener(this);
        vista.cambiarEstado.addActionListener(this);
        curso.cbxCursos(vista.cbxCursos);

    }

    public void start() {
        vista.btnMatricular.setVisible(false);
        vista.setVisible(true);
        refrescar("", 0);
        refrescar2("");
    }

    public void clean() {
        vista.txtDia.setText(null);
        vista.txtDocente.setText(null);
        vista.txtHora.setText(null);
    }

    public void refrescar(String filtro, int idCurso) {
        vista.tblEstudiantesMatriculados.setModel(matricula.ListarMatriculas(filtro, idCurso));
        u.setId_rol(u.validarRol("estudiante"));
    }

    public void refrescar2(String filtro) {
        vista.tblEstudiantes.setModel(u.ListarUsuarios(filtro));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnMatricular) {
            int id = u.consultarIdUsuario((String) vista.tblEstudiantes.getValueAt(vista.tblEstudiantes.getSelectedRow(), 0));
            matricula.setId_usuario(id);
            matricula.setId_curso(vista.cbxCursos.getItemAt(vista.cbxCursos.getSelectedIndex()).getId_curso());
            try {
                if (matricula.matricular()) {
                    Lectura.mostrar("Se realizó la matricula con exito");
                    refrescar("", vista.cbxCursos.getItemAt(vista.cbxCursos.getSelectedIndex()).getId_curso());
                } else {
                    Lectura.mostrar("Error al matricular el estudiante");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMatriculas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == vista.cambiarEstado) {

            matricula.setId_usuario(u.consultarIdUsuario((String) vista.tblEstudiantesMatriculados.getValueAt(vista.tblEstudiantesMatriculados.getSelectedRow(), 0)));
            matricula.setId_curso(vista.cbxCursos.getItemAt(vista.cbxCursos.getSelectedIndex()).getId_curso());
            matricula.setId_matricula(matricula.consultarIdMatricula());
            int estado = 1;
            String cadena = "activo";
            if (vista.tblEstudiantesMatriculados.getValueAt(vista.tblEstudiantesMatriculados.getSelectedRow(), 3).equals("activo")) {
                estado = 0;
                cadena = "inactivo";
            }
            matricula.setEstado(estado);
            if (matricula.getId_matricula() != 0) {

                try {
                    if (matricula.cambiarEstadoMaricula()) {
                        Lectura.mostrar("El registro ahora se encuentra " + cadena);
                    } else {
                        Lectura.mostrar("error al cambiar el estado");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorMatriculas.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Lectura.mostrar("seleccione un curso");
            }

            refrescar("", vista.cbxCursos.getItemAt(vista.cbxCursos.getSelectedIndex()).getId_curso());

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int idCurso = vista.cbxCursos.getItemAt(vista.cbxCursos.getSelectedIndex()).getId_curso();
        if (e.getSource() == vista.txtBuscar2) {
            refrescar(vista.txtBuscar2.getText(),idCurso);
        }
        if (e.getSource() == vista.txtBuscar3) {
            refrescar2(vista.txtBuscar3.getText());
        }
    }

    //combobox
    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {
            int idCurso = vista.cbxCursos.getItemAt(vista.cbxCursos.getSelectedIndex()).getId_curso();
            if (idCurso != 0) {
                String nombre = "";
                vista.btnMatricular.setVisible(true);
                curso.setId_curso(idCurso);
                curso.consultarCurso();
                nombre += curso.getDocente_curso();
                if (curso.estadoDocente == 0) {
                    nombre += "-inactivo";
                }
                vista.txtDia.setText(curso.getDia_curso());
                vista.txtDocente.setText(nombre);
                vista.txtHora.setText(curso.getHora_curso());

                refrescar("", idCurso);
            } else {
                vista.btnMatricular.setVisible(false);
                refrescar("", 0);
                clean();
            }

        }

    }

}
