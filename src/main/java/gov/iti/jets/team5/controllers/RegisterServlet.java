package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.UserAuthDto;
import gov.iti.jets.team5.services.LoginService;
import gov.iti.jets.team5.services.RegisterService;
import gov.iti.jets.team5.services.impl.LoginServiceImpl;
import gov.iti.jets.team5.services.impl.RegisterServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegisterService registerService = RegisterServiceImpl.getInstance();
        UserAuthDto userAuthDto = new UserAuthDto();
        userAuthDto.setFirstName(request.getParameter("firstName"));
        userAuthDto.setLastName(request.getParameter("lastName"));
        userAuthDto.setEmail(request.getParameter("email"));
        userAuthDto.setPassword(request.getParameter("password"));
        userAuthDto.setPhone(request.getParameter("phone"));

        Boolean registered = registerService.registerUser(userAuthDto);
    }
}
