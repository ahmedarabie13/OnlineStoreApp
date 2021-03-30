package gov.iti.jets.team5.repositories;

import gov.iti.jets.team5.models.dbEntities.Category;
import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.models.dto.ProductDto;
import gov.iti.jets.team5.models.enums.ProductStatus;
import gov.iti.jets.team5.utils.factory.AppSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductRepository {

    private static ProductRepository productRepositoryInstance = null;

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
    public List<ProductDto> fetchProducts(int pageNumber){
//        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from Product");

        int pageSize = 10;
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);

        List<Product> products = query.getResultList();
        List<ProductDto> theProducts = new ArrayList<>();

        for (Product p : products) {
            ProductDto productDto = new ProductDto();
            productDto.setProductID(String.valueOf(p.getId()));
            productDto.setProductName(p.getProductName());
            productDto.setProductImageURL("images/products/MeatlessPieces.png");
            productDto.setProductPrice(p.getPrice());
            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
            theProducts.add(productDto);
        }
        System.out.println("Returned Product List Size: " + products.size());
//        entityManager.getTransaction().commit();
        return theProducts;
    }

    public List<ProductDto> fetchCatProducts(int category, int pageNumber){
        System.out.println("$$$$$$$ 1");
        int pageSize = 10;
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
            productDto.setProductPrice(p.getPrice());
            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
            theProducts.add(productDto);
            System.out.println("$$$$$$$ " + p.getProductName() );
        }
        return theProducts;
    }

    public long fetchNumOfProducts(){
        Query q = entityManager.createQuery("select count(*) from Product");
        var productsNum = q.getResultList();
        System.out.println("number of products: " + (long) productsNum.get(0));
        return (long) productsNum.get(0);
    }

}
