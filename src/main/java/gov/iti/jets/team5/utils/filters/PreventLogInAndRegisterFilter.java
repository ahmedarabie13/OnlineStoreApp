package gov.iti.jets.team5.utils.filters;

import gov.iti.jets.team5.models.dto.UserAuthDto;
import gov.iti.jets.team5.models.dto.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class PreventLogInAndRegisterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        UserDto currentUser = (UserDto) ((HttpServletRequest) request).getSession().getAttribute("currentUser");
        if (currentUser != null) {
            //todo: check if fails
            request.getRequestDispatcher("main").forward(request,response);
//            ((HttpServletResponse) response).sendRedirect("index.jsp");
            return;
        } else {
            chain.doFilter(request, response);
        }
    }
}
