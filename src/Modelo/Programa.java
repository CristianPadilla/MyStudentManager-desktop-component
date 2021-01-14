package Modelo;

import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class Programa extends ConnectionBD {

    private int id_programa;
    private String nombre_programa;



    public void cbxProgramas(JComboBox<Programa> combo) {

//        to change the parameter type from the cbx before this, important to have toString method
        String sql = "Select * from programa";
        combo.removeAllItems();
        Programa pro = new Programa();
        pro.setId_programa(0);
        pro.setNombre_programa("Seleccione un programa");
        combo.addItem(pro);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pro = new Programa();
                pro.setId_programa(Integer.parseInt(rs.getString("id_programa")));
                pro.setNombre_programa(rs.getString("nombre_programa"));
                combo.addItem(pro);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }

    @Override
    public String toString() {
        return nombre_programa;
    }

    public String getNombre_programa() {
        return nombre_programa;
    }

    public void setNombre_programa(String nombre_programa) {
        this.nombre_programa = nombre_programa;
    }

}
