package gov.iti.jets.team5.models.ajaxModels;

public class CartItemData {
    private String operation;
    private int productId;
    private int cartItemQuantity;

    public CartItemData() {
    }

    public int getProductId() {
        return productId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void setCartItemQuantity(int cartItemQuantity) {
        this.cartItemQuantity = cartItemQuantity;
    }

    @Override
    public String toString() {
        return "CartItemData{" +
                "productId=" + productId +
                ", productCartQuantity=" + cartItemQuantity +
                '}';
    }
}
