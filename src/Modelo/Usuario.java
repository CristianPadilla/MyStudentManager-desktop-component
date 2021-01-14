package Modelo;

//import com.mysql.cj.xdevapi.Statement;
//import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Usuario extends ConnectionBD {

    private int id_usuario;
    private String nombre;
    private String nombre_usuario;
    private String correo_electronico;
    private long documento_identidad;
    private int id_rol;
    private int estado;

    public Usuario() {
        ps = null;
        rs = null;
        sql = null;

    }

    public DefaultTableModel ListarUsuarios(String filtro) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("nombre");
        modelo.addColumn("nombre de usuario");
        modelo.addColumn("correo electronico");
        modelo.addColumn("numero de documento");

        //consulta rol del tipo de usuario a listar
        try {

            //like funciona para como una query que me trae todos los registros que contienen los datos de filtro
            //concat para hacer el request en el where con los campos que se indiquen
            // los %son para que filtre desde todos los rangos del filtro, eje: cristian trae rist,cri,tian, etc
            sql = "SELECT id_usuario,nombre,nombre_usuario,correo_electronico,documento_identidad FROM usuarios "
                    + "WHERE id_rol = " + id_rol + " AND CONCAT (nombre,nombre_usuario,correo_electronico,documento_identidad)"
                    + "LIKE '%" + filtro + "%' AND estado=1";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] fila = new Object[4];
            while (rs.next()) {

                fila[0] = rs.getString("nombre");
                fila[1] = rs.getString("nombre_usuario");
                fila[2] = rs.getString("correo_electronico");
                fila[3] = rs.getString("documento_identidad");
                modelo.addRow(fila);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelo;

    }

    public DefaultTableModel ListarUsuariosInactivos(String filtro) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("nombre");
        modelo.addColumn("nombre de usuario");
        modelo.addColumn("correo electronico");
        modelo.addColumn("numero de documento");
        //consulta rol del tipo de usuario a listar
        try {
            //like funciona para como una query que me trae todos los registros que contienen los datos de filtro
            //concat para hacer el request en el where con los campos que se indiquen
            // los %son para que filtre desde todos los rangos del filtro, eje: cristian trae rist,cri,tian, etc
            sql = "SELECT id_usuario,nombre,nombre_usuario,correo_electronico,documento_identidad FROM usuarios "
                    + "WHERE id_rol = " + id_rol + " AND CONCAT (nombre,nombre_usuario,correo_electronico,documento_identidad)"
                    + "LIKE '%" + filtro + "%' AND estado=0";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] fila = new Object[4];
            while (rs.next()) {

                fila[0] = rs.getString("nombre");
                fila[1] = rs.getString("nombre_usuario");
                fila[2] = rs.getString("correo_electronico");
                fila[3] = rs.getString("documento_identidad");
                modelo.addRow(fila);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelo;

    }

    public boolean crearUsuario() {
//        id_rol = validarRol(nombreRol);
        sql = "INSERT INTO usuarios (nombre, nombre_usuario, correo_electronico, documento_identidad, id_rol) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, nombre_usuario);
            ps.setString(3, correo_electronico);
            ps.setString(4, String.valueOf(documento_identidad));
            ps.setString(5, String.valueOf(id_rol));
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean modificarUsuario() {
//        id_rol = validarRol(nombreRol);
        sql = "UPDATE usuarios SET nombre=? , nombre_usuario =? , correo_electronico =? , documento_identidad =?, id_rol =? "
                + "WHERE id_usuario =? ";
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, nombre_usuario);
            ps.setString(3, correo_electronico);
            ps.setString(4, String.valueOf(documento_identidad));
            ps.setString(5, String.valueOf(id_rol));
            ps.setString(6, String.valueOf(id_usuario));
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean cambiarEstadoUsuario(boolean estado) {
//        sql = "DELETE FROM usuarios  WHERE id_usuario =? ";
        int est = 1;
        if (estado ) {
            est=0;            
        }
        sql = "UPDATE usuarios SET estado="+est+" WHERE id_usuario =? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(id_usuario));

            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public int consultarIdUsuario(String nombre) {
        int id = 0;
//        sql = "SELECT  id_usuario FROM usuarios WHERE nombre = "+nombre;
        sql = "SELECT id_usuario FROM usuarios WHERE nombre = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
//            Lectura.mostrar(nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = Integer.parseInt(rs.getString("id_usuario"));
            } else {
                Lectura.mostrar("El usuario no existe");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    public int validarRol(String nombreRol) {
        int id_rol = 0;
        String sqlAux = "SELECT id_rol FROM rol WHERE nombre_rol = '" + nombreRol + "'";
        try {
            ps = con.prepareStatement(sqlAux);
            rs = ps.executeQuery();
            if (rs.next()) {
                id_rol = Integer.parseInt(rs.getString("id_rol"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id_rol;
    }

    public void cbxUsuarios(JComboBox<Usuario> combo, String nombreRol) {
//        to change the parameter type from the cbx before this, important to have toString method
        String sql = "Select * from usuarios WHERE id_rol =" + validarRol(nombreRol) + " AND estado=1";
        combo.removeAllItems();
        Usuario u = new Usuario();
        u.setId_usuario(0);
        u.setNombre("Seleccione un Docente");
        combo.addItem(u);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                u = new Usuario();
                u.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
                u.setNombre(rs.getString("nombre"));
                combo.addItem(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean Login() {
        sql = "SELECT * FROM usuarios WHERE documento_identidad=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, documento_identidad);
            rs = ps.executeQuery();
            if (rs.next()) {
                int idrol = Integer.parseInt(rs.getString("id_rol"));
                System.out.println("id del rol: " + idrol);
                if (idrol == validarRol("administrador")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public String toString() {
        return nombre;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public long getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(long documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

}
