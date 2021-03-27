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
            productDto.setProductPrice(p.getPrice().doubleValue());
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
        List<Product> catProductsList = new ArrayList<>(catProducts);
        List<ProductDto> theProducts = new ArrayList<>();
        int size = Math.min(pageSize, catProductsList.size());
        for(int i = (pageNumber - 1) * pageSize; i < size; i++){
            Product item = catProductsList.get(i);
            ProductDto productDto = new ProductDto();
            productDto.setProductID(String.valueOf(item.getId()));
            productDto.setProductName(item.getProductName());
            productDto.setProductImageURL("images/products/MeatlessPieces.png");
            productDto.setProductPrice(item.getPrice().doubleValue());
            productDto.setProductStatus(ProductStatus.valueOf(item.getStatus()));
            theProducts.add(productDto);
        }
//        for (Product p : catProducts) {
//            ProductDto productDto = new ProductDto();
//            productDto.setProductID(String.valueOf(p.getId()));
//            productDto.setProductName(p.getProductName());
//            productDto.setProductImageURL("images/products/MeatlessPieces.png");
//            productDto.setProductPrice(p.getPrice().doubleValue());
//            productDto.setProductStatus(ProductStatus.valueOf(p.getStatus()));
//            theProducts.add(productDto);
//            System.out.println("$$$$$$$ " + p.getProductName() );
//        }
        return theProducts;
    }

    public long fetchNumOfProducts(String categoryId){
        if(categoryId == null){
            Query q = entityManager.createQuery("select count(*) from Product");
            var productsNum = q.getResultList();
            System.out.println("number of products: " + (long) productsNum.get(0));
            return (long) productsNum.get(0);
        } else {
            int catId = Integer.parseInt(categoryId);
            Query q = entityManager.createQuery("from Category c where c.id = :cid")
                    .setParameter("cid", catId);
            List<Category> cats = q.getResultList();
            Category theCat = cats.get(0);
            System.out.println("number of products with cat: " + (long) theCat.getProducts().size());
            return (long) theCat.getProducts().size();
        }
    }

}
