package com.samples.hibernate;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {

        // just throws Log to console.
        BasicConfigurator.configure();

        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User();
        user.setUsername("Jack");
        user.setGoal(320);

        session.save(user);

        session.getTransaction().commit();
        session.close();
        HibernateUtilities.getSessionFactory().close();
    }
}