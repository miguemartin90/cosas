/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.EquipoImpl;
import modelo.Equipo;
import modelo.EquipoModel;
import vista.EquipoView;

/**
 *
 * @author Rafa
 */
public class EquipoControllerImpl implements EquipoController{
    private EquipoModel model;
    private List<EquipoView> views=new ArrayList<EquipoView>();

    public void setup(EquipoModel model, List<EquipoView> views) {
        setModel(model);
        addViews(views);
        model.setController(this);
        
    }

    public void start() {
        for(EquipoView view:views)
            view.display();
    }

    private void addViews(List<EquipoView> views){
        for(EquipoView view:views)
            addView(view);
    }
    
    public void addView(EquipoView view) {
        view.setModel(model);
        view.setController(this);
        views.add(view);
    }

    public void removeView(EquipoView view) {
        views.remove(view);
    }

    public EquipoModel getModel() {
        return model;
    }

    public void setModel(EquipoModel model) {
        this.model=model;
    }

    @Override
    public void nuevoEquipoGesture(String nombre, String pais, String pos_grupo, String grupo) {
        Equipo equipo=new EquipoImpl(nombre);
        equipo.setPais(pais);
        equipo.setPos_grupo(pos_grupo);
        equipo.setGrupo(grupo);
        getModel().nuevoEquipo(equipo);
    }

    public void actualizaEquipoGesture(String nombre, String pais, String pos_grupo, String grupo) {
        Equipo equipo=new EquipoImpl(nombre);
        equipo.setPais(pais);
        equipo.setPos_grupo(pos_grupo);
        equipo.setGrupo(grupo);
        getModel().actualizarEquipo(equipo);
    }

    public void borraEquipoGesture(String nombre) {
        Equipo equipo=new EquipoImpl(nombre);
        getModel().eliminarEquipo(equipo);
    }

    public void fireDataModelChanged() {
        for (EquipoView view : views) {
            view.dataModelChanged();
        }
    }

}
