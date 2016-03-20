package com.samples.hibernate;

public interface HibernateProperties {

    String HIBERNATE_CONNECTION_URL = "hibernate.connection.url",
           HIBERNATE_DEFAULT_SCHEMA = "hibernate.default_schema",
           HIBERNATE_DIALECT = "hibernate.dialect",
           HIBERNATE_USERNAME = "hibernate.connection.username",
           HIBERNATE_PASSWORD = "hibernate.connection.password",
           HIBERNATE_DRIVER_CLASS = "hibernate.connection.driver_class",
           HIBERNATE_SHOW_SQL = "show_sql",
           HIBERNATE_FORMAT_SQL = "format_sql";
}
