package Control;

import Vista.VistaUsuario;
import Vista.VistaHome;
import Vista.VistaCursos;
import Vista.VistaMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorHome implements ActionListener {

    private VistaHome vHome = new VistaHome();

    public ControladorHome() {
        this.vHome.btnVistaEstudiante.addActionListener(this);
        this.vHome.btnVistaDocente.addActionListener(this);
        this.vHome.btnVistaAdministrador.addActionListener(this);
        this.vHome.btnVistaCursos.addActionListener(this);
        this.vHome.btnVistaMatriculas.addActionListener(this);     
        this.vHome.btnCerrars.addActionListener(this);
    }

    public void start() {
        vHome.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vHome.btnVistaEstudiante) {
            VistaUsuario v = new VistaUsuario();
            vHome.jDesktopPane1.add(v);
            ControladorUsuario contr = new ControladorUsuario(v, "estudiante");
            contr.start();
            v.Titulo.setText("Estudiantes");
            v.setLocation((vHome.jDesktopPane1.getWidth()-v.getWidth())/2, (vHome.jDesktopPane1.getHeight()-v.getHeight())/2);
//            v.setSize(690, 680);
        }

        if (e.getSource() == vHome.btnVistaDocente) {

            VistaUsuario v = new VistaUsuario();
            vHome.jDesktopPane1.add(v);
            ControladorUsuario contr = new ControladorUsuario(v, "profesor");
            contr.start();
            v.Titulo.setText("Docentes");
            v.setLocation((vHome.jDesktopPane1.getWidth()-v.getWidth())/2, (vHome.jDesktopPane1.getHeight()-v.getHeight())/2);
//            v.setSize(690, 680);

        }
        if(e.getSource() == vHome.btnVistaAdministrador){
            VistaUsuario v = new VistaUsuario();
            vHome.jDesktopPane1.add(v);
            ControladorUsuario contr = new ControladorUsuario(v, "administrador");
            contr.start();
            v.Titulo.setText("Administrador");
            v.setLocation((vHome.jDesktopPane1.getWidth()-v.getWidth())/2, (vHome.jDesktopPane1.getHeight()-v.getHeight())/2);
//            v.setSize(690, 680);
        }
        if (e.getSource() == vHome.btnVistaCursos) {

            VistaCursos v = new VistaCursos();
            vHome.jDesktopPane1.add(v);
            ControladorCursos contr = new ControladorCursos(v);
            contr.start();
            v.setLocation((vHome.jDesktopPane1.getWidth()-v.getWidth())/2, (vHome.jDesktopPane1.getHeight()-v.getHeight())/2);
        }
        
        if (e.getSource() == vHome.btnVistaMatriculas) {

            VistaMatricula v = new VistaMatricula();
            vHome.jDesktopPane1.add(v);
            ControladorMatriculas contr = new ControladorMatriculas(v);
            contr.start();
            v.setLocation((vHome.jDesktopPane1.getWidth()-v.getWidth())/2, (vHome.jDesktopPane1.getHeight()-v.getHeight())/2);
        }
        if(e.getSource() == vHome.btnCerrars){
            ControladorLogin c = new ControladorLogin();
            vHome.dispose();
            c.start();
        }
    }    

}
