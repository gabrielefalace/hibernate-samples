package com.samples.hibernate;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {

        // just throws Log to console.
        BasicConfigurator.configure();

        Session session = HibernateUtilities.getSessionFactory().openSession();
        System.out.println("Hello World!");
        session.close();
    }
}