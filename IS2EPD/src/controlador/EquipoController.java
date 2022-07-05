/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.EquipoModel;
import vista.EquipoView;

/**
 *
 * @author Rafa
 */
public interface EquipoController {

    //Metodo para enlazar la vista y el modelo
    void setup(EquipoModel model, List<EquipoView> view);

    //Metodo para lanzar la aplicación MVC
    void start();

    void addView(EquipoView view);

    void removeView(EquipoView view);

    EquipoModel getModel();

    void setModel(EquipoModel model);

    void nuevoEquipoGesture(String nombre, String pais, String pos_grupo, String grupo);

    void borraEquipoGesture(String nombre);

    void actualizaEquipoGesture(String nombre, String pais, String pos_grupo, String grupo);
    
    void fireDataModelChanged();

}
