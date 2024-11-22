/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipos;

import controldeincidencia.entidades.EntTipo;
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
public class MdTipos {
    
    private String datasource = "";

    public MdTipos(String datasource) {
        this.datasource = datasource;
    }
    
    
    public ArrayList<EntTipo> getTipos() {
        ArrayList<EntTipo> salida = new ArrayList();
        
        Connection con = null;
                
            try {

                // obtenemos el contexto de la aplicacion.
                Context ctx = new InitialContext();
                // Obtenemos la fuente de datos
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                // Abrimos la conexión con la base de datos.
                con = (Connection) ds.getConnection();
                
                // Preparamos la consulta.
                PreparedStatement ps = con.prepareStatement("SELECT * FROM tipo");    
                // Ejecutamos la consulta y guardamos el resultado en el ResultSet
                ResultSet rs = ps.executeQuery();
                               
                // Recorremos todos los registros encontrados en la base de datos.
                while (rs.next()) {
                    // Sacamos los datos de cada registro.
                    int codigo = rs.getInt("codigo");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    
                    // Creamos una entidad nueva por cada registro
                    EntTipo tipo = new EntTipo(codigo, nombre, descripcion);
                    // Añadimos la entidad al array que devolveremos.
                    salida.add(tipo);
                    
                }
                      
            }   catch (Exception ex) {
                Logger.getLogger(SvTipos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        // Cerramos la conexión para que no se quede ninguna abierta.
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(SvTipos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        // devolvemos el array de entidades
        return salida;
    }
    
    public EntTipo getTipo(int codigoTipo) {
        EntTipo salida = null;
        
        Connection con = null;
                
            try {

                // obtenemos el contexto de la aplicacion.
                Context ctx = new InitialContext();
                // Obtenemos la fuente de datos
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                // Abrimos la conexión con la base de datos.
                con = (Connection) ds.getConnection();
                
                // Preparamos la consulta.
                PreparedStatement ps = con.prepareStatement("SELECT * FROM tipo WHERE codigo= ? ");    
                ps.setInt(1, codigoTipo);
                // Ejecutamos la consulta y guardamos el resultado en el ResultSet
                ResultSet rs = ps.executeQuery();
                               
                // Recorremos todos los registros encontrados en la base de datos.
                while (rs.next()) {
                    // Sacamos los datos de cada registro.
                    int codigo = rs.getInt("codigo");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    
                    // Creamos una entidad nueva por cada registro
                    salida = new EntTipo(codigo, nombre, descripcion);
                    
                    break;
                    
                }
                      
            }   catch (Exception ex) {
                Logger.getLogger(SvTipos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        // Cerramos la conexión para que no se quede ninguna abierta.
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(SvTipos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        // devolvemos el array de entidades
        return salida;
    }
    
}
