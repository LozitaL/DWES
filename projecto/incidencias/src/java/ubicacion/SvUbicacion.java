/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ubicacion;

import Menu.EntMenu;
import Menu.Mdmenu;
import controldeincidencia.entidades.EntUbicacion;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author joseluiscasadovalero
 */
public class SvUbicacion extends HttpServlet {

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
            throws ServletException, IOException {
        //Modelo menu,
                    Mdmenu md1 = new Mdmenu("jdbc/incidencias");
                    ArrayList<EntMenu> mMenu = md1.getMenus();
                    request.setAttribute("menu", mMenu);
        // Indicamos que la respuesta va a ser en HTML
            response.setContentType("text/html;charset=UTF-8");

            String codigo = request.getParameter("codigo");
            
            // Obtenemos el modelo
            MdUbicaciones modelo = new MdUbicaciones("jdbc/incidencias");
            
            if (codigo == null) {
                // Le pedimos al modelo todos las ubicaciones
                ArrayList<EntUbicacion> ubicaciones = modelo.getUbicaciones();

                // Guardamos en la memoria de la solicitud la variable "ubicacionesActuales"
                // con el array de todos los elementos.
                request.setAttribute("ubicacionesActuales", ubicaciones);

                // Pasamos el control de la solicitud a fichero ubicaciones.jsp
                RequestDispatcher dispacher = request.getRequestDispatcher("/vista/ubicaciones/ubicaciones.jsp");
                dispacher.forward(request, response);
            } else {
                int iCodigo = Integer.parseInt(codigo);
                EntUbicacion ub = modelo.getUbicacion(iCodigo);
                
                request.setAttribute("ubicacionActual", ub);
                
                RequestDispatcher dispacher = request.getRequestDispatcher("/vista/ubicaciones/ubicacion.jsp");
                dispacher.forward(request, response);
                
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
        processRequest(request, response);
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
        processRequest(request, response);
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
