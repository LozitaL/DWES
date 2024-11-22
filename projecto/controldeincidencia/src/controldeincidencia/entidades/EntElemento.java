/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controldeincidencia.entidades;

import java.util.ArrayList;

/**
 *
 * @author joseluiscasadovalero
 */
public class EntElemento {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int idTipo;
    
    private EntTipo tipo; 
    private ArrayList<EntIncidencia> incidencias;

    public EntElemento(int codigo, String nombre, String descripcion, int idTipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idTipo = idTipo;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the idTipo
     */
    public int getIdTipo() {
        return idTipo;
    }

    /**
     * @param idTipo the idTipo to set
     */
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    /**
     * @return the tipo
     */
    public EntTipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(EntTipo tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the incidencias
     */
    public ArrayList<EntIncidencia> getIncidencias() {
        return incidencias;
    }

    /**
     * @param incidencias the incidencias to set
     */
    public void setIncidencias(ArrayList<EntIncidencia> incidencias) {
        this.incidencias = incidencias;
    }
    
    public void addIncidencia(EntIncidencia incidencia) {
        if (incidencias == null) {
            incidencias = new ArrayList();
        }
        incidencias.add(incidencia);
    }
    
}
