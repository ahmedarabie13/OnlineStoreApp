package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.services.RegisterService;
import gov.iti.jets.team5.services.impl.RegisterServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegisterService registerService = RegisterServiceImpl.getInstance();
        UserDto userDto = new UserDto();
        userDto.setFirstName(request.getParameter("firstName"));
        userDto.setLastName(request.getParameter("lastName"));
        userDto.setEmail(request.getParameter("email"));
        userDto.setPassword(request.getParameter("password"));
        userDto.setPhone(request.getParameter("phone"));
        System.out.println(userDto.toString());

        Boolean userRegistered = registerService.registerUser(userDto);

        if(userRegistered){
            response.sendRedirect("login.jsp");
            //System.out.println("Inside the servlet");
        } else {
            //System.out.println("Here!!!");
            //todo: a db failure/connection maybe dunno why it would be false yet!!
            request.setAttribute("RegistrationFailed","true");
            request.getRequestDispatcher("registration.jsp").forward(request,response);
        }
    }
}
