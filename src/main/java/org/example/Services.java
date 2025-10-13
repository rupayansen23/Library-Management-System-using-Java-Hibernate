package org.example;

import Entities.Student;
import Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Services {
    public static boolean saveIntoDB(final Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return false;
    }
}
