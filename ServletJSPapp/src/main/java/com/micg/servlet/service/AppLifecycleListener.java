package com.micg.servlet.service;

import com.micg.servlet.datasets.UserAccountDataSet;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

@WebListener
public class AppLifecycleListener implements ServletContextListener {
    //обьект который следит за контейнером сервлетов и при создании приложения, производит инициализацию sessionFactory
    //а при завершении приложения, закрывает sessionFactory
    private static final String hibernate_show_sql = "true";
    private static final String hibernate_hbm2ddl_auto = "validate";
    public static SessionFactory sessionFactory;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        sessionFactory = createSessionFactory(getConfiguration());
    }

    private Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(UserAccountDataSet.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/UsersDatabase");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "4444");
        configuration.setProperty("hibernate.show_sql", hibernate_show_sql);
        configuration.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
        return configuration;
    }

    private SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        sessionFactory.close();
    }
}
