package server;

import devOps.OperationSupport;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;

/**
 * Created by Winiar on 07.06.2017.
 */
public class SimpleServer {

    private final Server server;

    public SimpleServer(int port, Handler[] handlers) {
        this.server = new Server(port);
        HandlerCollection h = new HandlerCollection();
        h.setHandlers(handlers);
        server.setHandler(h);
    }

    public void start(){
        try {
            this.server.start();
            OperationSupport.serverStarted(server.getURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            this.server.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
