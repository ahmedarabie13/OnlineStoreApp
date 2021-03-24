package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.utils.Cookies;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LogOut", urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        request.getSession().setAttribute("currentUser",null);
        Cookies.addCookie("c_user",null,0,response);
        response.sendRedirect("main");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
