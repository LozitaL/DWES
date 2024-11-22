/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salas;


import controldeincidencia.entidades.EntSala;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseluiscasadovalero
 */
public class MdSalas {
    
    private String datasource = "";

    public MdSalas(String datasource) {
        this.datasource = datasource;
    }
    
    
    public ArrayList<EntSala> getSalas() {
        ArrayList<EntSala> salida = new ArrayList();
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT * FROM sala");                
                ResultSet rs = ps.executeQuery();
                               
                while (rs.next()) {
                    
                    int codigo = rs.getInt("codigo");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    
                    
                    
                    EntSala sala = new EntSala(codigo, nombre);
                    
                    
                    salida.add(sala);
                    
                }
                      
            }   catch (Exception ex) {
                Logger.getLogger(MdSalas.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MdSalas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return salida;
    }
    
    public EntSala getSala(int codigoSala) {
        EntSala salida = null;
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT * FROM sala WHERE codigo = ?"); 
                ps.setInt(1, codigoSala);
                
                ResultSet rs = ps.executeQuery();
                               
                while (rs.next()) {
                    
                    int codigo = rs.getInt("codigo");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");

                    salida  = new EntSala(codigo, nombre);
                    
                    break;
      
                    
                }
                      
            }   catch (Exception ex) {
                Logger.getLogger(MdSalas.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MdSalas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return salida;
    }
    
    public boolean guardaSala(int codigoSala, String nombre) {
        
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                
                PreparedStatement ps = con.prepareStatement("UPDATE sala SET nombre = ? WHERE codigo = ?"); 
                ps.setString(1, nombre);
                ps.setInt(2, codigoSala);
                
                ps.executeUpdate();
                               
                return true;
                      
            }   catch (Exception ex) {
                Logger.getLogger(MdSalas.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MdSalas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return false;
    }
    
    public boolean crearSala(int codigoSala, String nombre) {
        
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                
                PreparedStatement ps = con.prepareStatement("INSERT INTO sala (nombre) values (?)"); 
                ps.setString(1, nombre);
                
                
                ps.executeUpdate();
                               
                return true;
                      
            }   catch (Exception ex) {
                Logger.getLogger(MdSalas.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MdSalas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return false;
    }
    
    public boolean eliminarSala(int codigoSala) {
        
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                
                PreparedStatement ps = con.prepareStatement("DELETE FROM sala WHERE codigo= ?"); 
                ps.setInt(1, codigoSala);
                
                
                ps.executeUpdate();
                               
                return true;
                      
            }   catch (Exception ex) {
                Logger.getLogger(MdSalas.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MdSalas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return false;
    }
    
}
