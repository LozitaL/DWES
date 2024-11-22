
package Menu;
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

public class Mdmenu {
    private String datasource = "";

    public Mdmenu(String datasource) {
        this.datasource = datasource;
    }
        public ArrayList<EntMenu> getMenus() {
        ArrayList<EntMenu> salida = new ArrayList();
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT * FROM menu ORDER BY orden");                
                ResultSet rs = ps.executeQuery();
                               
                while (rs.next()) {
                    
                    int codigo = rs.getInt("codigo");
                    String nombre = rs.getString("nombre");
                    String url = rs.getString("url");
                    int orden = rs.getInt("orden");
                    
                    EntMenu menu = new EntMenu(codigo, nombre, url, orden);
                    
                    salida.add(menu);
                    
                }
                      
            }   catch (Exception ex) {
                Logger.getLogger(Mdmenu.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Mdmenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return salida;
    }
     
        public EntMenu getMenu(int codigomenu) {
        EntMenu salida = null;
        
        Connection con = null;
                
            try {

                // obtenemos el contexto de la aplicacion.
                Context ctx = new InitialContext();
                // Obtenemos la fuente de datos
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                // Abrimos la conexión con la base de datos.
                con = (Connection) ds.getConnection();
                
                // Preparamos la consulta.
                PreparedStatement ps = con.prepareStatement("SELECT * FROM menu WHERE codigo= ? ");    
                ps.setInt(1, codigomenu);
                // Ejecutamos la consulta y guardamos el resultado en el ResultSet
                ResultSet rs = ps.executeQuery();
                               
                // Recorremos todos los registros encontrados en la base de datos.
                while (rs.next()) {
                    // Sacamos los datos de cada registro.
                      int codigo = rs.getInt("codigo");
                    String nombre = rs.getString("nombre");
                    String url = rs.getString("url");
                    int orden = rs.getInt("orden");
                    
                    // Creamos una entidad nueva por cada registro
                    salida = new EntMenu(codigo, nombre, url, orden);
                    
                    break;
                    
                }
                      
            }   catch (Exception ex) {
                Logger.getLogger(EntMenu.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        // Cerramos la conexión para que no se quede ninguna abierta.
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(EntMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        // devolvemos el array de entidades
        return salida;
    }
}
