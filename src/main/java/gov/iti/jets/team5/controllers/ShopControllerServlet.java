package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.models.dto.CategoryDto;
import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.enums.ProductStatus;
import gov.iti.jets.team5.services.CategoryService;
import gov.iti.jets.team5.services.ProductService;
import gov.iti.jets.team5.services.impl.CategoryServiceImpl;
import gov.iti.jets.team5.services.impl.ProductServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/shop")
public class ShopControllerServlet extends HttpServlet {
    private static final List<ProductDto> products = new CopyOnWriteArrayList<>();
//    private int productsCount = 79;

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

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        ProductService productService = ProductServiceImpl.getInstance();
//        List<ProductDto> productsList;
//        String pageNumberStr = request.getParameter("page");
//
//        int pageNumber = 1;
//        if (pageNumberStr != null) {
//            System.out.println(pageNumberStr);
//            pageNumber = Integer.parseInt(pageNumberStr);
//
//            productsList = productService.fetchProducts(pageNumber);
//            System.out.println(productsList.size() + " <--------productsss");
//        } else {
//            productsList = productService.fetchProducts(1);
//        }
//
//        request.setAttribute("products", productsList);
//        request.setAttribute("totalCount", productsCount);
//        request.setAttribute("currentPage", pageNumber);
//
//        CategoryService categoryService = CategoryServiceImpl.getInstance();
//        List<CategoryDto> categoryList = categoryService.fetchCategories();
//        request.setAttribute("categories", categoryList);
//
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shop.jsp");
//        requestDispatcher.forward(request, response);
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ProductService productService = ProductServiceImpl.getInstance();
        List<ProductDto> productsList;

        String pageNumberStr = request.getParameter("page");
        String category = request.getParameter("cat");
        System.out.println(category + " <--------categoryId");
        int pageNumber = 1;
        if (pageNumberStr != null) {
            if(category != null){
                pageNumber = Integer.parseInt(pageNumberStr);
                productsList = productService.fetchCatProducts(Integer.parseInt(category), pageNumber);
                System.out.println(productsList.size() + " <--------productsssCategoriesss");
            }else {
                System.out.println(pageNumberStr);
                pageNumber = (int) Double.parseDouble(pageNumberStr);

                productsList = productService.fetchProducts(pageNumber);
                System.out.println(productsList.size() + " <--------productsss");
            }
        } else {
            productsList = productService.fetchProducts(1);
        }

        request.setAttribute("products", productsList);
        //todo actual products count
        long productsCount = productService.fetchNumOfProducts(category);
        int num = (int) (Math.round((productsCount/10) + 0.5));
        System.out.println(num + " ROUNDDD");
        request.setAttribute("totalCount", productsCount);
        request.setAttribute("numOfPages", num);
        request.setAttribute("currentPage", pageNumber);

        CategoryService categoryService = CategoryServiceImpl.getInstance();
        List<CategoryDto> categoryList = categoryService.fetchCategories();
        request.setAttribute("categories", categoryList);

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
