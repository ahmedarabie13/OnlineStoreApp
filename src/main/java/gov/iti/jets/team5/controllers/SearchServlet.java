package gov.iti.jets.team5.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String searchFor = request.getParameter("searchFor");
        if (!searchFor.equals("")) {
            request.setAttribute("search", searchFor);
            request.setAttribute("nothing",false);
            System.out.println("Product user search for" + searchFor);
            request.getRequestDispatcher("shop").forward(request, response);
        } else {
            request.setAttribute("nothing", true);
            request.getRequestDispatcher("shop").forward(request, response);

        }
    }
}
