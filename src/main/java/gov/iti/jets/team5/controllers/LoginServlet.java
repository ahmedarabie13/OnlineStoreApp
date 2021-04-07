package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.UserAuthDto;
import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.repositories.CartRepository;
import gov.iti.jets.team5.services.LoginService;
import gov.iti.jets.team5.services.impl.CartServiceImpl;
import gov.iti.jets.team5.services.impl.LoginServiceImpl;
import gov.iti.jets.team5.utils.Cookies;
import gov.iti.jets.team5.utils.mappers.CartItemDtoMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final int MONTH = 60 * 60 * 24 * 30;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService loginService = LoginServiceImpl.getInstance();
        UserAuthDto userAuthDto = new UserAuthDto();
        userAuthDto.setEmail(request.getParameter("email"));
        userAuthDto.setPassword(request.getParameter("password"));

        if (loginService.isUserAuthed(userAuthDto)) {
            UserDto userDto = loginService.getCurrentUserCredentials(userAuthDto.getId());
            request.getSession().setAttribute("currentUser", userDto);
            Cookies.addCookie("c_user", String.valueOf(userAuthDto.getId()), MONTH, response);
            var cartItems = CartRepository.getInstance().getCartItems(userAuthDto.getId());
            CartItemDtoMapper cartItemDtoMapper = new CartItemDtoMapper();
            if (cartItems == null) {
                cartItems = new ArrayList<>();
            }
            var cartItemsDto = cartItemDtoMapper.getListDto(cartItems);
            request.getSession().setAttribute("cartItems", cartItemsDto);
            Double totalPrice = new CartServiceImpl().getCartTotalPrice(userAuthDto.getId());
            request.getSession().setAttribute("totalPrice", totalPrice);
            if (userDto.getUserRole().equals("admin")) {
                request.getRequestDispatcher("panel").forward(request, response);
            } else {
                //todo : check if fails
                request.getRequestDispatcher("main").forward(request, response);
            }
//            response.sendRedirect("main");
        } else {
            //todo: redirect with error parameters
//            request.setAttribute("Error","true");
//            request.getRequestDispatcher("login.jsp").forward(request,response);
            response.sendRedirect("login?Error=true");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("Error") != null) {
            request.setAttribute("Error", "true");
//            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
