/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import controlador.EquipoController;

/**
 *
 * @author Rafa
 */
public interface EquipoModel {

    EquipoController getController();

    void setController(EquipoController controller);

    void nuevoEquipo(Equipo contacto);

    Equipo obtenerEquipo(String nombre);

    void eliminarEquipo(Equipo contacto);

    void actualizarEquipo(Equipo contacto);

    List<Equipo> obtenerEquipos();

    public int comprobarEquipo(String nombre, String pais, String pos_grupo, String grupo);

}
