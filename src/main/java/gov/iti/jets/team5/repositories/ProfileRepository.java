package gov.iti.jets.team5.repositories;

import gov.iti.jets.team5.models.dbEntities.PotentialOrders;
import gov.iti.jets.team5.models.dbEntities.UserData;
import gov.iti.jets.team5.models.dto.UserDto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProfileRepository {
    private static ProfileRepository profileRepositoryInstance = null;

    public static ProfileRepository getInstance() {
        if (profileRepositoryInstance == null) {
            synchronized (ProfileRepository.class) {
                if (profileRepositoryInstance == null) {
                    profileRepositoryInstance = new ProfileRepository();
                }
            }
        }
        return profileRepositoryInstance;
    }

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaTest");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public boolean updateUser(UserDto userDto,int userId) {

        try {
            entityManager.getTransaction().begin();
            System.out.println("from repoooo");
            UserData userToUpdate = new UserData();
            userToUpdate = entityManager.find(UserData.class,userId);
            entityManager.getTransaction().commit();
            entityManager.detach(userToUpdate);
            System.out.println(userToUpdate.getPhone());
            entityManager.getTransaction().begin();
            userToUpdate.setFirstName(userDto.getFirstName());
            userToUpdate.setLastName(userDto.getLastName());
            userToUpdate.setEmail(userDto.getEmail());
            System.out.println(userDto.getEmail());
            userToUpdate.setPhone(userDto.getPhone());
            userToUpdate.setPassword(userDto.getPassword());
            userToUpdate.setCity(userDto.getCity());
            userToUpdate.setBirthdate(userDto.getDateOfBirth());
            userToUpdate.setStreet(userDto.getStreet());
            userToUpdate.setUserRole("user");
            entityManager.merge(userToUpdate);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public UserDto getCurrentUser(int userId) {
        //entityManager.getTransaction().begin();
        try {

            UserData currentUser = new UserData();
            currentUser = entityManager.find(UserData.class, userId);
            UserDto userDto= new UserDto();
            userDto.setFirstName(currentUser.getFirstName());
            userDto.setDateOfBirth(currentUser.getBirthdate());
            userDto.setStreet(currentUser.getStreet());
            userDto.setCity(currentUser.getCity());
            userDto.setEmail(currentUser.getEmail());
            userDto.setPhone(currentUser.getPhone());
            userDto.setLastName(currentUser.getLastName());
            userDto.setPassword(currentUser.getPassword());
            return userDto;
        } catch (Exception e){
        e.printStackTrace();
        return null;
    }

    }


}
