package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dto.OrderDto;

public interface ProductService {
//    isOrder
    Boolean updateProductsAfterCheckout(OrderDto orderDto);

}

