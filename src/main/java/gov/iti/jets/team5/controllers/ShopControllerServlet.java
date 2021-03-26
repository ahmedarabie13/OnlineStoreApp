package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.enums.ProductStatus;
import gov.iti.jets.team5.services.ProductService;
import gov.iti.jets.team5.services.impl.ProductServiceImpl;
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
        String pageNumberStr = request.getParameter("page");

        ProductService productService = ProductServiceImpl.getInstance();
        List<ProductDto> productsList;

        int pageNumber = 1;
        if (pageNumberStr != null) {
            System.out.println(pageNumberStr);
            pageNumber = (int) Double.parseDouble(pageNumberStr);

            productsList = productService.fetchProducts(pageNumber);
            System.out.println(productsList.size() + " <--------productsss");
        } else {
            productsList = productService.fetchProducts(1);
        }

        request.setAttribute("products", productsList);
        request.setAttribute("totalCount", productsCount);
        request.setAttribute("currentPage", (float) pageNumber);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shop.jsp");
        requestDispatcher.forward(request, response);
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        ProductService productService = ProductServiceImpl.getInstance();
//        List<ProductDto> productsList = productService.fetchProducts();
//        System.out.println(productsList.size() + " <--------productsss");
//        request.setAttribute("products", productsList);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shop.jsp");
//        requestDispatcher.forward(request, response);
//    }
}
