package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.ajaxModels.CartItemData;
import gov.iti.jets.team5.models.dbEntities.CartItems;
import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.dto.UserDto;

import java.util.List;

public interface CartService {
    //todo: get the cart and add the product to it
    String addToCart(int productId,int userId);

    boolean updateProductQuantity(int userId, CartItemData cartItemData);
    double getCartTotalPrice(int userId);

    void deleteCartItem(int userId, CartItemData cartItemData);

    List<CartItems> getCartItems(int userId);
}
