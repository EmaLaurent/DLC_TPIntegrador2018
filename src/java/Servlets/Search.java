/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.DatosTermino;
import Entidades.ResultadoDeBusqueda;
import Logica.OAHashtableReader;
import Logica.ProcesadorConsulta;
import Logica.TSB_OAHashtable;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author milen
 */
public class Search extends HttpServlet
{
    private final String PATHVOCABULARIO = "D:/Usuarios/Ema/Mis Documentos/Facu UTN/2018/DLC/DLC_TPIntegrador2018/tabla.dat";
//    private final String PATHVOCABULARIO = "d:\\Users\\Manuel\\Desktop\\UTN\\[DLC] Diseño de Lenguajes de Consulta\\TPIntegrador\\HashTable\\tabla.dat";
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
    throws ServletException, IOException
    {
        String dest = "/error.html";
        TSB_OAHashtable<String,DatosTermino> hash;
        HttpSession session = request.getSession();
        try
        {
            if(session.getAttribute("tabla") == null)
            {
                OAHashtableReader slr = new OAHashtableReader(PATHVOCABULARIO);
                hash = (TSB_OAHashtable<String,DatosTermino>) slr.read();
                session.setAttribute("tabla", hash);
            }
            else
                hash = (TSB_OAHashtable<String,DatosTermino>) session.getAttribute("tabla");
            String busqueda = request.getParameter("buscar_txt");
            ProcesadorConsulta pc = new ProcesadorConsulta(hash);
            ArrayList<ResultadoDeBusqueda> resultados = pc.leerConsulta(busqueda);
            if(resultados == null || resultados.isEmpty())
               ; //proximamente (aca informaremos que no existen resultados para esa busqueda
            else
                request.setAttribute("resultados", resultados);
            request.setAttribute("busqueda", busqueda);
            dest = "/busqueda.jsp";
            
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e.getMessage());    
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        ServletContext app = this.getServletContext();
        RequestDispatcher disp = app.getRequestDispatcher(dest);
        disp.forward(request, response);
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
