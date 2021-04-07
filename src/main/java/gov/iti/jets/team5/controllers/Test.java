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
import java.io.PrintWriter;

@WebServlet(name = "Test", urlPatterns = "/tst")
public class Test extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        System.out.println("inside1");
        PrintWriter out = response.getWriter();
        out.println("hi");
        out.close();
    }
}
