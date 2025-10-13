package org.example;

import Entities.Admin;
import Utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class AppStartup {
    private static SessionFactory sessionFactory;
    public static void ensureAdminExists() {
        sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            Long count = session.createQuery("select count(a) from Admin a", long.class).uniqueResult();
            if(count == 0) {
                createAdminInteractively(session);
            }
        }
        catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
    }
    public static void createAdminInteractively(Session session) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter admin Username : ");
        String userName = sc.nextLine().trim();
        System.out.println("Enter Password : ");
        String password = sc.nextLine().trim();

        try {
            Transaction transaction = session.beginTransaction();
            Admin admin = new Admin(password, userName);
            session.persist(admin);
            transaction.commit();
            System.out.println("Admin is created");
        }
        catch (HibernateException he) {
            System.out.println(he.getMessage());
        }
    }
}
