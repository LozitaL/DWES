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
public class EntPrestamo {
    private int idElemento;
    private int idUsuario;
    private Date fechaInicio;
    private Date fechaFin;
    
    private EntElemento elemento;
    private EntUsuario usuario;

    public EntPrestamo(int idElemento, int idUsuario, Date fechaInicio, Date fechaFin) {
        this.idElemento = idElemento;
        this.idUsuario = idUsuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
    
    
    
}
