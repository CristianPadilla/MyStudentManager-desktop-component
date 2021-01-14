package Principal;

import Control.ControladorHome;
import Control.ControladorLogin;
import Vista.Login;
import Vista.VistaHome;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Ejecutar {

    public static void main(String[] args) {
//        VistaHome v = new VistaHome();
//        ControladorHome c = new ControladorHome();
//        c.start();
//        Login l = new Login();
        for (javax.swing.UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Ejecutar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Ejecutar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Ejecutar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Ejecutar.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
        ControladorLogin c = new ControladorLogin();
        c.start();
    }

}
