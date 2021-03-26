package gov.iti.jets.team5.dao.daoImpl;

import gov.iti.jets.team5.dao.ProductDao;
import gov.iti.jets.team5.models.entity.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static ProductDaoImpl productDaoInstance;

    private ProductDaoImpl() {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("hibernateGettingStarted");
        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();

    }

    // Singleton
    public static ProductDaoImpl getInstance() {
        if (productDaoInstance == null) {
            productDaoInstance = new ProductDaoImpl();
        }
        return productDaoInstance;
    }

    @Override
    public boolean addProduct(ProductEntity productEntity) {
        return false;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return null;
    }

    @Override
    public boolean deleteProduct(int productID) {
        return false;
    }

    @Override
    public ProductEntity getProduct(int ProductID) {
        return null;
    }

    @Override
    public boolean deleteProduct(ProductEntity productEntity) {
        return false;
    }

//    @Override
//    public Integer getProductQuantity(ProductEntity productEntity) {
//        return null;
//    }

}
