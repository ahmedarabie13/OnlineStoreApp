package gov.iti.jets.team5.repositories;

import gov.iti.jets.team5.models.dbEntities.Category;
import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.enums.ProductStatus;
import gov.iti.jets.team5.utils.factory.AppSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductRepository {

    private static ProductRepository productRepositoryInstance = null;
    private int pageSize = 9;

    EntityManagerFactory entityManagerFactory = AppSessionFactory.getInstance();
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static ProductRepository getInstance() {
        if (productRepositoryInstance == null) {
            synchronized (UserRepository.class) {
                if (productRepositoryInstance == null) {
                    productRepositoryInstance = new ProductRepository();
                }
            }
        }
        return productRepositoryInstance;
    }

    //    public List<ProductDto> fetchProducts(){
//        Query q = entityManager.createQuery("from Product");
//        List<Product> products = q.getResultList();
//        List<ProductDto> theProducts = new ArrayList<>();
//        for (Product p : products) {
//            ProductDto productDto = new ProductDto();
//            productDto.setProductID(String.valueOf(p.getId()));
//            productDto.setProductName(p.getProductName());
//            productDto.setProductImageURL("images/products/MeatlessPieces.png");
//            productDto.setProductPrice(p.getPrice().doubleValue());
//            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
//            theProducts.add(productDto);
//        }
//        System.out.println("Returned Product List Size: " + products.size());
//        return theProducts;
//    }
    public List<ProductDto> fetchProducts(int pageNumber) {
//        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Product");
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);

        List<Product> products = query.getResultList();
        List<ProductDto> theProducts = new ArrayList<>();

        for (Product p : products) {
            ProductDto productDto = new ProductDto();
            productDto.setProductID(String.valueOf(p.getId()));
            productDto.setProductName(p.getProductName());
            productDto.setProductImageURL("images/products/MeatlessPieces.png");
            productDto.setProductPrice(p.getPrice().doubleValue());
            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
            theProducts.add(productDto);
        }
        System.out.println("Returned Product List Size: " + products.size());
//        entityManager.getTransaction().commit();
        return theProducts;
    }

    public List<ProductDto> fetchCatProducts(int category, int pageNumber) {
        System.out.println("$$$$$$$ 1");
        Query query = entityManager.createQuery("from Category cat where cat.id = :category")
                .setParameter("category", category);
        List<Category> returnedCatObj = query.getResultList();
        Set<Product> catProducts = returnedCatObj.get(0).getProducts();
        List<ProductDto> theProducts = new ArrayList<>();
//        for(int i = (pageNumber - 1) * pageSize; i <= pageSize; i++){
//            Product item = catProducts.
//            ProductDto productDto = new ProductDto();
//            productDto.setProductID(String.valueOf(p.getId()));
//            productDto.setProductName(p.getProductName());
//            productDto.setProductImageURL("images/products/MeatlessPieces.png");
//            productDto.setProductPrice(p.getPrice().doubleValue());
//            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
//            theProducts.add(productDto);
//        }
        for (Product p : catProducts) {
            ProductDto productDto = new ProductDto();
            productDto.setProductID(String.valueOf(p.getId()));
            productDto.setProductName(p.getProductName());
            productDto.setProductImageURL("images/products/MeatlessPieces.png");
            productDto.setProductPrice(p.getPrice().doubleValue());
            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
            theProducts.add(productDto);
            System.out.println("$$$$$$$ " + p.getProductName());
        }
        return theProducts;
    }

    public long fetchNumOfProducts() {
        Query q = entityManager.createQuery("select count(*) from Product");
        var productsNum = q.getResultList();
        System.out.println("number of products: " + (long) productsNum.get(0));
        return (long) productsNum.get(0);
    }

    public List<ProductDto> fetchProductsByFilter(int pageNumber, int filterStart, int filterEnd) {
        BigDecimal filterStartDecimal = new BigDecimal(filterStart);
        BigDecimal filterEndDecimal = new BigDecimal(filterEnd);
        Query query = entityManager.createQuery(
                "from Product p where p.price between : startPrice and :endPrice")
                .setParameter("startPrice", filterStartDecimal)
                .setParameter("endPrice", filterEndDecimal);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);

        List<Product> products = query.getResultList();
        List<ProductDto> theProducts = new ArrayList<>();

        for (Product p : products) {
            ProductDto productDto = new ProductDto();
            productDto.setProductID(String.valueOf(p.getId()));
            productDto.setProductName(p.getProductName());
            productDto.setProductImageURL("images/products/MeatlessPieces.png");
            productDto.setProductPrice(p.getPrice().doubleValue());
            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
            theProducts.add(productDto);
        }
        System.out.println("Returned Product List Size: " + products.size());
