package edu.depaul.cdm.se.account.servlet;

import edu.depaul.cdm.se.account.service.AccountServiceRemote;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import javax.ejb.EJB;

/**
 * The servlet class to insert Account into database
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccount"})
public class CreateAccountServlet extends HttpServlet {

    @EJB
    private AccountServiceRemote accountService;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        try {
            String name = (String) request.getParameter("name");
            float balance = Float.parseFloat(request.getParameter("balance"));

            accountService.openAccount(name, balance);
            request.getRequestDispatcher("ListAccount").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
