package gov.iti.jets.team5.utils.filters;

import gov.iti.jets.team5.models.dto.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminRedirectionFilter implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
        UserDto currentUser =(UserDto) httpServletRequest.getSession().getAttribute("currentUser");
        if(currentUser != null){
            if(currentUser.getUserRole().equals("admin")){
                chain.doFilter(request,response);
            }else {
                ((HttpServletResponse) response).sendRedirect("404.jsp");
                return;
            }
        } else {
            ((HttpServletResponse) response).sendRedirect("404.jsp");
        }
    }
}
