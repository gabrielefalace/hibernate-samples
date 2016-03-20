package com.samples.hibernate;

import static java.lang.Boolean.TRUE;
import static com.samples.hibernate.HibernateProperties.*;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.Properties;

public class HibernateUtilities {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver",
                                USERNAME = "root",
                                PASSWORD = "root",
                                DEFAULT_SCHEMA = "protein_tracker",
                                CONNECTION_URL = "jdbc:mysql://localhost:3306",
                                DIALECT =  "org.hibernate.dialect.MySQLDialect";

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            Configuration configuration = new Configuration();
            Properties props = new Properties();
            props.setProperty(HIBERNATE_DRIVER_CLASS, DRIVER_CLASS);
            props.setProperty(HIBERNATE_USERNAME, USERNAME);
            props.setProperty(HIBERNATE_PASSWORD, PASSWORD);
            props.setProperty(HIBERNATE_CONNECTION_URL, CONNECTION_URL);
            props.setProperty(HIBERNATE_DEFAULT_SCHEMA, DEFAULT_SCHEMA);
            props.setProperty(HIBERNATE_DIALECT, DIALECT);
            props.setProperty(HIBERNATE_SHOW_SQL, TRUE.toString());
            props.setProperty(HIBERNATE_FORMAT_SQL, TRUE.toString());

            configuration.setProperties(props);
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException he){
            System.out.println("Problem creating the session factory!");
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
