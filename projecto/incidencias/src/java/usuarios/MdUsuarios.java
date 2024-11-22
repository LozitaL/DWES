/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;


import controldeincidencia.entidades.EntUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author joseluiscasadovalero
 */
public class MdUsuarios {
    
    private String datasource = "";

    public MdUsuarios(String datasource) {
        this.datasource = datasource;
    }
    
    
    public ArrayList<EntUsuario> getUsuarios() {
        ArrayList<EntUsuario> salida = new ArrayList();

        Connection con = null;
        
        try {
            
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
            con = (Connection) ds.getConnection();
            
            PreparedStatement pr = con.prepareStatement("SELECT * FROM usuario");
            
            ResultSet rs = pr.executeQuery();
            
            
            while(rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String tlf = rs.getString("telefono");
                        
                
                EntUsuario usr = new EntUsuario(codigo, nombre, correo, tlf);
                
                
                salida.add(usr);
            }
            
            
            
            
            
        } catch (NamingException ex) {
            Logger.getLogger(MdUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MdUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MdUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return salida;
        
    }
    
    
}
