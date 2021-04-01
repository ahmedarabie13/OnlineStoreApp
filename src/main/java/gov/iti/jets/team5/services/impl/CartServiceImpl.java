package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.ajaxModels.CartItemData;
import gov.iti.jets.team5.models.dbEntities.CartItems;
import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.repositories.CartRepository;
import gov.iti.jets.team5.services.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    @Override
    public Boolean addToCart(int productId, int userId) {
        //todo: access db to get the cart
        System.out.println(productId + " from cart service");
        CartRepository.getInstance().addProductToCart(productId, userId);
        //todo: add the product to the cart product list

        return true;
    }

    @Override
    public boolean updateProductQuantity(int userId, CartItemData cartItemData) {
        System.out.println("in cartService for Update");
        CartRepository cartRepository = CartRepository.getInstance();
        if (cartRepository.isQuantityValid(cartItemData)) {
            System.out.println("sufficient storeQuantity for the cart");
            cartRepository.updateQuantity(userId, cartItemData);
            return true;
        }else {
            System.out.println("insufficient quantity");
            return false;
        }

    }

    @Override
    public double getCartTotalPrice(int userId) {
        return CartRepository.getInstance().getCartTotalPrice(userId);

    }

    @Override
    public void deleteCartItem(int userId, CartItemData cartItemData) {
        CartRepository.getInstance().deleteCartItem(userId,cartItemData.getProductId());
    }

    @Override
    public List<CartItems> getCartItems(int userId) {
        return CartRepository.getInstance().getCartItems(userId);
    }
//    public CartItems
}
