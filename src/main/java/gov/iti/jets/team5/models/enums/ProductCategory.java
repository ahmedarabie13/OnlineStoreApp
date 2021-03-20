package gov.iti.jets.team5.models.enums;

import java.io.Serializable;

public enum ProductCategory implements Serializable {
    COOKING("COOKING"),
    CHOCOLATES_SNACKS("CHOCOLATES_SNACKS"),
    BEVERAGES("BEVERAGES"),
    DRIED_FRUITS("DRIED_FRUITS");

    private final String category;

    ProductCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "category='" + category + '\'' +
                '}';
    }
}
