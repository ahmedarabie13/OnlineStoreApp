package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.dao.ProductDao;
import gov.iti.jets.team5.dao.daoImpl.ProductDaoImpl;
import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.models.dto.OrderDto;
import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.repositories.ProductRepository;
import gov.iti.jets.team5.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl productServiceInstance = null;

    ProductRepository ps = ProductRepository.getInstance();

    public static ProductService getInstance() {
        if (productServiceInstance == null) {
            synchronized (ProductServiceImpl.class) {
                if (productServiceInstance == null) {
                    productServiceInstance = new ProductServiceImpl();
                }
            }
        }
        return productServiceInstance;
    }

    @Override
    public Boolean updateProductsAfterCheckout(OrderDto orderDto) {
        //todo: subtract the order products amounts from the db products amounts
        var products = orderDto.getProducts().keySet();
        products.stream().forEach((productDto) -> {
            Integer productQuantityInOrder = orderDto.getProducts().get(productDto);
            ProductDao productDao = ProductDaoImpl.getInstance();

            Integer storedQuantity = 12;
//                    productDao.getProductQuantity(productDto);
            Integer newAmount = storedQuantity - productQuantityInOrder;
            //todo : update the db with the product new quantity
        });

        return true;
    }


    //    @Override
//    public List<ProductDto> fetchProducts() {
//        return ps.fetchProducts();
//    }
    @Override
    public List<ProductDto> fetchProducts(int pageNumber) {
        return ps.fetchProducts(pageNumber);
    }

    @Override
    public List<ProductDto> fetchCatProducts(String category, int pageNumber) {
        return ps.fetchCatProducts(category, pageNumber);
    }

    @Override

    public List<ProductDto> fetchProductsByFilter(int pageNumber, int filterStart, int filterEnd) {
        return ps.fetchProductsByFilter(pageNumber, filterStart, filterEnd);
    }

    @Override
    public List<ProductDto> fetchProductsByFilterAndCategory(int pageNumber, String category, int filterStart, int filterEnd) {
        return ps.fetchProductsByFilterAndCategory(pageNumber, category, filterStart, filterEnd);
    }


    public long fetchNumOfProducts(String categoryId) {
        return ps.fetchNumOfProducts(categoryId);
    }

    @Override
    public Product fetchProductData(String productId) {
        return ps.fetchProductData(productId);
    }

    @Override
    public List<ProductDto> searchForProducts(String productName) {
        return ps.searchForProducts(productName);
    }

}
