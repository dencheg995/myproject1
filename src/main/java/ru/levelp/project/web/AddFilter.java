package ru.levelp.project.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebFault;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AddFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        System.out.println("REQUEST" + req.getRequestURL() + "from " +  req.getRemoteAddr());

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
