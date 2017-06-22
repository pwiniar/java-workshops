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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        String message = "Hello World";

        String s = message;
        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title>SO question 2370960</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>Message: " + s + "</p>\n" +
                "</body>\n" +
                "</html>");

//        response.getWriter().println(
//                "<html><head><title>ATM</title></head>" +
//                        "<body><form action=\"/withdraw\" method=\"post\">" +
//                        "<label for=\"amount\">Amount</label>" +
//                        "<input type=\"text\" id=\"amount\" name=\"amount\">" +
//                        "<button type=\"submit\" id=\"withdraw\">Withdraw</button>" +
//                        "</form></body></html>");
    }
}
