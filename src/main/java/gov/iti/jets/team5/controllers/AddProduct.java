package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.CategoryDto;
import gov.iti.jets.team5.services.CategoryService;
import gov.iti.jets.team5.services.impl.CategoryServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/addProduct")
public class AddProduct extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryService categoryService = CategoryServiceImpl.getInstance();
        List<CategoryDto> categories = categoryService.fetchCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("addProduct.jsp").forward(request, response);
    }
}
