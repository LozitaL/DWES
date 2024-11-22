/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubicacion;

import elementos.MdElementos;
import controldeincidencia.entidades.EntElemento;
import controldeincidencia.entidades.EntSala;
import controldeincidencia.entidades.EntUbicacion;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import salas.MdSalas;

/**
 *
 * @author joseluiscasadovalero
 */
public class MdUbicaciones {
    
    private String datasource = "";

    public MdUbicaciones(String datasource) {
        this.datasource = datasource;
    }
    
    
    public ArrayList<EntUbicacion> getUbicaciones() {
        ArrayList<EntUbicacion> salida = new ArrayList();
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT * FROM ubicacion");                
                ResultSet rs = ps.executeQuery();
                               
                while (rs.next()) {
                    
                    int codigo = rs.getInt("codigo");
                    int idsala = rs.getInt("idSala");
                    int idelelemento = rs.getInt("idElemento");
                    String descripcion = rs.getString("descripcion");
                    Date fechaInicio = rs.getDate("fechaInicio");
                    Date fechaFin = rs.getDate("fechaFin");
                    
                    
                    
                    EntUbicacion ubicacion = new EntUbicacion(codigo, idsala, idelelemento, descripcion, fechaInicio, fechaFin);
                    
                    
                    salida.add(ubicacion);
                    
                }
                
                
                MdSalas mSalas = new MdSalas(datasource);
                // Obtenemos todas las salas.
                ArrayList<EntSala> arSalas = mSalas.getSalas();
                
                MdElementos mElementos = new MdElementos(datasource);
                // Obtenemos todos los elementos.
                ArrayList<EntElemento> arElementos = mElementos.getElementos();
                
                
                for (int i = 0; i < salida.size(); i++) {
                    EntUbicacion ub = salida.get(i);
                    for (int j = 0; j<arSalas.size(); j++) {
                        EntSala sa = arSalas.get(j);
                        if (ub.getIdSala() == sa.getCodigo()) {
                            ub.setSala(sa);
                            break;
                        }
                     }
                    for (int j = 0; j<arElementos.size(); j++) {
                        EntElemento ele = arElementos.get(j);
                        if (ub.getIdElemento()== ele.getCodigo()) {
                            ub.setElemento(ele);
                            break;
                        }
                     }
                }
                
                     
            }   catch (Exception ex) {
                Logger.getLogger(MdUbicaciones.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MdUbicaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return salida;
    }
    
    public EntUbicacion getUbicacion(int codigoUbi) {
        EntUbicacion salida = null;
        
        Connection con = null;
                
            try {

                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("java:comp/env/"+this.datasource);
                con = (Connection) ds.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT * FROM ubicacion where codigo = ?");
                ps.setInt(1, codigoUbi);
                ResultSet rs = ps.executeQuery();
                               
                while (rs.next()) {
                    
                    int codigo = rs.getInt("codigo");
                    int idsala = rs.getInt("idSala");
                    int idelelemento = rs.getInt("idElemento");
                    String descripcion = rs.getString("descripcion");
                    Date fechaInicio = rs.getDate("fechaInicio");
                    Date fechaFin = rs.getDate("fechaFin");
                    
                    
                    
                    salida  = new EntUbicacion(codigo, idsala, idelelemento, descripcion, fechaInicio, fechaFin);
                    
                    
                }
                
                if (salida != null) {
                
                MdSalas mSalas = new MdSalas(datasource);
                // Obtenemos todas las salas.
                EntSala sala = mSalas.getSala(salida.getIdSala());
                
                salida.setSala(sala);
                
                MdElementos mElementos = new MdElementos(datasource);
                // Obtenemos todos los elementos.
                EntElemento elemento = mElementos.getElemento(salida.getIdElemento());
                
                salida.setElemento(elemento);
                
                
                
                }
                
                     
            }   catch (Exception ex) {
                Logger.getLogger(MdUbicaciones.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MdUbicaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
        return salida;
    }
    
}
