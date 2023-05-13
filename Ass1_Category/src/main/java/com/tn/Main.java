package com.tn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class Main {

    public static void main(String[] args) {
        Session session = null;
        try{
            session = buildSessionFatory().openSession();

//            session.beginTransaction();

//            Category category = new Category();
//            category.setCategoryName("category 1");
//
//            session.save(category);
//
//            session.getTransaction().commit();

            System.out.println("Success");
        } finally {

        }
    }

    public static SessionFactory buildSessionFatory() {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Category.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
