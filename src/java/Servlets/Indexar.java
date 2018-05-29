/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.DatosTermino;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica.Indexer;
import Logica.OAHashtableReader;
import Logica.TSB_OAHashtable;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Emanuel Laurent
 */
@MultipartConfig
public class Indexar extends HttpServlet
{
//    private final String PATHVOCABULARIO = "D:/Usuarios/Ema/Mis Documentos/Facu UTN/2018/DLC/DLC_TPIntegrador2018/tabla.dat";
    private final String PATHVOCABULARIO = "E:/Users/milen/Documents/Facu UTN/2018/DLC/DLC_TPIntegrador2018/tabla.dat";
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
        //Obtenemos el archivo cargado en el jsp junto con sus datos
        Part filePart = request.getPart("file_btn");
        String fileName = filePart.getSubmittedFileName();
        //Obtenemos el path donde se guardara el archivo
        File uploads = new File(getServletContext().getInitParameter("file-upload"));
        File file = new File(uploads, fileName);
        TSB_OAHashtable hash;
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
            Indexer indx = new Indexer(hash);
            //Leemos el archivo cargado y lo guardamos en el directorio predefinido
            InputStream fileContent = filePart.getInputStream();
            Files.copy(fileContent, file.toPath());
            indx.indexarArchivo(file);
            dest = "/index.jsp";
        }
//        try
//        {
//            indx.indexarDirectorio();
//            tablaHash = indx.getHash();
//            request.setAttribute("cantPalabras",tablaHash.size());
//            dest = "/index.jsp";
//        }
        catch(IOException e)
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
