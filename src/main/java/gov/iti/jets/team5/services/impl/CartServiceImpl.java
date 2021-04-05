package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.ajaxModels.CartItemData;
import gov.iti.jets.team5.models.dto.CartItemDto;

import gov.iti.jets.team5.repositories.CartRepository;
import gov.iti.jets.team5.services.CartService;
import gov.iti.jets.team5.utils.mappers.CartItemDtoMapper;

import java.util.List;

public class CartServiceImpl implements CartService {
    @Override
    public String addToCart(int productId, int userId) {
        return CartRepository.getInstance().addProductToCart(productId, userId);
    }

    @Override
    public boolean updateProductQuantity(int userId, CartItemData cartItemData) {
        System.out.println("in cartService for Update");
        CartRepository cartRepository = CartRepository.getInstance();
        if (cartRepository.isQuantityValid(cartItemData)) {
            System.out.println("sufficient storeQuantity for the cart");
            cartRepository.updateQuantity(userId, cartItemData);
            return true;
        } else {
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
        CartRepository.getInstance().deleteCartItem(userId, cartItemData.getProductId());
    }

    @Override
    public List<CartItemDto> getCartItems(int userId) {

        var cartItems = CartRepository.getInstance().getCartItems(userId);
        CartItemDtoMapper cartItemDtoMapper = new CartItemDtoMapper();
        return cartItemDtoMapper.getListDto(cartItems);
    }
}
