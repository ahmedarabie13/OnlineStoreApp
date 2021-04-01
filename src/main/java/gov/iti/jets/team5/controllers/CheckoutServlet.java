package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.CreditCardDto;
import gov.iti.jets.team5.models.dto.OrderDto;
import gov.iti.jets.team5.services.BankService;
import gov.iti.jets.team5.services.ProductService;
import gov.iti.jets.team5.services.impl.BankServiceImpl;
import gov.iti.jets.team5.services.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Checkout", urlPatterns = "/checkout")
public class CheckoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("checkout.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getting the services
        BankService bankService = new BankServiceImpl();
        ProductService productService = new ProductServiceImpl();
        CreditCardDto creditCardDto = new CreditCardDto(request.getParameter("CCNumber"), request.getParameter("cvv"));
        //todo: populate orderDto object with the cart items or get the cartObject from jsp
        OrderDto orderDto = new OrderDto();

        if (bankService.isValidCreditCard(creditCardDto)) {

            Double totalOrderPrice = orderDto.getProducts().keySet().stream().map(product -> {
                        return (product.getProductPrice().doubleValue() * orderDto.getProducts().get(product));
                    }
            ).reduce(0.0, Double::sum);
           if( bankService.withdraw(creditCardDto, totalOrderPrice)){

               productService.updateProductsAfterCheckout(orderDto);
           }else {

           }

        } else {
            request.setAttribute("Error", "true");
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        }

    }

}
