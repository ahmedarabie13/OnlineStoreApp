package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.services.LoginService;
import gov.iti.jets.team5.services.impl.LoginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService loginService = LoginServiceImpl.getInstance();
        UserDto userDto = new UserDto();
        userDto.setUserName(request.getParameter("userName"));
        userDto.setPassword(request.getParameter("password"));

        if(loginService.isUserAuthed(userDto)){

            //todo: create new session & redirect to homePage with the session

        }
        else {

            //todo: redirect with error parameters

        }
    }
}
