package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.enums.ProductStatus;
import gov.iti.jets.team5.services.ProductService;
import gov.iti.jets.team5.services.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {

    private static final ProductService productService = ProductServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String newName = request.getParameter("newName");
        String newDesc = request.getParameter("newDesc");
        String newPrice = request.getParameter("newPrice");
        String newQuantity = request.getParameter("newQuantity");
        String status = request.getParameter("status");
        System.out.println("STATUS IS: " + status);
        String pid = request.getParameter("id");
        try{
            ProductDto productDto = new ProductDto();
            productDto.setProductName(newName);
            productDto.setProductDescription(newDesc);
            productDto.setProductPrice(BigDecimal.valueOf(Double.parseDouble(newPrice)));
            productDto.setProductQuantity(Integer.parseInt(newQuantity));
            ProductStatus productStatus = (status.equals("NEW")) ? ProductStatus.NEW : (status.equals("SOLD_OUT")) ? ProductStatus.SOLD_OUT : ProductStatus.SALE;
            productDto.setProductStatus(productStatus);
            boolean updated = productService.updateProduct(Integer.parseInt(pid), productDto);
            PrintWriter out = response.getWriter();
            if(updated){
                out.write("true");
            } else {
//                System.out.println("lol");
//                request.getRequestDispatcher("opsUpd.jsp?pid="+pid).forward(request, response);
//                response.sendRedirect("opsUpd.jsp?pid="+pid);
//                return;
            out.write("false");
            }
        } catch (Exception e){
//            System.out.println("lol");
            e.printStackTrace();
//            response.sendRedirect("opsUpd.jsp?pid="+pid);
//            return;
        }
    }
}