//        entityManager.getTransaction().commit();
        return theProducts;
    }

//    public List<ProductDto> fetchProductsByFilterAndCategory(int pageNumber, int category, int filterStart, int filterEnd) {
//        BigDecimal filterStartDecimal = new BigDecimal(filterStart);
//        BigDecimal filterEndDecimal = new BigDecimal(filterEnd);
//        Query query = entityManager.createQuery("from Category cat where cat.id = :category")
//                .setParameter("category", category);
//        List<Category> returnedCatObj = query.getResultList();
//        Category category1 = returnedCatObj.get(0);
//        Set<Product> catProducts = category1.getProducts();
//
//        List<ProductDto> theProducts = new ArrayList<>();
////        for(int i = (pageNumber - 1) * pageSize; i <= pageSize; i++){
////            Product item = catProducts.
////            ProductDto productDto = new ProductDto();
////            productDto.setProductID(String.valueOf(p.getId()));
////            productDto.setProductName(p.getProductName());
////            productDto.setProductImageURL("images/products/MeatlessPieces.png");
////            productDto.setProductPrice(p.getPrice().doubleValue());
////            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
////            theProducts.add(productDto);
////        }
//
//        for (Product product : catProducts) {
//            if (product.getPrice().compareTo(filterStartDecimal) > 0 && product.getPrice().compareTo(filterEndDecimal) < 0) {
//                ProductDto productDto = new ProductDto();
//                productDto.setProductID(String.valueOf(product.getId()));
//                productDto.setProductName(product.getProductName());
//                productDto.setProductImageURL("images/products/MeatlessPieces.png");
//                productDto.setProductPrice(product.getPrice().doubleValue());
//                productDto.setProductStatus(ProductStatus.valueOf(product.getStatus()));
//                theProducts.add(productDto);
//                System.out.println("$$$$$$$ " + product.getProductName());
//
//            }
//        }
//        return theProducts;
//    }

    public List<ProductDto> fetchProductsByFilterAndCategory(int pageNumber, String category, int filterStart, int filterEnd) {
        BigDecimal filterStartDecimal = new BigDecimal(filterStart);
        BigDecimal filterEndDecimal = new BigDecimal(filterEnd);
        try{
            int categoryId = Integer.parseInt(category);
            Query query = entityManager.createQuery("from Category cat where cat.id = :category")
                    .setParameter("category", categoryId);
            List<Category> returnedCatObj = query.getResultList();
            if(returnedCatObj.isEmpty()){
                return null;
            } else {
                Set<Product> catProducts = returnedCatObj.get(0).getProducts();
                List<Product> catProductsList = new ArrayList<>(catProducts);
                List<ProductDto> theProducts = new ArrayList<>();
                int size = Math.min(pageSize, catProductsList.size());
                for(int i = (pageNumber - 1) * pageSize; i < size; i++){
                        Product product = catProductsList.get(i);
                    if (product.getPrice().compareTo(filterStartDecimal) > 0 && product.getPrice().compareTo(filterEndDecimal) < 0) {
                        ProductDto productDto = new ProductDto();
                        productDto.setProductID(String.valueOf(product.getId()));
                        productDto.setProductName(product.getProductName());
                        productDto.setProductImageURL("images/products/MeatlessPieces.png");
                        productDto.setProductPrice(product.getPrice().doubleValue());
                        productDto.setProductStatus(ProductStatus.valueOf(product.getStatus()));
                        theProducts.add(productDto);
                    }
                }
                return theProducts;
            }
        } catch (NumberFormatException e ){
            return null;
        }
    }
}
