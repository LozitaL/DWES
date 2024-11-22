/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controldeincidencia.entidades;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author joseluiscasadovalero
 */
public class EntIncidencia {
    private int codigo;
    private int idUsuarioCreacion;
    private int idElemento;
    private Date fechaCreacion;
    private String Descripcion;
    
    private EntUsuario usuarioCreacion;
    private EntElemento elemento;
    private ArrayList<EntHistorialIncidencia> historial = new ArrayList();

    public EntIncidencia(int codigo, int idUsuarioCreacion, int idElemento, Date fechaCreacion, String Descripcion) {
        this.codigo = codigo;
        this.idUsuarioCreacion = idUsuarioCreacion;
        this.idElemento = idElemento;
        this.fechaCreacion = fechaCreacion;
        this.Descripcion = Descripcion;
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
     * @return the idUsuarioCreacion
     */
    public int getIdUsuarioCreacion() {
        return idUsuarioCreacion;
    }

    /**
     * @param idUsuarioCreacion the idUsuarioCreacion to set
     */
    public void setIdUsuarioCreacion(int idUsuarioCreacion) {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    /**
     * @return the idElemento
     */
    public int getIdElemento() {
        return idElemento;
    }

    /**
     * @param idElemento the idElemento to set
     */
    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the usuarioCreacion
     */
    public EntUsuario getUsuarioCreacion() {
        return usuarioCreacion;
    }

    /**
     * @param usuarioCreacion the usuarioCreacion to set
     */
    public void setUsuarioCreacion(EntUsuario usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    /**
     * @return the elemento
     */
    public EntElemento getElemento() {
        return elemento;
    }

    /**
     * @param elemento the elemento to set
     */
    public void setElemento(EntElemento elemento) {
        this.elemento = elemento;
    }

    /**
     * @return the historial
     */
    public ArrayList<EntHistorialIncidencia> getHistorial() {
        return historial;
    }

    /**
     * @param historial the historial to set
     */
    public void setHistorial(ArrayList<EntHistorialIncidencia> historial) {
        this.historial = historial;
    }
    
    public void addHistorial(EntHistorialIncidencia nuevoHistorial) {
//        if (historial == null) {
//            historial = new ArrayList();
//        }
        
        historial.add(nuevoHistorial);
    }
    
}
