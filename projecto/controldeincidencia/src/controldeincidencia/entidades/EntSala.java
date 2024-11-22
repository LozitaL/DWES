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
public class EntSala {
    private int codigo;
    private String nombre;
    private String descripcion;
    
    private ArrayList<EntUbicacion> ubicaciones;
    
    public EntSala(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
     * @return the ubicaciones
     */
    public ArrayList<EntUbicacion> getUbicaciones() {
        return ubicaciones;
    }

    /**
     * @param ubicaciones the ubicaciones to set
     */
    public void setUbicaciones(ArrayList<EntUbicacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
    
    public void addUbicacion(EntUbicacion ubicacion) {
        if (ubicaciones == null) {
            ubicaciones = new ArrayList();
        }
        
        ubicaciones.add(ubicacion);
    }
    
}
