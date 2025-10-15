package org.example;

import Entities.Admin;
import Utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class AdminService {
    private static SessionFactory sessionFactory;
    public static void adminLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the userName : ");
        String userName = sc.nextLine().trim();
        System.out.println("Enter the password : ");
        String password = sc.nextLine().trim();
        sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            String hql = "from Admin a where a.userName = :u and a.password = :p";
            Admin admin = session.createQuery(hql, Admin.class)
                    .setParameter("u", userName)
                    .setParameter("p", password)
                    .uniqueResultOptional().orElse(null);
            if(admin !=null && userName.equals(admin.getUserName()) && password.equals(admin.getPassword())) {
                System.out.println("Authentication Successful");
                menues(session, sc);
            } else {
                System.out.println("Invalid Critentials");
            }
        }
        catch(HibernateException he) {
            System.out.println(he.getMessage());
        }
    }
    public static void menues(Session session, Scanner sc) {
        while(true) {
            System.out.println("1 for Show Student details");
            System.out.println("2 for Entry Book");
            System.out.println("3 for Exit to main menu");
            int ch = sc.nextInt();
            switch (ch) {
                case 1 :
                    System.out.println("further code will be added here");
                case 2 :
                    System.out.println("further code will be added here");
                case 3:
                    System.exit(ch);
            }
        }
    }
}
