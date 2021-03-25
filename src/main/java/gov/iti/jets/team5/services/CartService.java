package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.dto.UserDto;

public interface CartService {
    //todo: get the cart and add the product to it
    Boolean addToCart(UserDto userDto, ProductDto product);
}
