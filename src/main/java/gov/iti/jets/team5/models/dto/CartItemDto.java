package gov.iti.jets.team5.models.dto;

public class CartItemDto {
    private int quantity;
    private ProductDto product;

    public CartItemDto(int quantity, ProductDto product) {
        this.quantity = quantity;
        this.product = product;
    }

    public CartItemDto() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
