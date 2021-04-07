package gov.iti.jets.team5.dao;

import gov.iti.jets.team5.models.entity.ProductEntity;

import java.util.List;

public interface ProductDao {
   boolean addProduct(ProductEntity productEntity);
   List<ProductEntity> getAllProducts();
   boolean deleteProduct(int productId);
   ProductEntity getProduct(int productId);
   boolean deleteProduct(ProductEntity productEntity);
//   Integer getProductQuantity(int productId);
}