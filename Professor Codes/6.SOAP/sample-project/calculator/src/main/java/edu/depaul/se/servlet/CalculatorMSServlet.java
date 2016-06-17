package edu.depaul.se.servlet;

import edu.depaul.se.xml.CalculatorRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import static edu.depaul.se.xml.CalculatorRequest.CalculatorOperation;
import javax.jms.Destination;
import javax.jms.MessageConsumer;

@WebServlet("/CalculatorMSServlet")
public class CalculatorMSServlet extends HttpServlet {

    @Resource(mappedName = "jms/CalculatorQ")
    private Queue queue;
    @Resource(mappedName = "jms/ConnectionFactory")    
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
        QueueConnection queueConnection = null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String lhs = request.getParameter("lhs");
            String rhs = request.getParameter("rhs");
            char operator = request.getParameter("operator").charAt(0);

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


            queueConnection = queueConnectionFactory.createQueueConnection();
            queueConnection.start();
            QueueSession queueSession = queueConnection.createQueueSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            QueueSender sender = queueSession.createSender(queue);

            CalculatorOperation operation;
            // Send message
            if (operator == '+') {
                operation = CalculatorOperation.ADD;
            } else if (operator == '-') {
                operation = CalculatorOperation.SUBTRACT;
            } else if (operator == '*') {
                operation = CalculatorOperation.MULTIPLY;
            } else {
                operation = CalculatorOperation.DIVIDE;
            }

            CalculatorRequest c = new CalculatorRequest(lhsNum, rhsNum, operation);

            StringWriter writer = new StringWriter();


            JAXBContext context = JAXBContext.newInstance(CalculatorRequest.class);
            Marshaller m = context.createMarshaller();
            m.marshal(c, writer);
            
            TextMessage msg = queueSession.createTextMessage(writer.toString());

            Destination replyQueue = queueSession.createTemporaryQueue();
            MessageConsumer responseConsumer = queueSession.createConsumer(replyQueue);

            msg.setJMSReplyTo(replyQueue);
            sender.send(msg);

            TextMessage reply = (TextMessage) responseConsumer.receive(10000);
            
            out.println("<html>");
            out.println("<h1>");
            out.print("Message sent: ");
            out.println(writer.toString());
            out.print("<p>");
            
            if (reply != null) {
                out.print("Result is " + reply.getText());
            }
            
            out.println("</html>");

        } catch (Exception  e) {
            out.println("<html>");
            out.println("<h1>");
            out.println("Error processing request: " + e.toString());
            out.println("</html>");
            throw new RuntimeException(e);
        } finally {
            try {
                if (queueConnection != null) {
                    queueConnection.close();
                }
            } catch (JMSException e) { //ignore
            }
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
