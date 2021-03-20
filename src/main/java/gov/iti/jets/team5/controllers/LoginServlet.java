package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.UserAuthDto;
import gov.iti.jets.team5.services.LoginService;
import gov.iti.jets.team5.services.impl.LoginServiceImpl;
import gov.iti.jets.team5.utils.Cookies;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final int MONTH = 60 * 60 * 24 * 30;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService loginService = LoginServiceImpl.getInstance();
        UserAuthDto userAuthDto = new UserAuthDto();
        userAuthDto.setEmail(request.getParameter("email"));
        userAuthDto.setPassword(request.getParameter("password"));

        if (loginService.isUserAuthed(userAuthDto)) {
            request.getServletContext().setAttribute("currentUser", userAuthDto);
            Cookies.addCookie("c_user", String.valueOf(userAuthDto.getId()), MONTH, response);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } else {
            //todo: redirect with error parameters
            request.setAttribute("Error","true");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
