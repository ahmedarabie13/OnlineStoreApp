package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.S3Integration.S3BucketOperations;
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
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.xml.bind.SchemaOutputResolver;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/products")
@MultipartConfig
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
            String name = request.getParameter("prodName");
            String desc = request.getParameter("desc");
            String price = request.getParameter("prodPrice");
            String quan = request.getParameter("prodQuan");
            String [] cats = request.getParameterValues("cats");
            Part filePart = request.getPart("filename");
            System.out.println("product name is: " + name);
            System.out.println("product name is: " + desc);
            System.out.println("product price is: " + price);
            System.out.println("product quantity is: " + quan);
            System.out.println("product image file name is: " + filePart.getSubmittedFileName());
            System.out.println("product image file name is: " + filePart.getInputStream());

            boolean valid = validateInputs(name, desc, price, quan);
            if(!valid){
                request.setAttribute("error", "error");
                request.getRequestDispatcher("addProduct").forward(request, response);
            }

            String imgURL = S3BucketOperations.uploadFile(filePart);
            if(cats != null) System.out.println(cats.length + " cats are");
            ProductDto productDto = new ProductDto();
            productDto.setProductName(name);
            productDto.setProductDescription(desc);
            productDto.setProductPrice(BigDecimal.valueOf(Double.parseDouble(price)));
            productDto.setProductQuantity(Integer.parseInt(quan));
            productDto.setProductImageURL(imgURL);
            boolean added = productService.addProduct(productDto, cats);
            PrintWriter out = response.getWriter();
            if (added) {
                out.write("true");
                response.sendRedirect("products");
                return;
            } else {
                out.write("false");
                request.setAttribute("error", "error");
                request.getRequestDispatcher("addProduct").forward(request, response);
            }
        } catch (Exception e){
            e.printStackTrace();
            request.setAttribute("error", "error");
            request.getRequestDispatcher("addProduct").forward(request, response);
        }
    }

    private boolean validateInputs(String name, String desc, String price, String quan) {
        if(name.equals("") || desc.equals("")){
            return false;
        } else {
            try {
                BigDecimal p = BigDecimal.valueOf(Double.parseDouble(price));
                int q = Integer.parseInt(quan);
                if(p.compareTo(BigDecimal.ZERO) < 0 || p.compareTo(BigDecimal.ZERO) == 0 || q < 0){
                    return false;
                }
            } catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        return true;
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
