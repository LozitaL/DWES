package elementos;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import Menu.EntMenu;
import Menu.Mdmenu;
import controldeincidencia.entidades.EntElemento;
import controldeincidencia.entidades.EntIncidencia;
import controldeincidencia.entidades.EntSala;
import controldeincidencia.entidades.EntTipo;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import tipos.MdTipos;


/**
 *
 * @author joseluiscasadovalero
 */
public class SvElementos extends HttpServlet {

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
            MdElementos modelo = new MdElementos("jdbc/incidencias");
            MdTipos modeloTipo = new MdTipos("jdbc/incidencias");
            MdElementos modeloElemento = new MdElementos("jdbc/incidencias");
             
           
            
            if (accion != null && accion.equals("guardar")) {
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                int iIdTipo = Integer.parseInt(request.getParameter("idtipo"));
                if (nombre!= null && codigo != null) {
                    int iCodigo = Integer.parseInt(codigo);
                    if (iCodigo > 0 && modelo.guardaElemento(iCodigo, nombre, descripcion, iIdTipo)) {
                        // En caso de guardar correctamente
                        ArrayList<EntElemento> elementos = modelo.getElementos();

                        request.setAttribute("elementosActuales", elementos);
                
                        RequestDispatcher dispacher = request.getRequestDispatcher("/vista/elementos/elementos.jsp");
                        dispacher.forward(request, response);
                    } else if (iCodigo == 0 && modelo.crearElemento(iCodigo, nombre, descripcion, iIdTipo)) {
                        // En caso de guardar correctamente
                        ArrayList<EntElemento> elementos = modelo.getElementos();

                        request.setAttribute("elementosActuales", elementos);
                
                        RequestDispatcher dispacher = request.getRequestDispatcher("/vista/elementos/elementos.jsp");
                        dispacher.forward(request, response);
                    } else {
                        // Si falla el guardado
                        EntElemento elemento = modelo.getElemento(iCodigo);
                
                        request.setAttribute("elementosActuales", elemento);

                        RequestDispatcher dispacher = request.getRequestDispatcher("/vista/elementos/elemento.jsp");
                        dispacher.forward(request, response);
                    }
                }
                
                
                
            } else if (accion != null && accion.equals("eliminar")) {
                int iCodigo = Integer.parseInt(codigo);
                if (iCodigo > 0 && modelo.eliminarElemento(iCodigo)) {
                    // En caso de guardar correctamente
                    ArrayList<EntElemento> salas = modelo.getElementos();

                    request.setAttribute("elementosActuales", salas);

                    RequestDispatcher dispacher = request.getRequestDispatcher("/vista/elementos/elementos.jsp");
                    dispacher.forward(request, response);
                }

            } else if (accion != null && accion.equals("mostrar")){
                int iCodigo = Integer.parseInt(codigo);
                if(iCodigo > 0) {
                  EntElemento meme = modelo.getElemento(iCodigo);
                  request.setAttribute("elementoactual", meme);
                  RequestDispatcher dispacher = request.getRequestDispatcher("/vista/elementos/elementos.jsp");
                  dispacher.forward(request, response);
                }
                
                RequestDispatcher dispacher = request.getRequestDispatcher("/vista/elementos/elemento.jsp");
                dispacher.forward(request, response);
                
            } else if(accion != null && accion.equals("nuevainc")){
                Date a = new Date();
                EntIncidencia inci = new EntIncidencia(0,0,0,a,"");
                request.setAttribute("incidenciaActual",inci);
                
                ArrayList<EntElemento> elemento = modeloElemento.getElementos();
                request.setAttribute("elementoActual", elemento);
                RequestDispatcher dispacher = request.getRequestDispatcher("/vista/incidencias/incidencia.jsp");
                dispacher.forward(request,response);
                
            } else if (accion != null && accion.equals("nuevo")) {
                
                EntElemento elemento = new EntElemento(0, "", "", 0);
                
                request.setAttribute("elementoActual", elemento);
                
                // Obtengo los tipos de elementos y los meto en una variable ("tiposActuales").
                ArrayList<EntTipo> tipos = modeloTipo.getTipos();
                request.setAttribute("tiposActuales", tipos);
                
                
                RequestDispatcher dispacher = request.getRequestDispatcher("/vista/elementos/elemento.jsp");
                dispacher.forward(request, response);
                
                
                
                
            } else if (codigo == null) {
                // Le pedimos al modelo todos los elementos / articulos
                ArrayList<EntElemento> elementos = modelo.getElementos();

                // Guardamos en la memoria de la solicitud la variable "articulosActuales"
                // con el array de todos los elementos.
                request.setAttribute("elementosActuales", elementos);

                // Pasamos el control de la solicitud a fichero articulos.jsp
                RequestDispatcher dispacher = request.getRequestDispatcher("/vista/elementos/elementos.jsp");
                dispacher.forward(request, response);
            } else  {
                int iCodigo = Integer.parseInt(codigo);
                
                EntElemento elemento = modelo.getElemento(iCodigo);
                
                request.setAttribute("elementoActual", elemento);
                
                // Obtengo los tipos de elementos y los meto en una variable ("tiposActuales").
                ArrayList<EntTipo> tipos = modeloTipo.getTipos();
                request.setAttribute("tiposActuales", tipos);
                
                
                
                RequestDispatcher dispacher = request.getRequestDispatcher("/vista/elementos/elemento.jsp");
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
