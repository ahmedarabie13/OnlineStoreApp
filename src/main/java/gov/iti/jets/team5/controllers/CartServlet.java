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
        int currentUserId = ((UserDto) request.getSession().getAttribute("currentUser")).getId();
        var cartItems = CartRepository.getInstance().getCartItems(currentUserId);
        CartItemDtoMapper cartItemDtoMapper = new CartItemDtoMapper();
        var cartItemsDto = cartItemDtoMapper.getListDto(cartItems);
        request.getSession().setAttribute("cartItems",cartItemsDto);
        Double totalPrice = new CartServiceImpl().getCartTotalPrice(currentUserId);
        request.getSession().setAttribute("totalPrice",totalPrice);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int currentUserId = ((UserDto) request.getSession().getAttribute("currentUser")).getId();
        var cartItems = CartRepository.getInstance().getCartItems(currentUserId);
        CartItemDtoMapper cartItemDtoMapper = new CartItemDtoMapper();
        var cartItemsDto = cartItemDtoMapper.getListDto(cartItems);
        Double totalPrice = new CartServiceImpl().getCartTotalPrice(currentUserId);
        request.getSession().setAttribute("cartItems",cartItemsDto);
        request.getSession().setAttribute("totalPrice",totalPrice);
        Gson gson = new Gson();
        var jsonObj=gson.toJson(cartItemsDto);
        out.println(jsonObj);

    }
}
