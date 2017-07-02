package web.controller;

import org.thymeleaf.ITemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Winiar on 02.07.2017.
 */
public interface IGTVGController {

    public void process(
            HttpServletRequest request,
            HttpServletResponse response,
            ServletContext servletContext,
            ITemplateEngine templateEngine)
            throws Exception;

}
