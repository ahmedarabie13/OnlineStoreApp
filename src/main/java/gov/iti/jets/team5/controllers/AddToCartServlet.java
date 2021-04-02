package gov.iti.jets.team5.controllers;


import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.services.CartService;
import gov.iti.jets.team5.services.impl.CartServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "AddToCart", urlPatterns = "/addToCart")
public class AddToCartServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        System.out.println(productId + " from cart Servlet");
        int currentUserId = ((UserDto) request.getSession().getAttribute("currentUser")).getId();
        CartService cartService = new CartServiceImpl();
        String status = cartService.addToCart(productId, currentUserId);
        request.getSession().setAttribute("totalPrice", cartService.getCartTotalPrice(currentUserId));
        PrintWriter out = response.getWriter();
        out.println("{\"status\": \"" + status + "\"}");
    }

}
