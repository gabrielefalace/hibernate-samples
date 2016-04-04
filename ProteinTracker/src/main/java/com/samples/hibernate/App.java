package com.samples.hibernate;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

        List<GoalAlert> goalAlerts = Arrays.asList(new GoalAlert("Congrats"), new GoalAlert("You did it!"));

        user.getGoalAlerts().addAll(goalAlerts);

        session.save(user);

        session.getTransaction().commit();


        session.close();
        HibernateUtilities.getSessionFactory().close();
    }
}