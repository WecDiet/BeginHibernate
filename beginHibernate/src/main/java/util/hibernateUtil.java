package util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class hibernateUtil {
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            // Thay "myPersistenceUnit" bằng tên persistence-unit trong persistence.xml
            return Persistence.createEntityManagerFactory("BeginHibernate");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void shutdown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
