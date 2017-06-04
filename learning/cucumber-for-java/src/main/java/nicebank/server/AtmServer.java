package nicebank.server;

import nicebank.servlet.AtmServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Winiar on 04.06.2017.
 */
public class AtmServer {

    private final Server server;

    public AtmServer(int port) {
        server = new Server(port);

        ServletContextHandler context =
                new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        server.setHandler(context);
        AtmServlet atmServlet = new AtmServlet();
        ServletHolder servletHolder = new ServletHolder(atmServlet);
        context.addServlet(servletHolder, "/*");
    }

    public void start() throws Exception {
        server.start();
        System.out.println("Listening on " + server.getURI());
    }

    public void stop() throws Exception {
        server.stop();
    }

    public static void main(String[] args) throws Exception {
        new AtmServer(9988).start();
    }
}
