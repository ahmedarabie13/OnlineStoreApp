package gov.iti.jets.team5.models.enums;

import java.io.Serializable;

public enum ProductStatus implements Serializable {
    SALE("SALE"),
    SOLD_OUT("SOLD_OUT"),
    NEW("NEW");

    private String productStatus;

    ProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return productStatus;
    }
}
