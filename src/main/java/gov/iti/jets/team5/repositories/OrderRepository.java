package gov.iti.jets.team5.repositories;

import gov.iti.jets.team5.models.dbEntities.PotentialOrders;
import gov.iti.jets.team5.utils.factory.AppSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class OrderRepository {
    private EntityManagerFactory entityManagerFactory = AppSessionFactory.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static OrderRepository instance = null;

    public static OrderRepository getInstance() {
        if (instance == null) {
            synchronized (OrderRepository.class) {
                if (instance == null) {
                    instance = new OrderRepository();
                }
            }
        }
        return instance;
    }

    private OrderRepository() {

    }

    public void getNewCart(int userId) {
        try {
            entityManager.getTransaction().begin();
            //todo get current cart orderId
            int orderId = ((PotentialOrders) entityManager.createQuery("from PotentialOrders p where p.userData.id = :user_id and p.active = true")
                    .setParameter("user_id", userId).getResultList()
                    .get(0))
                    .getOrderId();

            //todo: update active field in current cart
            //todo: insert new row for the new cart

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
        }
    }
}
