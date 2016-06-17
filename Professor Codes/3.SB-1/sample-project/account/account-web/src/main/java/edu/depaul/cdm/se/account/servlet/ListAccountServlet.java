package edu.depaul.cdm.se.account.servlet;

import edu.depaul.cdm.se.account.service.AccountServiceRemote;
import java.io.*;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 * The servlet class to list Accounts from database
 */
@WebServlet(name = "ListAccountServlet", urlPatterns = {"/ListAccount"})
public class ListAccountServlet extends HttpServlet {

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
            throws ServletException, IOException {
        try {
            request.setAttribute("accountList", accountService.getAllAccounts());

            //Forward to the jsp page for rendering
            request.getRequestDispatcher("ListAccount.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        } finally {
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
        return "ListPerson servlet";
    }
    // </editor-fold>
}
