/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.EquipoController;
import controlador.EquipoControllerImpl;
import java.util.*;
import java.util.List;
import modelo.persistencia.EquipoDAO;
import modelo.persistencia.JDBC.EquipoDAOJDBC;

/**
 *
 * @author eps
 */
public class EquipoModelImpl implements EquipoModel {

    //Para comunicarnos con el controlador
    private EquipoController controller;

    @Override
    public EquipoController getController() {
        return this.controller;
    }

    @Override
    public void setController(EquipoController controller) {
        this.controller = controller;
    }

    @Override
    public void nuevoEquipo(Equipo contacto) {
        //Debemos llamar la capa de persistencia para comunicarse con la base de datos
        EquipoDAO c = obtenerImplementacionEquipoDAO();
        c.create(contacto);
        //Avisamos cada vez que cambiamos la base de datos
        this.controller.fireDataModelChanged();
    }

    @Override
    public Equipo obtenerEquipo(String nombre) {
        //Debemos llamar la capa de persistencia para comunicarse con la base de datos
        EquipoDAO c = obtenerImplementacionEquipoDAO();
        return c.read(nombre);

    }

    @Override
    public void eliminarEquipo(Equipo contacto) {
        //Debemos llamar la capa de persistencia para comunicarse con la base de datos
        EquipoDAO c = obtenerImplementacionEquipoDAO();
        c.delete(contacto);
        //Avisamos cada vez que cambiamos la base de datos
        this.controller.fireDataModelChanged();
    }

    @Override
    public void actualizarEquipo(Equipo contacto) {
        //Debemos llamar la capa de persistencia para comunicarse con la base de datos
        EquipoDAO c = obtenerImplementacionEquipoDAO();
        c.update(contacto);
        //Avisamos cada vez que cambiamos la base de datos
        this.controller.fireDataModelChanged();
    }

    @Override
    public List<Equipo> obtenerEquipos() {
        //Debemos llamar la capa de persistencia para comunicarse con la base de datos
        EquipoDAO c = obtenerImplementacionEquipoDAO();
        return c.list();
    }

    public int comprobarEquipo(String nombre, String pais, String pos_grupo, String grupo) {
        List<Equipo> equipos = obtenerEquipos();
        
        String grupoAux = grupo;
        String paisAux = pais;
        int contador = 0;
        boolean encontrado = false;
        int i = 0;
        while (contador < 2 && !encontrado && i < equipos.size()) {
            if (equipos.get(i).getGrupo().equalsIgnoreCase(grupoAux)) {
                contador++;
                if(contador == 2){
                    return 2;
                }
            }

            if (equipos.get(i).getPais().equalsIgnoreCase(paisAux) && equipos.get(i).getPos_grupo().equalsIgnoreCase(pos_grupo)) {
                return 3;
            }
            
            if(equipos.get(i).getNombre().equalsIgnoreCase(nombre)){
                return 1;
            }
            
            i++;
        }    
        return 0;
    }

    protected EquipoDAO obtenerImplementacionEquipoDAO() {
        return new EquipoDAOJDBC();
    }

}
