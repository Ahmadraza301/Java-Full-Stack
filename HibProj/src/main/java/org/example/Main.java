package org.example;

import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Create an Alien object
        Alien a1 = new Alien();
        a1.setAname("Noor");
        a1.setTech("Java");

        // Configure Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();
                session.persist(a1);  // Fixed: using object instance 'a1' instead of class 'Alien'
                transaction.commit();
                System.out.println("Alien saved successfully: " + a1);

            } catch (PersistenceException e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                System.err.println("Failed to save alien: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.err.println("Hibernate initialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}