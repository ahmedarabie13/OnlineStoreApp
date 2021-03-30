package gov.iti.jets.team5.controllers;

import com.google.gson.Gson;
import gov.iti.jets.team5.models.ajaxModels.CartItemData;
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

@WebServlet(name = "UpdateCartServlet", urlPatterns = "/updateCart")
public class UpdateCartServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("updateCart servlet");
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        CartItemData cartItemData = gson.fromJson(request.getParameter("cartItemData"), CartItemData.class);
        System.out.println(cartItemData);
        CartService cartService = new CartServiceImpl();
        UserDto currentUser = (UserDto) request.getSession().getAttribute("currentUser");
        if (cartItemData.getOperation().equals("updateQuantity")) {
            if (cartService.updateProductQuantity(currentUser.getId(), cartItemData)) {
                double totalPrice = cartService.getCartTotalPrice(currentUser.getId());
                System.out.println("from servlet: update succeeded");
                out.write("{\"status\": \"success\",\n" +
                        "                 \"totalPrice\": " + totalPrice + "}");

            } else {
                double totalPrice = cartService.getCartTotalPrice(currentUser.getId());
                out.write("{\"status\": \"failed\",\n" +
                        "                 \"totalPrice\": " + totalPrice + "}");
                System.out.println("from servlet: update failed");
            }
        } else if (cartItemData.getOperation().equals("deleteCartItem")) {
            cartService.deleteCartItem(currentUser.getId(),cartItemData);
            var cartItems = cartService.getCartItems(currentUser.getId());
            CartItemDtoMapper cartItemDtoMapper = new CartItemDtoMapper();
            var cartItemsDto = cartItemDtoMapper.getListDto(cartItems);
            request.getSession().setAttribute("cartItems",cartItemsDto);
            var jsonObj=gson.toJson(cartItemsDto);
            System.out.println("from servlet: delete");
//            System.out.println("json : "+jsonObj);
            out.println(jsonObj);
        }
    }
}
