package com.samples.hibernate;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.hibernate.Session;

import java.util.Date;

public class App {
    public static void main(String[] args) {

        // just throws Log to console.
        BasicConfigurator.configure();
        LogManager.getRootLogger().setLevel(Level.DEBUG);

        Session session = HibernateUtilities.getSessionFactory().openSession();

        // First Transaction
        session.beginTransaction();

        User user = new User();
        user.setUsername("Rick");
        user.getProteinData().setGoal(219);

        user.addHistory(new UserHistory(new Date(), "Set  the Goal to 219"));
        session.save(user);

        session.getTransaction().commit();

        // Second Transaction
        session.beginTransaction();

        User loadedUser = (User) session.load(User.class, 1);
        for(UserHistory history: loadedUser.getHistory()){
            System.out.println("\n Entry Time: " + history.getEntryTime());
        }

        System.out.println("User associated to protein is: " + loadedUser.getProteinData().getUser().getUsername());

        loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 20);
        loadedUser.addHistory(new UserHistory(new Date(), "Added 20 points"));

        session.getTransaction().commit();


        session.close();
        HibernateUtilities.getSessionFactory().close();
    }
}