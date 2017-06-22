package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nicebank.server.AtmServer;
import nicebank.support.KnowsTheDomain;

/**
 * Created by Winiar on 04.06.2017.
 */
public class ServerHooks {

    public static final int PORT = 8887;
    private AtmServer server;
    private KnowsTheDomain helper;

    public ServerHooks() {
        this.helper = new KnowsTheDomain();
    }

    @Before("@server")
    public void startServer() throws Exception {
        server = new AtmServer(PORT, helper.getCashSlot(), helper.getAccount(helper.getOwner()));
        server.start();
    }

    @After("@server")
    public void stopServer() throws Exception {
        server.stop();
    }
}
