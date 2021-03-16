package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.UserAuthDto;
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
        UserAuthDto userAuthDto = new UserAuthDto();
        userAuthDto.setUserName(request.getParameter("userName"));
        userAuthDto.setPassword(request.getParameter("password"));

        if(loginService.isUserAuthed(userAuthDto)){

            //todo: create new session & redirect to homePage with the session

        }
        else {

            //todo: redirect with error parameters

        }
    }
}
