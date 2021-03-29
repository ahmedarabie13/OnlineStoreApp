package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.services.ProductService;
import gov.iti.jets.team5.services.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "shopDetail", urlPatterns = "/shopDetail")
public class ShopDetailServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");
        if(productId != null){
            System.out.println("maha"+productId);
            ProductService productService = ProductServiceImpl.getInstance();
            Product productObj = productService.fetchProductData(productId);
            if(productObj == null){
                response.sendRedirect("404.jsp");
            }else {
                request.setAttribute("productObj", productObj);
                request.getRequestDispatcher("shop-detail.jsp").forward(request,response);
            }
        } else {
            request.getRequestDispatcher("shop-detail.jsp").forward(request,response);
        }
    }
}
