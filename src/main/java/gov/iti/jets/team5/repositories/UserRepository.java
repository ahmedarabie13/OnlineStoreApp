package gov.iti.jets.team5.repositories;

import gov.iti.jets.team5.models.dbEntities.PotentialOrders;
import gov.iti.jets.team5.models.dto.UserAuthDto;
import gov.iti.jets.team5.models.dto.UserDto;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.query.Query;
import gov.iti.jets.team5.models.dbEntities.UserData;
import gov.iti.jets.team5.utils.factory.AppSessionFactory;
import gov.iti.jets.team5.utils.mappers.UserDtoMapper;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static UserRepository userRepositoryInstance = null;

    private EntityManagerFactory entityManagerFactory = AppSessionFactory.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

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


    public boolean isRegistered(String enteredEmail) {
        //entityManager.getTransaction().begin();
        Query q = entityManager.createQuery("select count(*) from UserData u where u.email = :email")
                .setParameter("email", enteredEmail);
        List<Integer> rows = q.getResultList();
        System.out.println("rows.get(0): " + rows.get(0));
        boolean result = (Integer.parseInt(String.valueOf(rows.get(0))) == 0) ? false : true;
        //entityManager.getTransaction().commit();
        System.out.println(result + " The result");
        return result;

    }

    public boolean registerUser(UserDto userDto) {
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
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().commit();
            return false;
        }
    }

    public UserAuthDto getUserAuth(String email) {
        entityManager.getTransaction().begin();
        var list = entityManager.createQuery("from UserData u where u.email = :email")
                .setParameter("email", email).getResultList();
        UserAuthDto userAuthDto = null;
        if (list.size() == 1) {
            UserData userData = (UserData) list.get(0);
            System.out.println(userData);
            userAuthDto = new UserAuthDto(userData.getEmail(), userData.getPassword(), userData.getId());
        }
        entityManager.getTransaction().commit();
        return userAuthDto;


    }

    public List<UserDto> fetchAllUsers() {
        List<UserDto> users = new ArrayList<>();

        List userDataList = entityManager.createQuery("from UserData").getResultList();

        for (int i = 0 ; i < userDataList.size() ; i++) {
            UserData userData = (UserData) userDataList.get(i);
            UserDto userDto = new UserDto(userData.getFirstName(), userData.getLastName(), userData.getEmail(),
                    userData.getPhone(), userData.getPassword());
            userDto.setId(userData.getId());
            userDto.setStreet(userData.getStreet());
            userDto.setCity(userData.getCity());
            userDto.setUserRole(userData.getUserRole());

            users.add(userDto);
        }

        return users;
    }

    public UserDto getUserById(int id) {
        entityManager.getTransaction().begin();
        UserData userData = entityManager.find(UserData.class, id);
        UserDto userDto = null;
        if (userData != null) {
            UserDtoMapper userDtoMapper = new UserDtoMapper();
            userDto = userDtoMapper.getDto(userData);
        }
        entityManager.getTransaction().commit();
        return userDto;
    }

    public Boolean isUserExist(int id) {
        entityManager.getTransaction().begin();
        UserData userData = entityManager.find(UserData.class, id);
        entityManager.getTransaction().commit();
        if (userData != null) {
            return true;
        }
        else {
            return false;
        }
    }
}
