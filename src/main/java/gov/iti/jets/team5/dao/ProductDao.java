package gov.iti.jets.team5.dao;

import gov.iti.jets.team5.models.entity.ProductEntity;

import java.util.List;

public interface ProductDao {
    public boolean addProduct(ProductEntity productEntity);
    public List<ProductEntity> getAllProducts();
    public boolean deleteProduct(int productID);
    public ProductEntity getProduct(int ProductID);
    public boolean deleteProduct(ProductEntity productEntity);
}