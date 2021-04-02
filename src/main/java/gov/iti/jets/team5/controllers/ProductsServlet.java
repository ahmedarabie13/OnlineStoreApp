package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.CategoryDto;
import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.enums.ProductStatus;
import gov.iti.jets.team5.services.CategoryService;
import gov.iti.jets.team5.services.ProductService;
import gov.iti.jets.team5.services.impl.CategoryServiceImpl;
import gov.iti.jets.team5.services.impl.ProductServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    private static final ProductService productService = ProductServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ProductDto> productsList;
        String pageNumberStr = request.getParameter("page");
        String category = request.getParameter("cat");
        long productsCount = productService.fetchNumOfProducts(category);
//        System.out.println("productsCount = " + productsCount);
        if (productsCount < 0) {
            System.out.println("productsCount < 0");
            response.sendRedirect("404.jsp");
            return;
        }
        int num = (int) (Math.round((productsCount / 9) + 0.5));
        int pageNumber = 1;
        if (pageNumberStr != null) {
            try {
                pageNumber = Integer.parseInt(pageNumberStr);
                if (pageNumber > num || pageNumber < 1) {
                    response.sendRedirect("404.jsp");
                    return;
                }
                if (category != null) {
                    productsList = productService.fetchCatProducts(category, pageNumber);
                    if (productsList == null) {
                        response.sendRedirect("404.jsp");
                        return;
                    }
                    request.setAttribute("products", productsList);
                } else {
                    System.out.println(pageNumberStr);
                    pageNumber = Integer.parseInt(pageNumberStr);
                    productsList = productService.fetchProducts(pageNumber);
                    request.setAttribute("products", productsList);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("404.jsp");
                return;
            }
        } else {
            productsList = productService.fetchProducts(1);
            request.setAttribute("products", productsList);
        }
        request.setAttribute("totalCount", productsCount);
        request.setAttribute("numOfPages", num);
        request.setAttribute("currentPage", pageNumber);

        CategoryService categoryService = CategoryServiceImpl.getInstance();
        List<CategoryDto> categoryList = categoryService.fetchCategories();
        request.setAttribute("categories", categoryList);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("products.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String name = request.getParameter("name");
            String desc = request.getParameter("desc");
            String price = request.getParameter("price");
            String quan = request.getParameter("quan");
            String [] cats = request.getParameterValues("cats[]");
            if(cats != null) System.out.println(cats.length + " cats are");
            ProductDto productDto = new ProductDto();
            productDto.setProductName(name);
            productDto.setProductDescription(desc);
            productDto.setProductPrice(BigDecimal.valueOf(Double.parseDouble(price)));
            productDto.setProductQuantity(Integer.parseInt(quan));
            boolean added = productService.addProduct(productDto, cats);
            PrintWriter out = response.getWriter();
            if (added) {
                out.write("true");
            } else {
                out.write("false");
//                response.sendRedirect("addProduct.jsp");
//                return;
            }
        } catch (Exception e){
            e.printStackTrace();
//            response.sendRedirect("addProduct.jsp");
//            return;
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String newName = request.getParameter("newName");
        String newDesc = request.getParameter("newDesc");
        String newPrice = request.getParameter("newPrice");
        String newQuantity = request.getParameter("newQuantity");
        String pid = request.getParameter("id");
        ProductDto productDto = new ProductDto();
        productDto.setProductName(newName);
        productDto.setProductDescription(newDesc);
        productDto.setProductPrice(BigDecimal.valueOf(Double.parseDouble(newPrice)));
        productDto.setProductQuantity(Integer.parseInt(newQuantity));
        boolean updated = productService.updateProduct(Integer.parseInt(pid), productDto);
        PrintWriter out = response.getWriter();
        if (updated) {
            out.write("true");
        } else {
            out.write("false");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("id");
        boolean deleted = productService.deleteProduct(Integer.parseInt(pid));
        PrintWriter out = response.getWriter();
        if (deleted) {
            out.write("true");
        } else {
            out.write("false");
        }
    }
}
