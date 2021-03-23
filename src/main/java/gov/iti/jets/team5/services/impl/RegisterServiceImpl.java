package gov.iti.jets.team5.services.impl;

import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.repositories.UserRepository;
import gov.iti.jets.team5.services.RegisterService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class RegisterServiceImpl implements RegisterService {

    private static RegisterServiceImpl registerServiceInstance = null;

    //todo maybe moved to a class that generates sessions for the services classes
    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    Session session = sessionFactory.openSession();

    public static RegisterService getInstance() {
        System.out.println("inside3 get instance");
        if (registerServiceInstance == null) {
            System.out.println("inside4 get instance");
            synchronized (RegisterServiceImpl.class) {
                if (registerServiceInstance == null) {
                    System.out.println("inside5 get instance");
                    registerServiceInstance = new RegisterServiceImpl();
                }
                System.out.println("inside6 get instance");
            }
            System.out.println("inside7 get instance");
        }
        System.out.println("inside8 get instance");
        return registerServiceInstance;
    }

    @Override
    public boolean isRegistered(String email) {
        //boolean isRegistered = UserRepository.isRegistered(email, session);
        //todo real db check
        if (email.equals("maha@gmail.com")) {
            return true;
        } else {
            return false;
        }
//        if (isRegistered) {
//            return true;
//        } else {
//            return false;
//        }
    }

    @Override
    public boolean registerUser(UserDto userDto) {
        //todo go and register the user in the db
        //todo either to send the object itself or the attributes in it? according to hibernate
        return true;
    }
}
