package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Curso extends ConnectionBD {


    private int id_curso;
    private String codigo_curso;
    private String asignatura_curso;
    private int grupo_curso;
    private String hora_curso;
    private String dia_curso;
    private String docente_curso;
    private int id_usuario;
    private int estado_curso;
    private int id_programa;
    public int estadoDocente;
//    private Matricula[] matriculas;

    public Curso() {

    }

    public DefaultTableModel ListarCursos(String filtro) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("codigo");
        modelo.addColumn("asignatura");
        modelo.addColumn("grupo");
        modelo.addColumn("hora");
        modelo.addColumn("día");
        modelo.addColumn("docente");
        modelo.addColumn("programa");
        modelo.addColumn("estado");

        //consulta rol del tipo de usuario a listar
        //SELECT * FROM usuarios WHERE CONCAT(nombre,nombre_usuario,correo_electronico,documento_identidad) LIKE '%%'
        try {
            sql = "SELECT * FROM curso INNER JOIN usuarios ON usuarios.id_usuario = curso.id_usuario  INNER JOIN programa ON programa.id_programa = curso.id_programa WHERE CONCAT (codigo_curso,asignatura_curso,grupo_curso) LIKE '%" + filtro + "%' ";

//            String sql2 = "SELECT * FROM curso INNER JOIN usuarios ON usuarios.id_usuario = curso.id_usuario  INNER JOIN programa ON programa.id_programa = curso.id_programa"
//                    + "WHERE CONCAT (codigo_curso,asignatura_curso,grupo_curso) LIKE '%" + filtro + "%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] fila = new Object[8];
            while (rs.next()) {
                String estado = null;
                if (Integer.parseInt(rs.getString("estado")) == 1) {
                    estado = "activo";
                } else {
                    estado = "inactivo";
                }

                fila[0] = rs.getString("codigo_curso");
                fila[1] = rs.getString("asignatura_curso");
                fila[2] = rs.getString("grupo_curso");
                fila[3] = rs.getString("hora_curso");
                fila[4] = rs.getString("dia_curso");
                fila[5] = rs.getString("nombre");
                fila[6] = rs.getString("nombre_programa");
                fila[7] = estado;
                modelo.addRow(fila);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modelo;
    }

    public boolean crearCursos() {

        sql = "INSERT INTO curso (codigo_curso, asignatura_curso, grupo_curso, hora_curso, dia_curso, id_usuario, id_programa) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo_curso);
            ps.setString(2, asignatura_curso);
            ps.setString(3, String.valueOf(grupo_curso));
            ps.setString(4, hora_curso);
            ps.setString(5, dia_curso);
            ps.setString(6, String.valueOf(id_usuario));
            ps.setString(7, String.valueOf(id_programa));
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean modificarCursos() {
        sql = "UPDATE curso SET codigo_curso=? , asignatura_curso =? , grupo_curso =? , hora_curso =?, dia_curso =?, id_usuario =?, id_programa =? "
                + "WHERE id_curso =? ";
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, codigo_curso);
            ps.setString(2, asignatura_curso);
            ps.setString(3, String.valueOf(grupo_curso));
            ps.setString(4, hora_curso);
            ps.setString(5, dia_curso);
            ps.setString(6, String.valueOf(id_usuario));
            ps.setString(7, String.valueOf(id_programa));
            ps.setString(8, String.valueOf(id_curso));
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean cambiarEstado() {

        sql = "UPDATE  curso  SET estado=? WHERE id_curso =? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(estado_curso));
            ps.setString(2, String.valueOf(id_curso));

            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int consultarIdCurso(String codigo) {
        int id = 0;
        sql = "SELECT  id_curso FROM curso WHERE codigo_curso =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = Integer.parseInt(rs.getString("id_curso"));
            } else {
                Lectura.mostrar("El usuario no existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public void cbxCursos(JComboBox<Curso> combo) {
//        to change the parameter type from the cbx before this, important to have toString method
        String sql = "Select * from curso ";
        combo.removeAllItems();
        Curso c = new Curso();
        c.setCodigo_curso("");
        c.setAsignatura_curso("Seleccione un Curso");
        c.setId_curso(0);
        c.setEstado_curso(2);
        combo.addItem(c);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Curso();
                c.setId_curso(Integer.parseInt(rs.getString("id_curso")));
                c.setCodigo_curso(rs.getString("codigo_curso"));
                c.setAsignatura_curso(rs.getString("asignatura_curso"));
                int estado = 1;
                if (rs.getString("estado").equals("0")) {
                    estado = 0;
                }
                c.setEstado_curso(estado);
                combo.addItem(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void consultarCurso() {
        sql = "SELECT * FROM curso INNER JOIN usuarios ON usuarios.id_usuario=curso.id_usuario WHERE id_curso=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_curso);
            rs = ps.executeQuery();
            if (rs.next()) {
                estadoDocente = Integer.parseInt(rs.getString("usuarios.estado"));
                hora_curso = rs.getString("hora_curso");
                dia_curso = rs.getString("dia_curso");
                docente_curso = rs.getString("nombre");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getCodigo_curso() {
        return codigo_curso;
    }

    @Override
    public String toString() {
        String estado="activo";
        if(estado_curso==0){
            estado="inactivo";
        }else if (estado_curso != 0 && estado_curso != 1){
            estado="";
        }
        return codigo_curso + " - " + asignatura_curso + " - " + estado;   
    }

    public void setCodigo_curso(String codigo_curso) {
        this.codigo_curso = codigo_curso;
    }

    public String getAsignatura_curso() {
        return asignatura_curso;
    }

    public String getDocente_curso() {
        return docente_curso;
    }

    public void setDocente_curso(String docente_curso) {
        this.docente_curso = docente_curso;
    }

    public void setAsignatura_curso(String asignatura_curso) {
        this.asignatura_curso = asignatura_curso;
    }

    public int getGrupo_curso() {
        return grupo_curso;
    }

    public void setGrupo_curso(int grupo_curso) {
        this.grupo_curso = grupo_curso;
    }

    public String getHora_curso() {
        return hora_curso;
    }

    public void setHora_curso(String hora_curso) {
        this.hora_curso = hora_curso;
    }

    public String getDia_curso() {
        return dia_curso;
    }

    public void setDia_curso(String dia_curso) {
        this.dia_curso = dia_curso;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }

    public int getEstado_curso() {
        return estado_curso;
    }

    public void setEstado_curso(int estado_curso) {
        this.estado_curso = estado_curso;
    }
}
