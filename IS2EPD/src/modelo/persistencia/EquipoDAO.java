/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia;

import java.util.List;
import modelo.Equipo;

/**
 *
 * @author Rafa
 */
public interface EquipoDAO {

    Equipo read(String pk);

    void create(Equipo equipo);

    void update(Equipo equipo);

    void delete(Equipo equipo);

    List<Equipo> list();

}
