package Modelo;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Matricula extends ConnectionBD {

    private int id_matricula;
    private int id_usuario;
    private int id_curso;
    private Notas notas;
    private int estado;

    public Matricula() {
        ps = null;
        rs = null;
        sql = null;
    }

    public DefaultTableModel ListarMatriculas(String filtro, int idCurso) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("nombre");
        modelo.addColumn("No.documento");
        modelo.addColumn("correo electronico");
        modelo.addColumn("estado");

        //consulta rol del tipo de usuario a listar
        try {

            //like funciona para como una query que me trae todos los registros que contienen los datos de filtro
            //concat para hacer el request en el where con los campos que se indiquen
            // los %son para que filtre desde todos los rangos del filtro, eje: cristian trae rist,cri,tian, etc
            sql = "SELECT * FROM matricula INNER JOIN curso ON curso.id_curso = matricula.id_curso INNER JOIN usuarios ON usuarios.id_usuario = matricula.id_estudiante "
                    + "WHERE matricula.id_curso = " + idCurso + " AND CONCAT (nombre,nombre_usuario,correo_electronico,documento_identidad)"
                    + "LIKE '%" + filtro + "%'";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] fila = new Object[4];
            while (rs.next()) {
                String estado = null;
                if (Integer.parseInt(rs.getString("estado")) == 1) {
                    estado = "activo";
                } else {
                    estado = "inactivo";
                }

                fila[0] = rs.getString("nombre");
                fila[1] = rs.getString("documento_identidad");
                fila[2] = rs.getString("correo_electronico");
                fila[3] = estado;
                modelo.addRow(fila);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelo;

    }

    public boolean matricular() throws SQLException {

        try {
            int id_profesor = 0;
            con.setAutoCommit(false);
            //validar estado del docente
            sql = "SELECT id_usuario FROM curso WHERE id_curso=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_curso);
            rs = ps.executeQuery();
            if (rs.next()) {
                id_profesor = Integer.parseInt(rs.getString("id_usuario"));
                sql = "SELECT estado FROM usuarios WHERE id_usuario=?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, id_profesor);
                rs = ps.executeQuery();
                if (rs.next()) {
                    if (Integer.parseInt(rs.getString("estado")) == 0) {
                        Lectura.mostrar("¡El docente del curso esta inactivo!");
                        return false;
                    }
                }
            }

            //validar que no este matriculado
            sql = "SELECT * FROM matricula WHERE id_estudiante=? AND id_curso=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_usuario);
            ps.setInt(2, id_curso);
            rs = ps.executeQuery();
            if (rs.next()) {
                Lectura.mostrar("Este estudiante ya se encuentra matriculado en este curso");
                return false;
            }
            //crear registro de matricula
            sql = "INSERT INTO matricula (id_estudiante, id_curso) VALUES (?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_usuario);
            ps.setInt(2, id_curso);
            ps.execute();

            //consulta codigo de la matricula anteriormente creada
            sql = "SELECT id_matricula FROM matricula WHERE id_estudiante=? AND id_curso=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_usuario);
            ps.setInt(2, id_curso);
            rs = ps.executeQuery();
            if (rs.next()) {
                id_matricula = Integer.parseInt(rs.getString("id_matricula"));
            }
            //crea registro notas relacionado con esa matricula
            sql = "INSERT INTO notas (id_matricula) VALUES(?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_matricula);
            ps.execute();

            con.commit();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
            con.rollback();
            return false;
        }
    }

    public boolean cambiarEstadoMaricula() throws SQLException {

        try {
//            con.setAutoCommit(false);
            sql = "UPDATE matricula SET estado =? WHERE id_matricula=?";
//            int idNotas = 0;
            //borrar registro de la tabla notas
            ps = con.prepareStatement(sql);
            ps.setInt(1, estado);
            ps.setInt(2, id_matricula);
            ps.execute();

//
//            sql = "DELETE FROM notas WHERE id_notas=?";
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, idNotas);
//            ps.execute();
//            //eliminar registro en matricula
//            sql = "DELETE FROM matricula WHERE id_matricula=?";
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, id_matricula);
//            ps.execute();
//            con.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
//            con.rollback();
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
//            con.rollback();
            return false;
        }
    }

    public int consultarIdMatricula() {
        int id = 0;
        sql = "SELECT id_matricula FROM matricula WHERE id_estudiante = ? AND id_curso = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_usuario);
            ps.setInt(2, id_curso);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = Integer.parseInt(rs.getString("id_matricula"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public int getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public Notas getNotas() {
        return notas;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
