package gov.iti.jets.team5.repositories;

import gov.iti.jets.team5.models.dbEntities.PotentialOrders;
import gov.iti.jets.team5.models.dto.UserDto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import gov.iti.jets.team5.models.dbEntities.UserData;

import java.util.List;

public class UserRepository {

    private static UserRepository userRepositoryInstance = null;

    public static UserRepository getInstance() {
        if (userRepositoryInstance == null) {
            synchronized (UserRepository.class) {
                if (userRepositoryInstance == null) {
                    userRepositoryInstance = new UserRepository();
                }
            }
        }
        return userRepositoryInstance;
    }

    public boolean isRegistered(String enteredEmail){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query q = session.createQuery("select count(*) from UserData u where u.email = :email")
                .setParameter("email", enteredEmail);
        List<Integer> rows = q.list();
        System.out.println("rows.get(0): " + rows.get(0));
//        boolean result = (rows.get(0) == 0) ? false : true;
        System.out.println("BOO");
        session.close();
        if(rows.get(0) == 0){
            System.out.println("BOO");
            return false;
        } else {
            System.out.println("WOO");
            return true;
        }
//        return result;
    }

    public boolean registerUser(UserDto userDto){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            UserData userToRegister = new UserData();
            userToRegister.setFirstName(userDto.getFirstName());
            userToRegister.setLastName(userDto.getLastName());
            userToRegister.setEmail(userDto.getEmail());
            userToRegister.setPhone(userDto.getPhone());
            userToRegister.setPassword(userDto.getPassword());
            userToRegister.setUserRole("user");
            session.persist(userToRegister);
            session.getTransaction().commit();
            PotentialOrders userActiveCart = new PotentialOrders();
            userActiveCart.setUserData(userToRegister);
            userActiveCart.setActive(true);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
