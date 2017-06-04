package nicebank.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Winiar on 04.06.2017.
 */
public class AtmServlet extends HttpServlet {

    private static final String PAGE_HTML =
            "<html>" +
               "<head>" +
                    "<title>Nice Bank ATM</title>" +
               "</head>" +
                    "<body>" +
                    "  <h1>Welcome to our nice bank!</h1>" +
                    "</body>" +
            "</html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(PAGE_HTML);
    }
}
