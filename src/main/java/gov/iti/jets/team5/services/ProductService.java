package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.models.dto.OrderDto;
import gov.iti.jets.team5.models.dto.ProductDto;

import java.util.List;

public interface ProductService {
//    isOrder
    Boolean updateProductsAfterCheckout(OrderDto orderDto);
    List<ProductDto> fetchProducts();

}

