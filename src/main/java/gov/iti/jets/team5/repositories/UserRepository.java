package gov.iti.jets.team5.repositories;

import gov.iti.jets.team5.models.dbEntities.PotentialOrders;
import gov.iti.jets.team5.models.dto.UserDto;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.query.Query;
import gov.iti.jets.team5.models.dbEntities.UserData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UserRepository {

    private static UserRepository userRepositoryInstance = null;

    //todo make EntityManagerFactory singleton
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaTest");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

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
        //entityManager.getTransaction().begin();
        Query q = entityManager.createQuery("select count(*) from UserData u where u.email = :email")
                .setParameter("email", enteredEmail);
        List<Integer> rows = q.getResultList();
        System.out.println("rows.get(0): " + rows.get(0));
        boolean result = (Integer.parseInt(String.valueOf(rows.get(0))) == 0) ? false : true;
        //entityManager.getTransaction().commit();
        //System.out.println("BOO");
        //entityManager.close();
        //System.out.println("WOO");
        System.out.println(result + " The result");
        return result;

    }

    public boolean registerUser(UserDto userDto){
        entityManager.getTransaction().begin();
        try {
            UserData userToRegister = new UserData();
            userToRegister.setFirstName(userDto.getFirstName());
            userToRegister.setLastName(userDto.getLastName());
            userToRegister.setEmail(userDto.getEmail());
            userToRegister.setPhone(userDto.getPhone());
            userToRegister.setPassword(userDto.getPassword());
            userToRegister.setUserRole("user");
            entityManager.persist(userToRegister);
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
            PotentialOrders userActiveCart = new PotentialOrders();
            userActiveCart.setUserData(userToRegister);
            userActiveCart.setActive(true);
            entityManager.persist(userActiveCart);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
