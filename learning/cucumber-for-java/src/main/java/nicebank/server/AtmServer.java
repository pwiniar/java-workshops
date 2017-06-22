package nicebank.server;

import nicebank.account.Account;
import nicebank.account.Owner;
import nicebank.servlet.AtmServlet;
import nicebank.servlet.WithdrawalServlet;
import nicebank.teller.CashSlot;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Winiar on 04.06.2017.
 */
public class AtmServer
{
    private final Server server;

    public AtmServer(int port, CashSlot cashSlot, Account account) {
        server = new Server(port);

        ServletContextHandler context =
                new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new WithdrawalServlet(cashSlot, account)),"/withdraw");
        context.addServlet(new ServletHolder(new AtmServlet()),"/");
    }

    public void start() throws Exception {
        server.start();
        System.out.println("Listening on " + server.getURI());
    }

    public void stop() throws Exception {
        server.stop();
        System.out.println("Server shutdown");
    }

    public static void main(String[] args) throws Exception {
        new AtmServer(9988, new CashSlot(), new Account(new Owner("Pawel", "Winiarski"))).start();
    }
}