package Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    static {
        try {
            if(sessionFactory == null) {
                sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Error in creating session factory"+e.getMessage());
        }

    }
}
