package gov.iti.jets.team5;

import gov.iti.jets.team5.models.dbEntities.Category;
import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.models.enums.ProductStatus;
import gov.iti.jets.team5.utils.factory.AppSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class DbTest {
    public static void main(String[] args) {
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

        Set<Category> catsV = new HashSet<>();
        catsV.add(cat4);
        Set<Category> catsD = new HashSet<>();
        catsD.add(cat1);
        Set<Category> catsVS = new HashSet<>();
        catsVS.add(cat2);
        Set<Category> catsF = new HashSet<>();
        catsF.add(cat3);
        Set<Category> catsS = new HashSet<>();
        catsS.add(cat5);

//        entityManager.getTransaction().begin();
//        Product p1 = new Product();
//        p1.setProductName("Meatless Pieces");
//        p1.setProductDescription("Vegan Meatless Meat balls Made with Soy Beans");
//        p1.setQuantity(5);
//        p1.setPrice(new BigDecimal("3000.56"));
//        p1.setSellerName("Maha");
//        p1.setCategories(catsV);
//        //todo handle the photo and make it nullable
//        p1.setPhoto("empty");
//        p1.setStatus(ProductStatus.NEW.getProductStatus());
//
//        Product p2 = new Product();
//        p2.setProductName("Meatless Pieces");
//        p2.setProductDescription("Vegan Meatless Meat balls Made with Soy Beans");
//        p2.setQuantity(10);
//        p2.setPrice(new BigDecimal("2000.60"));
//        p2.setSellerName("Youmna");
//        p2.setCategories(catsV);
//        p2.setPhoto("empty");
//        p2.setStatus(ProductStatus.SOLD_OUT.getProductStatus());
//
//        Product p3 = new Product();
//        p3.setProductName("Milk");
//        p3.setProductDescription("Fresh Milk");
//        p3.setQuantity(52);
//        p3.setPrice(new BigDecimal("20.36"));
//        p3.setSellerName("Assem");
//        p3.setCategories(catsD);
//        //todo handle the photo and make it nullable
//        p3.setPhoto("empty");
//        p3.setStatus(ProductStatus.NEW.getProductStatus());
//
//        Product p4 = new Product();
//        p4.setProductName("Yogurt");
//        p4.setProductDescription("Fresh Yogurt");
//        p4.setQuantity(100);
//        p4.setPrice(new BigDecimal("6"));
//        p4.setSellerName("Assem");
//        p4.setCategories(catsD);
//        p4.setPhoto("empty");
//        p4.setStatus(ProductStatus.SOLD_OUT.getProductStatus());
//
//        Product p5 = new Product();
//        p5.setProductName("Carrot");
//        p5.setProductDescription("Fresh Carrot");
//        p5.setQuantity(5);
//        p5.setPrice(new BigDecimal("3.56"));
//        p5.setSellerName("Arabie");
//        p5.setCategories(catsVS);
////        todo handle the photo and make it nullable
//        p5.setPhoto("empty");
//        p5.setStatus(ProductStatus.NEW.getProductStatus());
//
//        Product p6 = new Product();
//        p6.setProductName("Apple");
//        p6.setProductDescription("Fresh Apple");
//        p6.setQuantity(10);
//        p6.setPrice(new BigDecimal("4"));
//        p6.setSellerName("Arabie");
//        p6.setCategories(catsF);
//        p6.setPhoto("empty");
//        p6.setStatus(ProductStatus.SOLD_OUT.getProductStatus());
//
//        Product p7 = new Product();
//        p7.setProductName("Banana");
//        p7.setProductDescription("Fresh Banana");
//        p7.setQuantity(5);
//        p7.setPrice(new BigDecimal("6"));
//        p7.setSellerName("Arabie");
//        p7.setCategories(catsF);
//        //todo handle the photo and make it nullable
//        p7.setPhoto("empty");
//        p7.setStatus(ProductStatus.NEW.getProductStatus());
//
//        Product p8 = new Product();
//        p8.setProductName("Lays");
//        p8.setProductDescription("Hot Pepper Chips");
//        p8.setQuantity(10);
//        p8.setPrice(new BigDecimal("5"));
//        p8.setSellerName("Youmna");
//        p8.setCategories(catsS);
//        p8.setPhoto("empty");
//        p8.setStatus(ProductStatus.SOLD_OUT.getProductStatus());
//
//        Product p9 = new Product();
//        p9.setProductName("Doritos");
//        p9.setProductDescription("Sweet Pepper Corn Chips");
//        p9.setQuantity(5);
//        p9.setPrice(new BigDecimal("5"));
//        p9.setSellerName("Youmna");
//        p9.setCategories(catsS);
//        //todo handle the photo and make it nullable
//        p9.setPhoto("empty");
//        p9.setStatus(ProductStatus.NEW.getProductStatus());
//
//        Product p10 = new Product();
//        p10.setProductName("Oreo");
//        p10.setProductDescription("Chocolate Biscuits");
//        p10.setQuantity(10);
//        p10.setPrice(new BigDecimal("5"));
//        p10.setSellerName("Youmna");
//        p10.setCategories(catsS);
//        p10.setPhoto("empty");
//        p10.setStatus(ProductStatus.SOLD_OUT.getProductStatus());
//
//        Product p11 = new Product();
//        p11.setProductName("Oreo2");
//        p11.setProductDescription("Chocolate Biscuits");
//        p11.setQuantity(10);
//        p11.setPrice(new BigDecimal("5"));
//        p11.setSellerName("Youmna");
//        p11.setCategories(catsS);
//        p11.setPhoto("empty");
//        p11.setStatus(ProductStatus.SOLD_OUT.getProductStatus());
//
//        entityManager.persist(p1);
//        entityManager.persist(p2);
//        entityManager.persist(p3);
//        entityManager.persist(p4);
//        entityManager.persist(p5);
//        entityManager.persist(p6);
//        entityManager.persist(p7);
//        entityManager.persist(p8);
//        entityManager.persist(p9);
//        entityManager.persist(p10);
//
//        entityManager.persist(p11);
//        entityManager.getTransaction().commit();

//        Query q = entityManager.createQuery("from Product p where p.id = :pid")
//                .setParameter("pid", 90);
//        List<Product> pro = q.getResultList();
//        System.out.println(pro);
        entityManager.close();
    }
}
