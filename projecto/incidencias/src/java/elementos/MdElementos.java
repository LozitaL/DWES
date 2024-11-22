/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elementos;

import controldeincidencia.entidades.EntElemento;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joseluiscasadovalero
 */
public class MdElementos {
    
    private String datasource = "";

    public MdElementos(String datasource) {
        this.datasource = datasource;
    }
    
    
    public ArrayList<EntElemento> getElementos() {
        ArrayList<EntElemento> salida = new ArrayList();
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT * FROM elemento");                
                ResultSet rs = ps.executeQuery();
                               
                while (rs.next()) {
                    
                    int codigo = rs.getInt("codigo");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    int tipo = rs.getInt("idTipo");
                    
                    EntElemento elem = new EntElemento(codigo, nombre, descripcion, tipo);
                    
                    salida.add(elem);
                    
                }
                      
            }   catch (Exception ex) {
                Logger.getLogger(MdElementos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MdElementos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return salida;
    }
    
    public EntElemento getElemento(int codigoEle) {
        EntElemento salida = null;
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT * FROM elemento where codigo = ?");        
                ps.setInt(1, codigoEle);
                ResultSet rs = ps.executeQuery();
                               
                while (rs.next()) {
                    
                    int codigo = rs.getInt("codigo");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    int tipo = rs.getInt("idTipo");
                    
                    salida = new EntElemento(codigo, nombre, descripcion, tipo);

                    
                }
                      
            }   catch (Exception ex) {
                Logger.getLogger(MdElementos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MdElementos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return salida;
    }
   
    
    public boolean guardaElemento(int codigoSala, String nombre, String descripcion, int idTipo) {
        
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                
                PreparedStatement ps = con.prepareStatement("UPDATE elemento SET nombre = ?, descripcion = ?, idTipo = ? WHERE codigo = ?"); 
                ps.setString(1, nombre);
                ps.setString(2, descripcion);
                ps.setInt(3, idTipo);
                ps.setInt(4, codigoSala);
                
                ps.executeUpdate();
                               
                return true;
                      
            }   catch (Exception ex) {
                Logger.getLogger(MdElementos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MdElementos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return false;
    }
    
    public boolean crearElemento(int codigoSala, String nombre, String descripcion, int idTipo) {
        
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                
                PreparedStatement ps = con.prepareStatement("INSERT INTO elemento (nombre, descripcion, idTipo) values (?,?,?)"); 
                ps.setString(1, nombre);
                ps.setString(2, descripcion);
                ps.setInt(3, idTipo);
                
                
                ps.executeUpdate();
                               
                return true;
                      
            }   catch (Exception ex) {
                Logger.getLogger(MdElementos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MdElementos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return false;
    }
    
    public boolean eliminarElemento(int codigoElemento) {
        
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                
                PreparedStatement ps = con.prepareStatement("DELETE FROM elemento WHERE codigo= ?"); 
                ps.setInt(1, codigoElemento);
                
                
                ps.executeUpdate();
                               
                return true;
                      
            }   catch (Exception ex) {
                Logger.getLogger(MdElementos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MdElementos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return false;
    }
}
