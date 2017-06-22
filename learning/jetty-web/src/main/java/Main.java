import handlers.ParamHandler;
import handlers.SimpleHandler;
import org.eclipse.jetty.server.Handler;
import server.SimpleServer;

/**
 * Created by Winiar on 07.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        Handler[] handlers = {new SimpleHandler(), new ParamHandler()};
        SimpleServer simpleServer = new SimpleServer(2001, handlers);
        simpleServer.start();
    }

}
