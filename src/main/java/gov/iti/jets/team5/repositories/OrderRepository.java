package gov.iti.jets.team5.repositories;


import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import gov.iti.jets.team5.models.dbEntities.Orders;
import gov.iti.jets.team5.models.dbEntities.UserData;
import gov.iti.jets.team5.models.dto.OrderDetailsDto;
import gov.iti.jets.team5.models.dto.OrderDto;
import gov.iti.jets.team5.models.dto.UserDto;

import gov.iti.jets.team5.models.dbEntities.CartItems;
import gov.iti.jets.team5.models.dbEntities.Orders;
import gov.iti.jets.team5.models.dbEntities.PotentialOrders;
import gov.iti.jets.team5.models.dbEntities.UserData;

import gov.iti.jets.team5.utils.factory.AppSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;


import java.util.Date;


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


    public void getNewCart(int userId, String address) {
        try {
            entityManager.getTransaction().begin();
            //todo get current cart
            PotentialOrders currentCart = ((PotentialOrders) entityManager.createQuery("from PotentialOrders p where p.userData.id = :user_id and p.active = true")
                    .setParameter("user_id", userId).getResultList()
                    .get(0));
            System.out.println("from Repo: getting the cart");
            //todo: get the current User Object
            UserData currentUser = entityManager.find(UserData.class, userId);
            System.out.println("from Repo: getting the currentUser");
            //todo: get the total price for the cart
            Double totalOrderPrice;
            var cartItems = (List<CartItems>) entityManager.createQuery("from CartItems c where c.id.orderId = :order_id")
                    .setParameter("order_id", currentCart.getOrderId()).getResultList();
            totalOrderPrice = cartItems.stream().map(cartItem -> {
                var cartItemData = ((CartItems) cartItem);
                return (Double) (cartItemData.getQuantity() * cartItemData.getProduct().getPrice().doubleValue());
            }).reduce(0.0, Double::sum);
            System.out.println("from Repo: getting the currentOrderPrice");
            //todo: update active field in current cart
            currentCart.setActive(false);
            entityManager.merge(currentCart);
            System.out.println("from Repo: deactivating the old cart");
            //todo: insert new row for the new cart
            PotentialOrders newCart = new PotentialOrders();
            newCart.setActive(true);
            newCart.setUserData(currentUser);
            entityManager.persist(newCart);
            System.out.println("from Repo: creating the new cart");
            //todo: insert new row for the order table
            Orders newOrder = new Orders();
            newOrder.setOrderDate(new Date());
            newOrder.setPotentialOrders(currentCart);
            newOrder.setUserData(currentUser);
            newOrder.setTotal(totalOrderPrice.longValue());
            newOrder.setAddress(address);
            entityManager.persist(newOrder);


        } catch (Exception e) {
            System.out.println("exception in inserting new cart");
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
        }
    }

    public List<OrderDetailsDto> fetchOrdersByUserId(int userID) {
        List<OrderDetailsDto> orders = new ArrayList<>();

        try {
            entityManager.getTransaction().begin();
            List orderList = entityManager.createQuery("from Orders o where o.userData.id = :userID")
                    .setParameter("userID", userID)
                    .getResultList();

            System.out.println("Order sizzzzzze" + orderList.size());

            for (int i = 0; i < orderList.size(); i++) {
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

