package edu.depaul.cdm.se.servlet.ejb;

import edu.depaul.cdm.se.sbejb.IStatefulCounter;
import edu.depaul.cdm.se.sbejb.IStatelessCounter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Demo stateless vs stateful session and multi threading from web container
 */
@WebServlet(name = "CounterServlet", urlPatterns = {"/CounterServlet"})
public class CounterServlet extends HttpServlet {

    @EJB
    private IStatelessCounter instanceSLCounter;
    
    @EJB
    private IStatefulCounter instanceSFCounter;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        instanceSLCounter.increment();
        instanceSFCounter.increment();

        out.println("<h1>Servlet CounterServlet at " + request.getContextPath() + "</h1>");
        out.println("<h2>StatelessCounter:" + instanceSLCounter.count() + "</h2>");
        out.println("<h2>StatefulCounter:" + instanceSFCounter.count() + "</h2>");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
