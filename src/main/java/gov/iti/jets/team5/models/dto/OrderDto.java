package gov.iti.jets.team5.models.dto;

import java.util.HashMap;
import java.util.Map;

public class OrderDto {
    private Map<ProductDto,Integer> products = new HashMap<>();
    private UserDto userDto;

    public OrderDto(Map<ProductDto, Integer> products, UserDto userDto) {
        this.products = products;
        this.userDto = userDto;
    }

    public OrderDto() {
    }

    public Map<ProductDto, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
