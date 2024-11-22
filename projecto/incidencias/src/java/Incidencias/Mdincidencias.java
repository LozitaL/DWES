package Incidencias;

import controldeincidencia.entidades.EntIncidencia;
import elementos.MdElementos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Mdincidencias {

    private String datasource;

    public Mdincidencias(String datasource) {
        this.datasource = datasource;
    }
    public boolean guardaIncidencia(int codigo, int idUsuarioCreacion, int idElemento, Date fechaCreacion, String descripcion) {
        
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                
                PreparedStatement ps = con.prepareStatement("UPDATE incidencia SET codigo = ?, idUsuarioCreacion = ?, idElemento = ?, fechaCreacion = ?, descripcion = ?,WHERE codigo = ?"); 
                ps.setInt(0, codigo);
                ps.setInt(1, idUsuarioCreacion);
                ps.setInt(3, idElemento);
                ps.setDate(4, fechaCreacion);
                ps.setString(5, descripcion);
                
                ps.executeUpdate();
                               
                return true;
                      
            }   catch (Exception ex) {
                Logger.getLogger(Mdincidencias.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Mdincidencias.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return false;
    }
   public EntIncidencia getIncidencia() {
        EntIncidencia salida = null;
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT * FROM incidencias");        
                ResultSet rs = ps.executeQuery();
                               
                while (rs.next()) {
                    
                    int codigo = rs.getInt("codigo");
                    int idUsuarioCreacion = rs.getInt("idUsuarioCreacion");
                    int idElemento = rs.getInt("idElemento");
                    Date fechaCreacion = rs.getDate("fechaCreacion");
                    String Descripcion = rs.getString("Descripcion");
                    
                    salida = new EntIncidencia(codigo,idUsuarioCreacion,idElemento,fechaCreacion,Descripcion);

                    
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
    
    public boolean crearIncidencia(int codigo, int idUsuarioCreacion, int idElemento, Date fechaCreacion, String Descripcion) {
        
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                
                PreparedStatement ps = con.prepareStatement("INSERT INTO incidencia (codigo, idUsuarioCreacion, idElemento, fechaCreacion, Descripcion) values (?,?,?,?,?)"); 
                ps.setInt(1,codigo);
                ps.setInt(2,idUsuarioCreacion);
                ps.setInt(3, idElemento);
                ps.setDate(4, fechaCreacion);
                ps.setString(5, Descripcion);
                
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
    
     public ArrayList<EntIncidencia> getIncidencias() {
        ArrayList<EntIncidencia> salida = new ArrayList();
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT * FROM incidencia");                
                ResultSet rs = ps.executeQuery();
                               
                while (rs.next()) {
                    
                     int codigo = rs.getInt("codigo");
                    int idUsuarioCreacion = rs.getInt("idUsuarioCreacion");
                    int idElemento = rs.getInt("idElemento");
                    Date fechaCreacion = rs.getDate("fechaCreacion");
                    String Descripcion = rs.getString("Descripcion");
                    
                    EntIncidencia elem = new EntIncidencia(codigo,idUsuarioCreacion,idElemento,fechaCreacion,Descripcion);
                    
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
}
