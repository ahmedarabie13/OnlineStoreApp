package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.services.ProductService;
import gov.iti.jets.team5.services.impl.ProductServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {

    private static final ProductService productService = ProductServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("id");
        boolean deleted = productService.deleteProduct(Integer.parseInt(pid));
        PrintWriter out = response.getWriter();
        if(deleted){
            out.write("true");
        } else {
//            response.sendRedirect("404.jsp");
//            return;
            out.write("false");
        }
    }
}
