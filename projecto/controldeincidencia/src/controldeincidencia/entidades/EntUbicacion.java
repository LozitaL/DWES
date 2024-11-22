/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controldeincidencia.entidades;

import java.util.Date;

/**
 *
 * @author joseluiscasadovalero
 */
public class EntUbicacion {
    private int codigo;
    private int idSala;
    private int idElemento;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    
    private EntSala sala;
    private EntElemento elemento;

    public EntUbicacion(int codigo, int idSala, int idElemento, String descripcion, Date fechaInicio, Date fechaFin) {
        this.codigo = codigo;
        this.idSala = idSala;
        this.idElemento = idElemento;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
     * @return the idSala
     */
    public int getIdSala() {
        return idSala;
    }

    /**
     * @param idSala the idSala to set
     */
    public void setIdSala(int idSala) {
        this.idSala = idSala;
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
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the sala
     */
    public EntSala getSala() {
        return sala;
    }

    /**
     * @param sala the sala to set
     */
    public void setSala(EntSala sala) {
        this.sala = sala;
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
    
    
}
