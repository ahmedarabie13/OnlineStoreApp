package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.services.RegisterService;
import gov.iti.jets.team5.services.impl.RegisterServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "emailRegistered", urlPatterns = "/emailRegistered")
public class RegisteredEmailServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println("inside1");
        RegisterService registerService = RegisterServiceImpl.getInstance();
        String email = request.getParameter("email");
        System.out.println("Form email is: " + email);
        Boolean registered = registerService.isRegistered(email);
        request.setAttribute("isRegistered", registered);
        System.out.println(registered);
        PrintWriter out = response.getWriter();
        if(registered){
            out.write("true");
        } else {
            out.write("false");
        }
    }
}
