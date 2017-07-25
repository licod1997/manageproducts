/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.product.ProductErrors;
import sample.product.ProductSessionBeanRemote;

/**
 *
 * @author Notebook
 */
public class UpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String viewServlet = "ViewServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String id = request.getParameter("txtProductID");
            String price = request.getParameter("txtPrice");
            String unit = request.getParameter("txtUnit");

            ProductErrors errors = new ProductErrors();
            boolean err = false;

            if (unit.length() > 20 || unit.length() < 1 || unit.equalsIgnoreCase("")) {
                err = true;
                errors.setUnit("Product Unit must be 1~20 characters");
            }

            float parsedPrice = 0;

            try {
                parsedPrice = Float.parseFloat(price);
            } catch (NumberFormatException ex) {
                err = true;
                errors.setPrice("Product Price must be numbers");
                log("UpdateServlet _ NumberFormat " + ex.getMessage());
            } 

            if (!err) {
                Context context = new InitialContext();

                Object obj = context.lookup("ProJNDI");
                ProductSessionBeanRemote poji = (ProductSessionBeanRemote) obj;

                poji.updateProduct(id, parsedPrice, unit);
            } else {
                request.setAttribute("UPDATE", errors);
            }

            RequestDispatcher rd = request.getRequestDispatcher(viewServlet);
            rd.forward(request, response);
        } catch (NamingException ex) {
            log("UpdateServlet _ JNDI " + ex.getMessage());
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
