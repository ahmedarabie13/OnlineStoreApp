package gov.iti.jets.team5.utils.filters;

import gov.iti.jets.team5.models.dto.UserAuthDto;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoggedInFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoggedInFilter Filter is initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("entering the LoggedInFilter filter (1)");
        UserAuthDto userAuth = (UserAuthDto) ((HttpServletRequest) request).getSession().getAttribute("userAuth");
        if(userAuth == null){
            System.out.println("no userAuth object on the session scope hence not logged in");
            ((HttpServletResponse) response).sendRedirect("login.jsp");
            return;
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("LoggedInFilter Filter is destroyed");
    }
}
