package gov.iti.jets.team5.utils.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppSessionFactory {
    private static EntityManagerFactory entityManagerFactory = null;

    public static EntityManagerFactory getInstance() {
        if (entityManagerFactory == null) {
            synchronized (AppSessionFactory.class) {
                if (entityManagerFactory == null) {
                    entityManagerFactory = Persistence.createEntityManagerFactory("jpaTest");
                }
            }
        }
        return entityManagerFactory;
    }
}
