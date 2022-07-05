/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.EquipoImpl;
import modelo.Equipo;
import modelo.persistencia.EquipoDAO;

/**
 *
 * @author Rafa
 */
public class EquipoDAOJDBC implements EquipoDAO {

    public void create(Equipo equipo) {
        String sql = "insert into equipos(nombre,pais,pos_grupo,grupo) values (?,?,?,?)";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, equipo.getNombre());
            stm.setString(2, equipo.getPais());
            stm.setString(3, equipo.getPos_grupo());
            stm.setString(4, equipo.getGrupo());
            stm.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Equipo read(String pk) {
        Equipo c = null;
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM equipos where nombre=" + pk);
            String nombre, pais, pos_grupo, grupo;
            if (res.next()) {
                nombre = res.getString("nombre");
                pais = res.getString("pais");
                pos_grupo = res.getString("pos_grupo");
                grupo = res.getString("grupo");
                c = new EquipoImpl(nombre, pais, pos_grupo, grupo);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return c;
    }

    public void update(Equipo contacto) {
        String sql = "UPDATE equipos set pais=?, pos_grupo=?,grupo=? where nombre like ?";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, contacto.getPais());
            stm.setString(2, contacto.getPos_grupo());
            stm.setString(3, contacto.getGrupo());
            stm.setString(4, contacto.getNombre());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void delete(Equipo contacto) {
        String sql = "DELETE FROM equipos WHERE nombre='" + contacto.getNombre()+"'";
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public List<Equipo> list() {
        List<Equipo> equipos = new ArrayList<Equipo>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM equipos ");
            String nombre, pais, pos_grupo, grupo;
            while (res.next()) {
                nombre = res.getString("nombre");
                pais = res.getString("pais");
                pos_grupo = res.getString("pos_grupo");
                grupo = res.getString("grupo");
                equipos.add(new EquipoImpl(nombre, pais, pos_grupo, grupo));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return equipos;
    }
}
