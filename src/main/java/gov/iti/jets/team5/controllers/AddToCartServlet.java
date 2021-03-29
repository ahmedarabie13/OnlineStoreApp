package gov.iti.jets.team5.controllers;


import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.services.CartService;
import gov.iti.jets.team5.services.impl.CartServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "AddToCart", urlPatterns = "/addToCart")
public class AddToCartServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        int productId = Integer.parseInt(request.getParameter("productId"));
        System.out.println(productId + " from cart Servlet");
        int currentUserId = ((UserDto) request.getSession().getAttribute("currentUser")).getId();
        CartService cartService = new CartServiceImpl();
        cartService.addToCart(productId,currentUserId);
    }

}
