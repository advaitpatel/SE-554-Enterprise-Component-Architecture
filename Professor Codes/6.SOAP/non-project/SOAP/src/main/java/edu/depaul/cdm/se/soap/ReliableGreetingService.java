package edu.depaul.cdm.se.soap;

import java.util.Hashtable;
import java.util.Map;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceContext;

/**
 * Reliable Message sample
 * Special note to wsit file in WEB-INF directory wsp policy element
 * NOTE:  wsit is Metro specific feature
 */
@WebService(serviceName = "ReliableGreetingService")
public class ReliableGreetingService {
    /* JAX-WS initializes context for each request */
    @Resource
    private WebServiceContext context;

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !!";
    }
    

    /* Get Sesssion using well-known key in MessageContext */
    private Map getSession() {
        return (Map)context.getMessageContext()
                .get("com.sun.xml.ws.session");

    }
    
    @WebMethod
    public void addString(String s ) {
        /* append string to session data */
        setSessionData(getSessionData() + " " + s);
    }

    @WebMethod
    public String getResult() {
        /* return session data */
        return getSessionData();
    }

    /* Get String associated with SessionID for current request */

    private String getSessionData() {
        Map sess = getSession();
        String ret = (String)sess.get("request_record");
        return ret != null ? ret : "";


    }

    /* Store String associated with SessionID for current request */
    private void setSessionData(String data) {
        Map session = getSession();
        session.put("request_record", data);
     
    }

    
}
