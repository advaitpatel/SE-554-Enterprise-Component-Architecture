package edu.depaul.cdm.se.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TransferFundsServlet", urlPatterns = {"/TransferFunds"})
public class TransferFundsServlet extends HttpServlet {

    @Resource(mappedName = "jms/javaee6/transferFundsQ")
    private Queue queue;
    @Resource(mappedName = "jms/javaee6/ConnectionFactory")
    private QueueConnectionFactory queueConnectionFactory;

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
        try {
            QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
            queueConnection.start();
            QueueSession queueSession = queueConnection.createQueueSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            QueueSender sender = queueSession.createSender(queue);

            StringBuilder builder = new StringBuilder();
            builder.append(request.getParameter("fromAccount"));
            builder.append(";");
            builder.append(request.getParameter("toAccount"));
            builder.append(";");
            builder.append(request.getParameter("amount"));
            TextMessage msg = queueSession.createTextMessage(builder.toString());

            sender.send(msg);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TransferFundsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TransferFundsServlet at " + request.getContextPath() + "</h1>");
            out.println("Message sent: ");
            out.println(builder);
            out.println("</body>");
            out.println("</html>");
        } catch (JMSException je) {
        } finally {
            out.close();
        }
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
