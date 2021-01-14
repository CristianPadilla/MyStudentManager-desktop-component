package Control;

import Modelo.ConnectionBD;
import Modelo.Curso;
import Modelo.Lectura;
import Modelo.Programa;
import Modelo.Usuario;
import Vista.VistaCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ControladorCursos implements ActionListener, KeyListener {

    private VistaCursos vista;
    private Curso curso;
    //atributos extra necesarios
    ConnectionBD con;
    Programa pro = new Programa();
    Usuario u = new Usuario();

    public ControladorCursos(VistaCursos v) {
        this.vista = v;
        this.curso = new Curso();
        this.con = new ConnectionBD();
        vista.btnModificar.setVisible(false);
        pro.cbxProgramas(vista.cbxPrograma);
        u.cbxUsuarios(vista.cbxDocentes, "profesor");
        vista.txtIdCurso.setVisible(false);
        vista.btnLimpiar.setVisible(false);

        this.vista.btnCrear.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.FilaEditar.addActionListener(this);
        this.vista.FilaCambiarEstado.addActionListener(this);
        this.vista.txtBuscar.addKeyListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnCrear) {
            curso.setCodigo_curso(vista.txtCodigo.getText());
            curso.setAsignatura_curso(vista.txtAsignatura.getText());
            curso.setGrupo_curso(Integer.parseInt(vista.txtGrupo.getText()));
            curso.setHora_curso(vista.txtHora.getText());
            curso.setDia_curso(vista.txtDia.getText());
            curso.setId_usuario(vista.cbxDocentes.getItemAt(vista.cbxDocentes.getSelectedIndex()).getId_usuario());
            curso.setId_programa(vista.cbxPrograma.getItemAt(vista.cbxPrograma.getSelectedIndex()).getId_programa());
            if (curso.getId_programa() == 0 || curso.getId_usuario() == 0) {
                Lectura.mostrar("Seleccione un programa y un docente válidos para el curso");

            } else {
                if (curso.crearCursos()) {
                    Lectura.mostrar("Se registró con exito");
                    clean();
                } else {
                    Lectura.mostrar("error al crear el curso");
                }
            }
            refrescar("");
        }

        if (e.getSource() == vista.btnModificar) {
            curso.setCodigo_curso(vista.txtCodigo.getText());
            curso.setAsignatura_curso(vista.txtAsignatura.getText());
            curso.setGrupo_curso(Integer.parseInt(vista.txtGrupo.getText()));
            curso.setHora_curso(vista.txtHora.getText());
            curso.setDia_curso(vista.txtDia.getText());
            curso.setId_curso(Integer.parseInt(vista.txtIdCurso.getText()));

            if (vista.cbxDocentes.getItemAt(vista.cbxDocentes.getSelectedIndex()).getId_usuario() == 0) {
                Lectura.mostrar("!Seleccione un docente¡");
            } else if (vista.cbxPrograma.getItemAt(vista.cbxPrograma.getSelectedIndex()).getId_programa() == 0) {
                Lectura.mostrar("!Seleccione un programa¡");
            } else {
                curso.setId_usuario(vista.cbxDocentes.getItemAt(vista.cbxDocentes.getSelectedIndex()).getId_usuario());
                curso.setId_programa(vista.cbxPrograma.getItemAt(vista.cbxPrograma.getSelectedIndex()).getId_programa());
                if (curso.modificarCursos()) {
                    Lectura.mostrar("Se modificó con exito");
                    refrescar("");
                    clean();
                    refrescar("");
                    vista.btnModificar.setVisible(false);
                    vista.btnCrear.setVisible(true);
                    
                } else {
                    Lectura.mostrar("error al modificar");
                }
            }
        }

        // for rightclick button´s table
        if (e.getSource() == vista.FilaEditar) {
            vista.txtCodigo.setText((String) vista.tblCursos.getValueAt(vista.tblCursos.getSelectedRow(), 0));
            vista.txtAsignatura.setText((String) vista.tblCursos.getValueAt(vista.tblCursos.getSelectedRow(), 1));
            vista.txtGrupo.setText((String) vista.tblCursos.getValueAt(vista.tblCursos.getSelectedRow(), 2));
            vista.txtHora.setText((String) vista.tblCursos.getValueAt(vista.tblCursos.getSelectedRow(), 3));
            vista.txtDia.setText((String) vista.tblCursos.getValueAt(vista.tblCursos.getSelectedRow(), 4));
            int id = curso.consultarIdCurso((String) vista.tblCursos.getValueAt(vista.tblCursos.getSelectedRow(), 0));
            vista.txtIdCurso.setText(String.valueOf(id));
            vista.btnModificar.setVisible(true);
            vista.btnCrear.setVisible(false);
            vista.btnLimpiar.setVisible(true);
        }

        if (e.getSource() == vista.FilaCambiarEstado) {
            int id = curso.consultarIdCurso((String) vista.tblCursos.getValueAt(vista.tblCursos.getSelectedRow(), 0));
            curso.setId_curso(id);
            int estado=1;
            String cadena="activo";
            if (vista.tblCursos.getValueAt(vista.tblCursos.getSelectedRow(), 7).equals("activo")) {
                estado=0;
                cadena="inactivo";
            }
            
            
            curso.setEstado_curso(estado);
            if (curso.cambiarEstado()) {
                Lectura.mostrar("el curso ahora se encuentra "+cadena);
                clean();
            } else {
                Lectura.mostrar("error al cambiar estado del curso");
            }
            refrescar("");

        }

        if (e.getSource() == vista.txtBuscar) {
            curso.ListarCursos(vista.txtBuscar.getText());

        }

        if (e.getSource() == vista.btnLimpiar) {
            vista.btnModificar.setVisible(false);
            vista.btnCrear.setVisible(true);
            vista.btnLimpiar.setVisible(false);
            clean();
        }
    }

    public void start() {
        vista.setVisible(true);
        refrescar("");
        vista.btnModificar.setVisible(false);
    }

    public void clean() {

        vista.txtCodigo.setText(null);
        vista.txtAsignatura.setText(null);
        vista.txtGrupo.setText(null);
        vista.txtHora.setText(null);
        vista.txtDia.setText(null);
        vista.btnModificar.setVisible(false);
        vista.btnCrear.setVisible(true);
    }

    public void refrescar(String filtro) {
        vista.tblCursos.setModel(curso.ListarCursos(filtro));
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        refrescar(vista.txtBuscar.getText());
    }

}
