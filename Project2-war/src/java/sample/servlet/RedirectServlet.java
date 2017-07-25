/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Notebook
 */
public class RedirectServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String loginPage = "login.html";
    private final String invalidPage = "invalid.html";
    private final String testPage = "index.jsp";
    
    private final String loginServlet = "LoginServlet";
    private final String insertServlet = "InsertServlet";
    private final String updateServlet = "UpdateServlet";
    private final String deleteServlet = "DeleteServlet";
    private final String importServlet = "ImportServlet";
    private final String viewServlet = "ViewServlet";
    private final String saveServlet = "SaveServlet";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String button = request.getParameter("btAction");
            String url = loginPage;
            
            if (button == null){
                
            } else if (button.equals("Main")){
                url = loginPage;
            } else if (button.equals("Login")){
                url = loginServlet;
            } else if (button.equals("Insert")){
                url = insertServlet;
            } else if (button.equals("Update")){
                url = updateServlet;
            } else if (button.equals("Delete")){
                url = deleteServlet;
            } else if (button.equals("Import")){
                url = importServlet;
            } else if (button.equals("Save")){
                url = saveServlet;
            } else if (button.equals("Cancel")){
                url = viewServlet;
            } else {
                
            }
            
            RequestDispatcher rd= request.getRequestDispatcher(url);
            rd.forward(request, response);
        } finally {
            out.close();
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
