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
public class EntUsuario {
    private int codigo;
    private String nombre;
    private String correo;
    private String telefono;
    
    private ArrayList<EntPrestamo> prestamos;

    public EntUsuario() {
    }

    
    public EntUsuario(int codigo, String nombre, String correo, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
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
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the prestamos
     */
    public ArrayList<EntPrestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * @param prestamos the prestamos to set
     */
    public void setPrestamos(ArrayList<EntPrestamo> prestamos) {
        this.prestamos = prestamos;
    }
    
    public void addPrestamo(EntPrestamo nuevoPrestamo){
        if (prestamos == null) {
            prestamos = new ArrayList();
        }
        
        prestamos.add(nuevoPrestamo);
    }
    
}
