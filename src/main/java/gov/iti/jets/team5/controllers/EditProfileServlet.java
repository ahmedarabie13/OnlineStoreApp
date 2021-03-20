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

@WebServlet(name = "EditProfile", urlPatterns = "/editProfile")
public class EditProfileServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegisterService registerService = RegisterServiceImpl.getInstance();
        UserDto userDto = new UserDto();
        userDto.setFirstName(request.getParameter("firstName"));
        userDto.setLastName(request.getParameter("lastName"));
        userDto.setEmail(request.getParameter("email"));
        userDto.setPassword(request.getParameter("password"));
        userDto.setPhone(request.getParameter("phone"));

        Boolean registered = registerService.registerUser(userDto);
    }
}
