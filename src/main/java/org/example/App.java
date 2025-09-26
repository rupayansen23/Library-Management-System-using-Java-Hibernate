package org.example;

import Entities.Student;
import Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App
{
    public static void main( String[] args ) {
        Student student = new Student("mca", "rupayan", "sen",
                "mca2024010");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(student);
            System.out.println("Student saved successfully");
            transaction.commit();
        }
        catch(Exception e) {
            if(transaction == null) {
                transaction.rollback();
            }
            else {
                e.printStackTrace();
            }
        }
        finally {
            session.close();
        }
    }
}
