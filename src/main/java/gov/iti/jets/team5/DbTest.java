package gov.iti.jets.team5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import gov.iti.jets.team5.models.dbEntities.*;
public class DbTest {
    public static void main (String [] args){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserData user = new UserData();
        user.setFirstName("maha");
        user.setLastName("mekdad");
        user.setPhone("01146747769");
        user.setEmail("maha@gmail.com");
        user.setPassword("Qq1@Qq1@");
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }
}
