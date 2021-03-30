package gov.iti.jets.team5.controllers;

import com.google.gson.Gson;
import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.repositories.CartRepository;
import gov.iti.jets.team5.services.CartService;
import gov.iti.jets.team5.services.impl.CartServiceImpl;
import gov.iti.jets.team5.utils.mappers.CartItemDtoMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "cart", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//        response.setContentType("text");
        int currentUserId = ((UserDto) request.getSession().getAttribute("currentUser")).getId();
        var cartItems = CartRepository.getInstance().getCartItems(currentUserId);
        System.out.println("from servlet cart list : "+ cartItems);
//        System.out.println("from servlet cart");
        CartItemDtoMapper cartItemDtoMapper = new CartItemDtoMapper();
        var cartItemsDto = cartItemDtoMapper.getListDto(cartItems);
        request.getSession().setAttribute("cartItems",cartItemsDto);
        Gson gson = new Gson();
        var jsonObj=gson.toJson(cartItemsDto);
        System.out.println("json : "+jsonObj);
        out.println(jsonObj);

    }
}
