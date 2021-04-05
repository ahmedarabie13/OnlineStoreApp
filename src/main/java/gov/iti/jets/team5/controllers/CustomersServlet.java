package gov.iti.jets.team5.controllers;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import gov.iti.jets.team5.models.dto.OrderDetailsDto;
import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.repositories.OrderRepository;
import gov.iti.jets.team5.services.UserService;
import gov.iti.jets.team5.services.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/customers")
public class CustomersServlet extends HttpServlet {
    private static List<UserDto> users = new CopyOnWriteArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserServiceImpl.getInstance();

        String idStr = request.getParameter("id");
        if (idStr != null) {
            System.out.println("idStr = " + idStr);
            int id = Integer.parseInt(idStr);
            UserDto userDto = userService.fetchUserByID(id);

            if (userDto != null) {
                // todo don't use repository
                OrderRepository orderRepository = OrderRepository.getInstance();
                List<OrderDetailsDto> orders = orderRepository.fetchOrdersByUserId(id);

                System.out.println("Orders size before forward " + orders.size());
                System.out.println(orders);

                request.setAttribute("userData", userDto);
                request.setAttribute("orders", orders);

                request.getRequestDispatcher("customerDetails.jsp").forward(request, response);
            }
        } else {
            users = userService.fetchUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("customers.jsp").forward(request, response);
        }
    }
}
