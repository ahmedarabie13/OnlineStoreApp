package gov.iti.jets.team5.repositories;

import gov.iti.jets.team5.models.ajaxModels.CartItemData;
import gov.iti.jets.team5.models.dbEntities.CartItems;
import gov.iti.jets.team5.models.dbEntities.CartItemsId;
import gov.iti.jets.team5.models.dbEntities.PotentialOrders;
import gov.iti.jets.team5.models.dbEntities.Product;
import gov.iti.jets.team5.utils.factory.AppSessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class CartRepository {
    private static CartRepository instance = null;
    private EntityManagerFactory entityManagerFactory = AppSessionFactory.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static CartRepository getInstance() {
        if (instance == null) {
            synchronized (CartRepository.class) {
                if (instance == null) {
                    instance = new CartRepository();
                }
            }
        }
        return instance;
    }

    public void addProductToCart(int productId, int userId) {
        System.out.println(productId + " from cart repo");
        try {
            entityManager.getTransaction().begin();
            var list = entityManager.createQuery("from PotentialOrders p where p.userData.id = :user_id and p.active = true")
                    .setParameter("user_id", userId).getResultList();
            if (list.size() == 1) {
                CartItemsId cartItemsId = new CartItemsId();
                cartItemsId.setProductId(productId);
                cartItemsId.setOrderId(((PotentialOrders) list.get(0)).getOrderId());
                var cartItem = entityManager.find(CartItems.class, cartItemsId);
                if (cartItem != null) {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                } else {
                    var product = (Product) entityManager.find(Product.class, productId);
                    cartItem = new CartItems();
                    System.out.println("new CartItem");
                    cartItem.setId(cartItemsId);
                    cartItem.setQuantity(1);
                    cartItem.setProduct(product);
                }
                entityManager.persist(cartItem);
                System.out.println("done");
            }
        } catch (Exception e) {
            System.out.println("exception thrown");
            e.printStackTrace();
        } finally {
            System.out.println("we reached finally");
            entityManager.getTransaction().commit();
        }
    }

    public List<CartItems> getCartItems(int userId) {
        entityManager.getTransaction().begin();
        List<CartItems> resultList = null;
        try {
            var list = entityManager.createQuery("from PotentialOrders p where p.userData.id = :user_id and p.active = true")
                    .setParameter("user_id", userId).getResultList();
            if (list.size() == 1) {
                int orderId = ((PotentialOrders) list.get(0)).getOrderId();
                resultList = entityManager.createQuery("from CartItems c where c.potentialOrders.orderId = :order_id")
                        .setParameter("order_id", orderId).getResultList();
                System.out.println("cart Items list: " + resultList);
            }

        } catch (Exception e) {

        } finally {
            entityManager.getTransaction().commit();
            return resultList;
        }
    }

    public boolean isQuantityValid(CartItemData cartItemData) {
        boolean isSufficient = false;
        if (cartItemData.getCartItemQuantity() > 0) {
            entityManager.getTransaction().begin();
            try {
                Product product = entityManager.find(Product.class, cartItemData.getProductId());
                if (product != null) {
                    isSufficient = cartItemData.getCartItemQuantity() <= product.getQuantity();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                entityManager.getTransaction().commit();
            }
        }
        return isSufficient;
    }

    public void updateQuantity(int userId, CartItemData cartItemData) {
        entityManager.getTransaction().begin();
        try {
            var carts = entityManager.createQuery("from PotentialOrders p where p.userData.id = :user_id and p.active = true")
                    .setParameter("user_id", userId).getResultList();
            if (carts.size() == 1) {
                int orderId = ((PotentialOrders) carts.get(0)).getOrderId();
                CartItemsId cartItemId = new CartItemsId(orderId, cartItemData.getProductId());
                CartItems cartItem = entityManager.find(CartItems.class, cartItemId);
                cartItem.setQuantity(cartItemData.getCartItemQuantity());
                entityManager.merge(cartItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
            System.out.println("done merging");
        }
    }

    public double getCartTotalPrice(int userId) {
        entityManager.getTransaction().begin();
        double totalPrice = 0.0;
        try {
            var carts = entityManager.createQuery("from PotentialOrders p where p.userData.id = :user_id and p.active = true")
                    .setParameter("user_id", userId).getResultList();
            if (carts.size() == 1) {
                int orderId = ((PotentialOrders) carts.get(0)).getOrderId();
                var cartItems =(List<CartItems>) entityManager.createQuery("from CartItems c where c.id.orderId = :order_id")
                        .setParameter("order_id", orderId).getResultList();
                totalPrice = cartItems.stream().map(cartItem -> {
                    var cartItemData = ((CartItems) cartItem);
                    return (Double) (cartItemData.getQuantity() * cartItemData.getProduct().getPrice().doubleValue());
                }).reduce(0.0, Double::sum);
                System.out.println("totalPrice: "+totalPrice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
            return totalPrice;
        }
    }

    public void deleteCartItem(int userId, int productId) {
        entityManager.getTransaction().begin();
        try{
            var carts = entityManager.createQuery("from PotentialOrders p where p.userData.id = :user_id and p.active = true")
                    .setParameter("user_id", userId).getResultList();
            if (carts.size() == 1) {
                int orderId = ((PotentialOrders) carts.get(0)).getOrderId();
                CartItemsId cartItemId = new CartItemsId(orderId, productId);
                CartItems cartItem = entityManager.find(CartItems.class, cartItemId);
                if(cartItem!=null){
                    entityManager.remove(cartItem);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            entityManager.getTransaction().commit();
            System.out.println("delete done successfully");
        }
    }
}
