/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Incidencias;

import Menu.EntMenu;
import Menu.Mdmenu;
import controldeincidencia.entidades.EntIncidencia;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2º DAW
 */
public class SvIncidencias extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        //Modelo menu,
        Mdincidencias md1 = new Mdincidencias("jdbc/incidencias");
        ArrayList<EntIncidencia> Inci = md1.getIncidencias();
        request.setAttribute("incidencias", Inci);
        // Indicamos que la respuesta va a ser en HTML
        response.setContentType("text/html;charset=UTF-8");

        //Modelo menu,
         Mdmenu md2 = new Mdmenu("jdbc/incidencias");
         ArrayList<EntMenu> mMenu = md2.getMenus();
         request.setAttribute("menu", mMenu);
        
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<EntIncidencia> incidencias = md1.getIncidencias();
        request.setAttribute("incidenciasActuales", incidencias);
        
         // Pasamos el control de la solicitud a fichero usuarios.jsp
        RequestDispatcher dispacher = request.getRequestDispatcher("/vista/incidencias/incidencias.jsp");
        dispacher.forward(request, response);
        
        String codigo = request.getParameter("codigo");
        String accion = request.getParameter("accion");

        if (accion != null && accion.equals("guardar")) {
            String descripcion = request.getParameter("descripcion");
            int idUsuarioCreacion = Integer.parseInt(request.getParameter("idUsuarioCreacion"));
            int idElemento = Integer.parseInt(request.getParameter("idElemento"));

            String fechaCreacion = request.getParameter("fechaCreacion");
            Date dfecha = null;

            if (fechaCreacion != null) {
                dfecha = Date.valueOf(fechaCreacion);
            }
            if (idUsuarioCreacion != 0 && codigo != null) {
                int iCodigo = Integer.parseInt(codigo);
                if (iCodigo > 0 && md1.guardaIncidencia(iCodigo, idUsuarioCreacion, idElemento, dfecha, descripcion)) {
                    // En caso de guardar correctamente

                    request.setAttribute("incidenciasActuales", incidencias);

                    dispacher.forward(request, response);
                }
            } else if (codigo == null) {
                // Le pedimos al modelo todos los elementos / articulos

                // Guardamos en la memoria de la solicitud la variable "articulosActuales"
                // con el array de todos los elementos.
                request.setAttribute("incidenciasActuales", incidencias);

                // Pasamos el control de la solicitud a fichero articulos.jsp
                dispacher.forward(request, response);
            }
        }
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SvIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(SvIncidencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
