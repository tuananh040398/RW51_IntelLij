package com.tn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();

//            Query query = session.createQuery("FROM Account");
//            List<Account> accounts = query.list();
//            accounts.forEach(account -> {
//                System.out.println(account.getId());
//                System.out.println(account.getUserName());
//                for (Address address : account.getAddresses()) {
//                    System.out.println(address.getAddressName());
//                }
//            });

            Query query = session.createQuery("FROM Address ");
            List<Address> addresses = query.list();
            addresses.forEach(address -> {
                System.out.println(address.getAddressName());
                System.out.println(address.getAccount().getUserName());
            });
        } finally {

        }
    }

    private static SessionFactory buildSessionFactory() {
        // load configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Address.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
