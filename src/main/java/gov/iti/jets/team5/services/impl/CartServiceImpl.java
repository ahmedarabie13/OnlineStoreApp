package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.repositories.CartRepository;
import gov.iti.jets.team5.services.CartService;

public class CartServiceImpl implements CartService {
    @Override
    public Boolean addToCart(int productId,int userId) {
        //todo: access db to get the cart
        System.out.println(productId + " from cart service");
        CartRepository.getInstance().addProductToCart(productId,userId);
        //todo: add the product to the cart product list

        return true;
    }
//    public CartItems
}
