package com.tn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

//            Get All
//            Query query = session.createQuery("FROM User ");
//            List<User> users = query.list();
//            users.forEach(user -> {
//                System.out.println(user.getUsername());
//                System.out.println(user.getAddresses().size());
//                for (Address address : user.getAddresses()) {
//                    System.out.println(address.getStreet());
//                }
//
//  //              List<Address> addresses = user.getAddresses();
//  //             addresses.forEach(address -> {
//  //                  System.out.println(address.getStreet());
//  //              });
//            });
            session.beginTransaction();

            User user = new User();
            user.setUsername("TA");

            Address address1 = new Address();
            address1.setStreet("LTN");

            Address address2 = new Address();
            address2.setStreet("LTNNNNN");

            session.save(address1);
            session.save(address2);

            List<Address> addresses = new ArrayList<>();
            addresses.add(address1);
            addresses.add(address2);
            user.setAddresses(addresses);
            session.save(user);
            session.getTransaction().commit();


        } finally {

        }
    }

    private static SessionFactory buildSessionFactory() {
        // load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Address.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
