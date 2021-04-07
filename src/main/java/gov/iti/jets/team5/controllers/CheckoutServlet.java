package gov.iti.jets.team5.controllers;

import gov.iti.jets.team5.models.dto.CartItemDto;
import gov.iti.jets.team5.models.dto.CreditCardDto;
import gov.iti.jets.team5.models.dto.OrderDto;
import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.services.BankService;
import gov.iti.jets.team5.services.CartService;
import gov.iti.jets.team5.services.CheckoutService;
import gov.iti.jets.team5.services.ProductService;
import gov.iti.jets.team5.services.impl.BankServiceImpl;
import gov.iti.jets.team5.services.impl.CartServiceImpl;
import gov.iti.jets.team5.services.impl.CheckoutServiceImpl;
import gov.iti.jets.team5.services.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Checkout", urlPatterns = "/checkout")
public class CheckoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //todo: getting the data from the form
        String creditCardNumber = request.getParameter("cc-num");
        String creditCardCVV = request.getParameter("cc-cvv");
        String shippingAddress = request.getParameter("shippingAddress");
        //todo getting the cartItem list
        List<CartItemDto> cartItems = (List<CartItemDto>) request.getSession().getAttribute("cartItems");
        //todo : check if the cart is empty
        if (cartItems != null && shippingAddress != null) {
            System.out.println("cartItems not null");
            if (cartItems.size() > 0 && !(shippingAddress.isEmpty() || shippingAddress.isBlank())) {
                System.out.println("cartItems > 0 ");
                UserDto currentUser = ((UserDto) request.getSession().getAttribute("currentUser"));
                CartService cartService = new CartServiceImpl();
                BankService bankService = new BankServiceImpl();
                CheckoutService checkoutService = new CheckoutServiceImpl();
                ProductService productService = new ProductServiceImpl();
                Double totalPrice = (cartService.getCartTotalPrice(currentUser.getId()));
                CreditCardDto creditCardDto = new CreditCardDto(creditCardNumber, creditCardCVV);
                if (bankService.isValidCreditCard(creditCardDto)) {
                    System.out.println("valid creditCard");
                    if (bankService.withdraw(creditCardDto, totalPrice.longValue())) {
                        System.out.println("withdrawing done");
                        productService.updateProductsAfterCheckout(cartItems);
                        System.out.println("from Servlet: inserting new cart");
                        checkoutService.getNewCart(currentUser.getId(), shippingAddress);
//                        List <CartItemDto> newCartItems = cartService.getCartItems();
                        cartItems.clear();
                        request.getSession().setAttribute("cartItems", cartItems);
                        request.getRequestDispatcher("afterCheckout.jsp").forward(request, response);
//                        request.getRequestDispatcher("cart.jsp").forward(request, response);
                        return;
                    } else {
                        System.out.println("withdrawing failed");
                    }
                } else {
                    System.out.println("creditCard is not valid");
                }
            } else {
                System.out.println("cartItems size = zero");
            }
//        } else {
//            //todo : redirect with an error attribute
//        }
//        BankService bankService = new BankServiceImpl();
//        CreditCardDto creditCardDto = new CreditCardDto(request.getParameter("CCNumber"), request.getParameter("cvv"));
//        //todo: populate orderDto object with the cart items or get the cartObject from jsp
//        OrderDto orderDto = new OrderDto();
//
//        if (bankService.isValidCreditCard(creditCardDto)) {
//
//            Double totalOrderPrice = orderDto.getProducts().keySet().stream().map(product -> {
//                        return (product.getProductPrice().doubleValue() * orderDto.getProducts().get(product));
//                    }
//            ).reduce(0.0, Double::sum);
//            if (bankService.withdraw(creditCardDto,totalOrderPrice.longValue())) {
//
//                productService.updateProductsAfterCheckout(orderDto);
//            } else {
//
//            }

//        } else {
            System.out.println("an error happen");
            request.setAttribute("Error", "true");
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }

    }

}
