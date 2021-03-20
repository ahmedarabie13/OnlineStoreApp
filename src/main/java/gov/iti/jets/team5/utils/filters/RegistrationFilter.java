package gov.iti.jets.team5.utils.filters;

import gov.iti.jets.team5.utils.validations.RegexValidations;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = {"/register"})
public class RegistrationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("RegistrationFilter Filter is initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("entering the RegistrationFilter filter (1)");
        String firstName = request.getParameter("firstName");
        System.out.println("fn " + firstName);
        String lastName = request.getParameter("lastName");
        System.out.println("ln " + lastName);
        String email = request.getParameter("email");
        System.out.println("email " + email);
        String password = request.getParameter("password");
        System.out.println("pass " + password);
        String passwordConfirmation = request.getParameter("passConf");
        System.out.println("passConf " + passwordConfirmation);
        String phone = request.getParameter("phone");
        System.out.println("phone " + phone);
        if ((firstName != null && firstName != "" && firstName.length() >= 3 && firstName.length() <= 15) &&
                (lastName != null && lastName != "" && lastName.length() >= 3 && lastName.length() <= 15) &&
                (email != null && email != "") && (password != null && password != "") &&
                (passwordConfirmation != null && passwordConfirmation != "") && (phone != null && phone != "") &&
                (password.equals(passwordConfirmation))) {
            request.getRequestDispatcher("emailRegistered").include(request, response);
            Boolean isRegistered = (Boolean) request.getAttribute("isRegistered");
            System.out.println("is registered " + isRegistered);
            if (RegexValidations.emailValidator(email) && RegexValidations.phoneValidator(phone) && RegexValidations.passwordValidator(password) && !isRegistered) {
                System.out.println("RegistrationFilter filter checks are passed and continuing to the servlet (2)");
                chain.doFilter(request, response);
                System.out.println("RegistrationFilter Coming back to the filter with the response which is a forward to the login page (3)");
            } else {
                validationFailed(response);
                return;
            }
        } else {
            validationFailed(response);
            return;
        }
    }

    private void validationFailed(ServletResponse response) throws IOException {
        System.out.println("RegistrationFilter filter checks are not passed and redirecting to the registration again (2)");
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect("registration.jsp?val=false");
    }
    @Override
    public void destroy() {
        System.out.println("RegistrationFilter Filter is destroyed");
    }
}
