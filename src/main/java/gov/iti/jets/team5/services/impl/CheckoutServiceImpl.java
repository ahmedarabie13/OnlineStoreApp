package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.repositories.OrderRepository;
import gov.iti.jets.team5.services.CheckoutService;

public class CheckoutServiceImpl implements CheckoutService {
    @Override
    public void getNewCart(int userId,String address) {
        OrderRepository orderRepository = OrderRepository.getInstance();
        System.out.println("from service: inserting new cart");
        orderRepository.getNewCart(userId,address);

    }
}
