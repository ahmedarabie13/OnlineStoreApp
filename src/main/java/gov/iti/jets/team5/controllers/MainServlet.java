package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.CategoryDto;
import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.dto.UserAuthDto;
import gov.iti.jets.team5.services.CartService;
import gov.iti.jets.team5.services.LoginService;
import gov.iti.jets.team5.services.ProductService;
import gov.iti.jets.team5.services.impl.CartServiceImpl;
import gov.iti.jets.team5.services.impl.LoginServiceImpl;
import gov.iti.jets.team5.services.impl.ProductServiceImpl;
import gov.iti.jets.team5.utils.Cookies;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Main", urlPatterns = "/main")
public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentUserId = Cookies.getCookie("c_user", request);
        LoginService loginService = new LoginServiceImpl();
        if (!(currentUserId.equals("") || currentUserId == null)) {
            if (loginService.isUserIdExists(Integer.parseInt(currentUserId))) {
                if (request.getSession().getAttribute("currentUser") == null){
                    CartService cartService = new CartServiceImpl();
                    var cartItemsDto = cartService.getCartItems(Integer.parseInt(currentUserId));
                    request.getSession().setAttribute("cartItems",cartItemsDto);
                    request.getSession().setAttribute("currentUser", loginService.getCurrentUserCredentials(Integer.parseInt(currentUserId)));
                }
            }
        }

        ProductService productService = ProductServiceImpl.getInstance();
        List<ProductDto> products = productService.fetchLastRecentTenProducts();

        request.setAttribute("lastRecentProducts", products);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
