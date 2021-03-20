package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.enums.ProductStatus;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/shop")
public class ShopControllerServlet extends HttpServlet {
    private static final List<ProductDto> products = new CopyOnWriteArrayList<>();
    private int productsCount = 79;

    @Override
    public void init() throws ServletException {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Lol");
        productDto.setProductImageURL("images/img-pro-01.jpg");
        productDto.setProductStatus(ProductStatus.SALE);

        for (int i = 0; i < 90; i++) {
            productDto.setProductPrice(20.5 + i);
            products.add(productDto);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pageNumber = request.getParameter("page");

        if (pageNumber != null) {
            System.out.println(pageNumber);
            int startIndex = (int) Double.parseDouble(pageNumber);

            request.setAttribute("products", products.subList(startIndex * 10 , startIndex * 10 + 10));
        } else {
            request.setAttribute("products", products.subList(0, 10));
        }

        request.setAttribute("totalCount", productsCount);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shop.jsp");
        requestDispatcher.forward(request, response);
    }
}
