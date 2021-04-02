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
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/shop")
public class ShopControllerServlet extends HttpServlet {
    private static final List<ProductDto> products = new CopyOnWriteArrayList<>();
    //    private int productsCount = 79;
    private int filterStart;
    private int filterEnd;
    private int category;
    private int pageNumber;

    @Override
    public void init() throws ServletException {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Lol");
        productDto.setProductImageURL("images/img-pro-01.jpg");
        productDto.setProductStatus(ProductStatus.SALE);

        for (int i = 0; i < 90; i++) {
            productDto.setProductPrice(new BigDecimal(20.5 + i));
            products.add(productDto);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductService productService = ProductServiceImpl.getInstance();
        List<ProductDto> productsList;

        String pageNumberStr = request.getParameter("page");

        String category = request.getParameter("cat");
        System.out.println(category + " <--------categoryId");
        long productsCount = productService.fetchNumOfProducts(category);
        System.out.println("productsCount = " + productsCount);
        if(productsCount < 0){
            System.out.println("if(productsCount < 0){");
            response.sendRedirect("404.jsp");
            return;
        }
        int num = (int) (Math.round((productsCount/9) + 0.5));
        String categoryStr = request.getParameter("cat");
        String filterStartStr = request.getParameter("filterStart");
        String filterEndStr = request.getParameter("filterEnd");

        System.out.println("Start = " + filterStartStr + "  End = " + filterEndStr);
        if (filterStartStr == null) {
            filterStartStr = "0";
        }
        if (filterEndStr == null) {
            filterEndStr = "4000";
        }
        if (pageNumberStr == null) {
            pageNumberStr = "1";
        }

        filterStart = Integer.parseInt(filterStartStr);
        filterEnd = Integer.parseInt(filterEndStr);
        pageNumber = Integer.parseInt(pageNumberStr);

//        int pageNumber = 1;
        if (pageNumberStr != null) {
            try {
                pageNumber = Integer.parseInt(pageNumberStr);
                if(pageNumber > num || pageNumber < 1){
                    System.out.println("if(pageNumber > productsCount || pageNumber < 1){");
                    response.sendRedirect("404.jsp");
                    return;
                }
                if(categoryStr != null && !categoryStr.equals("null") && !categoryStr.equals("")){
//                    productsList = productService.fetchCatProducts(category, pageNumber);
                    productsList = productService.fetchProductsByFilterAndCategory(pageNumber, categoryStr, filterStart, filterEnd);
                    if(productsList == null){
                        System.out.println("f(productsList == null){");
                        response.sendRedirect("404.jsp");
                        return;
                    }
                    request.setAttribute("products", productsList);
                }else {
                    System.out.println(pageNumberStr);
                    pageNumber = (int) Double.parseDouble(pageNumberStr);

                    productsList = productService.fetchProductsByFilter(pageNumber, filterStart, filterEnd);
//                    productsList = productService.fetchProducts(pageNumber);
                    System.out.println(productsList.size() + " <--------productsss/catss");
                    request.setAttribute("products", productsList);
                }
            } catch(NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("404.jsp");
                return;
            }
        } else {
//            productsList = productService.fetchProducts(1);
            productsList = productService.fetchProductsByFilter(1, filterStart, filterEnd);

            request.setAttribute("products", productsList);
        }
        if(productsCount < 0 ){
            System.out.println("if(productsCount < 0 ){");
            response.sendRedirect("404.jsp");
            return;
        }

        request.setAttribute("totalCount", productsCount);
        request.setAttribute("numOfPages", num);
        request.setAttribute("currentPage", pageNumber);
        request.setAttribute("filterStart", filterStart);
        request.setAttribute("filterEnd", filterEnd);
        System.out.println("After");
        System.out.println("Start = " + filterStart + "  End = " + filterEnd);
        System.out.println(categoryStr + " LOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOL");
        request.setAttribute("currentCategory", categoryStr);


        CategoryService categoryService = CategoryServiceImpl.getInstance();
        List<CategoryDto> categoryList = categoryService.fetchCategories();
        request.setAttribute("categories", categoryList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/shop.jsp");
        requestDispatcher.forward(request, response);
    }
}
