package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nicebank.server.AtmServer;

/**
 * Created by Winiar on 04.06.2017.
 */
public class ServerHooks {

    public static final int PORT = 8887;
    private AtmServer server;

    @Before("@server")
    public void startServer() throws Exception {
        server = new AtmServer(PORT);
        server.start();
    }

    @After("@server")
    public void stopServer() throws Exception {
        server.stop();
    }
}
