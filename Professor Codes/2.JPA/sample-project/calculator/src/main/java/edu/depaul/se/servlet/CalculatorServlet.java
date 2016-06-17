package edu.depaul.se.servlet;

import edu.depaul.se.calculator.business.Calculator;
import edu.depaul.se.log.jpa.DBLogger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Handles the URL request and exception handling associated with Calculator
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String lhs = request.getParameter("lhs");
            String rhs = request.getParameter("rhs");
            char operator = request.getParameter("operator").charAt(0);
            RequestDispatcher rd;

            int lhsNum = 0;
            int rhsNum = 0;
            
            try {
                lhsNum = Integer.parseInt(lhs);
                rhsNum = Integer.parseInt(rhs);
            } catch (NumberFormatException nfe) {
                out.println("<html>");
                out.println("<h1>");
                out.println("One or more values were not numeric, please enter only numeric values");
                out.println("</html>");
                return;
            }
            
            float result = 0;

            Calculator calculator = new Calculator();
            if (operator == '+') {
                result = calculator.add(lhsNum, rhsNum);
            } else if (operator == '-') {
                result = calculator.subtract(lhsNum, rhsNum);
            } else if (operator == '*') {
                result = calculator.multiply(lhsNum, rhsNum);
            } else {
                result = calculator.divide(lhsNum, rhsNum);
            }

            String content = lhs + operator + rhs + "=" + result;
            logToDB(content);

            out.println("<html>");
            out.println("<head>Calculator</head>");
            out.print("<h1>");
            out.println(content);
            out.println("</html>");
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @PersistenceContext(unitName="calculatorPU")
    private EntityManager em;

    @Resource
    private UserTransaction ut;
    
    private void logToDB(String message) {
        try {
            ut.begin();    
            DBLogger log = new DBLogger();
            log.setMessage(message);
            em.persist(log);
            ut.commit();
        } catch (Exception ex) {
            try {
                ut.rollback();
            } catch (Exception ex1) {
                Logger.getLogger(CalculatorServlet.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(CalculatorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
