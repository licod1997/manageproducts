/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.detail.ImportErrors;
import sample.detail.ImportSessionBeanRemote;
import sample.product.ProductSessionBeanRemote;
import sample.product.TblProduct;

/**
 *
 * @author Notebook
 */
public class SaveServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String importServlet = "ImportServlet";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            Object productObj = session.getAttribute("IMPORT");
            
            TblProduct product = (TblProduct) productObj;
            String id = product.getProductID();
            
            String price = request.getParameter("txtPrice");
            String quantity = request.getParameter("txtQuantity");
            
            Date date = new Date();
            
            double parsedPrice = 0;
            int parsedQuantity = 0;
            
            ImportErrors errors = new ImportErrors();
            boolean err = false;
            
            try {
                parsedPrice = Double.parseDouble(price);
            } catch (NumberFormatException e) {
                err = true;
                errors.setPrice("Product Price must be numbers");
                log("SaveServlet _ NumberFormat " + e.getMessage());
            }
            
            try {
                parsedQuantity = Integer.parseInt(quantity);
            } catch (NumberFormatException e) {
                err = true;
                errors.setQuantity("Product Quantity must be numbers");
                log("SaveServlet _ NumberFormat " + e.getMessage());
            }
            
            if (!err) {
                Context context = new InitialContext();
                
                Object importObj = context.lookup("ImpJNDI");
                ImportSessionBeanRemote importPoji = (ImportSessionBeanRemote) importObj;
                
                importPoji.insertImport(date, parsedPrice, parsedQuantity, id);
                
                Object proObj = context.lookup("ProJNDI");
                ProductSessionBeanRemote proPoji = (ProductSessionBeanRemote) proObj;
                
                proPoji.updateAfterImport(id, parsedPrice, parsedQuantity);
                
            } else {
                request.setAttribute("SAVE", errors);
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(importServlet);
            rd.forward(request, response);
        } catch (NamingException ex) {
            log("SaveServlet _ JNDI " + ex.getMessage());
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
