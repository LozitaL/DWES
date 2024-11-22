package salas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import Menu.EntMenu;
import Menu.Mdmenu;
import controldeincidencia.entidades.EntElemento;
import controldeincidencia.entidades.EntSala;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;


/**
 *
 * @author joseluiscasadovalero
 */
public class SvSalas extends HttpServlet {

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
            String accion = request.getParameter("accion");
            

            // Obtenemos el modelo
            MdSalas modelo = new MdSalas("jdbc/incidencias");
            
            
            if (accion != null && accion.equals("guardar")) {
                String nombre = request.getParameter("nombre");
                if (nombre!= null && codigo != null) {
                    int iCodigo = Integer.parseInt(codigo);
                    if (iCodigo > 0 && modelo.guardaSala(iCodigo, nombre)) {
                        // En caso de guardar correctamente
                        ArrayList<EntSala> salas = modelo.getSalas();

                        request.setAttribute("salasActuales", salas);
                
                        RequestDispatcher dispacher = request.getRequestDispatcher("/vista/salas/salas.jsp");
                        dispacher.forward(request, response);
                    } else if (iCodigo == 0 && modelo.crearSala(iCodigo, nombre)) {
                        // En caso de guardar correctamente
                        ArrayList<EntSala> salas = modelo.getSalas();

                        request.setAttribute("salasActuales", salas);
                
                        RequestDispatcher dispacher = request.getRequestDispatcher("/vista/salas/salas.jsp");
                        dispacher.forward(request, response);
                    } else {
                        // Si falla el guardado
                        EntSala sala = modelo.getSala(iCodigo);
                
                        request.setAttribute("salaActual", sala);

                        RequestDispatcher dispacher = request.getRequestDispatcher("/vista/salas/sala.jsp");
                        dispacher.forward(request, response);
                    }
                }
                
                
                
            } else if (accion != null && accion.equals("eliminar")) {
                int iCodigo = Integer.parseInt(codigo);
                if (iCodigo > 0 && modelo.eliminarSala(iCodigo)) {
                    // En caso de guardar correctamente
                    ArrayList<EntSala> salas = modelo.getSalas();

                    request.setAttribute("salasActuales", salas);

                    RequestDispatcher dispacher = request.getRequestDispatcher("/vista/salas/salas.jsp");
                    dispacher.forward(request, response);
                }

            } else if (accion != null && accion.equals("nueva")) {
                
                EntSala sala = new EntSala(0, "");
                
                request.setAttribute("salaActual", sala);
                
                
                RequestDispatcher dispacher = request.getRequestDispatcher("/vista/salas/sala.jsp");
                dispacher.forward(request, response);
                
                
                
                
            } else if (codigo == null) {
                // Le pedimos al modelo todos los elementos / articulos
                ArrayList<EntSala> salas = modelo.getSalas();

                // Guardamos en la memoria de la solicitud la variable "articulosActuales"
                // con el array de todos los elementos.
                request.setAttribute("salasActuales", salas);

                // Pasamos el control de la solicitud a fichero articulos.jsp
                RequestDispatcher dispacher = request.getRequestDispatcher("/vista/salas/salas.jsp");
                dispacher.forward(request, response);
            } else {
                int iCodigo = Integer.parseInt(codigo);
                
                EntSala sala = modelo.getSala(iCodigo);
                
                request.setAttribute("salaActual", sala);
                
                
                RequestDispatcher dispacher = request.getRequestDispatcher("/vista/salas/sala.jsp");
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
