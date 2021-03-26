package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.services.CartService;

public class CartServiceImpl implements CartService {
    @Override
    public Boolean addToCart(UserDto userDto,ProductDto product) {
        //todo: access db to get the cart

        //todo: add the product to the cart product list

        return true;
    }
}
