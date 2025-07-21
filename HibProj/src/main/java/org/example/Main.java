package org.example;

import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Create a Student object
        Student student = new Student();
        student.setSName("Saquib");
        student.setSAge(25);

        // Configure Hibernate
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            Transaction transaction = null;

            try {
                transaction = session.beginTransaction();
                session.persist(student);
                transaction.commit();
                System.out.println("Student saved successfully: " + student);

            } catch (PersistenceException e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                System.err.println("Failed to save student: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.err.println("Hibernate initialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}