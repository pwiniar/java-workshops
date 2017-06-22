package devOps;

import org.eclipse.jetty.server.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Map;

/**
 * Created by Winiar on 07.06.2017.
 */
public class OperationSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(OperationSupport.class);

    public static void show(Request request, HttpServletRequest httpServletRequest, HttpServletResponse response, String s) {
        LOGGER.info("This is request {} \n This is httpServletRequest {} \n, This is response {} \n, This is string {} \n", request, httpServletRequest, response, s);
    }

    public static void serverStarted(URI uri) {
        LOGGER.info("Server started, listening on {}", uri);
    }

    public static void requestParams(Map<String, String[]> parameterMap) {
        for (String s : parameterMap.keySet()) {
            LOGGER.info("Server params {}:{}", s, parameterMap.get(s));
        }
    }
}
