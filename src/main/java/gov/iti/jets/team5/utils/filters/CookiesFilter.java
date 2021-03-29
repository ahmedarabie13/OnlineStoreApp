package gov.iti.jets.team5.utils.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

//@WebFilter(urlPatterns = {"/*"})
public class CookiesFilter implements Filter {

    private Cookie cookie = new Cookie("test", "test");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CookiesFilter Filter is initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //System.out.println("entering the CookiesFilter filter (1)");
        String servletPath = ((HttpServletRequest) request).getServletPath();
        String path = ((HttpServletRequest) request).getRequestURL().toString();
        //System.out.println("servlet: " + servletPath);
        if (servletPath.equals("/cookies.jsp")) {
            //System.out.println("starts wala?");
            chain.doFilter(request, response);
        } else {
            String [] extension = servletPath.split("\\.");
            if(extension.length > 0){
                if(extension[extension.length-1].equals("jsp")){
                    //System.out.println("-------------------> " + extension[extension.length-1]);
                    if (request.getParameter("checkCookie") == null) {
                        //System.out.println("checkCookie is null hence the 1nd visit");
                        ((HttpServletResponse) response).addCookie(cookie);
                        //System.out.println(((HttpServletRequest) request).getRequestURL().toString());
                        ((HttpServletResponse) response).sendRedirect(path+"?checkCookie=true");
                        return;
                    } else {
                        if (((HttpServletRequest) request).getCookies() == null) {
                            //System.out.println("the cookies array is null hence cookies are OFF, so redirect to the cookies page (2)");
                            request.setAttribute("CookiesEnabled","False");
                            ((HttpServletResponse) response).sendRedirect("cookies.jsp");
                            return;
                        } else if (((HttpServletRequest) request).getCookies().length == 0) {
                            //System.out.println("the cookies array is null hence cookies are OFF, so redirect to the cookies page (2)");
                            request.setAttribute("CookiesEnabled","False");
                            ((HttpServletResponse) response).sendRedirect("cookies.jsp");
                            return;
                        } else {
                            //System.out.println("the cookies array is not hence and cookies are ON, so continue with the request (3)");
                            request.setAttribute("CookiesEnabled","True");
                            chain.doFilter(request,response);
                        }
                    }
                } else {
                    Cookie [] cookiesList = ((HttpServletRequest) request).getCookies();
                    for (Cookie c: cookiesList) {
                        if(c.getName().equals("test")){
                            c.setMaxAge(0);
                        }
                    }
                    chain.doFilter(request, response);
                }
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("CookiesFilter Filter is destroyed");
    }
}
