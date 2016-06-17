package edu.depaul.cdm.se.asynch.client.session;

import edu.depaul.cdm.se.asynch.GreeterBeanRemote;
import java.util.concurrent.Future;
import javax.naming.Context;
import javax.naming.InitialContext;

public class App {

    public static void main(String[] args) throws Exception {
        InitialContext context = new InitialContext();
        App app = new App();
        app.runRemote(context);
    }

    private void runRemote(Context context) throws Exception {
        String jndiName = "java:global/asynch/AsynchGreetingsBean";
        GreeterBeanRemote bean = (GreeterBeanRemote) context.lookup(jndiName);
        Future<String> future = bean.greetMe("Dave");

        while (!future.isDone()) {
            Thread.sleep(1000);
            System.out.println("Not done yet and so doing something else....");
        }
        String ret = future.get();
        System.out.println("Response: " + ret);
    }
}
