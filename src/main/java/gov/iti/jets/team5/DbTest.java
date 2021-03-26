package gov.iti.jets.team5;

import gov.iti.jets.team5.models.enums.ProductStatus;
import gov.iti.jets.team5.utils.factory.AppSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import gov.iti.jets.team5.models.dbEntities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class DbTest {
    public static void main (String [] args){
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        UserData user = new UserData();
//        user.setFirstName("maha");
//        user.setLastName("mekdad");
//        user.setPhone("01146747769");
//        user.setEmail("maha@gmail.com");
//        user.setPassword("Qq1@Qq1@");
//        session.persist(user);
//        session.getTransaction().commit();
//        session.close();

        EntityManagerFactory entityManagerFactory = AppSessionFactory.getInstance();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Category cat1 = new Category();
        cat1.setName("dairies");
        Category cat2 = new Category();
        cat2.setName("veges");
        Category cat3 = new Category();
        cat3.setName("fruits");
        Category cat4 = new Category();
        cat4.setName("vegan");
        Category cat5 = new Category();
        cat5.setName("snacks");
        entityManager.persist(cat1);
        entityManager.persist(cat2);
        entityManager.persist(cat3);
        entityManager.persist(cat4);
        entityManager.persist(cat5);
        entityManager.getTransaction().commit();

        Set<Category> cats = new HashSet<>(); cats.add(cat4);

        entityManager.getTransaction().begin();
        Product p1 = new Product();
        p1.setProductName("Meatless Pieces");
        p1.setProductDescription("Vegan Meatless Meat balls Made with Soy Beans");
        p1.setQuantity(5);
        p1.setPrice(new BigDecimal("43.56"));
        p1.setSellerName("Maha");
        p1.setCategories(cats);
        //todo handle the photo and make it nullable
        p1.setPhoto("empty");
        p1.setStatus(ProductStatus.NEW.getProductStatus());

        Product p2 = new Product();
        p2.setProductName("Meatless Pieces");
        p2.setProductDescription("Vegan Meatless Meat balls Made with Soy Beans");
        p2.setQuantity(10);
        p2.setPrice(new BigDecimal("40.60"));
        p2.setSellerName("Youmna");
        p2.setCategories(cats);
        p2.setPhoto("empty");
        p2.setStatus(ProductStatus.SOLD_OUT.getProductStatus());

        entityManager.persist(p1); entityManager.persist(p2);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
