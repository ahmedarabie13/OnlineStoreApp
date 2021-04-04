package gov.iti.jets.team5.repositories;

import gov.iti.jets.team5.models.dbEntities.CartItems;
import gov.iti.jets.team5.models.dbEntities.Orders;
import gov.iti.jets.team5.models.dbEntities.PotentialOrders;
import gov.iti.jets.team5.models.dbEntities.UserData;
import gov.iti.jets.team5.utils.factory.AppSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.List;

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

    public void getNewCart(int userId,String address) {
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
}
