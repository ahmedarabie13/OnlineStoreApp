package gov.iti.jets.team5.repositories;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import gov.iti.jets.team5.models.dbEntities.Orders;
import gov.iti.jets.team5.models.dbEntities.UserData;
import gov.iti.jets.team5.models.dto.OrderDetailsDto;
import gov.iti.jets.team5.models.dto.OrderDto;
import gov.iti.jets.team5.models.dto.UserDto;
import gov.iti.jets.team5.utils.factory.AppSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static OrderRepository orderRepositoryInstance = null;

    private EntityManagerFactory entityManagerFactory = AppSessionFactory.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static OrderRepository getInstance() {
        if (orderRepositoryInstance == null) {
            synchronized (OrderRepository.class) {
                if (orderRepositoryInstance == null) {
                    orderRepositoryInstance = new OrderRepository();
                }
            }
        }
        return orderRepositoryInstance;
    }

    public List<OrderDetailsDto> fetchOrdersByUserId(int userID) {
        List<OrderDetailsDto> orders = new ArrayList<>();

        try {
            entityManager.getTransaction().begin();
            List orderList = entityManager.createQuery("from Orders o where o.userData.id = :userID")
                    .setParameter("userID", userID)
                    .getResultList();

            System.out.println("Order sizzzzzze" + orderList.size());

            for (int i = 0 ; i < orderList.size() ; i++) {
                Orders order = (Orders) orderList.get(i);
                OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
                orderDetailsDto.setId(order.getId());
                orderDetailsDto.setOrderDate(order.getOrderDate());
                orderDetailsDto.setTotal(order.getTotal());

                orders.add(orderDetailsDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
        }
        return orders;
    }
}
