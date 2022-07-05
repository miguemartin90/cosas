/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author eps
 */
public class EquipoImpl implements Equipo {

    private String nombre;
    private String pais;
    private String pos_grupo;
    private String grupo;

    public EquipoImpl(String nombre, String pais, String pos_grupo, String grupo) {
        this.nombre = nombre;
        this.pais = pais;
        this.pos_grupo = pos_grupo;
        this.grupo = grupo;
    }

    public EquipoImpl(String nombre) {
        this.nombre = nombre;
        this.pais = null;
        this.pos_grupo = null;
        this.grupo = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPos_grupo() {
        return pos_grupo;
    }

    public void setPos_grupo(String pos_grupo) {
        this.pos_grupo = pos_grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
