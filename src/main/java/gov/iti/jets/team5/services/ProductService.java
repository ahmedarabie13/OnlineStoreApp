package gov.iti.jets.team5.services;

import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.models.dto.CategoryDto;
import gov.iti.jets.team5.models.dto.OrderDto;
import gov.iti.jets.team5.models.dto.ProductDto;

import java.util.List;

public interface ProductService {
//    isOrder
    Boolean updateProductsAfterCheckout(OrderDto orderDto);
//    List<ProductDto> fetchProducts();

    List<ProductDto> fetchProducts(int pageNumber);

    List<ProductDto> fetchProductsByFilter(int pageNumber, int filterStart, int filterEnd);

    List<ProductDto> fetchProductsByFilterAndCategory(int pageNumber, String category, int filterStart, int filterEnd);
    List<ProductDto> fetchCatProducts(String category, int pageNumber);
    long fetchNumOfProducts(String categoryId);
    Product fetchProductData(String productId);
    List <ProductDto> searchForProducts(String productName);

}

