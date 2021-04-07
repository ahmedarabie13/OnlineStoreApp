package gov.iti.jets.team5.utils.mappers;

import gov.iti.jets.team5.models.dbEntities.CartItems;
import gov.iti.jets.team5.models.dto.CartItemDto;

public class CartItemDtoMapper extends AbstractDtoMapper<CartItemDto, CartItems> {
    @Override
    public CartItemDto getDto(CartItems entity) {
        CartItemDto cartItemDto = new CartItemDto();
        ProductDtoMapper productDtoMapper = new ProductDtoMapper();
        cartItemDto.setProduct(productDtoMapper.getDto(entity.getProduct()));
        cartItemDto.setQuantity(entity.getQuantity());
        return cartItemDto;
    }
}
